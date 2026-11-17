package controlador;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import modelo.Combate;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import vista.VentanaMarcadorFX;

public class ControladorMandosFX implements Runnable {
    private Combate combate;
    private VentanaMarcadorFX vista;
    private ControladorCombateFX ctrlCombate;
    private volatile boolean ejecutando;

    public ControladorMandosFX(Combate combate, VentanaMarcadorFX vista, ControladorCombateFX ctrlCombate) {
        this.combate = combate;
        this.vista = vista;
        this.ctrlCombate = ctrlCombate;
        this.ejecutando = true;
    }

    public void detener() {
        this.ejecutando = false;
    }

    @Override
    public void run() {
        List<Controller> mandos = new ArrayList<Controller>();

        try {
            Controller[] todos = ControllerEnvironment.getDefaultEnvironment().getControllers();
            for (int i = 0; i < todos.length; i++) {
                Controller.Type tipo = todos[i].getType();
                if (tipo == Controller.Type.GAMEPAD || tipo == Controller.Type.STICK) {
                    mandos.add(todos[i]);
                    if (mandos.size() == 2) break;
                }
            }
        } catch (Throwable t) {
            actualizarMensajeUI("Mandos: Librería nativa no cargada (Modo Teclado)");
            return;
        }

        if (mandos.isEmpty()) {
            actualizarMensajeUI("Mandos: 0 conectados (Modo Teclado activo)");
            return;
        } else if (mandos.size() == 1) {
            actualizarMensajeUI("Mandos: 1 conectado [Mando 1 -> CHUNG]");
        } else {
            actualizarMensajeUI("Mandos: 2 conectados [M1 -> CHUNG | M2 -> HONG]");
        }

        boolean[][] estadoPrevio = new boolean[mandos.size()][32];

        while (ejecutando) {
            for (int idxMando = 0; idxMando < mandos.size(); idxMando++) {
                Controller mando = mandos.get(idxMando);
                if (!mando.poll()) continue;

                Component[] componentes = mando.getComponents();
                int indiceBoton = 0;

                for (int c = 0; c < componentes.length; c++) {
                    Component comp = componentes[c];
                    if (comp.getIdentifier() instanceof Component.Identifier.Button) {
                        if (indiceBoton < 32) {
                            boolean presionado = comp.getPollData() == 1.0f;
                            if (presionado && !estadoPrevio[idxMando][indiceBoton]) {
                                procesarBotonMando(idxMando, indiceBoton);
                            }
                            estadoPrevio[idxMando][indiceBoton] = presionado;
                            indiceBoton++;
                        }
                    }
                }
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void procesarBotonMando(final int idxMando, final int boton) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (idxMando == 0) {
                    aplicarAccionChung(boton);
                } else if (idxMando == 1) {
                    aplicarAccionHong(boton);
                }
                vista.actualizarVista(combate);
                ctrlCombate.verificarFinPorFaltas();
            }
        });
    }

    private void aplicarAccionChung(int boton) {
        switch (boton) {
            case 0: combate.getChung().sumarPuntos(1); break;
            case 1: combate.getChung().sumarPuntos(2); break;
            case 2: combate.getChung().sumarPuntos(3); break;
            case 3: combate.getChung().sumarPuntos(4); break;
            case 4:
            case 5: combate.getChung().sumarPuntos(5); break;
            case 6: combate.penalizarChung(); break;
            case 7: ctrlCombate.alternarTiempo(); break;
        }
    }

    private void aplicarAccionHong(int boton) {
        switch (boton) {
            case 0: combate.getHong().sumarPuntos(1); break;
            case 1: combate.getHong().sumarPuntos(2); break;
            case 2: combate.getHong().sumarPuntos(3); break;
            case 3: combate.getHong().sumarPuntos(4); break;
            case 4:
            case 5: combate.getHong().sumarPuntos(5); break;
            case 6: combate.penalizarHong(); break;
            case 7: ctrlCombate.alternarTiempo(); break;
        }
    }

    private void actualizarMensajeUI(final String msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vista.actualizarEstadoMandos(msg);
            }
        });
    }
}
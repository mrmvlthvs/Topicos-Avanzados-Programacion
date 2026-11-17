package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.Combate;
import vista.VentanaMarcador;

public class ControladorCombate {
    private Combate combate;
    private VentanaMarcador vista;
    private Timer cronometro;
    private ControladorMandos ctrlMandos;
    private boolean combateTerminado;

    public ControladorCombate(Combate combate, VentanaMarcador vista) {
        this.combate = combate;
        this.vista = vista;
        this.combateTerminado = false;
        configurarCronometro();
        configurarEventosBotones();
    }

    private void configurarCronometro() {
        cronometro = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                combate.descontarSegundo();
                vista.actualizarVista(combate);

                if (combate.getTiempoRestanteSegundos() == 0 && !combateTerminado) {
                    finalizarCombate();
                }
            }
        });
    }

    private void configurarEventosBotones() {
        vista.getBtnIniciarPausar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alternarTiempo();
            }
        });

        vista.getBtnFinalizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarCombate();
            }
        });

        vista.getBtnSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarSalida();
            }
        });
    }

    public void alternarTiempo() {
        if (combateTerminado) return;

        if (combate.isEnCurso()) {
            combate.setEnCurso(false);
            cronometro.stop();
            vista.getBtnIniciarPausar().setText("Reanudar Tiempo (Espacio)");
        } else {
            combate.setEnCurso(true);
            cronometro.start();
            vista.getBtnIniciarPausar().setText("Pausar Tiempo (Espacio)");
        }
        vista.requestFocusInWindow();
    }

    public void verificarFinPorFaltas() {
        if (!combateTerminado &&
                (combate.getChung().getGamJeoms() >= 5 || combate.getHong().getGamJeoms() >= 5)) {
            finalizarCombate();
        }
    }

    public void finalizarCombate() {
        combateTerminado = true;

        combate.setEnCurso(false);
        cronometro.stop();
        vista.getBtnIniciarPausar().setEnabled(false);
        vista.mostrarResultadosFinales(combate);
    }

    public void confirmarSalida() {
        int opcion = JOptionPane.showConfirmDialog(vista,
                "¿Deseas cerrar el marcador y salir del sistema?",
                "Confirmar Salida", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            if (ctrlMandos != null) ctrlMandos.detener();
            cronometro.stop();
            vista.dispose();
            System.exit(0);
        }
    }

    public void setControladorMandos(ControladorMandos ctrlMandos) {
        this.ctrlMandos = ctrlMandos;
    }
}
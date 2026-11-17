package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modelo.Combate;
import vista.VentanaMarcadorFX;

public class ControladorTecladoFX implements EventHandler<KeyEvent> {
    private Combate combate;
    private VentanaMarcadorFX vista;
    private ControladorCombateFX ctrlCombate;

    public ControladorTecladoFX(Combate combate, VentanaMarcadorFX vista, ControladorCombateFX ctrlCombate) {
        this.combate = combate;
        this.vista = vista;
        this.ctrlCombate = ctrlCombate;
    }

    @Override
    public void handle(KeyEvent e) {
        KeyCode codigo = e.getCode();

        if (codigo == KeyCode.SPACE) {
            ctrlCombate.alternarTiempo();
            return;
        }

        switch (codigo) {
            // --- CONTROLES CHUNG (AZUL) ---
            case Q: combate.getChung().sumarPuntos(1); break;
            case W: combate.getChung().sumarPuntos(2); break;
            case E: combate.getChung().sumarPuntos(3); break;
            case R: combate.getChung().sumarPuntos(4); break;
            case T: combate.getChung().sumarPuntos(5); break;
            case A: combate.penalizarChung(); break;
            case Z: combate.getChung().sumarPuntos(-1); break;

            // --- CONTROLES HONG (ROJO) ---
            case U: combate.getHong().sumarPuntos(1); break;
            case I: combate.getHong().sumarPuntos(2); break;
            case O: combate.getHong().sumarPuntos(3); break;
            case P: combate.getHong().sumarPuntos(4); break;
            case L: combate.getHong().sumarPuntos(5); break;
            case J: combate.penalizarHong(); break;
            case M: combate.getHong().sumarPuntos(-1); break;
            default: break;
        }

        vista.actualizarVista(combate);
        ctrlCombate.verificarFinPorFaltas();
    }
}
package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import modelo.Combate;
import vista.VentanaMarcador;

public class ControladorTeclado extends KeyAdapter {
    private Combate combate;
    private VentanaMarcador vista;
    private ControladorCombate ctrlCombate;

    public ControladorTeclado(Combate combate, VentanaMarcador vista, ControladorCombate ctrlCombate) {
        this.combate = combate;
        this.vista = vista;
        this.ctrlCombate = ctrlCombate;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();

        // Control de tiempo con barra espaciadora
        if (codigo == KeyEvent.VK_SPACE) {
            ctrlCombate.alternarTiempo();
            return;
        }

        // --- CONTROLES CHUNG (AZUL) ---
        switch (codigo) {
            case KeyEvent.VK_Q: combate.getChung().sumarPuntos(1); break;
            case KeyEvent.VK_W: combate.getChung().sumarPuntos(2); break;
            case KeyEvent.VK_E: combate.getChung().sumarPuntos(3); break;
            case KeyEvent.VK_R: combate.getChung().sumarPuntos(4); break;
            case KeyEvent.VK_T: combate.getChung().sumarPuntos(5); break;
            case KeyEvent.VK_A: combate.penalizarChung(); break;
            case KeyEvent.VK_Z: combate.getChung().sumarPuntos(-1); break;

            // --- CONTROLES HONG (ROJO) ---
            case KeyEvent.VK_U: combate.getHong().sumarPuntos(1); break;
            case KeyEvent.VK_I: combate.getHong().sumarPuntos(2); break;
            case KeyEvent.VK_O: combate.getHong().sumarPuntos(3); break;
            case KeyEvent.VK_P: combate.getHong().sumarPuntos(4); break;
            case KeyEvent.VK_L: combate.getHong().sumarPuntos(5); break;
            case KeyEvent.VK_J: combate.penalizarHong(); break;
            case KeyEvent.VK_M: combate.getHong().sumarPuntos(-1); break;
        }

        vista.actualizarVista(combate);
        ctrlCombate.verificarFinPorFaltas();
    }
}
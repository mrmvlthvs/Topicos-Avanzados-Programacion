package principal;

import controlador.ControladorCombate;
import controlador.ControladorMandos;
import controlador.ControladorTeclado;
import javax.swing.JOptionPane;
import modelo.Combate;
import vista.DialogoRegistro;
import vista.VentanaMarcador;

public class PruebaMarcadorTaekwondo {
    private Combate combate;
    private VentanaMarcador ventana;
    private ControladorCombate ctrlCombate;
    private ControladorMandos ctrlMandos;

    // 1. META
    public void meta() {
        String titulo = "Marcador Electrónico de Taekwondo - ITL";
        String mensaje = "Sistema de puntuación en pantalla completa para combates\n" +
                "entre CHUNG (Azul) y HONG (Rojo), con soporte simultáneo\n" +
                "para teclado y dos mandos de consola.";
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    // 2. DATA (Captura inicial de competidores y tiempo)
    public boolean data() {
        DialogoRegistro dialogo = new DialogoRegistro();
        dialogo.setVisible(true);
        combate = dialogo.getCombateCreado();
        return combate != null;
    }

    // 3. PROCESO (Construcción del marcador y vinculación de controladores)
    public void proceso() {
        ventana = new VentanaMarcador();
        ventana.actualizarVista(combate);

        ctrlCombate = new ControladorCombate(combate, ventana);
        ctrlMandos = new ControladorMandos(combate, ventana, ctrlCombate);
        ctrlCombate.setControladorMandos(ctrlMandos);
    }

    // 4. RESULTADOS (Despliegue visual en pantalla completa)
    public void resultados() {
        ventana.setVisible(true);
        ventana.requestFocusInWindow();
    }

    // 5. NAVEGABILIDAD (Activación de eventos de teclado y mandos)
    public void navegabilidad() {
        ControladorTeclado ctrlTeclado = new ControladorTeclado(combate, ventana, ctrlCombate);
        ventana.addKeyListener(ctrlTeclado);

        Thread hiloMandos = new Thread(ctrlMandos);
        hiloMandos.setDaemon(true);
        hiloMandos.start();
    }

    public static void main(String[] args) {
        PruebaMarcadorTaekwondo sistema = new PruebaMarcadorTaekwondo();

        sistema.meta();
        if (sistema.data()) {
            sistema.proceso();
            sistema.resultados();
            sistema.navegabilidad();
        } else {
            System.out.println("Registro cancelado por el usuario.");
            System.exit(0);
        }
    }
}
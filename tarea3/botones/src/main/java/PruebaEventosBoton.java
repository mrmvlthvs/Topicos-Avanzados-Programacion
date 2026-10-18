import javax.swing.JOptionPane;

public class PruebaEventosBoton {
    private EventosBotones objGUI;

    void meta() {
        String t = "Prueba de Eventos con Botones";
        String m = "Programa que permite probar el manejo de eventos\n" +
                   "mediante botones (biblioteca AWT de Java).";

        JOptionPane.showMessageDialog(null, m, t, JOptionPane.INFORMATION_MESSAGE);
    }

    void resultados() {
        objGUI = new EventosBotones();
        objGUI.forma1();
        objGUI.mostrar(); // ejecuta la primera ventana del programa
    }

    // 5. NAVEGABILIDAD
        // La logica de navegabilidad se encuentra implementada en la subclase
        // ManejoEventosBoton de la clase EventosBotones.

    public static void main(String args[]) {
        PruebaEventosBoton test = new PruebaEventosBoton();

        test.meta();
        test.resultados();
        JOptionPane.showMessageDialog(null, "Cerrando programa...", 
                                "FIN DEL PROGRAMA", JOptionPane.PLAIN_MESSAGE);
    }
}
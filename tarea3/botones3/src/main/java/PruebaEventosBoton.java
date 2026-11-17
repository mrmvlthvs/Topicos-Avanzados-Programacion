import javax.swing.JOptionPane;

public class PruebaEventosBoton {
    private EventosBotones obj;

    void meta() {
        String t = "Prueba de Eventos con Botones";
        String m = "Programa que permite abrir y cerrar ventanas con el uso de "
                + "botones.\n Demostrara las prestaciones de los eventos de AWT"
                + " biblioteca de Java.";

        JOptionPane.showMessageDialog(null, m, t,
                JOptionPane.INFORMATION_MESSAGE);
    }

    // DATA: No hay datos de entrada, ni salida. Solo se ejecuta el programa.

    void procesos() {
        obj = new EventosBotones();
        obj.setElementosGraficos();
    }

    void resultados() {
        obj.mostrarSegundaPantallaResultados();
    }

    void navegabilidad() {
        obj.gestionarNavegabilidad();
    }

    public static void main(String[] args) {
        PruebaEventosBoton test = new PruebaEventosBoton();

        test.meta();
        test.procesos();
        test.resultados();
        test.navegabilidad();
    }
}
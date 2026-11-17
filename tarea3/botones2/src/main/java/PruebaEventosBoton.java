import javax.swing.JOptionPane;

public class PruebaEventosBoton {
    private EventosBotones obj;

    // 1. META
    void meta() {
        String t = "Prueba de Eventos con Botones";
        String m = "Programa que permite probar el manejo de eventos\n" +
                "mediante botones, elementos pertenecientes de biblioteca AWT de Java).";

        JOptionPane.showMessageDialog(null, m, t,
                JOptionPane.INFORMATION_MESSAGE);
    }

    // 2. DATA NO HAY. No se introducen datos crudos al programa.
    // 3. PROCESO NO HAY. No se realizan calculos ni transformacion de datos.
    // 4. RESULTADOS NO HAY. El despliegue visual se delego a navegabilidad.

    // 5. NAVEGABILIDAD
    void navegabilidad() {
        obj = new EventosBotones();

        obj.setVentana1();
        obj.setVentana2();
        obj.mostrarVentana(1);
    }

    public static void main(String[] args) {
        PruebaEventosBoton test = new PruebaEventosBoton();

        test.meta();
        test.navegabilidad();
    }
}
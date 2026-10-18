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

    // 2. DATA
    void data() {
        // NO HAY. No se introducen datos crudos al programa.
    }

    // 3. PROCESO
    void proceso() {
        // NO HAY. No se realizan calculos ni transformacion de datos.
    }

    // 4. RESULTADOS
    void resultados() {
        // NO HAY. El despliegue visual se delego a navegabilidad.
    }

    // 5. NAVEGABILIDAD
    void navegabilidad() {
        obj = new EventosBotones();

        // Construccion estructural
        obj.setVentana1();
        obj.setVentana2();

        // Interaccion visual inicial
        obj.mostrarVentana(1);
        System.out.println("-> Navegabilidad activa en capa visual.");
    }

    public static void main(String[] args) {
        PruebaEventosBoton test = new PruebaEventosBoton();

        test.meta();
        test.data();
        test.proceso();
        test.resultados();
        test.navegabilidad();
    }
}
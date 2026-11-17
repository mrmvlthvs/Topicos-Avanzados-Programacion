import javax.swing.JOptionPane;

public class PruebaRegistroTorneo {
    private TorneoDAO dao;
    private RegistroTorneoGUI gui;

    // 1. META
    void meta() {
        String t = "Proyecto Optativo - Unidad 4";
        String m = "Sistema de Registro para el Circuito Élite de Taekwondo\n" +
                "Aplicando Conexión a Base de Datos y Manipulación JDBC.";

        JOptionPane.showMessageDialog(null, m, t, JOptionPane.INFORMATION_MESSAGE);
    }

    // 2. DATA
    void data() {
        // Inicialización del objeto de conexión a datos (DAO)
        dao = new TorneoDAO();
        dao.conectar();
    }

    // 3. PROCESO
    void proceso() {
        // Construcción y preparación de la interfaz gráfica y sus componentes
        gui = new RegistroTorneoGUI(dao);
        gui.construirVentanaRegistro();
    }

    // 4. RESULTADOS
    void resultados() {
        // Despliegue visual de la interfaz de registro en pantalla
        System.out.println("-> Desplegando interfaz gráfica de acceso a datos.");
        gui.mostrar();
    }

    // 5. NAVEGABILIDAD
    void navegabilidad() {
        // La gestión de navegación y transacciones ocurre mediante los Listeners de la GUI.
        System.out.println("-> Navegabilidad y eventos de base de datos activos.");
    }

    public static void main(String[] args) {
        PruebaRegistroTorneo test = new PruebaRegistroTorneo();

        test.meta();
        test.data();
        test.proceso();
        test.resultados();
        test.navegabilidad();
    }
}
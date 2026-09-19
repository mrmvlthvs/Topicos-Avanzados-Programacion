package arslan;

import java.awt.FlowLayout;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class PruebaImageIcon {
    private Scanner sc = new Scanner(System.in);
    private String rutaImagen;
    private JFrame mainFrame;

    // 1. META
    void meta() {
        String msg = """
            === PRUEBA DE COMPONENTE SWING: IMAGEICON ===
            Demostracion de carga y visualizacion de una imagen
            utilizando el componente ImageIcon de javax.swing.*
            """;
        System.out.println(msg);
    }

    // 2. DATA
    void data() {
        System.out.print("Ingrese la ruta absoluta de la imagen (.jpg/.png): ");
        rutaImagen = sc.nextLine().trim();
    }

    // 3. PROCESO
    void proceso() {
        if (rutaImagen.isEmpty()) {
            System.out.println("Error: Proporcione una ruta valida.");
            return;
        }

        mainFrame = new JFrame("Prueba ImageIcon - Marlene I.M. Velazquez");
        mainFrame.setSize(500, 400);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon(rutaImagen);
        JLabel imageLabel = new JLabel(icon);

        mainFrame.add(imageLabel);
        System.out.println("Componentes graficos preparados exitosamente.");
    }

    // 4. RESULTADOS
    void resultados() {
        if (mainFrame != null) {
            mainFrame.setVisible(true);
            System.out.println("Ventana grafica desplegada en pantalla.");
        }
    }

    // 5. NAVEGABILIDAD
    public static void main(String[] args) {
        PruebaImageIcon app = new PruebaImageIcon();

        app.meta();
        while (true) {
            System.out.println("\n1. Cargar y visualizar imagen\n2. Salir");
            System.out.print("Seleccione una accion: ");
            String opcion = app.sc.nextLine().trim();

            switch (opcion) {
                case "1" -> {
                    app.data(); app.proceso(); app.resultados();
                }
                case "2" -> {
                    System.out.println("Finalizando ejecucion ordenadamente...");
                    return;
                }
                default -> System.out.println("Opcion invalida.");
            }
        }
    }
}
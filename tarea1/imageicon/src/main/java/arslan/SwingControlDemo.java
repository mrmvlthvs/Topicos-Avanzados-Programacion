package arslan;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingControlDemo {
    private Scanner sc = new Scanner(System.in);
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private String ruta;

    // 1. META
    void meta() {
        String msg = """
            === PRUEBA DE COMPONENTE SWING: IMAGEICON ===
            Muestra el componente ImageIcon cargando directamente la 
            imagen 'image02.jpg' ubicada en la misma carpeta.
            """;
        System.out.println(msg);
    }

    // 2. DATA
    void data() {
        ruta = "resources/image02.jpg";
        System.out.println("-> Asignando ruta local directa: " + ruta);
    }

    // 3. PROCESO
    void proceso() {
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        headerLabel = new JLabel("Control in action: ImageIcon", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        URL imgURL = SwingControlDemo.class.getResource(ruta);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL, "Imagen 02");
            JLabel commentlabel = new JLabel("", icon, JLabel.CENTER);
            controlPanel.add(commentlabel);
            statusLabel.setText("Imagen cargada exitosamente.");
        } else {
            statusLabel.setText("Couldn't find file: " + ruta);
        }

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
    }

    // 4. RESULTADOS
    void resultados() {
        if (mainFrame != null) {
            mainFrame.setVisible(true);
            System.out.println("-> Interfaz grafica desplegada.");
        }
    }

    // 5. NAVEGABILIDAD
    void menuPrincipal() {
        while (true) {
            System.out.println("\n1. Mostrar imagen (image02.jpg)\n2. Salir");
            System.out.print("Seleccione una accion: ");
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1" -> { data(); proceso(); resultados(); }
                case "2" -> {
                    System.out.println("Fin de ejecucion.");
                    return;
                }
                default -> System.out.println("Opcion no valida.");
            }
        }
    }

    public static void main(String[] args) {
        SwingControlDemo demo = new SwingControlDemo();
        demo.meta();
        demo.menuPrincipal();
        System.exit(0);
    }
}
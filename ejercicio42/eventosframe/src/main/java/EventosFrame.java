import java.awt.*;

class EventosFrame {
    Frame ventana;
    javax.swing.JOptionPane jop = new javax.swing.JOptionPane();

    void inicio() {  // meta
        jop.showMessageDialog(null, "Muestra eventos del Frame");
    }

    void launchFrame() {    // componentes entrada
        ventana = new Frame();
        ventana.setTitle("Prueba de Eventos de Frame");
        ventana.setSize(200, 400);
        ventana.setBackground(new Color(100, 200, 1));
        ventana.setLayout(new FlowLayout());
        ventana.add(new Label("Hola"));
        ventana.pack();
        OyenteFrame oyente = new OyenteFrame();
        ventana.addWindowListener(oyente); // maneja los eventos
        ventana.setVisible(true);         // salida a pantalla
    }
}

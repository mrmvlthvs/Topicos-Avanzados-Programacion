import java.awt.*;
import java.awt.event.*;

public class EventosBotones {
    private Frame v1, v2;
    private Button b1, b2;

    public void setBotones() {
        b1 = new Button("Abrir Frame");
        b2 = new Button("Cerrar Frame");

        b1.addActionListener(ev -> mostrarVentana(2));
        b2.addActionListener(ev -> cerrarVentana(2));
    }

    public void setVentana1() {
        v1 = new Frame("Ventana Principal");
        v1.setPreferredSize(new Dimension(500, 300));
        v1.setLayout(new FlowLayout());

        setBotones();
        v1.add(b1);
        v1.add(b2);

        // NAVEGABILIDAD: Permite cerrar con la 'X' de la ventana
        v1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana(1);
            }
        });

        v1.pack();
        v1.setLocationRelativeTo(null);
    }

    public void setVentana2() {
        v2 = new Frame("Segunda Ventana");
        v2.setPreferredSize(new Dimension(200, 100));
        v2.setBackground(new Color(195, 150, 210));
        v2.setLayout(new FlowLayout());
        v2.add(new Label("Hola!"));

        // NAVEGABILIDAD: Permite ocultar con la 'X' de la ventana
        v2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana(2);
            }
        });

        v2.pack();
        if (v1 != null) {
            v2.setLocationRelativeTo(v1);
        }
    }

    public void mostrarVentana(int v) {
        switch (v) {
            case 1 -> { if (v1 != null) v1.setVisible(true); }
            case 2 -> { if (v2 != null) v2.setVisible(true); }
        }
    }

    public void cerrarVentana(int ventana) {
        switch (ventana) {
            case 1 -> confirmacion(v1);
            case 2 -> cerrar(v2);
        }
    }

    public void confirmacion(Frame v) {
        if (v != null && v.isVisible()) {
            Dialog dialog = new Dialog(v, "¿Desea salir?", true);
            dialog.setLayout(new FlowLayout());
            dialog.setSize(300, 150);
            dialog.setLocationRelativeTo(v);

            Button btnSi = new Button("Si");
            Button btnNo = new Button("No");

            btnSi.addActionListener(ev -> {
                cerrar(v); // Corregido: Libera recursos directamente
                System.exit(0);
            });
            btnNo.addActionListener(ev -> dialog.dispose());

            dialog.add(new Label("¿Desea salir del programa?"));
            dialog.add(btnSi);
            dialog.add(btnNo);
            dialog.setVisible(true);
        }
    }

    public void cerrar(Frame v) {
        if (v != null) {
            v.setVisible(false);
            v.dispose();
        }
    }
}
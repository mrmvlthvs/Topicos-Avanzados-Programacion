import java.awt.*;
import java.awt.event.*;

public class EventosBotones {
    private Frame v1, v2;
    private Button b1, b2;
    private ManejadorEventosBoton manejador;

    public Button getB1() { return b1; }
    public Button getB2() { return b2; }

    public void setElementosGraficos() {
        v1 = new Frame("Ventana Principal");
        v1.setPreferredSize(new Dimension(500, 300));
        v1.setLayout(new FlowLayout());

        b1 = new Button("Abrir Frame");
        b2 = new Button("Cerrar Frame");
        manejador = new ManejadorEventosBoton(this);

        b1.addActionListener(manejador);
        b2.addActionListener(manejador);
        v1.add(b1);
        v1.add(b2);
        v1.pack();
        v1.setLocationRelativeTo(null);

        v2 = new Frame("Segunda Ventana");
        v2.setPreferredSize(new Dimension(200, 100));
        v2.setBackground(new Color(195, 150, 210));
        v2.setLayout(new FlowLayout());
        v2.add(new Label("Hola!"));
        v2.pack();
        if (v1 != null) v2.setLocationRelativeTo(v1);
    }

    public void mostrarSegundaPantallaResultados() {
        if (v2 != null)  v2.setVisible(true);
    }

    public void gestionarNavegabilidad() {
        if (v1 != null)  v1.setVisible(true);
        
        v1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { confirmacion(v1);}
        });

        v2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { cerrar(v2);}
        });
    }

    public void mostrarVentana(int v) {
        switch (v) {
            case 1:
                if (v1 != null) v1.setVisible(true);
                break;
            case 2:
                if (v2 != null) v2.setVisible(true);
                break;
        }
    }

    public void cerrarVentana(int ventana) {
        switch (ventana) {
            case 1:
                confirmacion(v1);
                break;
            case 2:
                cerrar(v2);
                break;
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

            btnSi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    cerrar(v);
                    System.exit(0);
                }
            });

            btnNo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    dialog.dispose();
                }
            });

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
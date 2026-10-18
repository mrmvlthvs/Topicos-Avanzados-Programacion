

import java.awt.*;
import java.awt.event.*;

public class EventosBotones {
    private Frame v1, v2;
    private Button boton1, boton2;
    private ManejadorEventosBoton oyeBoton;

    public EventosBotones() {
        oyeBoton = new ManejadorEventosBoton();
    }

    public void forma1() {
        v1 = new Frame("Ventana Principal");
        v1.setPreferredSize(new Dimension(600, 300));
        v1.setLayout(new FlowLayout());

        boton1 = new Button("Abrir Frame");
        boton2 = new Button("Cancelar");

        v1.add(boton1);
        v1.add(boton2);

        // NAVEGABILIDAD: Conexiones de los botones
        boton1.addActionListener(oyeBoton);
        boton2.addActionListener(oyeBoton);

        // NAVEGABILIDAD: Evento botonExit (La "X" de la ventana principal)
        v1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { cierreConfirmar(); }
        });

        v1.pack();
        v1.setLocationRelativeTo(null);
    }

    public void forma2() {
        if (v2 != null && v2.isVisible()) return;
        
        v2 = new Frame("Prueba de Eventos de Boton");
        v2.setPreferredSize(new Dimension(350, 100));
        v2.setBackground(new Color(191, 155, 202));
        v2.setLayout(new FlowLayout());
        v2.add(new Label("Hola"));
        
        // Conexión para poder cerrar v2 con su propia tachuela "X"
        v2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrar();
            }
        });

        v2.pack();
        v2.setLocationRelativeTo(v1);
        v2.setVisible(true);
    }

    // 5.1 mostrar()
    public void mostrar() {
        if (v1 != null) v1.setVisible(true);
    }

    // 5.2 cerrar()
    public void cerrar() {
        if (v2 != null && v2.isVisible()) {
            v2.setVisible(false);
            v2.dispose(); // libera recursos de la ventana
        }
    }

    // 5.3 cierreConfirmar()
    public void cierreConfirmar() {
        if (v1 != null && v1.isVisible()) {
            Dialog dialog = new Dialog(v1, "¿Desea salir?", true);
            dialog.setLayout(new FlowLayout());
            dialog.setSize(250, 120);
            dialog.setLocationRelativeTo(v1);

            Button btnSi = new Button("Si");
            Button btnNo = new Button("No");

            btnSi.addActionListener(ev -> {
                v1.setVisible(false);
                v1.dispose(); // libera recursos de la ventana
                System.exit(0);
            });
            btnNo.addActionListener(ev -> dialog.dispose());

            dialog.add(new Label("¿Desea salir del programa?"));
            dialog.add(btnSi);
            dialog.add(btnNo);
            dialog.setVisible(true);
        }
    }

    // 5.4 ManejadorEventosBoton.actionPerformed()
    private class ManejadorEventosBoton implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            Object fuente = evento.getSource();

            if (fuente == boton1) forma2(); // navega a la ventana 2
            else if (fuente == boton2) cerrar(); // cierra la ventana 2 
        }
    }
}
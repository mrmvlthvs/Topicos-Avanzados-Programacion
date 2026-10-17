import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosBotones {
    Button boton1,boton2;
    Frame v1,v2;
    ManejadorEventosBoton oyeBoton;

    void forma1(){
        v1=new Frame();

        v1.setPreferredSize(new Dimension(600, 300));
        v1.setLocationRelativeTo(null);
        v1.setLayout(new FlowLayout());

        boton1=new Button("Abrir Frame");
        boton2= new Button("Cancelar");
        oyeBoton=new ManejadorEventosBoton();

        v1.add(boton1);
        v1.add(boton2);
        boton1.addActionListener(oyeBoton);
        boton2.addActionListener(oyeBoton);
        cierreConfirmar(v1);
        v1.pack();
        v1.setVisible(true);
    }

    void forma2(){
        v2=new Frame();

        v2.setTitle("Prueba de Eventos de Boton");
        v2.setPreferredSize(new Dimension(350, 100));
        v2.setSize(350, 100);
        v2.setLocationRelativeTo(v1);
        v2.setBackground(new Color(191, 155, 202));
        v2.setLayout(new FlowLayout());
        v2.add(new Label("Hola"));
        cerrar(v2);
        v2.pack();
        v2.setVisible(true);
    }

    void cierreConfirmar(Frame ventana) {
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Dialog confirmarDialog = new Dialog(ventana,
                        "¿Estás seguro?", true);

                confirmarDialog.setLayout(new FlowLayout());
                confirmarDialog.setSize(250, 120);
                confirmarDialog.setLocationRelativeTo(ventana);

                Label lblMensaje = new Label("¿Estás seguro de salir?");
                Button btnSi = new Button("Sí");
                Button btnNo = new Button("No");

                btnSi.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        System.exit(0); // Cierra todo el programa
                    }
                });
                btnNo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        confirmarDialog.setVisible(false);
                        confirmarDialog.dispose();
                    }
                });
                confirmarDialog.add(lblMensaje);
                confirmarDialog.add(btnSi);
                confirmarDialog.add(btnNo);
                confirmarDialog.setVisible(true);
            }
        });
    }

    void cerrar(Frame ventana){
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (ventana != null){
                    ventana.setVisible(false);
                    ventana.dispose();
                }

            }
        });
    }

    public class ManejadorEventosBoton implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            Object fuente = evento.getSource();

            if (fuente==boton1)  forma2();
            if (fuente==boton2) cerrar(v2);
        }
    }
}

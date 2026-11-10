import java.awt.*;

public class EventosBotones {
    private Frame v1, v2;
    private Button b1, b2;

    public void setBtns(){
        b1 = new Button("Abrir Frame");
        b2 = new Button("Cerrar Frame");
    }

    public void setV1(){
        v1 = new Frame("Ventana Principal");
        v1.setPreferredSize(new Dimension(500, 300));
        v1.setLayout(new FlowLayout());
        v1.add(b1);
        v1.add(b2);
        v1.pack();
        v1.setLocationRelativeTo(null);
    }

    public void setV2(){
        v2 = new Frame("Segunda Ventana");
        v2.setPreferredSize(new Dimension(200, 100));
        v2.setBackground(new Color(195, 150, 210));
        v2.setLayout(new FlowLayout());
        v2.add(new Label("Hola!"));
        v2.pack();
        if (v1 != null) v2.setLocationRelativeTo(v1);
    }

    public void setActions(){

    }

    public void cerrar(Frame v){
        if (v != null){
            v.setVisible(false);
            v.dispose();
        }
    }
}

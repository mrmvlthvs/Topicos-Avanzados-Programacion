import java.awt.*;
import java.util.Vector;
import java.util.Enumeration;
public class PanelDibujo extends Panel {
    // variable miembro
    private Vector v;
    // constructor
    public PanelDibujo(Vector vect) {
        super(new FlowLayout());
        this.v = vect;
    }
    // redefinición del método paint()
    public void paint(Graphics g) {
        Dibujable dib;
        Enumeration e;
        e = v.elements();
        while(e.hasMoreElements()) {
            dib = (Dibujable)e.nextElement();
            dib.dibujar(g);
        }
    }
}
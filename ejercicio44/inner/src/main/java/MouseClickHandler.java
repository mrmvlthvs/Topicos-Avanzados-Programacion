import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MouseClickHandler implements MouseListener { 

    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, 
            "Mouse Clicked en: X=" + e.getX() + " Y=" + e.getY());
    }

    public void mousePressed(MouseEvent e) {
        JOptionPane.showMessageDialog(null, 
            "Mouse Pressed (botón presionado)");
    }

    public void mouseReleased(MouseEvent e) {
        JOptionPane.showMessageDialog(null, 
            "Mouse Released (botón liberado)");
    }

    public void mouseEntered(MouseEvent e) {
        // JOptionPane.showMessageDialog(null, 
        //     "Mouse Entered (cursor dentro del componente)");
    }

    public void mouseExited(MouseEvent e) {
        JOptionPane.showMessageDialog(null, 
            "Mouse Exited (cursor salió del componente)");
    }
}
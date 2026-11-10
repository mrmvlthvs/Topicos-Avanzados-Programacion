// Fichero VentanaCerrable.java     clase adaptadora
 import java.awt.*;
 import java.awt.event.*;

 class VentanaCerrable extends Frame implements WindowListener {  // oyente
   // constructores                                                  de ventanas
   public VentanaCerrable() {}  // constructor por omision

   public VentanaCerrable(String title) {  // constructor sobrecargado
     super(title);
     setSize(500,500);
     addWindowListener(this);
   }
 
   // metodos de la interface WindowsListener
   public void windowActivated(WindowEvent e) {}
   public void windowClosed(WindowEvent e) {}
   public void windowClosing(WindowEvent e) {  System.exit(0);  }
   public void windowDeactivated(WindowEvent e) {}
   public void windowDeiconified(WindowEvent e) {}
   public void windowIconified(WindowEvent e) {}
   public void windowOpened(WindowEvent e) {}
 } // fin de la clase VentanaCerrable


 

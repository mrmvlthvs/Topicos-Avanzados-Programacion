import java.awt.*;     // ojo parecido a ventana Cerrable
import java.awt.event.*;

class OyenteFrame extends WindowAdapter{    // manejo de eventos
  public void windowActivated( WindowEvent evento){
    System.out.println("Ventana activada");
  }
        
  public void windowClosed( WindowEvent evento) {
    System.out.println("Ventana Closed");
    System.exit(0);
  }
        
  public void windowClosing(WindowEvent evento){
    System.out.println("Cerrando Ventana");
    windowClosed(evento);
  }
        
  public void windowDeactivated( WindowEvent evento){
    System.out.println("Ventana desactivada");
  }
        
  public void windowDeiconified (WindowEvent evento){
    System.out.println("Ventana maximizada");
  }
        
  public void windowIconified( WindowEvent evento){
    System.out.println("Ventana minimizada");
  }
        
  public void windowOpened( WindowEvent evento){
    System.out.println("Ventana abierta por primera vez");
  }
}



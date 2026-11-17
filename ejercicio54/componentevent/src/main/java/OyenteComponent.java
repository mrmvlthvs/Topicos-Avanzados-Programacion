import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JTextArea;

//Oyente - 3° Postulado
class OyenteComponent implements ComponentListener {//7°:contratante
  JTextArea display;
  String newline = "\n";
    
  protected void displayMessage(String message) {
        //If the text area is not yet realized, and
        //we tell it to draw text, it could cause
        //a text/AWT tree deadlock. Our solution is
        //to ensure that the text area is realized
        //before attempting to draw text.
       // if (display.isShowing()) {
    display.append(message + newline);
    display.setCaretPosition(display.getDocument().getLength());
        //}
  }
    
  OyenteComponent(JTextArea disp) {  display = disp;  }

  @Override
  public void componentMoved(ComponentEvent e) {
    //Manejador - 4°Postulado       /*Evento Tipo* - 1° Postulado*/
    displayMessage(e.getComponent().getClass().getName() + " --- Moved");
  }

  @Override
  public void componentHidden(ComponentEvent e) {
    //Manejador - 4°Postulado       /*Evento Tipo* - 1° Postulado*/
    displayMessage(e.getComponent().getClass().getName() + " --- Hidden");
  }
    
  public void componentResized(ComponentEvent e) {
    displayMessage(e.getComponent().getClass().getName() + " --- Resized ");            
  }

  public void componentShown(ComponentEvent e) {
    displayMessage(e.getComponent().getClass().getName() + " --- Shown");
  }
}


import java.awt.event.*;
import javax.swing.JLabel;

public class OyenteItem implements ItemListener {
  JLabel label;
  
  OyenteItem(JLabel label) {  this.label = label;  }
  
  public void itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == ItemEvent.SELECTED) {
      label.setVisible(true);
      //Need to revalidate and repaint, or else the label
      //will probably be drawn in the wrong place.
      label.revalidate();
      label.repaint();
    } else label.setVisible(false);
  }
}  

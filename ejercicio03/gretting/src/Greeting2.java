import java.awt.*;
import javax.swing.*;

public class Greeting2 extends JFrame {
  JTextField textField;
  JLabel label;

  void init() {   // define variables del programa y despliegue de meta
    String msg = "Para mostrar un campo de texto en una ventana simple";

    label = new JLabel(msg);
  }

  public static void main (String[] args) {
    Greeting2 frame = new Greeting2();

    frame.init();
    frame.createGUI();
    frame.addWidgets();
    frame.setVisible(true); 
  }

  void addWidgets() {    // despliega la vista
    textField = new JTextField("Hello! primera GUI");
    add(label);
    add(textField);   
  }

  void createGUI() {  // define contexto grafico de la vista
    setSize(300, 200);           
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new FlowLayout() );
  }
}



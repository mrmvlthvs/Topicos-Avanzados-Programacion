/*TempCon.java
Protocolo acostumbrado
por cirino silva tovar
el 22 de septiembre del 2015
para ilustrar el uso de ActionEvent y addActionListener y actionPerformed()
tambien ActionListener
*/

import java.awt.*;    
import javax.swing.*; 
import java.awt.event.*;   

public class TempCon implements ActionListener {    
  private Label centLabel, farLabel;               
  private TextField centigrados, farenheit;
  private Button b;    
  private double c, f;
  private Frame frame;        

  public void inicio() {                             // cortinilla
    JFrame frame = new JFrame();                     // Contenedor 
    ImageIcon peli = new ImageIcon("Tierra10b.jpg"); // carga la imagen.
    JLabel imagenS = new JLabel(peli);            // etiqueta con la imagen

    //System.out.println("Convierte of a oc y viceversa");    
    frame.add(imagenS);        // Add a component with a custom paint method
    frame.setLocation(300, 300); 
    frame.setSize(500, 500);
    frame.setUndecorated(true);// no despliega cintilla de titulo del frame
    frame.setVisible(true);      // Display the frame
    try { Thread.sleep(2000); }  // duerme el hilo principal 2 segundos
    catch (InterruptedException e) {}
    frame.setVisible(false);
  }

  public void datos() {
    centLabel = new Label("Temperatura en oC:");
    centigrados = new TextField(5);
    farLabel = new Label("Temperatura en oF:");
    farenheit = new TextField(5);
    b = new Button("Convertir");   
    b.addActionListener(this);   
  }

  public void launchFrame() {
    frame = new VentanaCerrable("Temperatura");   // WindowEvent    
    frame.setLayout(new FlowLayout());  
    frame.add(centLabel);
    frame.add(centigrados);
    frame.add(farLabel);
    frame.add(farenheit);
    frame.add(b);
    frame.setSize(300,200);
    frame.pack();
    frame.setVisible(true);   
  }

  public boolean isNum(String cad) {
    if (cad != null && cad.length() > 0)
      try {
        Double.parseDouble(cad);
        return true;
      } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null, "No se haga el gracioso");        
        }
    return false;
  }

  public void actionPerformed(ActionEvent e) {   
    String aux, far;                        

    aux = centigrados.getText();
    far = farenheit.getText();
    if (isNum(aux))  {       
        c = Double.parseDouble(aux);
        f = 9*c/5 + 32;
        farenheit.setText(Double.toString(f));  
    } else if (isNum(far)) {
             f = Double.parseDouble(far);
             c = (f-32)*5/9;
             centigrados.setText(Double.toString(c));
           }
  }

  public static void main(String[] args) {
    TempCon tfc = new TempCon();

    tfc.inicio();
    tfc.datos();
    // ojo los calculos los invoca actionPerformed();
    tfc.launchFrame();   // los resultados desplegados en el frame
    // entre bambalinas la jvm maneja el hilo de despacho de eventos
    // e implementa la navegabilidad
  }
} 


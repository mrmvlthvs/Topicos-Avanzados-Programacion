/* TestInner.java
Tecnologico Nacional de Mexico
Instituto Tecnologico de Leon
Ingenieria en Sistemas Computacionales
Topicos avanzados de programacion
martes y jueves 8:45-10:25
viernes 9:35 a 10:25
alumno(a):________________
Tarea # :________________
Fecha:_________________

Algoritmo: 

1. Meta: Para ilustrar el tema de las clases internas, en java se usa un 
         oyente de eventos del MouseMotionListener colocando en un TextField
         la posicion de arrastre del apuntador del mouse en el Frame. 
         Tambien se usa un oyente de eventos MouseListener que reporta cuando
         se hace click en el mouse por medio de un dialogo.      

2. Datos: No hay, pero se despliega un Frame con una etiqueta en la 
          posicion norte y un TextField en la posicion sur de un administrador
          de distribucion de Componentes BorderLayout

3. Calculos u eventos: El oyente detecta la posicion actual del mouse en 
                       el frame mientras es arrastrado y lo guarda en una
                       cadena de texto s usando las prestaciones del evento
                       x = e.getX();      y = e.getY();
                       note que los demas manejadores del mouse quedan 
                       vacios.

4. Resultados: Se despliega la posicion de arrastre del apuntador del mouse
               en el TextField usando la sentencia:
               tf.setText(s);
               Tambien se presenta un dialogo en la pantalla cuando se hace
               click en el mouse.

5. Navegabilidad: Solo se usan los botones de iconifizacion en el frame.
*/

import java.awt.*;   // ejercicio 41 
import java.awt.event.*;

public class TestInner {
  private Frame f;
  private TextField tf;

  public TestInner() {
    f = new Frame("Inner classes example");   // fuente de eventos
    tf = new TextField(30);
  }

  public void launchFrame() {
    Label label = new Label("Click and drag the mouse");

    // Add components to the frame
    f.add(label, BorderLayout.NORTH);
    f.add(tf, BorderLayout.SOUTH);
    // Registering a listener that uses an Inner class
    f.addMouseMotionListener(this.new MyMouseMotionListener());  
    // Registering a listener that uses an extern class
    f.addMouseListener(new MouseClickHandler()); 
    // Size the frame and make it visible
    f.setSize(300, 200);
    f.setVisible(true);
  }

  class MyMouseMotionListener implements MouseMotionListener {  
    // clase interna  hereda de una adaptadora
    public void mouseDragged(MouseEvent e) {     
      // event handler de arrastre del mouse
      String s = "Mouse dragging:  X = "+ e.getX() + " Y = " + e.getY();
        
      tf.setText(s);
    }
	
    public void mouseMoved (MouseEvent e){}
    public void mouseExited (MouseEvent e){}
    public void mouseEntered (MouseEvent e){}
    public void mouseReleased (MouseEvent e){}
    public void mousePressed (MouseEvent e){}
  }

  public static void main(String args[]) {
    TestInner obj = new TestInner();

    obj.launchFrame();
  }
}


/*Action.java
Instituto Tecnologico de Leon
Ingenieria en sistemas computacionales
Topicos avanzados de programacion
martes y jueves 8:45- 10:25
viernes 9:35-10:25
Alumno:______________
foto digital
tarea #:_____________
Fecha pactada:_______
Fecha entrega:_______
*/

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action {
  int count = 1;
  
  public static void main(String[] args) {
    Action a = new Action();    
    Frame frame = new Frame("Example Frame");
    final TextArea textArea = new TextArea("Click button to handle clicks...");
    Button button = new Button("Click Me!!");    
    
    button.addActionListener(new ActionListener() {  // clase anonima oyente
      public void actionPerformed(ActionEvent arg0) {  // de eventos
        textArea.setText(textArea.getText() + "\nButton clicked"+a.count++);
        textArea.setText(textArea.getText() + " tiempo de ocurrencia:"+
                                               arg0.getWhen()+"\n");
        textArea.setText(textArea.getText() + " parametros:"+ 
                                               arg0.paramString()+"\n");
        textArea.setText(textArea.getText() + "modifiers:"+
                                               arg0.getModifiers()+"\n");
        textArea.setText(textArea.getText() + "command:"+
                                               arg0.getActionCommand()+"\n");
      }
    });
    
    frame.add(textArea, BorderLayout.NORTH);
    frame.add(button, BorderLayout.SOUTH);
    frame.setSize(300, 300);
    frame.setVisible(true);   // hilo especial de manejo de eventos
  }
}


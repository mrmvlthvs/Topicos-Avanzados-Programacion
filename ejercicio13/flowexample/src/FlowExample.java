/*
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #13
Fecha: 01/09/2026
*/
import java.awt.Button;
import java.awt.FlowLayout; // Import necesario para manejar eventos de ventana
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowExample {
  private Frame f;
  private Button button1;
  private Button button2;
  private Button button3;

  public FlowExample() {
    f = new Frame("Flow Layout");
    button1 = new Button("Ok");
    button2 = new Button("Open");
    button3 = new Button("Close");
  }

  public void launchFrame() {
    f.setLayout(new FlowLayout());
    f.add(button1);
    f.add(button2);
    f.add(button3);
    
    // ** Solución para cerrar el programa al presionar la X **
    f.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    f.setSize(100,100);
    f.setVisible(true);
  }

  public static void main(String args[]) {
    FlowExample guiWindow = new FlowExample();
    guiWindow.launchFrame();
  }
}
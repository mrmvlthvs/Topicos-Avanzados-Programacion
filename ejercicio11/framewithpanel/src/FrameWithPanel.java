/*
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #11
Fecha: 29/08/2026
*/
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter; // Import necesario
import java.awt.event.WindowEvent; // Import necesario

public class FrameWithPanel {
  private Frame f;

  public FrameWithPanel(String title) {
    f = new Frame(title);
  }
  
  public void launchFrame() {
    f.setSize(200,200);
    f.setBackground(Color.blue);
    f.setLayout(null);  // Override default layout mgr

    Panel pan = new Panel();
    pan.setSize(100,100);
    pan.setBackground(Color.yellow);

    f.add(pan);

    // ** Solución para cerrar el programa al presionar la X **
    f.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    f.setVisible(true);
  }

  public static void main(String args[]) {
    FrameWithPanel guiWindow =
        new FrameWithPanel("Frame with Panel");
    guiWindow.launchFrame();
  }
}
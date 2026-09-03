/*
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #16
Fecha: 01/09/2026
*/

import java.awt.*;

public class ComplexLayoutExample {
  private Frame f;
  private Panel p;
  private Button bw, bc;
  private Button bfile, bhelp;

  public ComplexLayoutExample() {
    f = new Frame("GUI example 3");
    bw = new Button("West");
    bc = new Button("Work space region");
    bfile = new Button("File");
    bhelp = new Button("Help");
  }

  public void launchFrame() {
    // Add bw and bc buttons in the frame border
    f.add(bw, BorderLayout.WEST);
    f.add(bc, BorderLayout.CENTER);
    // Create panel for the buttons in the north border
    p = new Panel();
    p.add(bfile);
    p.add(bhelp);
    f.add(p, BorderLayout.NORTH);
    // Pack the frame and make it visible
    f.pack();
    f.setVisible(true);
  }

  public static void main(String args[]) {
    ComplexLayoutExample gui = new ComplexLayoutExample();
    gui.launchFrame();
  }
}

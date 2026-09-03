/*
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #14
Fecha: 01/09/2026
*/

import java.awt.Button;
import java.awt.Frame; // Import necesario para manejar eventos de ventana
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridExample {
  private Frame f;
  private Button b[] = new Button[6];

  public GridExample() {
    f = new Frame("Grid Example");
    for (int i = 0; i < b.length; i++) 
      b[i] = new Button(Integer.toString(i+1));
  }

  public void launchFrame() {
    f.setLayout(new GridLayout(3,2));
    for (Button boton:b)
      f.add(boton);
    
    // ** Solución para cerrar el programa al presionar la X **
    f.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    f.pack();
    f.setVisible(true);
  }

  public static void main(String args[]) {
    GridExample grid = new GridExample();
    grid.launchFrame();
  }
}
/*
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #3
Fecha: 25/08/2026
*/

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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



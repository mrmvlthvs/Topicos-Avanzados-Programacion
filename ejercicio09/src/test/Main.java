/*
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #9
Fecha: 29/08/2026
*/
package test;

import javax.swing.SwingUtilities;

import model.*;
import view.*;
import controller.*;

public class Main
{
    public static void main(String[] args) {           
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {                                           
                Model model = new Model(0);
                View view = new View("-"); 
                Controller controller = new Controller(model,view);
                controller.contol();
            }
        });  
    }
}

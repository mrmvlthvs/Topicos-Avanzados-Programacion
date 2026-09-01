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
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.View;

public class Controller {

    private Model model;
    private View view;
    private ActionListener actionListener;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
                          
    }
    
    public void contol(){        
        actionListener = (ActionEvent actionEvent) -> {
            linkBtnAndLabel();
        };                
        view.getButton().addActionListener(actionListener);   
    }
    
    private void linkBtnAndLabel(){
        model.incX();                
        view.setText(Integer.toString(model.getX()));
    }    
}
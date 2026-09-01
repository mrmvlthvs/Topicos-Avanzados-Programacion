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
package model;

public class Model {
    
    private int x;
    
    public Model(){
        x = 0;
    }
    
    public Model(int x){
        this.x = x;
    }
    
    public void incX(){
        x++;
    }
    
    public int getX(){
        return x;
    }
}
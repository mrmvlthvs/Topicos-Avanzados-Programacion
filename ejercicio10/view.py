"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #10
Fecha: 29/08/2026
"""
import sys
from model import Person

def showAllView(list):
    print ('In our db we have %i users. Here they are:' % len(list))
    for item in list:
        print (item.name())
        
def startView():
    print ('MVC - the simplest example')
    sys.stdout.write('Do you want to see everyone in my db?[y/n]: ')
    sys.stdout.flush()

def endView():
    print ('Goodbye!')    

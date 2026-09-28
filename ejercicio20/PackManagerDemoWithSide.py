"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #20
Fecha: 01/09/2026 """

from tkinter import *

class PackManagerDemoWithSide:
    window = Tk()  # Create a window
    window.title("Pack Manager Demo 2")  # Set title
    
    Label(window, text="Blue", bg="blue").pack()
    Label(window, text="Red", bg="red").pack(fill=BOTH, expand=1)
    Label(window, text="Green", bg="green").pack(fill=BOTH)
    
    window.mainloop()

PackManagerDemoWithSide()
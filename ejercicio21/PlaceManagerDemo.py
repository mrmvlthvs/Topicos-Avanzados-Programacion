"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #21
Fecha: 01/09/2026 """

from tkinter import *

class PlaceManagerDemo:
    def __init__(self):
        window = Tk()  # Create a window
        window.title("Place Manager Demo")  # Set title
        
        Label(window, text="Blue", bg="blue").place(x=20, y=20)
        Label(window, text="Red", bg="red").place(x=50, y=50)
        Label(window, text="Green", bg="green").place(x=80, y=80)
        
        window.mainloop()


# Ejecutar la aplicación
PlaceManagerDemo()
"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #19
Fecha: 01/09/2026 """

from tkinter import *

class PackManagerDemo:
    def __init__(self):
        window = Tk()  # Create a window
        window.title("Pack Manager Demo 1")  # Set title
        
        Label(window, text="Blue", bg="blue").pack()
        Label(window, text="Red", bg="red").pack()
        Label(window, text="Green", bg="green").pack()
        
        window.mainloop()  # Event loop


# Ejecutar la aplicación
PackManagerDemo()
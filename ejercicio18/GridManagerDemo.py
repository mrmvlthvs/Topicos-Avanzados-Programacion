"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #18
Fecha: 01/09/2026 """

from tkinter import *

class GridManagerDemo:
    window = Tk()
    window.title("Grid Manager Demo")

    message = Message(window, text="This Message widget occupies three rows and two columns")
    message.grid(row=1, column=1, columnspan=2)

    Label(window, text="First Name:").grid(row=1, column=3)
    Entry(window).grid(row=1, column=4, pady=5)

    Label(window, text="Last Name:").grid(row=2, column=3)
    Entry(window).grid(row=2, column=4)

    Button(window, text="Get Name").grid(row=3, column=4, padx=5, pady=5)

    window.mainloop()

GridManagerDemo()
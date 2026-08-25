"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #4
Fecha: 25/08/2026
"""

import tkinter as tk
class Greeting2(tk.Tk):

  def __init__(self):
    super().__init__()
    self.textField = None
    self.label = None

  def init(self):  # define variables del programa y despliegue de meta
    msg = "Para mostrar un campo de texto en una ventana simple"
    self.label = tk.Label(self, text=msg)

  def createGUI(self):  # define contexto grafico de la vista
    self.geometry("300x200")

  def addWidgets(self):  # despliega la vista
    self.textField = tk.Entry(self)
    self.textField.insert(0, "Hello! primera GUI")


    self.label.pack()
    self.textField.pack()


if __name__ == "__main__":
  frame = Greeting2()

  frame.init()
  frame.createGUI()
  frame.addWidgets()
  frame.mainloop()  
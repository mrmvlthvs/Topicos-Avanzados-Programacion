"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #6
Fecha: 25/08/2026
"""


from tkinter import * #Import tkinter

def createGUI():
  global label, button
  
  window = Tk() # Create a root window
  label = Label(window, text = "Welcome to Python") # Create a label
  button = Button(window, text = "Click Me") # Create a button 
  return window 

def show():
  label.pack() # Display the label in the window
  button.pack() # Display the button in the window

def main():
  window = createGUI()
  show()
  window.mainloop() # Create an event loop

main()


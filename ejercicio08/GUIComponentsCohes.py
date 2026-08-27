"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #7
Fecha: 25/08/2026

1.- Meta: Demostrar el uso de los componentes de GUI en Python

2.- Datos: puedes ingresar tu nombre en el campo de texto, elegir el tipo
           de letra con un checkbox, elegir un color con un radio button y
           ademas tienes opciones en un combo box

3.- Calculos o eventos: No hay eventos

4.- Resultado: se presenta un JFrame con dos botones
                                         una etiqueta
					 un textField
					 dos casillas
					 dos radioButtons
					 y un comboBox
 
5.- Navegabilidad: solo botones de iconifizacion
"""                                       
           

from tkinter import * # Import tkinter
    
class GUIComponents:
    def marco1(self, frame1):
         # Add a label to frame1       
        self.lbl = Label(frame1, text = "Programming is fun")
        self.lbl.pack()        

    def createWidgets(self, frame2):
        CheckVar1 = IntVar()
        CheckVar2 = IntVar() 
        self.C1 = Checkbutton(frame2, text = "Bold", variable = CheckVar1, \
                 onvalue = 1, offvalue = 0, height=5, \
                 width = 20)
        self.C2 = Checkbutton(frame2, text = "Italic", variable = CheckVar2, \
                 onvalue = 1, offvalue = 0, height=5, \
                 width = 20)
        self.v1 = StringVar()
        self.btOk = Button(frame2, text = "OK", 
            command = self.processButton)
        self.btCancel = Button(frame2, text = "Cancel", 
            command = self.processButton)
        self.label = Label(frame2, text = "Enter your name: ")
        self.msg = StringVar()
        self.entry = Entry(frame2, textvariable = self.msg)
        self.rbRed = Radiobutton(frame2, text = "Red", bg = "red",
            variable = self.v1, value = 'R', 
            command = self.processRadiobutton) 
        self.rbYellow = Radiobutton(frame2, text = "Yellow", 
            bg = "yellow", variable = self.v1, value = 'Y', 
            command = self.processRadiobutton) 
        
    def __init__(self):
        window = Tk() # Create a window 
        window.title("Show GUI Components") # Set a title
        frame1 = Frame(window) # Create and add a frame to window 
        frame1.pack() 
        frame2 = Frame(window) # Create and add a frame to window 
        frame2.pack()
        self.marco1(frame1)
        self.createWidgets(frame2)
        
        self.btOk.grid(row = 1, column = 1)
        self.btCancel.grid(row = 1, column = 2)
        self.label.grid(row = 1, column = 3)
        self.entry.grid(row = 1, column = 4)
        self.C1.grid(row = 1, column = 5)
        self.C2.grid(row = 1, column = 6)
        self.rbRed.grid(row = 1, column = 7)
        self.rbYellow.grid(row = 1, column = 8)
        
        window.mainloop() # Create an event loop

    def processRadiobutton(self):
        if self.v1.get() == 'R':
            self.lbl["fg"] = "red"
        elif self.v1.get() == 'Y':
            self.lbl["fg"] = "yellow" 
    
    def processButton(self):
        self.lbl["text"] = self.msg.get() # New text for the label
        
GUIComponents() # Create GUI 


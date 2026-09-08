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
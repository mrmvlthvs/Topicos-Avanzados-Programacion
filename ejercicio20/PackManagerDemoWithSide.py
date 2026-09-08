from tkinter import *

class PackManagerDemoWithSide:
    window = Tk()  # Create a window
    window.title("Pack Manager Demo 2")  # Set title
    
    Label(window, text="Blue", bg="blue").pack()
    Label(window, text="Red", bg="red").pack(fill=BOTH, expand=1)
    Label(window, text="Green", bg="green").pack(fill=BOTH)
    
    window.mainloop()

PackManagerDemoWithSide()
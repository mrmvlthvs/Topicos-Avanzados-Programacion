"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #17
Fecha: 01/09/2026 """

import tkinter as tk
import sys

class TkinterLayouts:
    def __init__(self):
        self.opcion = ""
        self.root = None

    # 1. META
    def meta(self):
        msg = (
            "=== GESTORES DE GEOMETRIA (PACK, GRID, PLACE) ===\n"
            "Programa para visualizar los 3 layouts de Tkinter\n"
            "usando ejemplos de python-course.eu estructurados en 5 fases."
        )
        print(msg)

    # 2. DATA
    def data(self):
        self.opcion = input("Seleccione una accion: ").strip()

    # 3. PROCESO (Alta cohesion: prepara los widgets en memoria)
    def proceso(self):
        if self.opcion == "1":
            self.root = tk.Tk()
            self.root.title("Ejemplo Pack")
            tk.Label(self.root, text="Red", bg="red", fg="white").pack(fill=tk.X)
            tk.Label(self.root, text="Green", bg="green").pack(fill=tk.X)
            tk.Label(self.root, text="Blue", bg="blue", fg="white").pack(fill=tk.X)
            
        elif self.opcion == "2":
            self.root = tk.Tk()
            self.root.title("Ejemplo Grid")
            tk.Label(self.root, text="First Name").grid(row=0, column=0)
            tk.Label(self.root, text="Last Name").grid(row=1, column=0)
            tk.Entry(self.root).grid(row=0, column=1)
            tk.Entry(self.root).grid(row=1, column=1)
            
        elif self.opcion == "3":
            self.root = tk.Tk()
            self.root.title("Ejemplo Place")
            self.root.geometry("200x200")
            tk.Label(self.root, text="x=20, y=20", bg="cyan").place(x=20, y=20)
            tk.Label(self.root, text="x=80, y=80", bg="yellow").place(x=80, y=80)
            
        elif self.opcion == "4":
            pass
        else:
            print("ERROR: Opcion invalida. Intente de nuevo.")

    # 4. RESULTADOS (Consume el mainloop liberando el hilo al cerrar)
    def resultados(self):
        if self.root is not None:
            print("-> Desplegando interfaz grafica de Tkinter...")
            self.root.mainloop()
            self.root = None # Limpieza de memoria tras cerrar la ventana

    # 5. NAVEGABILIDAD
    def navegabilidad(self):
        while True:
            print("\n1. Layout Pack\n2. Layout Grid\n3. Layout Place\n4. Salir")
            self.data()
            
            if self.opcion == "4":
                print("Finalizando ejecucion ordenadamente...")
                sys.exit(0)
                
            self.proceso()
            self.resultados()

if __name__ == "__main__":
    app = TkinterLayouts()
    app.meta()
    app.navegabilidad()
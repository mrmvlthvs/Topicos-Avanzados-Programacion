"""
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #25
Fecha: 04/09/2026 """

import os
import zipfile

class GestorZip:
    def __init__(self):
        self.opcion = ""
        self.origen = ""
        self.destino = ""
        self.exito = False

    # 1. META
    def meta(self):
        msg = (
            "=== COMPRESION Y EXTRACCION DE ARCHIVOS ZIP ===\n"
            "Programa para comprimir un directorio (Ej. 23) y descomprimir\n"
            "un archivo ZIP (Ej. 24) utilizando el modulo 'zipfile'."
        )
        print(msg)

    # 2. DATA
    def data(self):
        if self.opcion == "1":
            self.origen = input("Directorio a comprimir: ").strip()
            self.destino = input("Ruta destino (.zip): ").strip()
        elif self.opcion == "2":
            self.origen = input("Ruta del archivo ZIP: ").strip()
            self.destino = input("Directorio de extraccion: ").strip()

    # 3. PROCESO (Integracion de ambas operaciones)
    def proceso(self):
        self.exito = False
        try:
            if self.opcion == "1":
                # Compresion de directorio con rutas relativas
                with zipfile.ZipFile(self.destino, 'w', 
                                     zipfile.ZIP_DEFLATED) as zf:
                    for raiz, _, archivos in os.walk(self.origen):
                        for arch in archivos:
                            ruta = os.path.join(raiz, arch)
                            relativo = os.path.relpath(ruta, self.origen)
                            zf.write(ruta, relativo)
                self.exito = True
                
            elif self.opcion == "2":
                # Extraccion de archivo ZIP
                with zipfile.ZipFile(self.origen, 'r') as zf:
                    zf.extractall(self.destino)
                self.exito = True
                
        except Exception as e:
            print(f"ERROR DURANTE EL PROCESO: {e}")

    # 4. RESULTADOS
    def resultados(self):
        if self.exito:
            if self.opcion == "1":
                print(f"-> Directorio comprimido en: {self.destino}")
            elif self.opcion == "2":
                print(f"-> Archivos extraidos en: {self.destino}")

    # 5. NAVEGABILIDAD
    def navegabilidad(self):
        while True:
            print("\n1. Comprimir directorio a ZIP (Ej. 23)")
            print("2. Extraer archivo ZIP (Ej. 24)")
            print("3. Salir")
            
            self.opcion = input("Seleccione accion: ").strip()
            if self.opcion == "3":
                print("Finalizando ejecucion de manera ordenada...")
                break
            
            if self.opcion in ["1", "2"]:
                self.data()
                self.proceso()
                self.resultados()
            else:
                print("Opcion invalida. Intente de nuevo.")

if __name__ == "__main__":
    app = GestorZip()
    app.meta()
    app.navegabilidad()
/*Tecnológico Nacional de México
 Instituto Tecnógico de León / campus I
 Ingeniería en Sistemas Computacionales 
 Tópicos avanzados de programación
 Martes y jueves 7:00-8:45
 viernes 7:00-7:50
 Alumno(a): _____________
 Ejercicio #: 33-bis
 Fecha: 25 sep 2025
 
 Algoritmo:
 
 1. Meta: Para demostrar el uso de los 4 tipos de lazos en su
          lenguaje de programación. Incluyendo el iterativo for-each
          
 2. Data: Escribe ("Deme el nombre del archivo o <enter> :")  
          nombre = ?
          usar un arreglo name [29] de String
          
2.1       LeeDatos(nombre) : boolean
                flag = false
                i = 0
                AbreArchivo(nombre)
                mientras (nombre.next() != EOF) emmpezaar
                   name[i] = leeSiguienteLinea(nombre) 
                   i = i + 1
                   flag = true       
                terminar
                regresa flag al llamador
                
 3. Calculo: no hay                
 
 4. reporta: 
            para cada nom en Name != null 
                Escribe(nom)
                
5. Navegabilidad: 
     resp = 'S'
     desplegar la meta();
     mientras (resp == 'S') empezar  // lazo condicional
       repite empieza      //lazo repeticional
         nom = data();
         sigue = LeeDatos(nom);
       termina mientras ( not sigue);  
       reporta los datos (name);
       repite empieza
         Escribe("Quiere desplegar otro archivo? s/n:");
         resp = ?
       termina mientras (resp == null);
     terminar             
*/

import java.util.Scanner;
import java.io.*;

class ListaTap {
  String name[] = new String [30];
  Scanner tecla = new Scanner(System.in);
  
  void meta() {
    System.out.println("Para desplegar una lista de nombres");
    System.out.println("del grupo de A Tópicos Avanzados de programación");
    System.out.println("usando un lazo iterativo for-each");
  }
  
  void listaArchivos(String path) {
    File canal = new File(path);
    File []lista = canal.listFiles();
    String l = "Archivos presentes en el subdirectorio de travajo:";
    
    l += path + "\n";
    for (int i = 0; i < lista.length; i++) //lazo contado
      l += lista[i] + "\n";
    System.out.println(l);     
  }
  
  String data(){
    String nombre = null;
    
    do {  //lazo repeticional
      System.out.print("Deme el nombre del archivo o <enter> :");
      nombre = tecla.nextLine();
      if (nombre.equals("")) listaArchivos(".");
    } while(nombre.length() == 0);
    return nombre;
  }
  
  boolean dataArch(String arch) {
    Scanner archi = null;
    File f = null;
    boolean flag = false;
    
    try {
      int i = 0;
      
      f = new File(arch);
      if (f.exists() && f.canRead()) {
        archi = new Scanner(f);     // abre archivo de datos
        while (archi.hasNextLine() && i < name.length)  // lee datos del archivo
          name [i++] = new String(archi.nextLine());  //lazo condicional
        flag = true;  
      }
    } catch (FileNotFoundException fnf) {
        System.out.println("No existe el archivo: "+ arch);
    } finally {
        if (archi != null) archi.close();
    }
    return flag;
  } 
  
   // no hay calculos
  
  void display() { // lazo iterativo for-each para recorrer el arreglo
    for (String n:name) // lazo iterativo for-each
      if (n != null) System.out.println(n);
  }
  
  public static void main(String args[]) {
     ListaTap l = new ListaTap();
     String nom = null;
     boolean sigue = false;
     String resp = "S";
     
     l.meta();
     while (resp.toUpperCase().charAt(0) == 'S') {  // lazo condicional
       do {      //lazo repeticional
         nom = l.data();
         sigue = l.dataArch(nom);
       } while (!sigue);  
       l.display();
       do {
         System.out.print("Quiere desplegar otro archivo? s/n:");
          resp = l.tecla.nextLine();
       } while (resp.length() <=0);
     }  
  } 
}
















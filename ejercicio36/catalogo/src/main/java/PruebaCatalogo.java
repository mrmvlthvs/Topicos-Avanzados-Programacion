/* ~/Escritorio/cir/apuntes/poo/poo 2016/java/u6/RAF/PruebaCatalogo.java
 es una implementacion para probar RandomAccessFile en java.io. 
 terminado el 25 de marzo 2019 
 modificado el 22 de septiembre 2023 para que se ajuste al algoritmo
*/

import java.io.*;
import java.util.*;

public class PruebaCatalogo {
  public static final long TAM = 82;
  Scanner t= new Scanner(System.in);
  Catalogo cat = new Catalogo(this);
  Miscelanius m = new Miscelanius();
  int pos;
  String temp;

  public void inicio() {         // consola
    m.clrScr();
    System.out.println("Para mostrar como se crea un archivo ");
    System.out.println("con datos de acceso aleatorio en java \n");
    System.out.println("Incluye operaciones tipo CRUD");
    System.out.println("Create, Read, Update and Delete");
  }
  
  public int pideNumReg() {
    do {
      System.out.print("No de registro:");
      temp = t.nextLine();
    } while (!m.isNum(temp));
    pos = Integer.parseInt(temp);
    return pos;
  }

  String capField(String captu, int len) {
    String aux;

    do { 
      System.out.print(captu);
      aux = t.nextLine();    
    } while(aux.length() <= 0 || aux.length() >= len);
    return aux;
  }

  void create(RandomAccessFile f) {      // consola
    Persona p = new Persona();
    long pos = 0L;
    
    try {  System.out.println("Registro No: " + f.length()/TAM);  }
    catch (IOException ioe) {  error(7,0L);  }
    p.setNombre(capField("Nombre:", 30));
    p.setDomicilio(capField("Domicilio: ", 30));
    p.setTelefono(capField("Telefono: ", 12));
    completa(p);
    try {  pos = f.getFilePointer()/TAM;  } catch (IOException ioe) {}
    if (!cat.añadeReg(f,p)) error(6, 0L);
    else System.out.println("Registro agregado en pos:" + pos);
  }

  void completa(Persona p) {          // consola
    String nom, dir, tel;

    nom = p.getNombre();
    dir = p.getDomicilio();
    tel = p.getTelefono();
    for (int i = nom.length(); i < 30; i++) nom +=" ";
    for (int i = dir.length(); i < 30; i++) dir +=" ";
    for (int i = tel.length(); i < 12; i++) tel +=" ";
    p.setNombre(nom);
    p.setDomicilio(dir);
    p.setTelefono(tel);
  }

  void encabezado () {
    System.out.println("              Listado de registros");
    System.out.print("_____________________________________________________");
    System.out.println("___________________");
    System.out.print("Num. Nombre                      Direccion");
    System.out.println("                       Telefono"); 
    System.out.print("_____________________________________________________");
    System.out.println("___________________");
  }

  String despMenu() {
    String des;

    System.out.println("                    ______________________");
    System.out.println("                    Crud de personas: Menu");
    System.out.println("                    ______________________");
    System.out.println("\n                            [1] Alta");
    System.out.println("                            [2] Baja");
    System.out.println("                            [3] Cambio");
    System.out.println("                            [4] Consulta");
    System.out.println("                            [5] lista");
    System.out.println("                            [6] Salir");     
    System.out.println("                    ______________________"); 
    do {
      System.out.print("                            Opcion..: ");
      des = t.nextLine();
    } while (!m.isNum(des));
    return des;
  }

  void menu(RandomAccessFile f) throws EOFException, IOException { // consola
    String des;                  // procedimientos en el algoritmo
    long pos;

    do {
      des = despMenu();
      m.clrScr();
      switch (des.charAt(0)) {  
        case '1':create(f);break;
	    case '2':pos = m.capInt("# de registro a borrar:");
                 cat.borra(f,pos);
                 break;
	    case '3':pos = m.capInt("# de registro a modificar:");
                 cat.modifica(f, pos);
                 break;
	    case '4':cat.show(f);
                 break;
	    case '5':encabezado();
                 cat.lista(f);
      }
    } while (des.charAt(0) !='6');
  }

  public static void main(String []args) {      // consola  o persistencia
    PruebaCatalogo pc = new PruebaCatalogo();
    RandomAccessFile raf;

    pc.inicio();
    try {
      raf = new RandomAccessFile("Catalogo.dat", "rw");
      pc.menu(raf);
      raf.close();
    } catch (FileNotFoundException fnfe) { 
        System.out.println("No existe el archivo");
      } catch (IOException ioe) {  pc.error(8,0L);  }
  }

  void error(int i, long r) {      // consola
    switch (i) { 
      case 1: System.out.println("El # de registros es: " + r); break;
      case 2: System.out.println("Registro inexistente.\n"); break;
      case 3: System.out.println("no se leyo ningun byte\n"); break;
      case 4: System.out.println("posicionamiento fallido\n"); break;
      case 5: System.out.println("El apuntador al registro es null"); break;
      case 6: System.out.println("NO se escribio en el archivo"); break;
      case 7: System.out.println("Error de entrada salida");break;
      case 8: System.out.println("main: Error de entrada/salida");
    }
    t.nextLine();
  }

  void captuMod(Persona p) {        // consola
    String aux;

    do {
      System.out.print("Nombre: " + p.getNombre() + " Nuevo Nombre: ");
      aux = t.nextLine();
      if (aux.length() == 0) break; 
    } while(!p.setNombre(aux.substring(0, Math.min(30,aux.length()))));            
    do {
      System.out.print("Direccion: " + p.getDomicilio() + " Nueva Dir:");
      aux = t.nextLine();
      if (aux.length() == 0) break; 
    } while (!p.setDomicilio(aux.substring(0, Math.min(30, aux.length()))));    
    do {
      System.out.print("Telefono: " + p.getTelefono() + " Nuevo tel:");
      aux = t.nextLine();
      if (aux.length() == 0) break;
    } while (!p.setTelefono(aux.substring(0, Math.min(12, aux.length()))));
    completa(p);
  }

  void despReg(Persona p, long pos) {           // consola
    System.out.println("Nombre: " + p.getNombre());
    System.out.println("Direccion: " + p.getDomicilio());
    System.out.println("Telefono: " + p.getTelefono());
    System.out.println("No de registro: " + pos);
    System.out.println();
  }

  void listReg(Persona p, long pos) {           // consola
    System.out.print(pos+" ");
    System.out.print(p.getNombre()+ " ");
    System.out.print(p.getDomicilio()+" ");
    System.out.println(p.getTelefono());
  }
}


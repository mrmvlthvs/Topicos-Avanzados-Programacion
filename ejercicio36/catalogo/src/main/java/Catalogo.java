/**Catalogo.java
@author: Cirino Silva Tovar
@Fecha: 15 de Junio 2016
basado en un programa mio llamado archivo.c
depurado y probado el 20 de Junio 2016
*/

import java.io.*;

public class Catalogo {
  public static final long TAM = 82L;
  private PruebaCatalogo pc;

  public Catalogo(PruebaCatalogo pc) {  this.pc = pc;  }

  public boolean leeReg(RandomAccessFile f, Persona p) {    // persistencia
    boolean flag = false;
	 
    if (p == null) pc.error(5, 0L);
    else try {
      p.setNombre(f.readUTF());
      p.setDomicilio(f.readUTF());
      p.setTelefono(f.readUTF());
      p.setAb(f.readInt());
      flag = true;
    } catch(EOFException e){ 
        System.out.println("Leereg:Se ha alcanzado el fin del archivo\n");
      } catch (IOException e ) {
	      System.out.println("Leereg:Excepción al leer el registro\n");
        }
    return flag;
  }

  public boolean añadeReg(RandomAccessFile f1, Persona p) { // persistencia
    boolean flag = false;
    String aux = "añadeReg:Excepción al escribir registro\n";
    
    if (p != null)		
      try {
        f1.writeUTF(p.getNombre());
        f1.writeUTF(p.getDomicilio());
        f1.writeUTF(p.getTelefono());
        f1.writeInt(p.getAb());
        flag = true;
      } catch (IOException e) {
	      System.out.println(aux);
	      flag = false;
        }
    else pc.error(5, 0L);
    return flag;
  }
 
  long numReg(RandomAccessFile raf) {      // persistencia
    long r = 0L;

    try {  
      r =  raf.length()/TAM;  
      return r;
    } catch (IOException ioe) {  
        System.out.println("numreg : Error de entrada/salida\n"); 
        return 0L;
      }
  }

  void modifica(RandomAccessFile raf, long pos) throws EOFException {  
    long posreal, r;
    String aux;
    Persona p = new Persona();

    posreal = pos*TAM;
    r = numReg(raf);
    if (pos < 0 || pos > r) pc.error(1, r);
    else { 
      try {  raf.seek(posreal);  } catch (IOException ioe) {}
      if (leeReg(raf, p)) 
        if (p.getAb() == 0) {
          pc.captuMod(p);
          pc.completa(p);
          try {  raf.seek(posreal);  } catch (IOException ioe) {}
          if (!añadeReg(raf, p)) pc.error(6, r);
          else System.out.println("Registro modificado pos:"+pos);
        } else pc.error(2, r);
      else pc.error(3, r);
    }  
  }  

  public void borra(RandomAccessFile raf, long pos) throws IOException {
    long posreal, r;
    int temp = 'n';
    Persona p = new Persona();
    
    posreal = pos*TAM;
    r = numReg(raf);
    if (pos < 0 || pos > r) pc.error(4, r);
    else { 
      try {  raf.seek(posreal);  } catch (IOException ioe) {}
      if (leeReg(raf, p)) {
        if (p.getAb() == 0) {  
          pc.despReg(p, pos);
          System.out.print("Comfirma borrar este registro: "+pos+" s/n: ");
          temp = System.in.read();
          System.in.skip(2);
          if (temp == 's' || temp == 'S') {
	        p.setAb(1);
	        try {  raf.seek(posreal);  } catch (IOException ioe) {}
            if (!añadeReg(raf, p)) pc.error(6, r);
            else System.out.println("Registro borrado pos: "+pos);
          }
        } else pc.error(2, r);
      } else pc.error(3, r);	
    }
  }

  void lista(RandomAccessFile raf) {     // persistencia
    Persona p = new Persona();
    long pos = 0L;

    try {  
      raf.seek(0L);  
      while (leeReg(raf, p)) {
        if (p.getAb() != 1) pc.listReg(p, pos);
        else System.out.println("Registro " + pos + " Status borrado:");
        pos = raf.getFilePointer()/TAM;    
      } 
    } catch (IOException ioe) {  
        System.out.println("lista : Error de entrada/salida\n");
      }   
  }

  public void show(RandomAccessFile raf) throws EOFException {    
    int n,pos=0;
    long posreal, r;
    Persona p = new Persona();

    pos = pc.pideNumReg();
    posreal = pos*TAM;
    r = numReg(raf);
    if (pos < 0 || pos > r) pc.error(4, r);
    else { 
      try {  raf.seek(posreal);  } catch (IOException ioe) {}
      if (leeReg(raf, p))   
        if (p.getAb() == 0) pc.despReg(p, pos); 
        else pc.error(2, r);
      else pc.error(3, r);
    }
  }
}


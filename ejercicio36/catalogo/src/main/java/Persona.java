public class Persona {
  private String nombre,
                 domicilio,
                 telefono;
  int ab;   // nota que deberia ser un boolean

  public boolean setNombre(String n) {  
    if (n.length() > 0 ) {
      nombre = n;
      return true;
    } else return false;  
  }

  public boolean setDomicilio(String d) {  
    if (d.length() > 0) {
      domicilio = d;
      return true;
    } else return false;  
  }

  public boolean setTelefono(String t) {  
    if (t.length() > 0 && t.length() < 13) {
      telefono = t;
      return true;
    } else return false;  
  }

  public void setAb(int ab) {  this.ab = ab;  }
  public String getNombre() {  return nombre;  }
  public String getDomicilio() {  return domicilio;  }
  public String getTelefono() {  return telefono;  }
  public int getAb() {  return ab;  }

  public String toString() {
    return "Nombre: "+nombre+"\n"+
           "Domicilio: "+domicilio+"\n"+
           "Telefono: "+telefono+"\n";
  }
}


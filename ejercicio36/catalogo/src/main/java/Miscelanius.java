import java.util.Scanner;

public class Miscelanius {
  Scanner tecla = new Scanner(System.in);
  String aux;
  
  boolean isNum(String cad) {
    try {
      Double.parseDouble(cad);
      return true;
    } catch (NumberFormatException nfe) {
        System.out.println("\nNo se haga el chistoso y digite un numero");
        return false;
      }
  }

  double capReal(String prompt) {
    do {
      System.out.print(prompt);
      aux = tecla.nextLine();
    } while(!isNum(aux));
    return Double.parseDouble(aux);
  }
  
  int capInt(String prompt) {
    do {
      System.out.print(prompt);
      aux = tecla.nextLine();
    } while(!isNum(aux));
    return (int) Math.round(Double.parseDouble(aux));
  }
  
  public static void clrScr() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
}


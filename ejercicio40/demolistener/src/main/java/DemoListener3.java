/*package libro.cap05;    //  java a fondo

1. Meta: Para demostrar los eventos de movimientos del Mouse
         MouseMotionListener la interface que hay que implementar un 
         programa que mueve la ventana aleatoriamente, cuando el cursor del
         mouse se aproxime a una distancia menor a 10 pixeles del boton.

2. Datos: No hay datos de entrada;

3. Calculos: se calcula la distancia entre la posicion del mouse 
             y las dimensines del boton.
             difX1 = Math.abs(pBoton.x-pMouse.x);
             difX2 = Math.abs((pBoton.x+dimBoton.width)-pMouse.x);		
             difY1 = Math.abs(pBoton.y-pMouse.y);
             difY2 = Math.abs((pBoton.y+dimBoton.height)-pMouse.y);

4. Resultados: Si (difX1 < 10 or difX2 < 10 or difY1 < 10 or difY2 < 10)
             calcula nuevas posiciones aleatorias para la ventana y 
             mueve la ventana a la posicion recien calculada
             y = (int) (Math.random()*(dimScreen.height-dimVentana.height));
             x = (int) (Math.random()*(dimScreen.width-dimVentana.width));
             setLocation(x,y);

5. Navegabilidad: no hay, es necesario aplicar la combinacion de teclas 
                  ctrl-c.			
*/

import java.awt.*;   // otorga un apuntador al paquete con 
                     // acceso a cualquier clase dentro de el
                     // pero no permite el acceso a sus subpaquetes
import java.awt.event.*;
import javax.swing.*;                     

public class DemoListener3 extends Frame { // contenedor
  private Button boton;                         
  
  public DemoListener3()	{          // constructor 
    super("Movimientos de Mouse Demo ");
    setLayout(new FlowLayout());	   // administrador de componentes de flujo
    addMouseMotionListener(new OyenteMouse()); // Registra oyente de eventos.		
    boton = new Button("Boton");		
    add(boton);		                 
    setSize(200,150);
    setVisible(true);   // lanza el hilo especial de despacho de eventos
  }
                                                       // clase interna
  class OyenteMouse implements MouseMotionListener{    // oyente de movtos del mouse
    public void mouseMoved(MouseEvent e){  // Event Handler
      int distancia = 10;                  // distancia del mouse al componente
      Point pMouse = e.getPoint();	   // posicion coordenada del puntero 
      Dimension dimBoton=boton.getSize();  // magnitud del boton
      Point pBoton = boton.getLocation();  // posicion coordenada del boton	
      int difX1 = Math.abs(pBoton.x-pMouse.x);
      int difX2 = Math.abs((pBoton.x+dimBoton.width)-pMouse.x);		
      int difY1 = Math.abs(pBoton.y-pMouse.y);
      int difY2 = Math.abs((pBoton.y+dimBoton.height)-pMouse.y);
 
      if( difX1<distancia || difX2 <distancia || 
	        difY1<distancia || difY2 <distancia) {
	      Dimension dimVentana = getSize();				
	      // dimension de la pantalla
	      Dimension dimScreen = getToolkit().getScreenSize();				
	      // nuevas coordenadas (aleatorias) para reubicar la ventana
	      int y = (int) (Math.random()*(dimScreen.height-dimVentana.height));
	      int x = (int) (Math.random()*(dimScreen.width-dimVentana.width));
			  // cambia la ubicacion de la ventana
	      setLocation(x,y);			
      }		
    }

    public void mouseDragged(MouseEvent e) {
      if (e != null)
        JOptionPane.showMessageDialog(null, "Arrastrando el componente");
    }  // Event Handler no codificado 			
  }	

  public static void main(String[] args) {  new DemoListener3(); }
}












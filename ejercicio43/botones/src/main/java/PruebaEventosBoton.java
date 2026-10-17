import javax.swing.*;

public class PruebaEventosBoton {

    void meta(){
        String title = "Prueba de Eventos con Botones";
        String message = """
                Programa que permite probar el manejo de eventos 
                mediante botones, elementos pertenecientes de la 
                biblioteca AWT de Java.""";

        JOptionPane.showMessageDialog(null, message, title,
                JOptionPane.INFORMATION_MESSAGE);
    }

    void data(){

    }

    void proceso(){

    }

    void resultados(){
        EventosBotones obj = new EventosBotones();
        obj.forma1();
    }

    public static void main(String args[]){
        PruebaEventosBoton test = new PruebaEventosBoton();

        test.meta();
        test.resultados();
    }
}  
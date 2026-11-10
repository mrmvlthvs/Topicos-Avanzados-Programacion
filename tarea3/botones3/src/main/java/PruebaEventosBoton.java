import javax.swing.JOptionPane;

public class PruebaEventosBoton {
    private EventosBotones obj;

    void meta(){
        String t = "Prueba de Eventos con Botones";
        String m = "Programa que permite abrir y cerrar ventanas con el uso de "
                + "botones./n Demostrara las prestaciones de los eventos de ";

        JOptionPane.showMessageDialog(null, m, t,
                JOptionPane.INFORMATION_MESSAGE);
    }

}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManejadorEventosBoton implements ActionListener {
    private EventosBotones obj;

    public ManejadorEventosBoton(EventosBotones obj) {
        this.obj = obj;
    }

    @Override
    public void actionPerformed(ActionEvent evento) { 
        Object fuente = evento.getSource(); 
        
        if (fuente == obj.getB1()) obj.mostrarVentana(2);
        if (fuente == obj.getB2()) obj.cerrarVentana(2);
    } 
}
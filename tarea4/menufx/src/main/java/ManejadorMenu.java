import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ManejadorMenu implements EventHandler<ActionEvent> {
    private VistaMenu vista;

    public ManejadorMenu(VistaMenu vista) {this.vista = vista;}

    @Override
    public void handle(ActionEvent evento) {
        Object fuente = evento.getSource();

        if (fuente == vista.getItemNuevo())
            vista.actualizarMensaje("Has presionado la opcion Nuevo");
        if (fuente == vista.getItemAbrir())
            vista.actualizarMensaje("Has presionado la opcion Abrir");
        if (fuente == vista.getItemCopiar())
            vista.actualizarMensaje("Has presionado la opcion Copiar");
        if (fuente == vista.getItemPegar())
            vista.actualizarMensaje("Has presionado la opcion Pegar");
        if (fuente == vista.getItemSalir())
            Platform.exit();
    }
}

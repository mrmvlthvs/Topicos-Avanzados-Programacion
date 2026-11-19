import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaMenu {
    private VBox panelRaiz;
    private HBox cajaMenu;
    private MenuBar barraMenu;
    private Menu menuArchivo;
    private Menu menuEdicion;
    private MenuItem itemNuevo;
    private MenuItem itemAbrir;
    private MenuItem itemSalir;
    private MenuItem itemCopiar;
    private MenuItem itemPegar;
    private Label lblMensaje;
    private Scene escena;

    public void iniciarComponentes() {
        String estiloBorde;
        panelRaiz = new VBox();
        cajaMenu = new HBox();
        barraMenu = new MenuBar();
        estiloBorde = "-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;";

        panelRaiz.setStyle(estiloBorde);
        panelRaiz.setMinSize(350, 250);
    }

    public void configurarEntradas() {
        menuArchivo = new Menu("Archivo");
        menuEdicion = new Menu("Edicion");
        itemNuevo = new MenuItem("Nuevo");
        itemAbrir = new MenuItem("Abrir");
        itemCopiar = new MenuItem("Copiar");
        itemPegar = new MenuItem("Pegar");

        menuArchivo.getItems().addAll(itemNuevo, itemAbrir);
        menuEdicion.getItems().addAll(itemCopiar, itemPegar);
        barraMenu.getMenus().addAll(menuArchivo, menuEdicion);
        cajaMenu.getChildren().add(barraMenu);
    }


    public void asignarOyente(EventHandler<ActionEvent> oyente) {
        itemNuevo.setOnAction(oyente);
        itemAbrir.setOnAction(oyente);
        itemCopiar.setOnAction(oyente);
        itemPegar.setOnAction(oyente);
    }

    public void configurarSalidas() {
        String textoInicial;
        textoInicial = "Presione cualquier opcion del menu";
        lblMensaje = new Label(textoInicial);

        panelRaiz.getChildren().addAll(cajaMenu, lblMensaje);
        escena = new Scene(panelRaiz);
    }

    public void configurarNavegabilidad(EventHandler<ActionEvent> oyente) {
        itemSalir = new MenuItem("Salir");

        itemSalir.setOnAction(oyente);
        menuArchivo.getItems().add(itemSalir);
    }

    public void mostrarVentana(Stage escenario) {
        escenario.setScene(escena);
        escenario.setTitle("Ejemplo de Menu JavaFX");
        escenario.show();
    }

    public void actualizarMensaje(String mensaje) {
        lblMensaje.setText(mensaje);
    }

    public MenuItem getItemNuevo() {return itemNuevo;}

    public MenuItem getItemAbrir() {return itemAbrir;}

    public MenuItem getItemSalir() {return itemSalir;}

    public MenuItem getItemCopiar() {return itemCopiar;}

    public MenuItem getItemPegar() {return itemPegar;}
}

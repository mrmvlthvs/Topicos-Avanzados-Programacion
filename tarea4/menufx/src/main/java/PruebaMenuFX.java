import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PruebaMenuFX extends Application {
    private VistaMenu vista;
    private ManejadorMenu oyente;

    public void goal() {
        Alert alerta = new Alert(AlertType.INFORMATION);

        alerta.setTitle("Ejemplo de Menu JavaFX");
        alerta.setHeaderText("Meta del Programa");
        alerta.setContentText(
                "Programa que demuestra el funcionamiento de una barra de menú "
                        + "(MenuBar) con opciones interactivas ."
        );
        alerta.showAndWait();
    }

    // --------- I. INICIO DE COMPONENTES GRAFICOS ---------------
    public void inicio() {
        vista = new VistaMenu();
        vista.iniciarComponentes();
        vista.configurarEntradas();
    }

    // --------- II. DATOS O ENTRADAS GRÁFICAS -------------------
    // NO HAY ENTRADA DE DATOS CRUDOS

    // --------- III. TRANSFORMACIONES POR EVENTOS ---------------
    public void transformaciones() {
        oyente = new ManejadorMenu(vista);

        vista.asignarOyente(oyente);
    }

    // --------- IV. RESULTADOS O SALIDAS --------------------
    public void resultados() {vista.configurarSalidas();}

    // -------------------- V. NAVEGABILIDAD --------------------
    public void navegabilidad(Stage escenario) {
        vista.configurarNavegabilidad(oyente);
        vista.mostrarVentana(escenario);
    }

    @Override
    public void start(Stage escenario) {
        goal();
        inicio();
        transformaciones();
        resultados();
        navegabilidad(escenario);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

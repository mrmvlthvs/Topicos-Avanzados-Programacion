package principal;

import controlador.ControladorCombateFX;
import controlador.ControladorMandosFX;
import controlador.ControladorTecladoFX;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.Combate;
import vista.DialogoRegistroFX;
import vista.VentanaMarcadorFX;

public class PruebaMarcadorTaekwondoFX extends Application {
    private Stage escenarioPrincipal;
    private Combate combate;
    private VentanaMarcadorFX ventana;
    private ControladorCombateFX ctrlCombate;
    private ControladorMandosFX ctrlMandos;

    @Override
    public void start(Stage primaryStage) {
        this.escenarioPrincipal = primaryStage;

        meta();
        if (data()) {
            proceso();
            resultados();
            navegabilidad();
        } else {
            System.out.println("Registro cancelado por el usuario.");
            Platform.exit();
            System.exit(0);
        }
    }

    // 1. META
    public void meta() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Marcador Electrónico de Taekwondo - ITL");
        alerta.setHeaderText("Sistema Oficial de Puntuación en Arena");
        alerta.setContentText(
                "Interfaz en pantalla completa para combates entre CHUNG (Azul)\n" +
                        "y HONG (Rojo), con soporte simultáneo para teclado y dos\n" +
                        "mandos de consola."
        );
        alerta.showAndWait();
    }

    // 2. DATA (Captura inicial de competidores y tiempo de combate)
    public boolean data() {
        DialogoRegistroFX dialogo = new DialogoRegistroFX();
        dialogo.showAndWait();
        combate = dialogo.getCombateCreado();
        return combate != null;
    }

    // 3. PROCESO (Construcción de la vista FX y vinculación de controladores)
    public void proceso() {
        ventana = new VentanaMarcadorFX(escenarioPrincipal);
        ventana.actualizarVista(combate);

        ctrlCombate = new ControladorCombateFX(combate, ventana);
        ctrlMandos = new ControladorMandosFX(combate, ventana, ctrlCombate);
        ctrlCombate.setControladorMandos(ctrlMandos);
    }

    // 4. RESULTADOS (Despliegue visual en pantalla completa)
    public void resultados() {
        escenarioPrincipal.show();
        escenarioPrincipal.setFullScreen(true);
    }

    // 5. NAVEGABILIDAD (Activación de eventos de teclado y mandos)
    public void navegabilidad() {
        ControladorTecladoFX ctrlTeclado = new ControladorTecladoFX(combate, ventana, ctrlCombate);
        escenarioPrincipal.getScene().setOnKeyPressed(ctrlTeclado);

        Thread hiloMandos = new Thread(ctrlMandos);
        hiloMandos.setDaemon(true);
        hiloMandos.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
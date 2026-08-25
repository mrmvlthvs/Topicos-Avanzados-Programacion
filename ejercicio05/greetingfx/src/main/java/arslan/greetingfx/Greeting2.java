package arslan.greetingfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Greeting2 extends Application {
    TextField textField;
    Label label;

    // Contenedor principal necesario para JavaFX (equivalente al ContentPane/Layout del JFrame)
    FlowPane root;
    Scene scene;
    Stage primaryStage;

    void initVariables() {   // Nota: 'init' ya es un método reservado de Application en JavaFX, por lo que se ajusta el nombre manteniendo la estructura
        String msg = "Para mostrar un campo de texto en una ventana simple";
        label = new Label(msg);
    }

    void createGUI(Stage stage) {  // define contexto grafico de la vista
        this.primaryStage = stage;
        root = new FlowPane();
        scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Greeting2");
        primaryStage.setScene(scene);
        // setDefaultCloseOperation(EXIT_ON_CLOSE) en JavaFX es automático al cerrar la última ventana o la Stage principal
    }

    void addWidgets() {     // despliega la vista
        textField = new TextField("Hello! primera GUI");

        // En JavaFX se añaden los componentes directamente al contenedor (Layout)
        root.getChildren().add(label);
        root.getChildren().add(textField);
    }

    // Método de entrada estándar de JavaFX
    @Override
    public void start(Stage primaryStage) {
        Greeting2 frame = this;

        frame.initVariables();
        frame.createGUI(primaryStage);
        frame.addWidgets();
        frame.setVisible(true);
    }

    // Método simulado para mantener exactamente la instrucción frame.setVisible(true)
    void setVisible(boolean visible) {
        if (visible && primaryStage != null) {
            primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args); // Lanza la aplicación JavaFX
    }
}
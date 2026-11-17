package vista;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Combate;
import modelo.Competidor;

public class DialogoRegistroFX extends Stage {
    private TextField txtNombreChung, txtEquipoChung;
    private TextField txtNombreHong, txtEquipoHong;
    private ComboBox<String> cmbTiempo;
    private Combate combateCreado;

    public DialogoRegistroFX() {
        setTitle("Registro Oficial de Combate - Taekwondo");
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        BorderPane raiz = new BorderPane();
        raiz.setPadding(new Insets(20));
        raiz.setStyle("-fx-background-color: #151922;");

        Label lblTitulo = new Label("REGISTRO DE COMPETIDORES");
        lblTitulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        BorderPane.setAlignment(lblTitulo, Pos.CENTER);
        BorderPane.setMargin(lblTitulo, new Insets(0, 0, 15, 0));
        raiz.setTop(lblTitulo);

        // Panel central con tarjetas CHUNG y HONG
        HBox panelCentro = new HBox(20);
        panelCentro.setAlignment(Pos.CENTER);

        // CHUNG (Azul)
        VBox panelChung = new VBox(8);
        panelChung.setPadding(new Insets(15));
        panelChung.setPrefWidth(260);
        panelChung.setStyle("-fx-background-color: #0D47A1; -fx-background-radius: 12;");

        Label lblTituloChung = new Label("CHUNG (AZUL)");
        lblTituloChung.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        Label lblNomC = new Label("Nombre:");
        lblNomC.setStyle("-fx-text-fill: #E3F2FD;");
        txtNombreChung = new TextField("Competidor Azul");
        Label lblEqC = new Label("Equipo / País:");
        lblEqC.setStyle("-fx-text-fill: #E3F2FD;");
        txtEquipoChung = new TextField("ITL León");

        panelChung.getChildren().addAll(lblTituloChung, lblNomC, txtNombreChung, lblEqC, txtEquipoChung);

        // HONG (Rojo)
        VBox panelHong = new VBox(8);
        panelHong.setPadding(new Insets(15));
        panelHong.setPrefWidth(260);
        panelHong.setStyle("-fx-background-color: #B71C1C; -fx-background-radius: 12;");

        Label lblTituloHong = new Label("HONG (ROJO)");
        lblTituloHong.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        Label lblNomH = new Label("Nombre:");
        lblNomH.setStyle("-fx-text-fill: #FFEBEE;");
        txtNombreHong = new TextField("Competidor Rojo");
        Label lblEqH = new Label("Equipo / País:");
        lblEqH.setStyle("-fx-text-fill: #FFEBEE;");
        txtEquipoHong = new TextField("Guanajuato");

        panelHong.getChildren().addAll(lblTituloHong, lblNomH, txtNombreHong, lblEqH, txtEquipoHong);

        panelCentro.getChildren().addAll(panelChung, panelHong);
        raiz.setCenter(panelCentro);

        // Panel inferior: Duración y botones
        VBox panelSur = new VBox(15);
        panelSur.setPadding(new Insets(18, 0, 0, 0));
        panelSur.setAlignment(Pos.CENTER);

        HBox filaTiempo = new HBox(10);
        filaTiempo.setAlignment(Pos.CENTER);
        Label lblTiempo = new Label("Duración del Combate:");
        lblTiempo.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 14px;");

        cmbTiempo = new ComboBox<String>(FXCollections.observableArrayList(
                "15 segundos (Prueba rápida)",
                "1 minuto (01:00)",
                "1 minuto 30 seg (01:30)",
                "2 minutos (02:00)"
        ));
        cmbTiempo.getSelectionModel().select(3);
        filaTiempo.getChildren().addAll(lblTiempo, cmbTiempo);

        HBox filaBotones = new HBox(15);
        filaBotones.setAlignment(Pos.CENTER);
        Button btnIniciar = new Button("Abrir Marcador en Pantalla Completa");
        btnIniciar.setStyle("-fx-background-color: #2E7D32; -fx-text-fill: #FFFFFF; -fx-font-weight: bold; -fx-padding: 8 16;");
        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setStyle("-fx-background-color: #424242; -fx-text-fill: #FFFFFF; -fx-padding: 8 16;");

        btnIniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                registrarYContinuar();
            }
        });

        btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                combateCreado = null;
                close();
            }
        });

        filaBotones.getChildren().addAll(btnIniciar, btnCancelar);
        panelSur.getChildren().addAll(filaTiempo, filaBotones);
        raiz.setBottom(panelSur);

        Scene escena = new Scene(raiz, 580, 390);
        setScene(escena);
    }

    private void registrarYContinuar() {
        String nomChung = txtNombreChung.getText().trim();
        String eqChung = txtEquipoChung.getText().trim();
        String nomHong = txtNombreHong.getText().trim();
        String eqHong = txtEquipoHong.getText().trim();

        if (nomChung.isEmpty() || eqChung.isEmpty() || nomHong.isEmpty() || eqHong.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Datos Incompletos");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor completa todos los campos de ambos competidores.");
            alerta.showAndWait();
            return;
        }

        int segundos = 120;
        switch (cmbTiempo.getSelectionModel().getSelectedIndex()) {
            case 0: segundos = 15; break;
            case 1: segundos = 60; break;
            case 2: segundos = 90; break;
            case 3: segundos = 120; break;
        }

        Competidor chung = new Competidor(nomChung, eqChung, "CHUNG");
        Competidor hong = new Competidor(nomHong, eqHong, "HONG");
        combateCreado = new Combate(chung, hong, segundos);
        close();
    }

    public Combate getCombateCreado() {
        return combateCreado;
    }
}
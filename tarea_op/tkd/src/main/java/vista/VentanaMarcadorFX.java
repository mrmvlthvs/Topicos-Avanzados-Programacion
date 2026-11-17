package vista;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Combate;

public class VentanaMarcadorFX {
    private Stage escenario;
    private Label lblPuntosChung, lblPuntosHong;
    private Label lblNombreChung, lblEquipoChung;
    private Label lblNombreHong, lblEquipoHong;
    private Label lblTiempo, lblRound, lblEstadoMandos;
    private Region[] indicadoresFaltaChung;
    private Region[] indicadoresFaltaHong;
    private Button btnIniciarPausar, btnFinalizar, btnSalir;
    private int puntosPreviosChung = 0;
    private int puntosPreviosHong = 0;

    public VentanaMarcadorFX(Stage escenario) {
        this.escenario = escenario;
        this.indicadoresFaltaChung = new Region[5];
        this.indicadoresFaltaHong = new Region[5];
        construirInterfaz();
    }

    private void construirInterfaz() {
        BorderPane raiz = new BorderPane();
        raiz.getStyleClass().add("fondo-arena");

        // --- BARRA SUPERIOR ---
        BorderPane barraSuperior = new BorderPane();
        barraSuperior.getStyleClass().add("barra-superior");
        barraSuperior.setPadding(new Insets(12, 30, 12, 30));

        lblRound = new Label("ROUND 1");
        lblRound.getStyleClass().add("etiqueta-round");
        BorderPane.setAlignment(lblRound, Pos.CENTER_LEFT);

        lblTiempo = new Label("02:00");
        lblTiempo.getStyleClass().add("reloj-combate");

        lblEstadoMandos = new Label("Mandos: Detectando...");
        lblEstadoMandos.setStyle("-fx-text-fill: #90A4AE; -fx-font-size: 14px;");
        BorderPane.setAlignment(lblEstadoMandos, Pos.CENTER_RIGHT);

        barraSuperior.setLeft(lblRound);
        barraSuperior.setCenter(lblTiempo);
        barraSuperior.setRight(lblEstadoMandos);
        raiz.setTop(barraSuperior);

        // --- PANEL CENTRAL (Tarjetas CHUNG y HONG) ---
        HBox contenedorTarjetas = new HBox(30);
        contenedorTarjetas.setPadding(new Insets(25, 35, 25, 35));
        contenedorTarjetas.setAlignment(Pos.CENTER);

        VBox tarjetaChung = crearTarjetaCompetidor("tarjeta-chung", true);
        VBox tarjetaHong = crearTarjetaCompetidor("tarjeta-hong", false);

        HBox.setHgrow(tarjetaChung, Priority.ALWAYS);
        HBox.setHgrow(tarjetaHong, Priority.ALWAYS);
        contenedorTarjetas.getChildren().addAll(tarjetaChung, tarjetaHong);
        raiz.setCenter(contenedorTarjetas);

        // --- BARRA INFERIOR ---
        HBox barraInferior = new HBox(20);
        barraInferior.setPadding(new Insets(12, 20, 18, 20));
        barraInferior.setAlignment(Pos.CENTER);

        btnIniciarPausar = new Button("Iniciar Tiempo (Espacio)");
        btnFinalizar = new Button("Finalizar Combate");
        btnSalir = new Button("Salir");

        btnIniciarPausar.getStyleClass().add("boton-control");
        btnFinalizar.getStyleClass().add("boton-control");
        btnSalir.getStyleClass().add("boton-control");

        // Evita que los botones capturen la barra espaciadora
        btnIniciarPausar.setFocusTraversable(false);
        btnFinalizar.setFocusTraversable(false);
        btnSalir.setFocusTraversable(false);

        barraInferior.getChildren().addAll(btnIniciarPausar, btnFinalizar, btnSalir);
        raiz.setBottom(barraInferior);

        Scene escena = new Scene(raiz);
        escena.getStylesheets().add(getClass().getResource("/recursos/estilos.css").toExternalForm());

        escenario.setTitle("Marcador Oficial Taekwondo");
        escenario.setScene(escena);
        escenario.setFullScreen(true);
        escenario.setFullScreenExitHint("");
    }

    private VBox crearTarjetaCompetidor(String claseCss, boolean esChung) {
        VBox tarjeta = new VBox(10);
        tarjeta.getStyleClass().add(claseCss);
        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.setPadding(new Insets(25));
        tarjeta.setMaxWidth(Double.MAX_VALUE);

        Label lblNombre = new Label(esChung ? "CHUNG" : "HONG");
        lblNombre.getStyleClass().add("nombre-competidor");

        Label lblEquipo = new Label("EQUIPO");
        lblEquipo.getStyleClass().add("equipo-competidor");

        Label lblPuntos = new Label("0");
        lblPuntos.getStyleClass().add("numero-puntos");
        VBox.setVgrow(lblPuntos, Priority.ALWAYS);

        // Barra de 5 cuadros visuales para Gam-jeom
        HBox barraFaltas = new HBox(12);
        barraFaltas.setAlignment(Pos.CENTER);
        Label txtFalta = new Label("GAM-JEOM:");
        txtFalta.setStyle("-fx-text-fill: #FFD600; -fx-font-weight: bold; -fx-font-size: 18px;");
        barraFaltas.getChildren().add(txtFalta);

        Region[] cuadros = new Region[5];
        for (int i = 0; i < 5; i++) {
            Region cuadro = new Region();
            cuadro.setPrefSize(32, 18);
            cuadro.getStyleClass().add("falta-inactiva");
            cuadros[i] = cuadro;
            barraFaltas.getChildren().add(cuadro);
        }

        tarjeta.getChildren().addAll(lblNombre, lblEquipo, lblPuntos, barraFaltas);

        if (esChung) {
            lblNombreChung = lblNombre;
            lblEquipoChung = lblEquipo;
            lblPuntosChung = lblPuntos;
            indicadoresFaltaChung = cuadros;
        } else {
            lblNombreHong = lblNombre;
            lblEquipoHong = lblEquipo;
            lblPuntosHong = lblPuntos;
            indicadoresFaltaHong = cuadros;
        }

        return tarjeta;
    }

    public void actualizarVista(Combate combate) {
        lblNombreChung.setText(combate.getChung().getNombre().toUpperCase());
        lblEquipoChung.setText(combate.getChung().getEquipo().toUpperCase());

        int ptsChung = combate.getChung().getPuntos();
        lblPuntosChung.setText(String.valueOf(ptsChung));
        if (ptsChung != puntosPreviosChung) {
            animarPunto(lblPuntosChung);
            puntosPreviosChung = ptsChung;
        }

        lblNombreHong.setText(combate.getHong().getNombre().toUpperCase());
        lblEquipoHong.setText(combate.getHong().getEquipo().toUpperCase());

        int ptsHong = combate.getHong().getPuntos();
        lblPuntosHong.setText(String.valueOf(ptsHong));
        if (ptsHong != puntosPreviosHong) {
            animarPunto(lblPuntosHong);
            puntosPreviosHong = ptsHong;
        }

        actualizarFaltas(indicadoresFaltaChung, combate.getChung().getGamJeoms());
        actualizarFaltas(indicadoresFaltaHong, combate.getHong().getGamJeoms());
        lblTiempo.setText(combate.obtenerTiempoFormateado());
    }

    private void actualizarFaltas(Region[] cuadros, int cantidad) {
        for (int i = 0; i < cuadros.length; i++) {
            cuadros[i].getStyleClass().removeAll("falta-activa", "falta-inactiva");
            if (i < cantidad) {
                cuadros[i].getStyleClass().add("falta-activa");
            } else {
                cuadros[i].getStyleClass().add("falta-inactiva");
            }
        }
    }

    private void animarPunto(Label etiqueta) {
        ScaleTransition pulso = new ScaleTransition(Duration.millis(160), etiqueta);
        pulso.setFromX(1.0);
        pulso.setFromY(1.0);
        pulso.setToX(1.15);
        pulso.setToY(1.15);
        pulso.setCycleCount(2);
        pulso.setAutoReverse(true);
        pulso.play();
    }

    public void actualizarEstadoMandos(String texto) {
        lblEstadoMandos.setText(texto);
    }

    public Button getBtnIniciarPausar() { return btnIniciarPausar; }
    public Button getBtnFinalizar() { return btnFinalizar; }
    public Button getBtnSalir() { return btnSalir; }
}
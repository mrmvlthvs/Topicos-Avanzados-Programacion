package controlador;

import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import modelo.Combate;
import vista.VentanaMarcadorFX;

public class ControladorCombateFX {
    private Combate combate;
    private VentanaMarcadorFX vista;
    private Timeline cronometro;
    private ControladorMandosFX ctrlMandos;
    private boolean combateTerminado;

    public ControladorCombateFX(Combate combate, VentanaMarcadorFX vista) {
        this.combate = combate;
        this.vista = vista;
        this.combateTerminado = false;
        configurarCronometro();
        configurarEventosBotones();
    }

    private void configurarCronometro() {
        cronometro = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                combate.descontarSegundo();
                vista.actualizarVista(combate);

                if (combate.getTiempoRestanteSegundos() == 0 && !combateTerminado) {
                    finalizarCombate();
                }
            }
        }));
        cronometro.setCycleCount(Timeline.INDEFINITE);
    }

    private void configurarEventosBotones() {
        vista.getBtnIniciarPausar().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                alternarTiempo();
            }
        });

        vista.getBtnFinalizar().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                finalizarCombate();
            }
        });

        vista.getBtnSalir().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmarSalida();
            }
        });
    }

    public void alternarTiempo() {
        if (combateTerminado) return;

        if (combate.isEnCurso()) {
            combate.setEnCurso(false);
            cronometro.pause();
            vista.getBtnIniciarPausar().setText("Reanudar Tiempo (Espacio)");
        } else {
            combate.setEnCurso(true);
            cronometro.play();
            vista.getBtnIniciarPausar().setText("Pausar Tiempo (Espacio)");
        }
    }

    public void verificarFinPorFaltas() {
        if (!combateTerminado &&
                (combate.getChung().getGamJeoms() >= 5 || combate.getHong().getGamJeoms() >= 5)) {
            finalizarCombate();
        }
    }

    public void finalizarCombate() {
        combateTerminado = true;
        combate.setEnCurso(false);
        cronometro.stop();
        vista.getBtnIniciarPausar().setDisable(true);

        String mensaje =
                "CHUNG (" + combate.getChung().getNombre() + " - " + combate.getChung().getEquipo() + "): " +
                        combate.getChung().getPuntos() + " pts (Gam-jeom: " + combate.getChung().getGamJeoms() + ")\n" +
                        "HONG (" + combate.getHong().getNombre() + " - " + combate.getHong().getEquipo() + "): " +
                        combate.getHong().getPuntos() + " pts (Gam-jeom: " + combate.getHong().getGamJeoms() + ")\n\n" +
                        combate.determinarGanador();

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Combate Finalizado");
        alerta.setHeaderText("RESULTADO OFICIAL DEL COMBATE");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void confirmarSalida() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION,
                "¿Deseas cerrar el marcador y salir del sistema?",
                ButtonType.YES, ButtonType.NO);
        alerta.setTitle("Confirmar Salida");
        alerta.setHeaderText(null);

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.YES) {
            if (ctrlMandos != null) {
                ctrlMandos.detener();
            }
            cronometro.stop();
            Platform.exit();
            System.exit(0);
        }
    }

    public void setControladorMandos(ControladorMandosFX ctrlMandos) {
        this.ctrlMandos = ctrlMandos;
    }
}
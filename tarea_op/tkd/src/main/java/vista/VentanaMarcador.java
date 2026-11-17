package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo.Combate;

public class VentanaMarcador extends JFrame {
    private JLabel lblPuntosChung, lblPuntosHong;
    private JLabel lblNombreChung, lblEquipoChung, lblFaltasChung;
    private JLabel lblNombreHong, lblEquipoHong, lblFaltasHong;
    private JLabel lblTiempo, lblEstadoMandos;
    private JButton btnIniciarPausar, btnFinalizar, btnSalir;

    public VentanaMarcador() {
        setTitle("Marcador Electrónico Taekwondo");
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setFocusable(true);
        construirInterfaz();
    }

    private void construirInterfaz() {
        setLayout(new BorderLayout());

        // --- PANEL SUPERIOR (Cronómetro y Estado de Mandos) ---
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(20, 20, 20));
        panelSuperior.setBorder(new EmptyBorder(10, 25, 10, 25));

        lblTiempo = new JLabel("02:00", SwingConstants.CENTER);
        lblTiempo.setFont(new Font("Consolas", Font.BOLD, 85));
        lblTiempo.setForeground(Color.YELLOW);

        lblEstadoMandos = new JLabel("Mandos: Buscando dispositivos...", SwingConstants.RIGHT);
        lblEstadoMandos.setFont(new Font("Arial", Font.PLAIN, 14));
        lblEstadoMandos.setForeground(Color.LIGHT_GRAY);

        panelSuperior.add(lblTiempo, BorderLayout.CENTER);
        panelSuperior.add(lblEstadoMandos, BorderLayout.EAST);
        add(panelSuperior, BorderLayout.NORTH);

        // --- PANEL CENTRAL (Marcadores CHUNG vs HONG) ---
        JPanel panelMarcadores = new JPanel(new GridLayout(1, 2));

        // Lado Izquierdo: CHUNG (Azul)
        JPanel panelChung = crearPanelCompetidor(new Color(13, 71, 161), true);
        panelMarcadores.add(panelChung);

        // Lado Derecho: HONG (Rojo)
        JPanel panelHong = crearPanelCompetidor(new Color(183, 28, 28), false);
        panelMarcadores.add(panelHong);

        add(panelMarcadores, BorderLayout.CENTER);

        // --- PANEL INFERIOR (Controles y Guía Rápida) ---
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBackground(new Color(25, 25, 25));
        panelInferior.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel lblGuia = new JLabel(
                "<html><center><b>TECLADO CHUNG:</b> [Q]+1 | [W]+2 | [E]+3 | [R]+4 | [T]+5 | [A]Gam-jeom | [Z]-1" +
                        "&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;" +
                        "<b>TECLADO HONG:</b> [U]+1 | [I]+2 | [O]+3 | [P]+4 | [L]+5 | [J]Gam-jeom | [M]-1" +
                        "<br><b>MANDOS CONSOLA:</b> Mando 1 = CHUNG | Mando 2 = HONG (Botones 1-4 = +1 a +4 pts, L1/R1 = +5 pts, Select = Gam-jeom)</center></html>",
                SwingConstants.CENTER
        );
        lblGuia.setForeground(Color.WHITE);
        lblGuia.setFont(new Font("Arial", Font.PLAIN, 13));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panelBotones.setOpaque(false);

        btnIniciarPausar = new JButton("Iniciar Tiempo (Espacio)");
        btnFinalizar = new JButton("Finalizar Combate");
        btnSalir = new JButton("Salir");

        // Evita que los botones roben el foco del teclado
        btnIniciarPausar.setFocusable(false);
        btnFinalizar.setFocusable(false);
        btnSalir.setFocusable(false);

        panelBotones.add(btnIniciarPausar);
        panelBotones.add(btnFinalizar);
        panelBotones.add(btnSalir);

        panelInferior.add(lblGuia, BorderLayout.NORTH);
        panelInferior.add(panelBotones, BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel crearPanelCompetidor(Color colorFondo, boolean esChung) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorFondo);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        JPanel panelDatos = new JPanel(new GridLayout(2, 1));
        panelDatos.setOpaque(false);
        panelDatos.setBorder(new EmptyBorder(20, 20, 10, 20));

        JLabel lblNombre = new JLabel(esChung ? "CHUNG" : "HONG", SwingConstants.CENTER);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 38));
        lblNombre.setForeground(Color.WHITE);

        JLabel lblEquipo = new JLabel("EQUIPO", SwingConstants.CENTER);
        lblEquipo.setFont(new Font("Arial", Font.PLAIN, 24));
        lblEquipo.setForeground(new Color(230, 230, 230));

        panelDatos.add(lblNombre);
        panelDatos.add(lblEquipo);

        JLabel lblPuntos = new JLabel("0", SwingConstants.CENTER);
        lblPuntos.setFont(new Font("Arial", Font.BOLD, 240));
        lblPuntos.setForeground(Color.WHITE);

        JLabel lblFaltas = new JLabel("GAM-JEOM: 0", SwingConstants.CENTER);
        lblFaltas.setFont(new Font("Arial", Font.BOLD, 26));
        lblFaltas.setForeground(Color.YELLOW);
        lblFaltas.setBorder(new EmptyBorder(10, 10, 25, 10));

        panel.add(panelDatos, BorderLayout.NORTH);
        panel.add(lblPuntos, BorderLayout.CENTER);
        panel.add(lblFaltas, BorderLayout.SOUTH);

        if (esChung) {
            lblNombreChung = lblNombre;
            lblEquipoChung = lblEquipo;
            lblPuntosChung = lblPuntos;
            lblFaltasChung = lblFaltas;
        } else {
            lblNombreHong = lblNombre;
            lblEquipoHong = lblEquipo;
            lblPuntosHong = lblPuntos;
            lblFaltasHong = lblFaltas;
        }

        return panel;
    }

    public void actualizarVista(Combate combate) {
        lblNombreChung.setText(combate.getChung().getNombre().toUpperCase());
        lblEquipoChung.setText(combate.getChung().getEquipo().toUpperCase());
        lblPuntosChung.setText(String.valueOf(combate.getChung().getPuntos()));
        lblFaltasChung.setText("GAM-JEOM: " + combate.getChung().getGamJeoms());

        lblNombreHong.setText(combate.getHong().getNombre().toUpperCase());
        lblEquipoHong.setText(combate.getHong().getEquipo().toUpperCase());
        lblPuntosHong.setText(String.valueOf(combate.getHong().getPuntos()));
        lblFaltasHong.setText("GAM-JEOM: " + combate.getHong().getGamJeoms());

        lblTiempo.setText(combate.obtenerTiempoFormateado());
    }

    public void actualizarEstadoMandos(String texto) {
        lblEstadoMandos.setText(texto);
    }

    public void mostrarResultadosFinales(Combate combate) {
        String mensaje = "=== RESULTADO OFICIAL DEL COMBATE ===\n\n" +
                "CHUNG (" + combate.getChung().getNombre() + " - " + combate.getChung().getEquipo() + "): " +
                combate.getChung().getPuntos() + " pts (Gam-jeom: " + combate.getChung().getGamJeoms() + ")\n" +
                "HONG (" + combate.getHong().getNombre() + " - " + combate.getHong().getEquipo() + "): " +
                combate.getHong().getPuntos() + " pts (Gam-jeom: " + combate.getHong().getGamJeoms() + ")\n\n" +
                combate.determinarGanador();

        JOptionPane.showMessageDialog(this, mensaje, "Combate Finalizado", JOptionPane.INFORMATION_MESSAGE);
    }

    public JButton getBtnIniciarPausar() { return btnIniciarPausar; }
    public JButton getBtnFinalizar() { return btnFinalizar; }
    public JButton getBtnSalir() { return btnSalir; }
}
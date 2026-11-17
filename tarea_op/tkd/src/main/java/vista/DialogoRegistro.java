package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import modelo.Combate;
import modelo.Competidor;

public class DialogoRegistro extends JDialog {
    private JTextField txtNombreChung, txtEquipoChung;
    private JTextField txtNombreHong, txtEquipoHong;
    private JComboBox<String> cmbTiempo;
    private JButton btnIniciarCombate, btnCancelar;
    private Combate combateCreado;

    public DialogoRegistro() {
        setTitle("Registro Oficial de Combate - Taekwondo");
        setModal(true);
        setSize(560, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(15, 15));
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("REGISTRO DE COMPETIDORES", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 15, 0));

        // Panel CHUNG (Azul)
        JPanel panelChung = new JPanel(new GridLayout(4, 1, 5, 5));
        TitledBorder bordeChung = BorderFactory.createTitledBorder("CHUNG (Azul)");
        bordeChung.setTitleColor(new Color(13, 71, 161));
        panelChung.setBorder(bordeChung);

        txtNombreChung = new JTextField("Competidor Azul");
        txtEquipoChung = new JTextField("ITL León");
        panelChung.add(new JLabel("Nombre:"));
        panelChung.add(txtNombreChung);
        panelChung.add(new JLabel("Equipo / País:"));
        panelChung.add(txtEquipoChung);

        // Panel HONG (Rojo)
        JPanel panelHong = new JPanel(new GridLayout(4, 1, 5, 5));
        TitledBorder bordeHong = BorderFactory.createTitledBorder("HONG (Rojo)");
        bordeHong.setTitleColor(new Color(183, 28, 28));
        panelHong.setBorder(bordeHong);

        txtNombreHong = new JTextField("Competidor Rojo");
        txtEquipoHong = new JTextField("Guanajuato");
        panelHong.add(new JLabel("Nombre:"));
        panelHong.add(txtNombreHong);
        panelHong.add(new JLabel("Equipo / País:"));
        panelHong.add(txtEquipoHong);

        panelCentro.add(panelChung);
        panelCentro.add(panelHong);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        // Panel Inferior (Tiempo y Botones)
        JPanel panelSur = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel panelTiempo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTiempo.add(new JLabel("Duración del Combate:"));
        String[] opcionesTiempo = {
                "15 segundos (Prueba rápida)",
                "1 minuto (01:00)",
                "1 minuto 30 seg (01:30)",
                "2 minutos (02:00)"
        };
        cmbTiempo = new JComboBox<String>(opcionesTiempo);
        cmbTiempo.setSelectedIndex(3);
        panelTiempo.add(cmbTiempo);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        btnIniciarCombate = new JButton("Abrir Marcador en Pantalla Completa");
        btnCancelar = new JButton("Cancelar");

        btnIniciarCombate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarYContinuar();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                combateCreado = null;
                dispose();
            }
        });

        panelBotones.add(btnIniciarCombate);
        panelBotones.add(btnCancelar);

        panelSur.add(panelTiempo);
        panelSur.add(panelBotones);
        panelPrincipal.add(panelSur, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private void registrarYContinuar() {
        String nomChung = txtNombreChung.getText().trim();
        String eqChung = txtEquipoChung.getText().trim();
        String nomHong = txtNombreHong.getText().trim();
        String eqHong = txtEquipoHong.getText().trim();

        if (nomChung.isEmpty() || eqChung.isEmpty() || nomHong.isEmpty() || eqHong.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor completa todos los campos de ambos competidores.",
                    "Datos Incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int segundos = 120;
        switch (cmbTiempo.getSelectedIndex()) {
            case 0: segundos = 15; break;
            case 1: segundos = 60; break;
            case 2: segundos = 90; break;
            case 3: segundos = 120; break;
        }

        Competidor chung = new Competidor(nomChung, eqChung, "CHUNG");
        Competidor hong = new Competidor(nomHong, eqHong, "HONG");
        combateCreado = new Combate(chung, hong, segundos);
        dispose();
    }

    public Combate getCombateCreado() {
        return combateCreado;
    }
}
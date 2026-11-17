import java.awt.*;
import java.awt.event.*;

public class RegistroTorneoGUI {
    private Frame ventana;
    private TextField txtNombre, txtCategoria, txtCinta, txtInstitucion;
    private Button btnRegistrar, btnConsultar;
    private TextArea areaResultados;
    private TorneoDAO dao;

    public RegistroTorneoGUI(TorneoDAO dao) {
        this.dao = dao;
    }

    public void construirVentanaRegistro() {
        ventana = new Frame("Registro - Circuito Élite Taekwondo Combate");
        ventana.setPreferredSize(new Dimension(500, 450));
        ventana.setLayout(new FlowLayout());

        // Componentes de entrada de datos
        ventana.add(new Label("Nombre Completo:"));
        txtNombre = new TextField(35);
        ventana.add(txtNombre);

        ventana.add(new Label("Categoría (Ej. -57 kg):"));
        txtCategoria = new TextField(35);
        ventana.add(txtCategoria);

        ventana.add(new Label("Cinta (Ej. Intermedio/Verde):"));
        txtCinta = new TextField(35);
        ventana.add(txtCinta);

        ventana.add(new Label("Institución (Ej. TecNM León):"));
        txtInstitucion = new TextField(35);
        ventana.add(txtInstitucion);

        // Botones de acción
        btnRegistrar = new Button("Registrar Competidor");
        btnConsultar = new Button("Consultar Registros");
        ventana.add(btnRegistrar);
        ventana.add(btnConsultar);

        // Área de visualización de datos (Unidad 4.4)
        areaResultados = new TextArea(12, 55);
        areaResultados.setEditable(false);
        ventana.add(areaResultados);

        // NAVEGABILIDAD: Listeners tradicionales (sin lambdas para cumplir con Cirino)
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = txtNombre.getText();
                String cat = txtCategoria.getText();
                String cin = txtCinta.getText();
                String inst = txtInstitucion.getText();

                if (!nom.isEmpty() && !cat.isEmpty()) {
                    boolean exito = dao.registrarCompetidor(nom, cat, cin, inst);
                    if (exito) {
                        areaResultados.setText("¡Competidor registrado exitosamente en la BD!");
                        limpiarCampos();
                    } else {
                        areaResultados.setText("Error al guardar en la base de datos.");
                    }
                } else {
                    areaResultados.setText("Por favor llena al menos Nombre y Categoría.");
                }
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String datos = dao.consultarCompetidores();
                areaResultados.setText(datos);
            }
        });

        // Cierre de ventana
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ventana.setVisible(false);
                ventana.dispose();
                System.exit(0);
            }
        });

        ventana.pack();
        ventana.setLocationRelativeTo(null);
    }

    public void mostrar() {
        if (ventana != null) {
            ventana.setVisible(true);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCategoria.setText("");
        txtCinta.setText("");
        txtInstitucion.setText("");
    }
}
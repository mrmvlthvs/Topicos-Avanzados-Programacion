/*
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #7
Fecha: 25/08/2026
*/
package arslan.guicomponents; //

import javax.swing.*;

public class GUIComponents {
    JPanel panel = new JPanel();                           // un panel
    JButton jbtOK = new JButton("OK");                     // dos botones
    JButton jbtCancel = new JButton("Cancel");
    JLabel jlblName = new JLabel("Enter your name: ");     // una etiqueta
    JTextField jtfName = new JTextField("Type Name Here"); // campo texto
    JCheckBox jchkBold = new JCheckBox("Bold");            // dos casillas
    JCheckBox jchkItalic = new JCheckBox("Italic");
    JRadioButton jrbRed = new JRadioButton("Red");         // dos botones radio
    JRadioButton jrbYellow = new JRadioButton("Yellow");   // caja combo
    JComboBox jcboColor = new JComboBox(new String[]{"Freshman", "Sophomore",
            "Junior", "Senior"});
    void addComponents() {
        panel.add(jbtOK);      // Add the OK button to the panel
        panel.add(jbtCancel);  // Add the Cancel button to the panel
        panel.add(jlblName);   // Add the label to the panel
        panel.add(jtfName);    // Add the text field to the panel
        panel.add(jchkBold);   // Add the check box to the panel
        panel.add(jchkItalic); // Add the check box to the panel
        panel.add(jrbRed);     // Add the radio button to the panel
        panel.add(jrbYellow);  // Add the radio button to the panel
        panel.add(jcboColor);  // Add the combo box to the panel
    }

    // sin operaciones

    void show() {
        JFrame frame = new JFrame(); // Create a frame

        frame.add(panel); // Add the panel to the frame
        frame.setTitle("Show GUI Components");
        frame.setSize(450, 100);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUIComponents gc = new GUIComponents();

        gc.addComponents();
        gc.show();
    }
}


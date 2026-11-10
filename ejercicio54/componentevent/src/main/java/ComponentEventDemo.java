/*
 * ComponentEventDemo.java is a 1.4 example that requires
 * no other files.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComponentEventDemo extends JPanel {
    static JFrame frame = new JFrame("Demo modular");
    JTextArea display;
    JLabel label;
    //String newline = "\n";

    public ComponentEventDemo() {
        super(new BorderLayout());
        display = new JTextArea();
        display.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(350, 200));

        JPanel panel = new JPanel(new BorderLayout());
        OyenteComponent oc = new OyenteComponent(display);
       
        label = new JLabel("This is a label", JLabel.CENTER);
        OyenteItem oi = new OyenteItem(label);
        label.addComponentListener(oc);
        panel.add(label, BorderLayout.CENTER);
        JCheckBox checkbox = new JCheckBox("Label visible", true);
        checkbox.addItemListener(oi);
        checkbox.addComponentListener(oc);
        panel.add(checkbox, BorderLayout.PAGE_END);
        //panel.addComponentListener(oc);
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.PAGE_END);
        frame.addComponentListener(oc);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        JComponent newContentPane = new ComponentEventDemo();

        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        //Create and set up the window.
        frame = new JFrame("ComponentEventDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content pane.
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
} 

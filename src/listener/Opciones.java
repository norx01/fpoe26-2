package listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Opciones {
    private JPanel mainPanel;
    private JComboBox comboBox1;

    public Opciones() {
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String opcion = comboBox1.getSelectedItem().toString();
                //String opcion = (String) comboBox1.getSelectedItem();

                switch (opcion)
                {
                    case "Yellow":
                        mainPanel.setBackground(Color.YELLOW);
                        break;
                    case "Cyan":
                        mainPanel.setBackground(Color.CYAN);
                        break;
                    case "Magenta":
                        mainPanel.setBackground(Color.MAGENTA);
                        break;
                    case "Black":
                        mainPanel.setBackground(Color.BLACK);
                        break;
                    default:
                        mainPanel.setBackground(Color.WHITE);
                        break;
                }
            }
        });
    }

    static void main() {
        //Crear ventana
        JFrame frame = new JFrame("Opciones");
        //unimos el panel al frame
        frame.setContentPane(new Opciones().mainPanel);
        //Mostrar la ventana
        frame.setVisible(true);
        //Cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Acomodamos los elementos
        frame.pack();
        //fijamos el tamaño de la ventana
        frame.setSize(400, 400);
    }
}

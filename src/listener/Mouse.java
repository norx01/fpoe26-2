package listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse {
    private JPanel mainPanel;

    public Mouse() {
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                if (e.getClickCount() == 2)
                {
                    mainPanel.setBackground(Color.ORANGE);
                }
                else
                {
                    mainPanel.setBackground(Color.RED);
                }
            }
        });

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                super.mouseEntered(e);
                mainPanel.setBackground(Color.GREEN);
            }
        });

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainPanel.setBackground(Color.PINK);
            }
        });
    }

    static void main() {
        //Crear ventana
        JFrame frame = new JFrame("Opciones");
        //unimos el panel al frame
        frame.setContentPane(new Mouse().mainPanel);
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

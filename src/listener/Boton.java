package listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton {
    private JPanel mainPanel;
    private JButton button1;
    private JLabel textoClicks;

    int clicks = 0;

    public Boton()
    {
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clicks++;
                textoClicks.setText("Clicks: "+clicks);

                if (clicks == 5)
                    mainPanel.setBackground(Color.RED);
                else if (clicks == 10)
                    mainPanel.setBackground(Color.BLUE);
                else if (clicks == 15)
                    mainPanel.setBackground(Color.PINK);
            }
        });
    }

    static void main() {
        //Crear ventana
        JFrame frame = new JFrame("Clicks");
        //unimos el panel al frame
        frame.setContentPane(new Boton().mainPanel);
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

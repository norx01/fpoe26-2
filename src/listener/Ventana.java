package listener;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ventana
{
    private JPanel mainPanel;

    static void main()
    {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().mainPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Ventana abierta");
            }
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrando ventana");
            }
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Ventana cerrada");
            }
            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Ventana minimizada");
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Ventana maximizada");
            }
            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Ventana activada");
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Ventana desactivada");
            }
        });

    }
}

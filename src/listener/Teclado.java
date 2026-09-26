package listener;

import javax.swing.*;
import java.awt.event.*;

public class Teclado {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public Teclado() {
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e)
            {
                super.keyReleased(e);
                char caracter = e.getKeyChar();
                JOptionPane.showMessageDialog(null, "Has pulsado: "+caracter);
            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Has pulsado: "+textField2.getText());
            }
        });

        textField3.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String texto = textField3.getText();

                if (!texto.contains("@gmail.com"))
                {
                    JOptionPane.showMessageDialog(null, "Correo invalido");
                    textField3.setText("");
                }
            }
        });
    }

    static void main() {
        //Crear ventana
        JFrame frame = new JFrame("Teclado");
        //unimos el panel al frame
        frame.setContentPane(new Teclado().mainPanel);
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Adivinador
{
    private JPanel mainPanel;
    private JTextField campoNumero;
    private JButton adivinarButton;

    int numeroAdivinar = 0;


    public Adivinador()
    {
        generarAleatorio();

        adivinarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int numeroUsuario = Integer.parseInt(campoNumero.getText());

                int resultado = numeroAdivinar - numeroUsuario;
                resultado = Math.abs(resultado);

                if(numeroUsuario == numeroAdivinar)
                {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    mainPanel.setBackground(Color.GREEN);
                    adivinarButton.setEnabled(false);
                }
                else if(resultado <=3)
                {
                    JOptionPane.showMessageDialog(null, "CALIENTE");
                    mainPanel.setBackground(Color.RED);
                    //adivinarButton.setEnabled(false);
                }
                else if (resultado <=5)
                {
                    mainPanel.setBackground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null, "TIBIO");
                    //adivinarButton.setEnabled(false);
                }
                else
                {
                    mainPanel.setBackground(Color.BLUE);
                    JOptionPane.showMessageDialog(null, "FRIO");
                    //adivinarButton.setEnabled(false);
                }

                /*
                if(numeroUsuario == numeroAdivinar)
                {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    mainPanel.setBackground(Color.GREEN);
                    adivinarButton.setEnabled(false);
                }
                else if((numeroAdivinar - numeroUsuario <=3) && (numeroAdivinar - numeroUsuario >=-3)) {
                    JOptionPane.showMessageDialog(null, "CALIENTE");
                    mainPanel.setBackground(Color.RED);
                //adivinarButton.setEnabled(false);
                } else if ((numeroAdivinar - numeroUsuario <=5) && (numeroAdivinar - numeroUsuario >=-5)){
                    mainPanel.setBackground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null, "TIBIO");
                    //adivinarButton.setEnabled(false);
                } else {
                    mainPanel.setBackground(Color.BLUE);
                    JOptionPane.showMessageDialog(null, "FRIO");
                    //adivinarButton.setEnabled(false);
                }

                 */

            }
        });
    }

    public void generarAleatorio()
    {
        numeroAdivinar = (int)(Math.random()*30)+1;
        //JOptionPane.showMessageDialog(null, "El numero a adivinar es: " + numeroAdivinar);
    }

    static void main()
    {
        //Crear ventana
        JFrame frame = new JFrame("Adivinador");
        //unimos el panel al frame
        frame.setContentPane(new Adivinador().mainPanel);
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

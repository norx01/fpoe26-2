package listener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Deslizador {
    private JPanel mainPanel;
    private JSlider slider1;
    private JProgressBar progressBar1;
    private JLabel textoValor;

    public Deslizador() {
        slider1.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                int valor = slider1.getValue();
                progressBar1.setValue(valor);
                textoValor.setText("Valor: "+valor);
            }
        });
    }

    static void main() {
        //Crear ventana
        JFrame frame = new JFrame("Deslizador");
        //unimos el panel al frame
        frame.setContentPane(new Deslizador().mainPanel);
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

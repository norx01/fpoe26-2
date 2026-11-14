package estructuraDatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class ColasGUI {
    private JPanel mainPanel;
    private JButton agregarClienteButton;
    private JButton mostrarColaDeClientesButton;
    private JButton atenderClienteButton;
    private JButton mostrarClienteActualButton;
    private JTextArea textArea1;

    //Creamos la cola de clientes
    Queue<String> colaClientes = new LinkedList<>();

    //contador de clientes
    int contadorClientes = 0;

    public ColasGUI()
    {
        agregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                colaClientes.add("Cliente "+contadorClientes++);
                textArea1.append("Cliente agregado: Cliente "+contadorClientes+"\n");
            }
        });
        mostrarColaDeClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textArea1.append("Cola de clientes: "+colaClientes+"\n");
            }
        });
        atenderClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textArea1.append("Cliente atendido: "+colaClientes.poll()+"\n");
            }
        });
        mostrarClienteActualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textArea1.append("Cliente actual: "+colaClientes.peek()+"\n");
            }
        });
    }

    static void main() {
        JFrame frame = new JFrame("ColasGUI");
        frame.setContentPane(new ColasGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

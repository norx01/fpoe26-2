package estructuraDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class PilasGUI {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton visitarPaginaButton;
    private JButton paginaActualButton;
    private JButton deshacerButton;
    private JTextArea textArea1;

    //creamos la pila
    Stack<String> historialWeb = new Stack<>();

    public PilasGUI()
    {
        visitarPaginaButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String pagina = textField1.getText();
                historialWeb.push(pagina);
                textArea1.append("Pagina: "+pagina+"\n");
            }
        });
        paginaActualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textArea1.append("Pagina Actual: "+historialWeb.peek()+"\n");
            }
        });
        deshacerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (!historialWeb.empty())
                    textArea1.append("Deshacer: "+historialWeb.pop()+"->"+historialWeb.peek()+"\n");
                else
                    JOptionPane.showMessageDialog(null, "No hay paginas para deshacer\n");
            }
        });
    }


    static void main() {
        JFrame frame = new JFrame("PilasGUI");
        frame.setContentPane(new PilasGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800,300);
    }
}

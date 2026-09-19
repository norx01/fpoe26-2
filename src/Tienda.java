import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tienda {
    private JPanel mainPanel;
    private JTextField campoCompra;
    private JTextField campoDescuento;
    private JButton calcularValorCompraButton;
    private JLabel textoCompra;
    private JLabel textoDescuento;
    private JLabel textoTotal;

    public Tienda()
    {
        calcularValorCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //tomamos del campo el valor total de la compra
               int valorCompra = Integer.parseInt(campoCompra.getText());
               //tomamos del campo el valor del descuento
               double valorDescuento = Double.parseDouble(campoDescuento.getText());
               //Calculamos el descuento
               double porcentajeDescuento = valorDescuento/100;
               //Calculamos el valor total de la compra con el descuento
               double valorTotal = valorCompra - (valorCompra*porcentajeDescuento);

               textoCompra.setText("Valor compra: $"+valorCompra);
               textoDescuento.setText("Porcentaje descuento: "+valorDescuento+"%");
               textoTotal.setText("Valor Total: $"+valorTotal);

            }
        });
    }

    static void main()
    {
        //Crear ventana
        JFrame frame = new JFrame("Tienda");
        //unimos el panel al frame
        frame.setContentPane(new Tienda().mainPanel);
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

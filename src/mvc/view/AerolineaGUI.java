package mvc.view;

import mvc.controller.AerolineaController;
import mvc.model.Aerolinea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class AerolineaGUI {
    private JPanel mainPanel;
    private JTextField campoNombre;
    private JTextField campoCodigo;
    private JSpinner spinnerCantidad;
    private JComboBox comboBoxOperacion;
    private JTextField campoOrigen;
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JTable table1;

    private AerolineaController aerolineaController = new AerolineaController();

    public AerolineaGUI()
    {
        agregarDatosTabla();
        agregarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                aerolineaController.agregar(aerolinea());
                agregarDatosTabla();
            }
        });

        actualizarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        eliminarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    public void agregarDatosTabla()
    {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Nombre");
        tableModel.addColumn("Codigo");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Operacion");
        tableModel.addColumn("Origen");

        table1.setModel(tableModel);

        String datos[] = new String[5];

        for(Aerolinea aerolinea: aerolineaController.listaAerolineas)
        {
            datos[0] = aerolinea.getNombre();
            datos[1] = aerolinea.getCodigo();
            datos[2] = String.valueOf(aerolinea.getCantidadAviones());
            datos[3] = aerolinea.getTipoOperacion();
            datos[4] = aerolinea.getPaisOrigen();

            tableModel.addRow(datos);
        }

    }

    public Aerolinea aerolinea()
    {
        String nombre = campoNombre.getText();
        String codigo = campoCodigo.getText();
        int cantidad = (int) spinnerCantidad.getValue();
        String operacion = (String) comboBoxOperacion.getSelectedItem();
        String origen = campoOrigen.getText();

        return new Aerolinea(nombre, codigo, cantidad, operacion, origen);
    }

    static void main()
    {
        JFrame frame = new JFrame("Aerolinea");
        frame.setContentPane(new AerolineaGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
    }
}

package mvc.controller;

import mvc.model.Aerolinea;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AerolineaController
{
    //definimos la lista
    public List<Aerolinea> listaAerolineas = new ArrayList<>();

    public void agregar(Aerolinea aerolinea)
    {
        listaAerolineas.add(aerolinea);
        JOptionPane.showMessageDialog(null, "Aerolinea agregada con éxito");
    }
}

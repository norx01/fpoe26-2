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

    public void eliminar(String codigo)
    {
        boolean encontrado = false;

        for (int i = 0; i < listaAerolineas.size(); i++)
        {
            if (listaAerolineas.get(i).getCodigo().equals(codigo))
            {
                listaAerolineas.remove(i);
                encontrado = true;
                JOptionPane.showMessageDialog(null, "Aerolinea eliminada con éxito");
                break;
            }
        }
        if (!encontrado)
            JOptionPane.showMessageDialog(null, "Aerolinea no encontrada");
    }

    public void actualizar(Aerolinea aerolinea)
    {
        boolean encontrado = false;

        for (int i = 0; i < listaAerolineas.size(); i++)
        {
            if (listaAerolineas.get(i).getCodigo().equals(aerolinea.getCodigo()))
            {
                listaAerolineas.get(i).setNombre(aerolinea.getNombre());
                listaAerolineas.get(i).setCantidadAviones(aerolinea.getCantidadAviones());
                listaAerolineas.get(i).setPaisOrigen(aerolinea.getPaisOrigen());
                listaAerolineas.get(i).setTipoOperacion(aerolinea.getTipoOperacion());
                encontrado = true;
                JOptionPane.showMessageDialog(null, "Aerolinea Actualizada con éxito");
                break;
            }
        }
        if (!encontrado)
            JOptionPane.showMessageDialog(null, "Aerolinea no encontrada");
    }
}

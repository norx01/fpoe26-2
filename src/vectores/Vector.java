package vectores;

import javax.swing.*;

public class Vector
{
    //Definimos el vector
    //tipo de dato [] nombre = new tipo de dato[tamaño]
    String[]deportes = new String[5];

    //agregar - create
    public void agregarDatos()
    {
        //definimos el tamaño del ciclo for
        //definimos la condicion de parada como el tamaño del vector
        //definimos el aumento en 1
        for (int i = 0;i < deportes.length; i++)
        {
            //solicitamos el valor
            String valor = JOptionPane.showInputDialog("Ingrese el nombre del deporte "+(i+1));
            //agregamos el valor al vector
            deportes[i] = valor;
        }
    }

    //Mostrar - read
    public void mostrarDatos()
    {
        for (int i = 0; i < deportes.length; i++)
        {
            //mostramos los datos del vector
            System.out.println((i+1)+": "+deportes[i]);
        }
    }

    //editar - update
    public void editarDato()
    {
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del dato"));
        String valor = JOptionPane.showInputDialog("Ingrese el nombre del deporte");
        deportes[pos-1] = valor;
    }

    //eliminar - delete
    public void eliminarDato()
    {
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del dato a eliminar"));
        deportes[pos-1] = null;
    }

    //menu
    public void menu()
    {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1. mostrar \n2.agregar \n3.editar \n4.eliminarv \n0.Salir"));
        switch (op)
        {
            case 1:
                mostrarDatos();
                break;
            case 2:
                agregarDatos();
                break;
            case 3:
                editarDato();
                break;
            case 4:
                eliminarDato();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null,"Opcion Invalida");
                break;
        }
        menu();
    }

    static void main() {
        Vector vector = new Vector();
        vector.menu();
    }
}

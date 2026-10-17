package listas;

import javax.swing.*;
import java.util.ArrayList;

public class ArrayLista
{
    //definimos el arrayList
    ArrayList<Integer> notas = new ArrayList<>();

    //mostrar - read
    public void mostrarDatos()
    {

        System.out.println("Lista de notas: "+notas);

        System.out.println("Lista con For");
        for (int i = 0; i < notas.size(); i++)
        {
            System.out.println(notas.get(i));
        }

        System.out.println("Lista con For Each");
        //for(tipo dato nombre:arrayList)
        for (int nota: notas)
        {
            System.out.println(nota);
        }
    }

    //agregar - create
    public void agregarDatos()
    {
            //solicitamos el valor
            int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota #"));
            //agregamos el valor al vector
            notas.add(valor);
    }

    //tamaño
    public void tamano()
    {
        System.out.println(notas.size());
    }

    //editar - update
    public void editarDato()
    {
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del dato"));
        int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota"));
        notas.set(pos,valor);
    }

    //eliminar - delete
    public void eliminarDato()
    {
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del dato a eliminar"));
        notas.remove(pos);
    }

    //menu
    public void menu()
    {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1. mostrar \n2.agregar \n3.editar \n4.eliminarv \n5.tamaño \n0.Salir"));
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
            case 5:
                tamano();
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

    static void main()
    {
        ArrayLista arrayLista = new ArrayLista();
        arrayLista.menu();
    }
}

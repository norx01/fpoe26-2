package estructuraDatos;

import java.util.LinkedList;
import java.util.Queue;

public class Colas
{
    //Creamos la cola
    Queue<String> cola = new LinkedList<>();

    //ejemplo de colas
    public void ejemplo()
    {
        //agregamos 5 elementos a la cola
        cola.add("Elemento 1");
        cola.add("Elemento 2");
        cola.add("Elemento 3");
        cola.add("Elemento 4");
        cola.add("Elemento 5");

        //mostramos la cola
        System.out.println("Cola: "+cola);

        //mostramos el primer elemento
        IO.println("Primer elemento: "+cola.peek());

        //atendemos dos elementos
        IO.println("Atendemos el elemento: "+cola.poll());
        IO.println("Atendemos el elemento: "+cola.poll());

        //mostramos la cola final
        System.out.println("Cola final: "+cola);
    }

    static void main() {
        Colas colas = new Colas();
        colas.ejemplo();
    }
}

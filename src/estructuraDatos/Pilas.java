package estructuraDatos;

import java.util.Stack;

public class Pilas
{
    //Creamos la pila
    Stack<String> pila = new Stack<String>();

    //Ejemplo de uso
    public void ejemplo()
    {
        //agregamos 3 elementos a la pila
        pila.push("Elemento 1");
        pila.push("Elemento 2");
        pila.push("Elemento 3");
        pila.push("Elemento 4");

        //Mostramos la pila
        System.out.println("Pila: "+pila);

        //Mi elemento actual (primero)
        System.out.println("Elemento actual: "+pila.peek());

        //Eliminamos dos elementos
        System.out.println("Eliminamos el elemento: "+pila.pop());
        System.out.println("Eliminamos el elemento: "+pila.pop());

        //Mostramos la pila final
        System.out.println("Pila final: "+pila);

    }

    static void main() {
        Pilas pila = new Pilas();
        pila.ejemplo();
    }
}

package archivos;

import javax.swing.*;
import java.io.*;

public class ManejoArchivos
{
    private String nombreArchivo;
    private String contenidoArchivo;

    //Metodo para crear archivos
    public void crearArchivo()
    {
        nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo");

        try
        {
            File archivo = new File(nombreArchivo + ".txt");

            if (archivo.createNewFile())
                JOptionPane.showMessageDialog(null, "Archivo creado exitosamente");
            else
                JOptionPane.showMessageDialog(null, "El archivo ya existe");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear el archivo");
        }
    }

    //Metodo para escribir en el archivo
    public void escribirArchivo()
    {
        nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo");

        try
        {
            FileWriter writer = new FileWriter(nombreArchivo+".txt");
            contenidoArchivo = JOptionPane.showInputDialog("Escriba el contenido del archivo");
            writer.write(contenidoArchivo);
            writer.close();
            JOptionPane.showMessageDialog(null, "Archivo escrito exitosamente");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo");
        }
    }

    //Metodo para leer el archivo
    public void leerArchivo()
    {
        nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo+".txt"));
            String lineas;
            while ((lineas = reader.readLine()) != null)
            {
                System.out.println(lineas);
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
    }

    //metodo para agregar texto
    public void agregarTexto()
    {
        nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo");

        try
        {
            FileWriter writer = new FileWriter(nombreArchivo+".txt",true);
            contenidoArchivo = JOptionPane.showInputDialog("Ingrese el contenido del archivo");
            writer.write("\n"+contenidoArchivo);
            writer.close();
            JOptionPane.showMessageDialog(null, "Texto agregado al archivo");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar texto al archivo");
        }
    }

    //metodo para eliminar Archivo
    public void eliminarArchivo()
    {
        nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo");

        File archivo = new File(nombreArchivo+".txt");
        if (archivo.exists())
        {
            archivo.delete();
            JOptionPane.showMessageDialog(null, "Archivo eliminado");
        }
        else
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
    }

    //metodo para buscar
    public void buscarPalabra()
    {
        nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo");
        String palabra = JOptionPane.showInputDialog("Ingrese la palabra a buscar");

        int contador = 0;
        int contadorLineas = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo+".txt")))
        {
            String lineas;

            while((lineas = br.readLine()) != null)
            {
                contadorLineas++;
                if (lineas.contains(palabra))
                {
                    contador++;
                    JOptionPane.showMessageDialog(null, "La palabra se encuentra en la linea: " + contadorLineas +
                            "\nla linea dice: "+lineas);
                }
            }
            if (contador == 0)
                JOptionPane.showMessageDialog(null, "La palabra no se encuentra en el archivo");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar la palabra");
        }
    }

    //metodo para agregar datos (almacenamiento)
    public void escribirDatos()
    {
        nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo");

        try
        {
            FileWriter writer = new FileWriter(nombreArchivo+".txt",true);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            String edad = JOptionPane.showInputDialog("Ingrese la edad");
            String estatura = JOptionPane.showInputDialog("Ingrese la estatura");

            writer.write(nombre + "," + edad + "," + estatura+"\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al escribir datos");
        }
    }

    //Metodo para obtener datos
    public void obtenerDatos()
    {
        nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo+".txt"));
            String linea;

            while ((linea = reader.readLine()) != null)
            {
                String[] datos = linea.split("\\,");
                System.out.println("Nombre: " + datos[0]);
                System.out.println("Edad: " + datos[1]);
                System.out.println("Estatura: " + datos[2]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener datos");
        }
    }

    public void menu()
    {
        int op = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion: " +
                "\n1. Crear archivo" +
                "\n2. Escribir archivo" +
                "\n3. Leer archivo" +
                "\n4. Buscar palabra" +
                "\n5. Eliminar archivo" +
                "\n6. Escribir datos" +
                "\n7. Obtener datos" +
                "\n8. Aregar texto"+
                "\n0. Salir"));

        switch (op)
        {
            case 1:
                crearArchivo();
                break;
            case 0:
                System.exit(0);
                break;
            case 2:
                escribirArchivo();
                break;
            case 3:
                leerArchivo();
                break;
            case 4:
                buscarPalabra();
                break;
            case 5:
                eliminarArchivo();
                break;
            case 6:
                escribirDatos();
                break;
            case 7:
                obtenerDatos();
                break;
            case 8:
                agregarTexto();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida");
                break;
        }
        menu();
    }

    static void main() {
        ManejoArchivos ma = new ManejoArchivos();
        ma.menu();
    }

}

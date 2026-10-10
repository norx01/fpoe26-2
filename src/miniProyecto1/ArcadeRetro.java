package miniProyecto1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArcadeRetro {
    private JPanel mainPanel;
    private JSpinner spinnerPingPong;
    private JSpinner spinnerPacman;
    private JSpinner spinnerCarrera;
    private JSpinner spinnerNave;
    private JButton calcularButton;
    private JButton jugarRondaButton;
    private JButton limpiarButton;
    private JComboBox comboBoxRecargar;
    private JSpinner spinnerRecarga;
    private JTextArea textArea1;
    private JButton recargarButton;
    private JTextField textFieldTiempo;
    private JButton actualizarTiempoLimiteButton;
    private JButton verResumenButton;
    private JLabel textoPaPingPong;
    private JLabel textoPaPacman;
    private JLabel textoPaCarrera;
    private JLabel textoPaNave;
    private JLabel textoPuPingPong;
    private JLabel textoPuPacman;
    private JLabel textoPuCarrera;
    private JLabel textoPuNave;
    private JLabel textoPuTotal;
    private JLabel textoMinutos;
    private JLabel textoBronce;
    private JLabel textoPlata;
    private JLabel textoOro;
    private JLabel textoTiempoMaximo;

    // Monedero del jugador (estado del día)
    int fichasBronce = 40, fichasPlata = 20, fichasOro = 8;

    // Minutos por partida
    final int MIN_PING = 3, MIN_PAC = 5, MIN_CARRERA = 6, MIN_NAVE = 8;

    // Tiempo
    int tiempoMaximo = 90;
    int minutosJugados = 0;

    // Acumulados por máquina
    int partPing = 0, partPac = 0, partCarrera = 0, partNave = 0;
    int ptsPing = 0, ptsPac = 0, ptsCarrera = 0, ptsNave = 0;
    int totalPts = 0;

    // Récord del día
    int record = 0;
    String maquinaRecord = "-";

    // Estado de UI
    boolean habilitado = true;

    //Vectores costos de juegos
    int[] pingPong = {2,0,0,3};
    int[] pacman = {2,1,0,5};
    int[] carrera = {2,2,1,6};
    int[] nave = {3,3,2,8};

    int[] costos = {0,0,0,0};

    //validacion negativo
    boolean validacion = false;




    public ArcadeRetro()
    {
        //Inicializamos variables
        inicializar();

        recargarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String valor = comboBoxRecargar.getSelectedItem().toString();
                int fichas = (int)spinnerRecarga.getValue();
                if (fichas <= 0)
                {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor mayor a 0");
                }
                else
                {
                    switch (valor)
                    {
                        case "Bronce":
                            fichasBronce += fichas;
                            break;
                        //Terminar
                    }
                }


                inicializar();
            }
        });
        actualizarTiempoLimiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tiempoMaximo = Integer.parseInt(textFieldTiempo.getText());
                JOptionPane.showMessageDialog(null, "Tiempo actualizado: "+tiempoMaximo+" minutos");
                inicializar();
            }
        });
        calcularButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                calcular();
            }
        });
        jugarRondaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jugar();
            }
        });
    }

    public void calcular()
    {
        validacion = false;
        int cantidadPing = (int)spinnerPingPong.getValue();
        int cantidadPac = (int)spinnerPacman.getValue();
        int cantidadCarrera = (int)spinnerCarrera.getValue();
        int cantidadNave = (int)spinnerNave.getValue();

        if (cantidadPing <= -1 || cantidadPac <= -1 || cantidadCarrera <= -1 || cantidadNave <= -1)
        {
            JOptionPane.showMessageDialog(null, "Debes ingresar un valor no negativo");
        }
        else
        {

            costos[0] = pingPong[0] * cantidadPing + nave[0] * cantidadNave + pacman[0] * cantidadPac + carrera[0] * cantidadCarrera;
            costos[1] = pingPong[1] * cantidadPing + nave[1] * cantidadNave + pacman[1] * cantidadPac + carrera[1] * cantidadCarrera;
            costos[2] = pingPong[2] * cantidadPing + nave[2] * cantidadNave + pacman[2] * cantidadPac + carrera[2] * cantidadCarrera;
            costos[3] = pingPong[3] * cantidadPing + nave[3] * cantidadNave + pacman[3] * cantidadPac + carrera[3] * cantidadCarrera;

            JOptionPane.showMessageDialog(null, "Fichas necesarias \n" + costos[0] + " Bronce \n"
                    + costos[1] + " Plata \n" + costos[2] + " Oro \n" + "Tiempo necesario \n" + costos[3] + " Minutos");

            validacion = true;
        }
    }

    public void jugar()
    {
        calcular();

        if (validacion)
        {
            if (fichasBronce < costos[0])
            {
                JOptionPane.showMessageDialog(null, "No tienes suficientes fichas de bronce"
                        +"\n"+"Fichas necesarias: "+(fichasBronce-costos[0]+" Bronce"));

            }
            else
            {
                if (fichasPlata < costos[1])
                {
                    JOptionPane.showMessageDialog(null, "No tienes suficientes fichas de Plata"
                            +"\n"+"Fichas necesarias: "+(fichasPlata-costos[1]+" Plata"));


                }
                else
                {
                    if (fichasOro < costos[2])
                    {
                        JOptionPane.showMessageDialog(null, "No tienes suficientes fichas de oro"
                                +"\n"+"Fichas necesarias: "+(fichasOro-costos[2]+" Oro"));


                    }
                    else
                    {
                        if (tiempoMaximo < costos[3]+minutosJugados)
                        {
                            JOptionPane.showMessageDialog(null, "Supera el tiempo maximo"+
                                    "\n"+"Tiempo necesario: "+(minutosJugados-costos[3]));
                        }
                        else
                        {
                            fichasBronce -= costos[0];
                            fichasPlata -= costos[1];
                            fichasOro -= costos[2];
                            minutosJugados += costos[3];

                            //Puntos y patidas ping pong
                            partPing += (int)spinnerPingPong.getValue();
                            int ramdonPing = 20 + (int)(Math.random() * 31)*(int)spinnerPingPong.getValue();
                            ptsPing += ramdonPing;


                            //puntos total
                            totalPts += ramdonPing;
                        }
                    }
                }
            }
        }



        inicializar();
    }

    public void inicializar()
    {
        //Fichas
        textoBronce.setText("Bronce: "+Integer.toString(fichasBronce));
        textoOro.setText("Oro: "+Integer.toString(fichasOro));
        textoPlata.setText("Plata: "+Integer.toString(fichasPlata));

        //puntajes maquina
        textoPuCarrera.setText("Carrera de autos: "+Integer.toString(ptsCarrera));
        textoPuNave.setText("Nave espacial: "+Integer.toString(ptsNave));
        textoPuPacman.setText("Pacman: "+Integer.toString(ptsPac));
        textoPuPingPong.setText("PingPong: "+Integer.toString(ptsPing));

        //partida maquina
        textoPaCarrera.setText("Carrera de autos: "+Integer.toString(partCarrera));
        textoPaNave.setText("Nave espacial: "+Integer.toString(partNave));
        textoPaPacman.setText("Pacman: "+Integer.toString(partPac));
        textoPaPingPong.setText("PingPong "+Integer.toString(partPing));
        textoPuTotal.setText("Total: "+Integer.toString(totalPts));

        //tiempo
        textoMinutos.setText("Minutos jugador hoy: "+Integer.toString(minutosJugados));
        textFieldTiempo.setText(Integer.toString(tiempoMaximo));
        textoTiempoMaximo.setText("Tiempo maximo: "+Integer.toString(tiempoMaximo));
    }


    static void main()
    {
        //Crear ventana
        JFrame frame = new JFrame("Arcade Retro");
        //unimos el panel al frame
        frame.setContentPane(new ArcadeRetro().mainPanel);
        //Mostrar la ventana
        frame.setVisible(true);
        //Cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Acomodamos los elementos
        frame.pack();
        //fijamos el tamaño de la ventana
        frame.setSize(800, 800);

    }
}

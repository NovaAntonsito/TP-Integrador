
import clases.Equipo;
import clases.Jugador;
import clases.Llave;
import clases.Ronda;
import configDB.DBConnection;
import configDB.DBConsultas;
import interfazUtiles.InterfazUtils;

import javax.swing.*;
import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        bienvenidaAlTorneo();
        menu();
    }

    public static void menu() {
        JOptionPane.showMessageDialog(null, "Bienvenido al Menu\nSelecciona una de las siguientes opciones:");

        // Se inicializan las variables que se utilizarán durante la ejecución del programa.
        boolean salir = true;
        ArrayList<Equipo> listaDeEquipos = null;
        Jugador jugador = null;
        Llave llaveDerecha = null;
        Llave llaveIzquierda = null;
        Ronda ronda = null;

        do {
            // Se utiliza la función opciones() de la clase InterfazUtils para obtener la opción seleccionada por el usuario.
            switch (InterfazUtils.opciones()) {
                case "1":
                    listaDeEquipos = crearListaDeEquipos(listaDeEquipos);
                    break;
                case "2":
                    agregarEquipos(listaDeEquipos);
                    break;
                case "3":
                    jugador = elegirEquipo(listaDeEquipos);
                    break;
                case "4":
                    llaveDerecha = crearLlaveDerecha(listaDeEquipos);
                    break;
                case "5":
                    llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
                    break;
                case "6":
                    ronda = crearRondas();
                    break;
                case "7":
                    jugarTorneo(ronda, llaveIzquierda, llaveDerecha, jugador);
                    break;
                case "8":
                    resultadoDelTorneo(jugador);
                    break;
                case "9":
                    pantallaDB(ronda);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo", "Salida", JOptionPane.CLOSED_OPTION);
                    salir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingreso invalido");
            }

        } while (salir);
    }


    public static void bienvenidaAlTorneo() {
        JOptionPane.showMessageDialog(null, "Bienvenidos al Torneo", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
    }

    public static ArrayList<Equipo> crearListaDeEquipos(ArrayList<Equipo> listaDeEquipos) {

        if (listaDeEquipos == null) {
            return new ArrayList<Equipo>();
        } else {
            JOptionPane.showMessageDialog(null,"Ya hay una lista creada","Informacion",JOptionPane.INFORMATION_MESSAGE);
            return listaDeEquipos;
        }

    }

    public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos) {
        if(!
                listaDeEquipos.isEmpty()){
            String cargaDeEquipos=JOptionPane.showInputDialog(null,"Ya hay una lista cargada\n ¿Desea cargarla nuevamente? SI | NO","Lista Cargada",JOptionPane.INFORMATION_MESSAGE);
            if(cargaDeEquipos.equalsIgnoreCase("SI")){
                listaDeEquipos.clear();
            }
        }
        // Mostramos un cuadro de diálogo para preguntar al usuario si quiere cargar los equipos manualmente o automáticamente
        String opcion = "";
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "Bienvenido a la carga de equipos\n¿Desea cargar los equipos manualmente? SI | NO",
                    "Carga de equipos", JOptionPane.INFORMATION_MESSAGE);
            if (opcion == null || opcion.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor en la casilla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion == null || opcion.equals(""));

        // Si el usuario selecciona "si", cargamos los equipos manualmente
        if (opcion.equalsIgnoreCase("si")) {
            InterfazUtils.cargarEquipoManualmente(listaDeEquipos);
        }
        // Si el usuario selecciona "no", cargamos los equipos automáticamente
        else {
            listaDeEquipos.add(new Equipo("Belgica"));
            listaDeEquipos.add(new Equipo("Francia"));
            listaDeEquipos.add(new Equipo("Portugal"));
            listaDeEquipos.add(new Equipo("Alemania"));
            listaDeEquipos.add(new Equipo("Brasil"));
            listaDeEquipos.add(new Equipo("Italia"));
            listaDeEquipos.add(new Equipo("Argelia"));
            listaDeEquipos.add(new Equipo("Argentina"));
        }
    }

    public static Jugador elegirEquipo(ArrayList<Equipo> listaDeEquipos) {
        // Creamos una nueva instancia del objeto Jugador
        Jugador jugador = new Jugador();
        // Llamamos al método elegirEquipo() del objeto jugador, pasándole como argumento la lista de equipos almacenada en listaDeEquipos
        jugador.elegirEquipo(listaDeEquipos);
        return jugador;
    }

    public static Llave crearLlaveDerecha(ArrayList<Equipo> listaDeEquipos) {
        // Crea una Llave derecha y la arma utilizando la lista de equipos que se le pasa como parámetro.
        Llave llaveDerecha = new Llave("Llave Derecha");
        llaveDerecha.armarLlave(listaDeEquipos, 0);
        return llaveDerecha;
    }

    public static Llave crearLlaveIzquierda(ArrayList<Equipo> listaDeEquipos) {
        // Crea una Llave izquierda y la arma utilizando la lista de equipos que se le pasa como parámetro.
        Llave llaveIzquierda = new Llave("Llave Izquierda");
        llaveIzquierda.armarLlave(listaDeEquipos, 4);
        return llaveIzquierda;
    }

    public static Ronda crearRondas() {
        // Crea una Ronda
        return new Ronda();
    }

    public static void jugarTorneo(Ronda ronda, Llave llaveIzquierda, Llave llaveDerecha, Jugador jugador) {
        // utiliza las llaves de la izquierda y la derecha para armar los cuartos de final,
        // luego llama al método "sumarPuntos" del jugador y repite el proceso para las semifinales y la final.
        ronda.cuartosDeFinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        ronda.semifinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        ronda.finalDelTorneo(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();

    }

    public static void resultadoDelTorneo(Jugador jugador) {
        // Muestra un mensaje en una ventana emergente con el puntaje obtenido por el jugador y el nombre del equipo seleccionado.
        JOptionPane.showMessageDialog(null, "Has conseguido " + jugador.getPuntaje()
                        + " por elegir al equipo: " + jugador.getEquipoSeleccionado().getNombre(), "Nombre",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void pantallaDB(Ronda winner){
        DBConnection dbConnection = new DBConnection();
        Connection conexionDB = dbConnection.crearConexion();
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Desea guardar los datos en la base de datos?",
                "Guardar datos", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            DBConsultas consultas = new DBConsultas(conexionDB);
            consultas.queryGenTabla();
            consultas.guardarDatos(winner.getGanadorRonda().getNombre().toString(), winner.getGanadorRonda().getCantGolesEnElTorneo());
            dbConnection.closeConexion();
        } else {
            dbConnection.closeConexion();
            System.out.println("El usuario ha elegido no guardar los datos en la base de datos.");
        }
    }

}

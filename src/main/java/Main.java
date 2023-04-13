
import clases.Equipo;
import clases.Jugador;
import clases.Llave;
import clases.Ronda;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        bienvenidaAlTorneo();
        ArrayList<Equipo> listaDeEquipos = crearListaDeEquipos();
        agregarEquipos(listaDeEquipos);
        Jugador jugador = elegirEquipo(listaDeEquipos);
        Llave llaveDerecha = crearLlaveDerecha(listaDeEquipos);
        Llave llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
        crearRondas(llaveIzquierda, llaveDerecha,jugador);
        resultadoDelTorneo(jugador);
    }

    public static void bienvenidaAlTorneo() {
        JOptionPane.showMessageDialog(null, "Bienvenidos al Torneo", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
    }

    public static ArrayList<Equipo> crearListaDeEquipos() {
        // Creamos una nueva instancia de un ArrayList vacío
        ArrayList<Equipo> listaDeEquipos = new ArrayList<>();
        return listaDeEquipos;
    }

    public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos) {
        // Mostramos un cuadro de diálogo para preguntar al usuario si quiere cargar los equipos manualmente o automáticamente
        String opcion="";
        do{
            opcion = JOptionPane.showInputDialog(null,
                    "Bienvenido a la carga de equipos\n¿Desea cargar los equipos manualmente? SI | NO",
                    "Carga de equipos", JOptionPane.INFORMATION_MESSAGE);
            if(opcion==null || opcion.equals("")){
                JOptionPane.showMessageDialog(null,"Ingrese un valor en la casilla","Error",JOptionPane.ERROR_MESSAGE);
            }
        }while(opcion==null || opcion.equals(""));

        // Si el usuario selecciona "si", cargamos los equipos manualmente
        if (opcion.equalsIgnoreCase("si")) {
            cargarEquipoManualmente(listaDeEquipos);
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

    public static Ronda crearRondas(Llave llaveIzquierda, Llave llaveDerecha, Jugador jugador) {
        // Crea una Ronda y utiliza las llaves de la izquierda y la derecha para armar los cuartos de final,
        // luego llama al método "sumarPuntos" del jugador y repite el proceso para las semifinales y la final.
        Ronda ronda = new Ronda();
        ronda.cuartosDeFinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        ronda.semifinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        ronda.finalDelTorneo(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        return ronda;
    }

    public static void resultadoDelTorneo(Jugador jugador) {
        // Muestra un mensaje en una ventana emergente con el puntaje obtenido por el jugador y el nombre del equipo seleccionado.
        JOptionPane.showMessageDialog(null, "Has conseguido " + jugador.getPuntaje()
                        + " por elegir al equipo: " + jugador.getEquipoSeleccionado().getNombre(), "Nombre",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void cargarEquipoManualmente(ArrayList<Equipo> listaDeEquipos){
        String nombreEquipo=null;
        for (int i = 0; i < 8; i++) {
            do{
                nombreEquipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo",
                        "Carga de equipos", JOptionPane.INFORMATION_MESSAGE);
                if(nombreEquipo==null || nombreEquipo.equals("")){
                    JOptionPane.showMessageDialog(null,"Ingrese un valor en la casilla","Error",JOptionPane.ERROR_MESSAGE);
                }
            }while(nombreEquipo==null || nombreEquipo.equals(""));
            listaDeEquipos.add(new Equipo(nombreEquipo));
        }
    }
}

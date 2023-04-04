
import clases.Equipo;
import clases.Jugador;
import clases.Llave;
import clases.Ronda;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Bienvenidos al Torneo","Bienvenida",JOptionPane.INFORMATION_MESSAGE);
        ArrayList<Equipo> listaDeEquipos=new ArrayList<>();
        listaDeEquipos.add(new Equipo("Belgica"));
        listaDeEquipos.add(new Equipo("Francia"));
        listaDeEquipos.add(new Equipo("Portugal"));
        listaDeEquipos.add(new Equipo("Argentina"));
        listaDeEquipos.add(new Equipo("Brasil"));
        listaDeEquipos.add(new Equipo("Italia"));
        listaDeEquipos.add(new Equipo("Argelia"));
        listaDeEquipos.add(new Equipo("Alemania"));

        Jugador jugador=new Jugador();
        jugador.elegirEquipo(listaDeEquipos);

        // Creo las llaves del torneo
        Llave llaveDerecha=new Llave();
        Llave llaveIzquierda= new Llave();
        // Armo las llaves del torneo
        llaveDerecha.armarLlave(listaDeEquipos,0);
        llaveIzquierda.armarLlave(listaDeEquipos,4);

        // Instancio un objeto de Ronda, para acceder a los metodos
        Ronda ronda=new Ronda();
        //Llamo a los metodos de Cuartos, semifinal y final

        // Cuartos
        ronda.cuartosDeFinal(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        // Semifinal
        ronda.semifinal(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        // Final
        ronda.finalDelTorneo(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();

        JOptionPane.showMessageDialog(null,"Has conseguido "+jugador.getPuntaje()
        +" por elegir al equipo: "+jugador.getEquipoSeleccionado().getNombre(),"Nombre",
                JOptionPane.INFORMATION_MESSAGE);


    }
}
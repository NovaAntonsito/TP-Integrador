import entities.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws SQLException {

        Rondas rondas=new Rondas();
        rondas.setNroRonda(3);

        //Hardcodeamos las listas de equipos
        ArrayList<Equipo> listaEquiposPrimeraRonda1=new ArrayList<>();
        ArrayList<Equipo> listaEquiposPrimeraRonda2=new ArrayList<>();
        listaEquiposPrimeraRonda1.add(new Equipo("Belgica"));
        listaEquiposPrimeraRonda1.add(new Equipo("Francia"));
        listaEquiposPrimeraRonda1.add(new Equipo("Portugal"));
        listaEquiposPrimeraRonda2.add(new Equipo("Italia"));
        listaEquiposPrimeraRonda1.add(new Equipo("Brasil"));
        listaEquiposPrimeraRonda2.add(new Equipo("Alemania"));
        listaEquiposPrimeraRonda2.add(new Equipo("Argelia"));
        listaEquiposPrimeraRonda2.add(new Equipo("Argentina"));

        //Supongamos que por consola elegimos un equipo, pero aca vamos a hardcodear esa seleccion
        Jugador jugador=new Jugador(listaEquiposPrimeraRonda2.get(3));
        
        Grupos g1 = new Grupos(listaEquiposPrimeraRonda1);
        Grupos g2 = new Grupos(listaEquiposPrimeraRonda2);
        Partido partido = new Partido();

        rondas.primeraRonda(g1,g2,partido);
        jugador.calcularPuntaje(g2.getListaEquipo());

        rondas.segundaRonda(g1,g2,partido);
        jugador.calcularPuntaje(g2.getListaEquipo());

        Equipo eWinner=rondas.rondaFinal(g1,g2,partido);
        jugador.calcularPuntaje(g2.getListaEquipo());
        //Muestro quien gano
        System.out.println("El campeon del mundo es: "+ eWinner.getName());
        System.out.println("Tu puntaje es: "+jugador.getPuntaje());


    }
}




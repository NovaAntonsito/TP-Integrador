import entities.Equipo;
import entities.Partido;
import entities.Rondas;

import java.util.ArrayList;


public class main {
    public static void main(String[] args) {
        Equipo e1 = new Equipo("Argentina", 0);
        Equipo e2 = new Equipo("Mexico", 0);
        Equipo e3 = new Equipo("Polonia", 0);
        Equipo e4 = new Equipo("Peru", 0);

        Partido p1 = new Partido(e1, e2, 3, 1);
        Partido p2 = new Partido(e3, e4, 1, 3);
        Partido pFinal = new Partido(e2, e3, 1, 5);

        System.out.println("Partido 1");
        p1.ganadorDelpartido();
        System.out.println("Partido 2");
        p2.ganadorDelpartido();
        System.out.println("Partido final");
        pFinal.ganadorDelpartido();

        Rondas ronda1 = new Rondas("Numero 1", new ArrayList<>());

        ronda1.añadirPartidos(p1);
        ronda1.añadirPartidos(p2);
        ronda1.añadirPartidos(pFinal);

        ronda1.golesEquipos();

    }
}




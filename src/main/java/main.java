import entities.Equipo;
import entities.Partido;
import entities.Pronostico;
import entities.Rondas;

import java.util.ArrayList;
import java.util.List;


public class main {
    public static void main(String[] args) {
        Equipo e1 = new Equipo("Argentina", 0);
        Equipo e2 = new Equipo("Mexico", 0);
        Equipo e3 = new Equipo("Polonia", 0);
        Equipo e4 = new Equipo("Peru", 0);

        Partido p1 = new Partido(e1, e2,null, 3, 1);
        Partido p2 = new Partido(e3, e4,null, 1, 3);
        Partido pFinal = new Partido(e2, e3,null, 1, 5);

        int puntaje=0;
        Pronostico pr1=new Pronostico();
        List<Equipo> pronosticos=new ArrayList<Equipo>();
        pronosticos.add(e1);
        pronosticos.add(e3);
        pronosticos.add(e3);
        pr1.setEquipos(pronosticos);

        System.out.println("Partido 1");
        if(pr1.getEquipos().get(0).equals(p1.ganadorDelpartido())){
            puntaje++;
        }
        p1.ganadorDelpartido();
        System.out.println("Partido 2");
        if(pr1.getEquipos().get(1).equals(p2.ganadorDelpartido())){
            puntaje++;
        }
        p2.ganadorDelpartido();
        System.out.println("Partido final");
        if(pr1.getEquipos().get(2).equals(pFinal.ganadorDelpartido())){
            puntaje++;
        }
        pFinal.ganadorDelpartido();
        
        Rondas ronda1 = new Rondas("Numero 1", new ArrayList<>());

        ronda1.añadirPartidos(p1);
        ronda1.añadirPartidos(p2);
        ronda1.añadirPartidos(pFinal);

        ronda1.golesEquipos();
        System.out.println("Tu puntaje es: "+puntaje);

    }
}




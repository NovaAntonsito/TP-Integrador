import entities.Equipo;
import entities.Partido;
import entities.Pronostico;
import entities.Rondas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class main {
    public static void main(String[] args) {
        String prompt = JOptionPane.showInputDialog("Ingrese el equipo que va a ganar");
        int puntaje = 0 , i = 1, j = 0;
        Equipo e1 = new Equipo("Argentina", 0);
        Equipo e2 = new Equipo("Mexico", 0);
        Equipo e3 = new Equipo("Polonia", 0);
        Equipo e4 = new Equipo("Peru", 0);

        Partido p1 = new Partido(e1, e2,null, (int) (Math.random()*7+0), (int) (Math.random()*7+0));
        Partido p2 = new Partido(e4, e3,null, (int) (Math.random()*7+0), (int) (Math.random()*7+0));
        Partido pFinal = new Partido(e2, e3,null, (int) (Math.random()*7+0), (int) (Math.random()*7+0));

        Rondas ronda1 = new Rondas("Numero 1", new ArrayList<>(),new ArrayList<>());

        Pronostico pr1=new Pronostico();


        ronda1.addPartidos(p1);
        ronda1.addPartidos(p2);
        ronda1.addPartidos(pFinal);

        ronda1.addAdversarios(e1);
        ronda1.addAdversarios(e2);
        ronda1.addAdversarios(e3);
        ronda1.addAdversarios(e4);

            switch (prompt){
                case "Argentina":
                    pr1.setEquipoElegido(e1);
                    break;
                case "Mexico":
                    pr1.setEquipoElegido(e2);
                    break;
                case "Polonia":
                    pr1.setEquipoElegido(e3);
                    break;
                case "Peru":
                    pr1.setEquipoElegido(e4);
                    break;
            }





        for (Partido p:ronda1.getPartidoList()) {
            System.out.println("---------Partido "+i+"---------");
            if (pr1.getEquipoElegido().equals(p.ganadorDelpartido())) {
                puntaje++;
            }
            i++;
            j++;
        }
        System.out.println("---------------------------------------");

        for (Equipo e: ronda1.getAdversarios()) {
            e.contarGoles();
        }

        System.out.println("Tu puntaje es: "+puntaje);

    }
}




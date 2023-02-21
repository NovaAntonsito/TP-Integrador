import entities.Equipo;
import entities.Grupos;
import entities.Partido;
import entities.Rondas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        int i = 1;
        Equipo e1 = new Equipo();
        Equipo e2 = new Equipo();
        Equipo e3 = new Equipo();
        Equipo e4 = new Equipo();


        Grupos g1 = new Grupos(new ArrayList<>(Arrays.asList(e1,e2,e3,e4)));

        String[] mejoresPaises = {"Bélgica",
                "Francia",
                "Brasil",
                "Inglaterra",
                "Portugal",
                "España",
                "Argentina"};

        /*
        * Solo recorro la lista y le asigno nombres aleatorios dependiendo del array de nombres
        * (WIP)
        * */
        for (Equipo e: g1.getEquipoList()) {
            int namesRandomIndex = (int)(Math.random()* mejoresPaises.length);
            e.setName("Equipo "+i);
            i++;
        }

        Partido partido = new Partido();

/*
* Recorrido principal del programa
* Mientras haya 1 elemento en la lista va a seguir haciendo partidos,
* removiendolos y poniendo otros equipos en la lista
* */
       while (g1.getEquipoList().size() != 1){
           Equipo[] randomTeams = g1.randomTeams(g1.getEquipoList());
           partido.simularPartido(randomTeams[0],randomTeams[1]);
           for (Equipo e:randomTeams) {
                g1.removeEquipoToGrupo(g1.getEquipoList());
           }
       }

        Rondas ganadorRonda = new Rondas("Ronda 1", g1.getEquipoList().get(0));

        System.out.println(ganadorRonda);





    }
}




import entities.Equipo;
import entities.Grupos;
import entities.Partido;
import entities.Rondas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        //int i = 1;
        Rondas rondas=new Rondas();
        rondas.setNroRonda(3);

        ArrayList<Equipo> listaEquipos1=new ArrayList<>();
        ArrayList<Equipo> listaEquipos2=new ArrayList<>();

        ArrayList<String> participantes = new ArrayList<>();
        participantes.add("Bélgica");
        participantes.add("Francia");
        participantes.add("Portugal");
        participantes.add("España");
        participantes.add("Italia");
        participantes.add("Argentina");
        participantes.add("Alemania");
        participantes.add("Brasil");

        ArrayList<String> copia=new ArrayList<>(participantes);
        rondas.armadorDeGrupos(listaEquipos1,listaEquipos2);
        Grupos g1 = new Grupos(listaEquipos1);
        Grupos g2 = new Grupos(listaEquipos2);
        participantes.addAll(copia);

        Partido partido = new Partido();
        for (Equipo e: g1.getEquipoList()) {
            int namesRandomIndex = (int)(Math.random()* participantes.size());
            e.setName(participantes.get(namesRandomIndex));
            participantes.remove(namesRandomIndex);
        }
        for (Equipo e: g2.getEquipoList()) {
            int namesRandomIndex = (int)(Math.random()* participantes.size());
            e.setName(participantes.get(namesRandomIndex));
            participantes.remove(namesRandomIndex);
        }
        for(int i=0;i<rondas.getNroRonda();i++){
            System.out.println("Ronda "+(i+1));
            for(int j=0;j<g1.getEquipoList().size();j+=2){
                if(g1.getEquipoList().size()>1||g2.getEquipoList().size()>1){
                    partido.simularPartido(g1.getEquipoList().get(j),g1.getEquipoList().get(j+1));
                    partido.simularPartido(g2.getEquipoList().get(j),g2.getEquipoList().get(j+1));
                }else{
                    partido.simularPartido(g1.getEquipoList().get(0),g2.getEquipoList().get(0));
                    g1.getEquipoList().removeIf(equipo -> !equipo.isAutorizacion());
                    g2.getEquipoList().removeIf(equipo -> !equipo.isAutorizacion());
                    System.out.println("El ganador del torneo es: "+
                            (g1.getEquipoList().isEmpty()?g2.getEquipoList().get(0).getName():g1.getEquipoList().get(0).getName()));

                }
                
                }
            g1.getEquipoList().removeIf(equipo -> !equipo.isAutorizacion());
            g2.getEquipoList().removeIf(equipo -> !equipo.isAutorizacion());

    }












    }
}




import entities.Equipo;
import entities.Grupos;
import entities.Partido;
import entities.Rondas;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Rondas rondas=new Rondas();
        rondas.setNroRonda(3);

        //Hardcodeamos las listas de equipos
        ArrayList<Equipo> listaEquiposPrimeraRonda1=new ArrayList<>();
        ArrayList<Equipo> listaEquiposPrimeraRonda2=new ArrayList<>();
        listaEquiposPrimeraRonda1.add(new Equipo("Belgica"));
        listaEquiposPrimeraRonda1.add(new Equipo("Francia"));
        listaEquiposPrimeraRonda1.add(new Equipo("Portugal"));
        listaEquiposPrimeraRonda1.add(new Equipo("España"));
        listaEquiposPrimeraRonda2.add(new Equipo("Italia"));
        listaEquiposPrimeraRonda2.add(new Equipo("Argentina"));
        listaEquiposPrimeraRonda2.add(new Equipo("Alemania"));
        listaEquiposPrimeraRonda2.add(new Equipo("Brasil"));


        Grupos g1 = new Grupos(listaEquiposPrimeraRonda1);
        Grupos g2 = new Grupos(listaEquiposPrimeraRonda2);

        Partido partido = new Partido();

        System.out.println("Ronda 1");
        for(int i=0;i<g1.getEquipoList().size();i+=2){
            partido.simularPartido(g1.getEquipoList().get(i),g1.getEquipoList().get(i+1));
            partido.simularPartido(g2.getEquipoList().get(i),g2.getEquipoList().get(i+1));
        }

        // Creo una lista nueva para los participantes de cada grupo que pasaron de ronda
        ArrayList<Equipo> listaEquiposSegundaRonda1=new ArrayList<>();
        ArrayList<Equipo> listaEquiposSegundaRonda2=new ArrayList<>();

        // Los agrego a las listas
        for(int i=0;i<g1.getEquipoList().size();i++){
            if(g1.getEquipoList().get(i).isAutorizacion()){
                listaEquiposSegundaRonda1.add(g1.getEquipoList().get(i));
            }
            if(g2.getEquipoList().get(i).isAutorizacion()){
                listaEquiposSegundaRonda2.add(g2.getEquipoList().get(i));
            }
        }
        //Seteo las nuevas listas en los grupos
        g1.setEquipoList(listaEquiposSegundaRonda1);
        g1.setEquipoList(listaEquiposSegundaRonda2);

        //Ajusto el proceso
        System.out.println("Ronda 2");
        partido.simularPartido(g1.getEquipoList().get(0),g1.getEquipoList().get(1));
        partido.simularPartido(g2.getEquipoList().get(0),g2.getEquipoList().get(1));

        if(!g1.getEquipoList().get(0).isAutorizacion()){
            g1.getEquipoList().remove(0);
        }else{
            g1.getEquipoList().remove(1);
        }
        if(!g2.getEquipoList().get(0).isAutorizacion()){
            g2.getEquipoList().remove(0);
        }else{
            g2.getEquipoList().remove(1);
        }
        //Ronda final
        System.out.println("La gran final");
        System.out.println("El campeon del mundo es: "+partido.simularPartido(g1.getEquipoList().get(0),g2.getEquipoList().get(0)).getName());

    }
}




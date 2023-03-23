package entities;

import java.util.ArrayList;

public class Rondas  {
    private int nroRonda;
    private Equipo equipoGanador;

    public Rondas(int nroRonda, Equipo equipoGanador) {
        this.nroRonda = nroRonda;
        this.equipoGanador = equipoGanador;
    }

    public Rondas() {
    }

    public void primeraRonda(Grupos g1, Grupos g2, Partido partido){
        System.out.println("Ronda 1");
        for(int i = 0; i<g1.getListaEquipo().size(); i+=2){
            partido.simularPartido(g1.getListaEquipo().get(i),g1.getListaEquipo().get(i+1));
            partido.simularPartido(g2.getListaEquipo().get(i),g2.getListaEquipo().get(i+1));
        }
        // Creo una lista nueva para los participantes de cada grupo que pasaron de ronda
        ArrayList<Equipo> listaEquiposSegundaRonda1=new ArrayList<>();
        ArrayList<Equipo> listaEquiposSegundaRonda2=new ArrayList<>();

        // Los agrego a las listas
        for(int i = 0; i<g1.getListaEquipo().size(); i++){
            if(g1.getListaEquipo().get(i).isAutorizacion()){
                listaEquiposSegundaRonda1.add(g1.getListaEquipo().get(i));
            }
            if(g2.getListaEquipo().get(i).isAutorizacion()){
                listaEquiposSegundaRonda2.add(g2.getListaEquipo().get(i));
            }
        }
        //Seteo las nuevas listas en los grupos
        g1.setListaEquipo(listaEquiposSegundaRonda1);
        g2.setListaEquipo(listaEquiposSegundaRonda2);
    }

    // Se encarga de la logica de la segunda ronda
    public void segundaRonda(Grupos g1,Grupos g2,Partido partido){
        System.out.println("Ronda 2");
        //Simula los partidos
        partido.simularPartido(g1.getListaEquipo().get(0),g1.getListaEquipo().get(1));
        partido.simularPartido(g2.getListaEquipo().get(0),g2.getListaEquipo().get(1));

        //Remueve a quien no este autorizado para jugar, debido a que perdio.
        //Basicamente en este caso deja un solo equipo en la lista
        if(!g1.getListaEquipo().get(0).isAutorizacion()){
            g1.getListaEquipo().remove(0);
        }else{
            g1.getListaEquipo().remove(1);
        }
        if(!g2.getListaEquipo().get(0).isAutorizacion()){
            g2.getListaEquipo().remove(0);
        }else{
            g2.getListaEquipo().remove(1);
        }
    }
    // Se juega la ronda final y retorna al ganador
    public Equipo rondaFinal(Grupos g1,Grupos g2,Partido partido){
        System.out.println("La gran final");
        return partido.simularPartido(g1.getListaEquipo().get(0),g2.getListaEquipo().get(0));
    }
    public int getNroRonda() {
        return nroRonda;
    }

    public void setNroRonda(int nroRonda) {
        this.nroRonda = nroRonda;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }
}

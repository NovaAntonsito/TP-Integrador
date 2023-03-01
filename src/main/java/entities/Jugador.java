package entities;

import java.util.List;

public class Jugador {

    Equipo seleccionado;
    int puntaje;

    public Jugador() {
    }

    public Jugador(Equipo seleccionado) {
        this.seleccionado = seleccionado;
        puntaje=0;
    }
    //Si el equipo seleccionado esta autorizado para seguir jugando despues de una ronda, es porque gano
    //Entonces le sumo un punto al jugador
    public void calcularPuntaje(List<Equipo> lista){
        if(seleccionado.isAutorizacion()){
            puntaje++;
        }
    }

    public Equipo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Equipo seleccionado) {
        this.seleccionado = seleccionado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}

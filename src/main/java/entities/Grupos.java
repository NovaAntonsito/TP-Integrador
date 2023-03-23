package entities;

import java.util.List;



public class Grupos {

    private List<Equipo> listaEquipo;

    public Grupos() {
    }

    public Grupos(List<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }

    public List<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(List<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }
}

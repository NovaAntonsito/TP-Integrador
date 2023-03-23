package entities;

import java.util.List;



public class Grupos {

    private List<Equipo> listaEquipo;
    private char nombreGrupo;



    public Grupos() {
    }

    public Grupos(char nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public char getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(char nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
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

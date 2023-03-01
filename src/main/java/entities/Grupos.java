package entities;

import java.util.List;



public class Grupos {

    private List<Equipo> equipoList;


    public Grupos() {
    }



    public Grupos(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }
}

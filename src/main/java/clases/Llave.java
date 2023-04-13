package clases;

import java.util.ArrayList;
import java.util.List;

public class Llave {

    private List<Equipo> equiposDeLaLlave;
    private String nombreDeLaLlave;

    public Llave() {
    }

    public Llave(List<Equipo> equiposDeLaLlave, String nombreDeLaLlave) {
        this.equiposDeLaLlave = equiposDeLaLlave;
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

    public Llave(String nombreDeLaLlave) {
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

    public List<Equipo> getEquiposDeLaLlave() {
        return equiposDeLaLlave;
    }

    public void setEquiposDeLaLlave(List<Equipo> equiposDeLaLlave) {
        this.equiposDeLaLlave = equiposDeLaLlave;
    }

    public String getNombreDeLaLlave() {
        return nombreDeLaLlave;
    }

    public void setNombreDeLaLlave(String nombreDeLaLlave) {
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

    public void armarLlave(List<Equipo> listaGeneral, int indiceInicial) {
        // Se crea una lista para almacenar los equipos de la llave
        List<Equipo> equiposLLave = new ArrayList<>();
        // Se itera desde el índice inicial hasta el índice inicial + 4
        // y se agrega cada equipo a la lista de equipos de la llave
        for (int i = indiceInicial; i < indiceInicial + 4; i++) {
            equiposLLave.add(listaGeneral.get(i));
        }
        // Se asigna la lista de equipos de la llave al atributo equiposDeLaLlave
        this.equiposDeLaLlave = equiposLLave;
    }

}

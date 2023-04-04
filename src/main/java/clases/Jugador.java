package clases;

import javax.swing.*;
import java.util.List;

public class Jugador {

    private Equipo equipoSeleccionado;
    private int puntaje;

    public Jugador() {
    }

    public Jugador(Equipo equipoSeleccionado, int puntaje) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.puntaje = puntaje;
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void elegirEquipo(List<Equipo> listaEquipos){
        String listaDeLosEquiposEnMensaje="Seleccione su equipo:  \n";
        for(int i=0;i<listaEquipos.size();i++){
            listaDeLosEquiposEnMensaje+=(i+1)+". "+listaEquipos.get(i).getNombre()+"\n";
        }
        JOptionPane.showMessageDialog(null,listaDeLosEquiposEnMensaje,"Seleccion de Equipo",JOptionPane.INFORMATION_MESSAGE);

        int indiceEquipo=0;
        do{
            indiceEquipo=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice del equipo que quiere seleccionar:","Ingreso valor",JOptionPane.INFORMATION_MESSAGE))-1;
        }while(indiceEquipo<1||indiceEquipo>8);
        JOptionPane.showMessageDialog(null,"EL EQUIPO DE ELEGISTE ES: "+listaEquipos.get(indiceEquipo).getNombre());
        this.equipoSeleccionado=listaEquipos.get(indiceEquipo);
    }
    public void sumarPuntos(){
        if(equipoSeleccionado.isAutorizacion()){
            puntaje++;
        }
    }
}

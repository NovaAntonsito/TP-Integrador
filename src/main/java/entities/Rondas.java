package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rondas  {
    private int nroRonda;
    private Equipo equipoGanador;

    public void armadorDeGrupos(ArrayList<Equipo> listaEquipos1,ArrayList<Equipo> listaEquipos2){
        for(int i=0;i<Math.pow(2,this.nroRonda);i++){
            if(i<Math.pow(2,this.nroRonda)/2){
                listaEquipos1.add(new Equipo());
            }else{
                listaEquipos2.add(new Equipo());
            }
        }
    }
}

package entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grupos {
    private List<Equipo> equipoList;


    /*
    *@param Lista de Equipos
    *Recibe una lista de equipos y la remueve si no tiene autorizacion
    *
   */

    public void removeEquipoToGrupo(List<Equipo> e){
        Iterator iterator = e.iterator();
        while (iterator.hasNext()){
            Equipo eTemp = (Equipo) iterator.next();
            if (!eTemp.isAutorizacion()){
                iterator.remove();
            }
        }
    }

    /*
    *@params Lista de equipos
    *Recibe una lista de equipos, saca dos equipos randoms y
    * las devuelve en un array
    */
    public Equipo[] randomTeams(List<Equipo> e){
        Random random = new Random();
        int index1 = random.nextInt(e.size());
        int index2 = random.nextInt(e.size());
        while (index2 == index1) {
            index2 = random.nextInt(e.size());
        }
        Equipo equipoLocal = e.get(index1);
        Equipo equipoVisitante = e.get(index2);
        return new Equipo[]{equipoLocal, equipoVisitante};
    }

}

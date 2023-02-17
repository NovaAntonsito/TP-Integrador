package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rondas  {

    private String nrodeRonda;
    private List<Partido> partidoList;

    public void addPartidos(Partido p){
        this.partidoList.add(p);
    }
    public void golesEquipos(){
        for (Partido partido:partidoList) {
            System.out.println(partido.getEquipo1().getNombre()+" metio "+partido.getEquipo1().getGolesEnTotal()+ " goles");
            System.out.println(partido.getEquipo2().getNombre()+" metio "+partido.getEquipo2().getGolesEnTotal()+ " goles");
        }
    }
}

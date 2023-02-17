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

    private List<Equipo> adversarios;
    private List<Partido> partidoList;

    public void addPartidos(Partido p){
        this.partidoList.add(p);
    }
    public void addAdversarios(Equipo e){
        this.adversarios.add(e);
    }

}

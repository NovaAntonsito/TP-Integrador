package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipo  {
    private String nombre;
    private int golesEnTotal;

    public void addGolesToEquipo(int i){
        this.golesEnTotal += i;
    }

    public void contarGoles(){
        System.out.println(this.nombre+ " metio "+ this.golesEnTotal+ " goles en total");
    }
}

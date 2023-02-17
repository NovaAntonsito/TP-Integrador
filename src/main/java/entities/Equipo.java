package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    private String nombre;
    private int golesEnTotal;

    public void addGolestoEquipo(int i){
        this.golesEnTotal += i;
    }
}

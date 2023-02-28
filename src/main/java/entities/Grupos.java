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
    private String rama;
    private List<Equipo> equipoList;

    public Grupos(List<Equipo> equipoList){
        this.equipoList=equipoList;
    }
}

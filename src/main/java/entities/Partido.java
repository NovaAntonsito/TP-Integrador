package entities;

import enums.Resultado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partido {


    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

public void ganadorDelpartido(){
    if(this.golesEquipo1 > this.golesEquipo2){
        System.out.println(equipo1.getNombre()+" "+ Resultado.GANADOR);
        System.out.println(equipo2.getNombre()+" "+ Resultado.PERDEDOR);
    } else if (this.golesEquipo1 == this.golesEquipo2) {
        System.out.println(equipo1.getNombre()+ " AND "+ equipo2.getNombre()+ " "+ Resultado.EMPATE);
    }else{
        System.out.println(equipo2.getNombre()+" "+ Resultado.GANADOR);
        System.out.println(equipo1.getNombre()+" "+ Resultado.PERDEDOR);
    }
    equipo1.addGolestoEquipo(this.golesEquipo1);
    equipo2.addGolestoEquipo(this.golesEquipo2);
}


}

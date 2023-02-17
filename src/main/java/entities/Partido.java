package entities;

import enums.Resultado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partido {


    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipoGanador;
    private int golesEquipo1;
    private int golesEquipo2;

public Equipo ganadorDelpartido(){
    equipo1.addGolestoEquipo(this.golesEquipo1);
    equipo2.addGolestoEquipo(this.golesEquipo2);
    if(this.golesEquipo1 > this.golesEquipo2){
        System.out.println(equipo1.getNombre()+" "+ Resultado.GANADOR);
        System.out.println(equipo2.getNombre()+" "+ Resultado.PERDEDOR);
        return equipo1;
    } else if (this.golesEquipo1 == this.golesEquipo2) {
        System.out.println(equipo1.getNombre()+ " AND "+ equipo2.getNombre()+ " "+ Resultado.EMPATE);
        return new Equipo();

    }else{
        System.out.println(equipo2.getNombre()+" "+ Resultado.GANADOR);
        System.out.println(equipo1.getNombre()+" "+ Resultado.PERDEDOR);
        return equipo2;
    }
    
}


}

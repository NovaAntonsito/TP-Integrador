package entities;

import enums.Resultado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partido {
    private int golesEquipo1 = (int) (Math.random() * 10), golesEquipo2 = (int) (Math.random() * 10);

    /*
     *@params Equipo1, Equipo2
     * Recibe los dos goles y simula un partido, cambia los resultados de cada equipo y
     * en caso de perder les quita la autorizacion para seguir jugando, en caso de empate
     * hay un retry
     * */
    public void simularPartido(Equipo e1, Equipo e2){
        if(this.golesEquipo1 > this.golesEquipo2){
            e2.setAutorizacion(false);
            e1.setResultadoEnPartido(Resultado.GANADOR);
            e2.setResultadoEnPartido(Resultado.PERDEDOR);
        } else if (this.golesEquipo1 == this.golesEquipo2) {
            System.out.println("Desempate en proceso");
            e1.setResultadoEnPartido(Resultado.EMPATE);
            e2.setResultadoEnPartido(Resultado.EMPATE);
            this.golesEquipo1 = (int)(Math.random()*10);
            this.golesEquipo2 = (int)(Math.random()*10);
            simularPartido(e1,e2);
        }else{
            e1.setAutorizacion(false);
            e1.setResultadoEnPartido(Resultado.PERDEDOR);
            e2.setResultadoEnPartido(Resultado.GANADOR);
        }
        System.out.println(e1.getName()+ " "+this.golesEquipo1+ " - "+e2.getName()+ " "+ this.golesEquipo2);
        e1.sumarGoles(this.golesEquipo1);
        e2.sumarGoles(this.golesEquipo2);
    }
}

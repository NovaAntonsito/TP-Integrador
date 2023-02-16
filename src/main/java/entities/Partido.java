package entities;

import enums.Resultado;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    /* La que proponen no se que sentido tiene planteo
    esto por mientras, es un if else horrendo pero lo
    estoy pensando asi nomas.
     */
    public void resultadoDelPartido(){
        if(golesEquipo1>golesEquipo2){
            equipo1.getPronostico().setPartido(this);
            equipo1.getPronostico().setResultado(Resultado.GANADOR);
            equipo2.getPronostico().setPartido(this);
            equipo2.getPronostico().setResultado(Resultado.PERDEDOR);
        }else if(golesEquipo1==golesEquipo2){
            equipo1.getPronostico().setPartido(this);
            equipo1.getPronostico().setResultado(Resultado.EMPATE);
            equipo2.getPronostico().setPartido(this);
            equipo2.getPronostico().setResultado(Resultado.EMPATE);
        }else{
            equipo1.getPronostico().setPartido(this);
            equipo1.getPronostico().setResultado(Resultado.PERDEDOR);
            equipo2.getPronostico().setPartido(this);
            equipo2.getPronostico().setResultado(Resultado.GANADOR);
        }
    }
}

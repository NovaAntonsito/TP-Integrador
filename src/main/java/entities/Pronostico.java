package entities;

import enums.Resultado;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@Data
@AllArgsConstructor
public class Pronostico {

    private Partido partido;
    private Resultado resultado;

    public int sumarPuntos(){
        if(resultado.equals(Resultado.GANADOR)){
            return 3;
        } else if (resultado.equals(Resultado.EMPATE)) {
            return 1;
        }else{
            return 0;
        }
    }
}

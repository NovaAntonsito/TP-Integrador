package entities;

import enums.Resultado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipo  {
    private String name;
    private boolean autorizacion = true;
    private Resultado resultadoEnPartido;
    private int cantGoles;


    //Suma todos los goles metido en todos los partidos
    public void sumarGoles(int i){
        this.cantGoles += i;
    }
}

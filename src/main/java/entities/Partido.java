package entities;

import enums.Resultado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partido {
    private int golesEquipo1=1 ;
    private int golesEquipo2=2 ;

    /*
     *@params Equipo1, Equipo2
     * Recibe los dos goles y simula un partido, cambia los resultados de cada equipo y
     * en caso de perder les quita la autorizacion para seguir jugando, en caso de empate
     * hay un retry
     * */
    public Equipo simularPartido(Equipo e1, Equipo e2){

        System.out.println(e1.getName()+ " "+this.golesEquipo1+ " - "+e2.getName()+ " "+ this.golesEquipo2);

        e1.sumarGoles(this.golesEquipo1);
        e2.sumarGoles(this.golesEquipo2);
        /* En caso de que la cantidad de goles del equipo 1 sea mayor a la cantidad de goles del equipo 2
         * le quita la posibilidad al equipo 2 de seguir jugando y actualiza sus resultados, luego retorna
         * al equipo ganador para trabajar con el
         */
        if(this.golesEquipo1 > this.golesEquipo2){
            e2.setAutorizacion(false);
            e1.setResultadoEnPartido(Resultado.GANADOR);
            e2.setResultadoEnPartido(Resultado.PERDEDOR);
            return e1;
            /* En caso de haber empate suelta un mensaje de que hubo un empate,
             * luego llama nuevamente a la funcion para generar un nuevo resultado
             */
        } else if (this.golesEquipo1 == this.golesEquipo2) {
            System.out.println("Desempate en proceso");
            e1.setResultadoEnPartido(Resultado.EMPATE);
            e2.setResultadoEnPartido(Resultado.EMPATE);
            simularPartido(e1,e2);
            /* Análogo al primer caso pero con el segundo equipo siendo el ganador*/
        }else{
            e1.setAutorizacion(false);
            e1.setResultadoEnPartido(Resultado.PERDEDOR);
            e2.setResultadoEnPartido(Resultado.GANADOR);
            return e2;
        }
       return null;
    }
}

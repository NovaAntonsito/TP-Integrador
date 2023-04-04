package clases;


import enumeraciones.Resultado;

import javax.swing.*;

public class Partido {

    private int golesEquipoLocal= (int) (Math.random() * 8);
    private int golesEquipoVisitante= (int) (Math.random() * 8);

    public Partido() {
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }


    public Equipo simularPartido(Equipo equipoLocal,Equipo equipoVisitante){

        // Muestra un mensaje con el resultado del partido
        JOptionPane.showMessageDialog(null,equipoLocal.getNombre()+" "+
                this.golesEquipoLocal+" - "+this.golesEquipoVisitante+" "+equipoVisitante.getNombre()
                , "Resultado",JOptionPane.INFORMATION_MESSAGE);
        // Le suma los goles a los equipos

        equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
        equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);

        // Logica de el partido

        if(this.golesEquipoLocal>this.golesEquipoVisitante){
            equipoVisitante.setAutorizacion(false);
            equipoVisitante.setResultadoEnElPartido(Resultado.PERDEDOR);
            equipoLocal.setResultadoEnElPartido(Resultado.GANADOR);
            return equipoLocal;
        }else if(this.golesEquipoLocal==this.golesEquipoVisitante){
            JOptionPane.showMessageDialog(null,
                    "Se jugara el desempate entre "+equipoLocal.getNombre()+" - "+
                            equipoVisitante.getNombre(),"Resultado",JOptionPane.INFORMATION_MESSAGE);
            equipoLocal.setResultadoEnElPartido(Resultado.EMPATE);
            equipoVisitante.setResultadoEnElPartido(Resultado.EMPATE);
            simularPartido(equipoLocal,equipoVisitante);
        }else{
            equipoLocal.setAutorizacion(false);
            equipoLocal.setResultadoEnElPartido(Resultado.PERDEDOR);
            equipoVisitante.setResultadoEnElPartido(Resultado.GANADOR);

            return equipoVisitante;
        }
        return null;
    }


}

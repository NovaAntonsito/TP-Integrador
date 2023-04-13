package clases;


import enumeraciones.Resultado;

import javax.swing.*;

public class Partido {

    private int golesEquipoLocal=2;
    private int golesEquipoVisitante=3;

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


    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante) {

        // Muestra un mensaje con el resultado del partido
        JOptionPane.showMessageDialog(null,
                equipoLocal.getNombre() + " " + this.golesEquipoLocal + " - " + this.golesEquipoVisitante + " " + equipoVisitante.getNombre(),
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);

        // Le suma los goles a los equipos
        equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
        equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);

        // Lógica del partido
        if (this.golesEquipoLocal > this.golesEquipoVisitante) {
            // El equipo local ganó
            equipoVisitante.setAutorizacion(false);
            equipoVisitante.setResultadoEnElPartido(Resultado.PERDEDOR);
            equipoLocal.setResultadoEnElPartido(Resultado.GANADOR);
            return equipoLocal;
        } else if (this.golesEquipoLocal == this.golesEquipoVisitante) {
            // Empate, se jugará un desempate
            JOptionPane.showMessageDialog(null,
                    "Se jugará el desempate entre " + equipoLocal.getNombre() + " - " + equipoVisitante.getNombre(),
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
            equipoLocal.setResultadoEnElPartido(Resultado.EMPATE);
            equipoVisitante.setResultadoEnElPartido(Resultado.EMPATE);
            simularPartido(equipoLocal, equipoVisitante); // llamada recursiva para simular el desempate
        } else {
            // El equipo visitante ganó
            equipoLocal.setAutorizacion(false);
            equipoLocal.setResultadoEnElPartido(Resultado.PERDEDOR);
            equipoVisitante.setResultadoEnElPartido(Resultado.GANADOR);
            return equipoVisitante;
        }

        return null;
    }



}

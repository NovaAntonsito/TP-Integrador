package integrador.clases;

import javax.swing.*;
import java.util.List;

public class Ronda {

    private int nroDeRonda;
    private int cantidadDeEquiposEnRonda;
    private int cantidadDeEquiposEnLLave;

    public Ronda() {
    }

    public int getNroDeRonda() {
        return nroDeRonda;
    }

    public void setNroDeRonda(int nroDeRonda) {
        this.nroDeRonda = nroDeRonda;
    }

    public int getCantidadDeEquiposEnRonda() {
        return cantidadDeEquiposEnRonda;
    }

    public void setCantidadDeEquiposEnRonda(int cantidadDeEquiposEnRonda) {
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
    }

    public int getCantidadDeEquiposEnLLave() {
        return cantidadDeEquiposEnLLave;
    }

    public void setCantidadDeEquiposEnLLave(int cantidadDeEquiposEnLLave) {
        this.cantidadDeEquiposEnLLave = cantidadDeEquiposEnLLave;
    }

    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha){
        // Seteo el numero de ronda
        this.nroDeRonda=1;
        // Setea la cantidad de equipos en llave como 4.
        this.cantidadDeEquiposEnLLave=4;
        // Instancio un objeto de partido para usar su metodo
        Partido partido=new Partido();
        // Muestro por pantalla un mensaje de bienvenida a cuartos
        JOptionPane.showMessageDialog(null,"Se jugaran los cuartos de final",
                "Cuartos",JOptionPane.INFORMATION_MESSAGE);

        // Simulo los partidos
        for(int i=0;i<cantidadDeEquiposEnLLave;i+=2){
            partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(i),
                    llaveIzquierda.getEquiposDeLaLlave().get(i+1));
            partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(i),
                    llaveDerecha.getEquiposDeLaLlave().get(i+1));
        }
        // Remuevo los que perdieron
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        // Setear la cantidad actual de equipos por llave
        this.cantidadDeEquiposEnLLave=2;
    }
    public void removerEquipos(List<Equipo> equipos){
        int contadorEquiposPorLlave=cantidadDeEquiposEnLLave;
        for(int i=0;i<contadorEquiposPorLlave;i++){
            Equipo auxiliar=equipos.get(i);
            if(!auxiliar.isAutorizacion()){
                equipos.remove(auxiliar);
                contadorEquiposPorLlave--;
            }
        }
    }

    public void semifinal(Llave llaveIzquierda, Llave llaveDerecha){
        // Seteo el numero de ronda
        this.nroDeRonda=2;
        // Instancio un objeto de partido para usar su metodo
        Partido partido=new Partido();
        // Muestro por pantalla un mensaje de bienvenida a cuartos
        JOptionPane.showMessageDialog(null,"Se jugaran las semifinales",
                "Semifinales",JOptionPane.INFORMATION_MESSAGE);

        // Simular los partidos
        partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(0),
                llaveIzquierda.getEquiposDeLaLlave().get(1));
        partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(0),
                llaveDerecha.getEquiposDeLaLlave().get(1));
        // Removemos a los perdedores
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
    }
    public void finalDelTorneo(Llave llaveIzquierda, Llave llaveDerecha){
        // Seteamos el numero de ronda
        this.nroDeRonda=3;
        // Muestro por pantalla un mensaje de bienvenida a cuartos
        JOptionPane.showMessageDialog(null,"Se jugara la final",
                "Final",JOptionPane.INFORMATION_MESSAGE);

        // Instancio un objeto de partido para usar su metodo
        Partido partido=new Partido();
        // Simulamos el partido final
        Equipo equipo=partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(0),
                llaveIzquierda.getEquiposDeLaLlave().get(0));
        // Muestro un mensaje demostrando quien gano el torneo
        JOptionPane.showMessageDialog(null,"El ganador del torneo es: "+
                equipo.getNombre(),
                "Ganador del torneo",JOptionPane.INFORMATION_MESSAGE);

    }
}

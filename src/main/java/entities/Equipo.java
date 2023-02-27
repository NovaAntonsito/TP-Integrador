package entities;

import enums.Resultado;



public class Equipo  {
    private String name;
    private boolean autorizacion = true;
    private Resultado resultadoEnPartido;
    private int cantGoles;

    public Equipo() {
    }

    public Equipo(String name, boolean autorizacion, Resultado resultadoEnPartido, int cantGoles) {
        this.name = name;
        this.autorizacion = autorizacion;
        this.resultadoEnPartido = resultadoEnPartido;
        this.cantGoles = cantGoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Resultado getResultadoEnPartido() {
        return resultadoEnPartido;
    }

    public void setResultadoEnPartido(Resultado resultadoEnPartido) {
        this.resultadoEnPartido = resultadoEnPartido;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }

    public Equipo(String name) {
        this.name=name;
    }

    //Suma todos los goles metido en todos los partidos
    public void sumarGoles(int i){
        this.cantGoles += i;
    }
}

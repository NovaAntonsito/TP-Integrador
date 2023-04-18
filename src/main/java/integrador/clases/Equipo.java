package integrador.clases;

import integrador.enumeraciones.Resultado;

public class Equipo {

    private String nombre;
    private boolean autorizacion=true;
    private Resultado resultadoEnElPartido;
    private int cantGolesEnElTorneo;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, boolean autorizacion, Resultado resultadoEnElPartido, int cantGolesEnElTorneo) {
        this.nombre = nombre;
        this.autorizacion = autorizacion;
        this.resultadoEnElPartido = resultadoEnElPartido;
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }
    // get + nombreDelAtributo empezando por mayuscula
    public String getNombre() {
        return nombre;
    }
    // set + nombreDelAtributo empezando por mayuscula
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Resultado getResultadoEnElPartido() {
        return resultadoEnElPartido;
    }

    public void setResultadoEnElPartido(Resultado resultadoEnElPartido) {
        this.resultadoEnElPartido = resultadoEnElPartido;
    }

    public int getCantGolesEnElTorneo() {
        return cantGolesEnElTorneo;
    }

    public void setCantGolesEnElTorneo(int cantGolesEnElTorneo) {
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

    public void sumarGolesNuevos(int nuevosGoles){
        this.cantGolesEnElTorneo+=nuevosGoles;
    }


}

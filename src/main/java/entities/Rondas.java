package entities;

public class Rondas  {
    private int nroRonda;
    private Equipo equipoGanador;

    public Rondas(int nroRonda, Equipo equipoGanador) {
        this.nroRonda = nroRonda;
        this.equipoGanador = equipoGanador;
    }

    public Rondas() {
    }

    public int getNroRonda() {
        return nroRonda;
    }

    public void setNroRonda(int nroRonda) {
        this.nroRonda = nroRonda;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }
}

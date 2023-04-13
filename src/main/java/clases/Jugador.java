package clases;

import javax.swing.*;
import java.util.List;

public class Jugador {

    private Equipo equipoSeleccionado;
    private int puntaje;

    public Jugador() {
    }

    public Jugador(Equipo equipoSeleccionado, int puntaje) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.puntaje = puntaje;
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    // Método para que el jugador elija su equipo favorito
    public void elegirEquipo(List<Equipo> listaEquipos) throws Exception {
        if (listaEquipos.size()!=8){
            throw new Exception("La lista no tiene equipos suficientes");
        }
        String listaDeLosEquiposEnMensaje = "Seleccione su equipo:  \n";
        // Crear una lista de los equipos disponibles
        for (int i = 0; i < listaEquipos.size(); i++) {
            listaDeLosEquiposEnMensaje += (i + 1) + ". " + listaEquipos.get(i).getNombre() + "\n";
        }

        // Mostrar los equipos disponibles en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, listaDeLosEquiposEnMensaje, "Seleccion de Equipo", JOptionPane.INFORMATION_MESSAGE);

        String indiceEquipo = null;
        int indiceEquipoParsed = 0;
        // Pedir al jugador que ingrese el índice del equipo que elige hasta que se ingrese un valor válido
        do {
            indiceEquipo = JOptionPane.showInputDialog(null, "Ingrese el indice del equipo",
                    "Seleccion de equipo", JOptionPane.INFORMATION_MESSAGE);
            if (indiceEquipo == null || indiceEquipo.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor en la casilla", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                indiceEquipoParsed = Integer.parseInt(indiceEquipo)-1;
            }

        } while (indiceEquipoParsed < 1 || indiceEquipoParsed > 8);
        // Mostrar al jugador el equipo que ha elegido y guardarlo como el equipo seleccionado del jugador
        JOptionPane.showMessageDialog(null, "EL EQUIPO DE ELEGISTE ES: " + listaEquipos.get(indiceEquipoParsed).getNombre());
        this.equipoSeleccionado = listaEquipos.get(indiceEquipoParsed);
    }

    // Método para sumar puntos al jugador si el equipo seleccionado tiene autorización
    public void sumarPuntos() {
        if (equipoSeleccionado.isAutorizacion()) {
            puntaje++;
        }
    }
}

package entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Ronda {

    private String nro;
    private ArrayList<Partido> partidos;

    // Asumo q se referira a imprimir puntaje del participante
    public int puntos(List<Equipo>pronosticosParticipante){return 5;}
}

package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Equipo {

    private String nombre;
    private String descripcion;
    private Pronostico pronostico;
}

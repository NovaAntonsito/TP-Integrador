
import Config.DBConnection;
import clases.Equipo;
import clases.Jugador;
import clases.Llave;
import clases.Ronda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conexion = DBConnection.obtenerConexion();
        PreparedStatement statement;

        if(DBConnection.verificarTabla()){
            System.out.println("La tabla esta creada!");
        }else{
            System.out.println("Creando tabla Partido");
            statement = conexion.prepareStatement("CREATE TABLE partido (Equipo VARCHAR(50), CantGoles INT);");
            statement.executeUpdate();
            System.out.println("Tabla creada");
        }

        JOptionPane.showMessageDialog(null, "Bienvenidos al Torneo", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
        ArrayList<Equipo> listaDeEquipos = new ArrayList<>();
        listaDeEquipos.add(new Equipo("Belgica"));
        listaDeEquipos.add(new Equipo("Francia"));
        listaDeEquipos.add(new Equipo("Portugal"));
        listaDeEquipos.add(new Equipo("Argentina"));
        listaDeEquipos.add(new Equipo("Brasil"));
        listaDeEquipos.add(new Equipo("Italia"));
        listaDeEquipos.add(new Equipo("Argelia"));
        listaDeEquipos.add(new Equipo("Alemania"));

        Jugador jugador = new Jugador();
        jugador.elegirEquipo(listaDeEquipos);

        // Creo las llaves del torneo
        Llave llaveDerecha = new Llave();
        Llave llaveIzquierda = new Llave();
        // Armo las llaves del torneo
        llaveDerecha.armarLlave(listaDeEquipos, 0);
        llaveIzquierda.armarLlave(listaDeEquipos, 4);

        // Instancio un objeto de Ronda, para acceder a los metodos
        Ronda ronda = new Ronda();
        //Llamo a los metodos de Cuartos, semifinal y final

        // Cuartos
        ronda.cuartosDeFinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        // Semifinal
        ronda.semifinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        // Final
        ronda.finalDelTorneo(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();

        JOptionPane.showMessageDialog(null, "Has conseguido " + jugador.getPuntaje()
                        + " por elegir al equipo: " + jugador.getEquipoSeleccionado().getNombre(), "Nombre",
                JOptionPane.INFORMATION_MESSAGE);


        int confirmInput = JOptionPane.showOptionDialog(
                null,
                "¿Quieres guardar los datos del ganador en la base de datos?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);

        if (confirmInput == JOptionPane.YES_OPTION){
            String consulta = "INSERT INTO partido (Equipo, CantGoles) VALUES (?, ?);";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, ronda.getEquipoGanador().getNombre());
            statement.setInt(2, ronda.getEquipoGanador().getCantGolesEnElTorneo());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos fueron persistidos");
        }else{
            JOptionPane.showMessageDialog(null, "Adios!");
        }

    }

}
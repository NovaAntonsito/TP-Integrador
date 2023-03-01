import config.DBConnection;
import entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws SQLException {

        Rondas rondas=new Rondas();
        rondas.setNroRonda(3);

        Connection conexion = DBConnection.obtenerConexion();

        //Hardcodeamos las listas de equipos
        ArrayList<Equipo> listaEquiposPrimeraRonda1=new ArrayList<>();
        ArrayList<Equipo> listaEquiposPrimeraRonda2=new ArrayList<>();
        listaEquiposPrimeraRonda1.add(new Equipo("Belgica"));
        listaEquiposPrimeraRonda1.add(new Equipo("Francia"));
        listaEquiposPrimeraRonda1.add(new Equipo("Portugal"));
        listaEquiposPrimeraRonda2.add(new Equipo("Italia"));
        listaEquiposPrimeraRonda1.add(new Equipo("Brasil"));
        listaEquiposPrimeraRonda2.add(new Equipo("Alemania"));
        listaEquiposPrimeraRonda2.add(new Equipo("Argelia"));
        listaEquiposPrimeraRonda2.add(new Equipo("Argentina"));

        //Supongamos que por consola elegimos un equipo, pero aca vamos a hardcodear esa seleccion
        Jugador jugador=new Jugador(listaEquiposPrimeraRonda2.get(3));

        //Para que esto funcione tiene que estar como autoincremental la primary key
        //Onda hay que pasar la tabla ya hecha, que se llame campeones para guardar los
        //campeones de cada torneo que se juegue, suponiendo que en un futuro variara cuando
        //se le agregue un factor de random al programa
        String consulta = "INSERT INTO campeones (nombre) VALUES (?)";
        PreparedStatement statement = conexion.prepareStatement(consulta);

        Grupos g1 = new Grupos(listaEquiposPrimeraRonda1);
        Grupos g2 = new Grupos(listaEquiposPrimeraRonda2);
        Partido partido = new Partido();

        rondas.primeraRonda(g1,g2,partido);
        jugador.calcularPuntaje(g2.getEquipoList());

        rondas.segundaRonda(g1,g2,partido);
        jugador.calcularPuntaje(g2.getEquipoList());

        Equipo eWinner=rondas.rondaFinal(g1,g2,partido);
        jugador.calcularPuntaje(g2.getEquipoList());
        //Muestro quien gano
        System.out.println("El campeon del mundo es: "+ eWinner.getName());
        System.out.println("Tu puntaje es: "+jugador.getPuntaje());

        //Persisto al ganador
        statement.setString(1, eWinner.getName());
        statement.executeUpdate();

        statement.close();

        DBConnection.cerrarConexion();
    }
}




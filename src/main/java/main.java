import config.DBConnection;
import entities.Equipo;
import entities.Grupos;
import entities.Partido;
import entities.Rondas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws SQLException {

        Rondas rondas=new Rondas();
        rondas.setNroRonda(3);

        Connection conexion = DBConnection.obtenerConexion();

        //Hardcodeamos las listas de equipos
        ArrayList<Equipo> listaEquiposPrimeraRonda1=new ArrayList<>();
        ArrayList<Equipo> listaEquiposPrimeraRonda2=new ArrayList<>();

        Equipo e1 = new Equipo("Belgica");
        Equipo e2 = new Equipo("Francia");
        Equipo e3 = new Equipo("Portugal");
        Equipo e4 = new Equipo("Italia");
        Equipo e5 = new Equipo("Argentina");
        Equipo e6 = new Equipo("Alemania");
        Equipo e7 = new Equipo("Alemania");
        Equipo e8 = new Equipo("Brasil");

        String consulta = "INSERT INTO partido (nombre) VALUES (?)";
        PreparedStatement statement = conexion.prepareStatement(consulta);

        listaEquiposPrimeraRonda1.add(e1);
        listaEquiposPrimeraRonda1.add(e2);
        listaEquiposPrimeraRonda1.add(e3);
        listaEquiposPrimeraRonda2.add(e4);
        listaEquiposPrimeraRonda1.add(e5);
        listaEquiposPrimeraRonda2.add(e6);
        listaEquiposPrimeraRonda2.add(e7);
        listaEquiposPrimeraRonda2.add(e8);


        Grupos g1 = new Grupos(listaEquiposPrimeraRonda1);
        Grupos g2 = new Grupos(listaEquiposPrimeraRonda2);

        Partido partido = new Partido();



        System.out.println("Ronda 1");
        for(int i=0;i<g1.getEquipoList().size();i+=2){
            partido.simularPartido(g1.getEquipoList().get(i),g1.getEquipoList().get(i+1));
            partido.simularPartido(g2.getEquipoList().get(i),g2.getEquipoList().get(i+1));
        }
        // Creo una lista nueva para los participantes de cada grupo que pasaron de ronda
        ArrayList<Equipo> listaEquiposSegundaRonda1=new ArrayList<>();
        ArrayList<Equipo> listaEquiposSegundaRonda2=new ArrayList<>();

        // Los agrego a las listas
        for(int i=0;i<g1.getEquipoList().size();i++){
            if(g1.getEquipoList().get(i).isAutorizacion()){
                listaEquiposSegundaRonda1.add(g1.getEquipoList().get(i));
            }
            if(g2.getEquipoList().get(i).isAutorizacion()){
                listaEquiposSegundaRonda2.add(g2.getEquipoList().get(i));
            }
        }
        //Seteo las nuevas listas en los grupos
        g1.setEquipoList(listaEquiposSegundaRonda1);
        g1.setEquipoList(listaEquiposSegundaRonda2);

        //Ajusto el proceso
        System.out.println("Ronda 2");
        partido.simularPartido(g1.getEquipoList().get(0),g1.getEquipoList().get(1));
        partido.simularPartido(g2.getEquipoList().get(0),g2.getEquipoList().get(1));

        //Determina quien gano y le saca la autorizacion
        if(!g1.getEquipoList().get(0).isAutorizacion()){
            g1.getEquipoList().remove(0);
        }else{
            g1.getEquipoList().remove(1);
        }
        if(!g2.getEquipoList().get(0).isAutorizacion()){
            g2.getEquipoList().remove(0);
        }else{
            g2.getEquipoList().remove(1);
        }
        //Ronda final
        Equipo eWinner = partido.simularPartido(g1.getEquipoList().get(0),g2.getEquipoList().get(0));
        System.out.println("La gran final");
        System.out.println("El campeon del mundo es: "+ eWinner.getName());

        statement.setString(1, eWinner.getName());

        statement.executeUpdate();


        statement.close();

        DBConnection.cerrarConexion();
    }
}




package configDB;

import java.sql.*;

public class DBConsultas {

    Connection conexion;

    public DBConsultas(Connection conexion) {
        this.conexion = conexion;
    }

    public void queryGenTabla(){
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet rs = metaData.getTables(null, null, "partido", null);
            boolean tablaEncontrada = rs.next();
            if (!tablaEncontrada){
                Statement statement = conexion.createStatement();
                statement.execute("CREATE TABLE partido (equipo_ganador VARCHAR(50), cant_goles INT);");
            }
        }catch (SQLException e){
            System.out.println("Error en la base de datos "+ e.getMessage());
        }
    }

    public void guardarDatos(String name, int cant){
        try {
            PreparedStatement consulta = conexion.prepareStatement("INSERT INTO partido (equipo_ganador, cant_goles)VALUES (?, ?);");
            consulta.setString(1, name);
            consulta.setInt(2, cant);
            consulta.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al guardar en la base de datos "+ e.getMessage());
        }


    }

}

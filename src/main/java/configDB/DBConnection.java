package configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection conexion;

    public DBConnection() {
    }

    public Connection crearConexion(){
        String uri = "jdbc:mysql://localhost:3306/tp_integrador";
        String user = "root";
        String pass = "admin";

        try{
            conexion = DriverManager.getConnection(uri, user, pass);
        }catch(SQLException s){
            System.out.println("Error en la base de datos "+ s.getMessage());
        }
        return conexion;
    }
    public void closeConexion(){
        try {
            if (conexion.isClosed() || conexion == null) {
                conexion.close();
            }
        }catch (SQLException s){
            System.out.println("Error al cerrar la base de datos "+ s.getMessage());
        }
    }
}

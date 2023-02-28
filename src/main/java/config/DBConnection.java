package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conexion;

    public static Connection obtenerConexion() {
        String url = "jdbc:mysql://localhost:3306/integrador";
        String usuario = "root";
        String contrasena = "root";

        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(url, usuario, contrasena);
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("La conexión a la base de datos se ha cerrado exitosamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }
}

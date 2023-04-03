package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // La conexión se almacena en una variable estática para que pueda ser compartida por toda la aplicación
    private static Connection conexion;

    // Este método devuelve la conexión a la base de datos
    public static Connection obtenerConexion() {
        // Se especifica la URL, usuario y contraseña de la base de datos
        String url = "jdbc:mysql://localhost:3306/integrador";
        String usuario = "root";
        String contrasena = "root";

        try {
            // Si la conexión no existe o está cerrada, se crea una nueva conexión mediante el método DriverManager.getConnection()
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(url, usuario, contrasena);
            }
        } catch (SQLException e) {
            // Si ocurre un error al conectarse a la base de datos, se imprime un mensaje de error en la consola
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        // Se devuelve la conexión (ya sea la existente o la recién creada)
        return conexion;
    }

    // Este método cierra la conexión a la base de datos
    public static void cerrarConexion() {
        try {
            // Si la conexión existe y no está cerrada, se llama al método Connection.close() para cerrarla
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("La conexión a la base de datos se ha cerrado exitosamente.");
            }
        } catch (SQLException e) {
            // Si ocurre un error al cerrar la conexión, se imprime un mensaje de error en la consola
            System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }
}

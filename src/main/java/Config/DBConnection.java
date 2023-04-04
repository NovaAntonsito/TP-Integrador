package Config;

import java.sql.*;

public class DBConnection {

    private static Connection conexion;

    // La conexión se almacena en una variable estática para que pueda ser compartida por toda la aplicación

    // Este método devuelve la conexión a la base de datos
    public static Connection obtenerConexion() {
        // Se especifica la URL, usuario y contraseña de la base de datos
        String url = "jdbc:mysql://localhost:3306/integradorARG";
        String usuario = "root";
        String contrasena = "1234";

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
    public static boolean verificarTabla() {
        boolean resultado = false;

        try {
            // Se obtiene la conexión a la base de datos
           conexion = obtenerConexion();

            // Se obtiene los metadatos de la base de datos
            DatabaseMetaData metaDatos = conexion.getMetaData();

            // Se busca la tabla "partido"
            ResultSet resultSet = metaDatos.getTables(null, null, "partido", null);

            // Si el conjunto de resultados contiene al menos una fila, eso significa que la tabla existe en la base de datos
            if (resultSet.next()) {
                resultado = true;
            }

            // Se cierra el conjunto de resultados
            resultSet.close();

        } catch (SQLException e) {
            // Si ocurre un error al verificar si la tabla existe, se imprime un mensaje de error en la consola
            System.err.println("Error al verificar si la tabla existe: " + e.getMessage());
        }

        // Se devuelve el resultado de la verificación
        return resultado;
    }
}

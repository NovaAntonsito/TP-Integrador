package integrador.database;

import integrador.clases.Equipo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class BaseDeDatos {

    public static Connection conexionABaseDeDatos;

    public BaseDeDatos() {
    }

    public static void crearConexion() {
        String url = "jdbc:mysql://localhost:3306/tp_integrador";
        // Dependiendo como este configurado el usuario de mysql esto puede variar
        // En los tutoriales se usa como root - admin
        // Podria ser por ejemplo tambien root - root

        String user = "root";
        String password = "root";
        JOptionPane.showMessageDialog(null, "Creando conexion a base de datos"
                , "Conectando", JOptionPane.PLAIN_MESSAGE);
        try {
            conexionABaseDeDatos = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexion creada exitosamente"
                    , "Conectado", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos "
                    + s.getMessage(), "Error al conectar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void closeConexion() {
        JOptionPane.showMessageDialog(null, "Cerrando la conexion a base de datos"
                , "Cerrando", JOptionPane.PLAIN_MESSAGE);
        try {
            if (conexionABaseDeDatos.isClosed() || conexionABaseDeDatos == null) {
                conexionABaseDeDatos.close();
                JOptionPane.showMessageDialog(null, "Conexion cerrada exitosamente"
                        , "Desconectado", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion con la base de datos "
                    + s.getMessage(), "Error al cerrar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void persistirInformacion(ArrayList<Equipo> equiposDelTorneo, Equipo ganadorDelTorneo) {

        try {
            Statement stmt = conexionABaseDeDatos.createStatement();
            JOptionPane.showMessageDialog(null, "Creando las tablas",
                    "Persistencia", JOptionPane.INFORMATION_MESSAGE);
            // Crear tabla Equipos si es que no existe
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Equipos (nombre VARCHAR(255), cantidad_de_goles INT)");

            // Vaciar tabla Equipos cada vez que se persista un nuevo torneo
            stmt.executeUpdate("TRUNCATE TABLE Equipos");

            // Crear tabla Ganador del Torneo si es que no existe
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Ganador_del_Torneo (campeon VARCHAR(255))");

            // Vaciar tabla Ganador del Torneo cada vez que se persista un nuevo torneo
            stmt.executeUpdate("TRUNCATE TABLE Ganador_del_Torneo");

            JOptionPane.showMessageDialog(null, "Se crearon las tablas",
                    "Persistencia", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, "Persistiendo la informacion",
                    "Persistencia", JOptionPane.INFORMATION_MESSAGE);

            // Preparo la query para guardar los equipos en la tabla
            PreparedStatement queryEquipos = conexionABaseDeDatos.prepareStatement("INSERT INTO Equipos (nombre, cantidad_de_goles)VALUES (?, ?);");
            // Persisto la informacion de los equipos del torneo
            for (Equipo equipo : equiposDelTorneo) {
                queryEquipos.setString(1, equipo.getNombre());
                queryEquipos.setInt(2, equipo.getCantGolesEnElTorneo());
                queryEquipos.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Se guardaron los participantes",
                    "Persistencia", JOptionPane.INFORMATION_MESSAGE);

            // Persisto al ganador del torneo
            PreparedStatement queryGanador = conexionABaseDeDatos.prepareStatement(
                    "INSERT INTO Ganador_del_Torneo (campeon) VALUES (?)");
            queryGanador.setString(1, ganadorDelTorneo.getNombre());
            queryGanador.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se guardo al ganador del torneo",
                    "Persistencia", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void leerRegistros() {
        try {
            Statement stmt = conexionABaseDeDatos.createStatement();

            // Leer los datos de la tabla Equipos
            ResultSet rs = stmt.executeQuery("SELECT * FROM Equipos");
            // Crear string con la lista de los participantes
            String registros = "Participantes \n";
            while (rs.next()) {
                registros += "-" + " " + rs.getString("nombre") + " - Goles: " + rs.getInt("cantidad_de_goles")+"\n";
            }
            JOptionPane.showMessageDialog(null, registros, "Lista de equipos", JOptionPane.INFORMATION_MESSAGE);

            // Leer el equipo ganador del torneo de la tabla Ganador del Torneo
            rs = stmt.executeQuery("SELECT * FROM Ganador_del_Torneo");
            String nombreGanador = "El ganador del torneo fue: ";
            if (rs.next()) {
                nombreGanador += rs.getString("campeon");
            }
            JOptionPane.showMessageDialog(null, nombreGanador, "Ganador", JOptionPane.INFORMATION_MESSAGE);

            // Cerrar la conexión y liberar los recursos
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


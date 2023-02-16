package Config;

import java.sql.*;

public class DBConexion {
    Connection con= DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sonoo","root","root");
    Statement stmt=con.createStatement();
    ResultSet rs;

    public DBConexion() throws SQLException {
    }
}

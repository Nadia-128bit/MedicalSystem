package grd_project;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {
    private static Connection con;
    
    private static final String URL = "jdbc:postgresql://localhost:5432/MediCam";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    
    public static Connection getConexion()throws SQLException {       
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

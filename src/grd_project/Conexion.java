package grd_project;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection con;
    
    private static final String URL = "jdbc:postgresql://localhost:5433/MediCam";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgre";
    
    public static Connection getConexion()throws SQLException {       
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public void agregarDatos(String consulta) {
        try {
            Statement s = getConexion().createStatement();
            s.execute(consulta);
           JOptionPane.showMessageDialog(null, "Agregado con éxito");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e);
        }
    }
    
    public void eliminar(String consulta) {
        try {
            Statement s = getConexion().createStatement();
            s.execute(consulta);
            JOptionPane.showMessageDialog(null, "Eliminado con éxito");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e);
        }
    }
}

package grd_project;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Conexion {
    private static Connection con;
    
    private static final String URL = "jdbc:postgresql://localhost:5433/MediCam";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgre";
    
    public static Connection getConexion()throws SQLException {       
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public void cargarDatos(JTable table, String query) {
        try {
            PreparedStatement pst = getConexion().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            model.setRowCount(0);

            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getString(i);
                }
                model.addRow(rowData);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
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

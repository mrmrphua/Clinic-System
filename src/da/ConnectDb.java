package da;


import java.sql.*;
import javax.swing.*;

public class ConnectDb {
    private String host = "jdbc:derby://localhost:1527/test";
    private String user = "haha";
    private String password = "hihi";
    private Connection conn;
    
    public ConnectDb(){
        createConnection();
    }
    
    public Connection createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return conn;
    }
    
    private void shutDown() {
        if (conn != null){
            try {
                conn.close();
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

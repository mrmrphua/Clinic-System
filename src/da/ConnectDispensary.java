/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.DatabaseDispensary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dewei
 */
public class ConnectDispensary {
    ConnectDb db = new ConnectDb();
 
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String tableName = "DISPENSARY";
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
     public ConnectDispensary() {
           conn = db.createConnection();
    }
     
       public DatabaseDispensary getCurrentRecord() {
        DatabaseDispensary programme = null;
        try {
            programme = new DatabaseDispensary(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return programme;
    }
       
        public ArrayList<DatabaseDispensary> getProgrammes() {
         ArrayList<DatabaseDispensary> programme = new ArrayList<DatabaseDispensary>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                programme.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return programme;
    }
        
         public DatabaseDispensary getRecord(String title) {
        DatabaseDispensary p = null;
        try {
            rs.beforeFirst();
            boolean found = false;
            while (!found && rs.next()) {
                if (title.equals(rs.getString("DISID"))) {
                    found = true;
                }
            }
            if (found)
                p = new DatabaseDispensary(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }
         
          public void insert(String disID,String disName,String unitprice,String quantity) {
      try{
        
                    stmt = conn.prepareStatement("INSERT INTO DISPENSARY VALUES(?, ?, ?, ?)");
           if(!disID.equals("")){
                        stmt.setString(1, disID);  
                        stmt.setString(2, disName);
                        stmt.setString(3, unitprice); 
                        stmt.setString(4, quantity);

                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record created !", "DONE",JOptionPane.INFORMATION_MESSAGE);
              }
              else
                        JOptionPane.showMessageDialog(null, "Dispensary ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}
    
          public void insert(String disID,String disName,String unitprice,String quantity,String usage) {
      try{
        
                    stmt = conn.prepareStatement("INSERT INTO DISPENSARY VALUES(?, ?, ?, ?,?)");
           if(!disID.equals("")){
                        stmt.setString(1, disID);  
                        stmt.setString(2, disName);
                        stmt.setString(3, unitprice); 
                        stmt.setString(4, quantity);
                        stmt.setString(5, usage);

                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record created !", "DONE",JOptionPane.INFORMATION_MESSAGE);
              }
              else
                        JOptionPane.showMessageDialog(null, "Dispensary ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}
          
          
    public void edit(String disID,String disName,String unitprice,String quantity, String disUsage) {
      try{
          stmt = conn.prepareStatement("UPDATE DISPENSARY SET DISNAME=?,UNITPRICE=?,QUANTITY=?,USAGE=? WHERE DISID=?");

               if(!disID.equals("")){
                stmt.setString(1,disName);
                stmt.setString(2,unitprice);
                stmt.setString(3,quantity);
                stmt.setString(4,disUsage);
                stmt.setString(5,disID);

                stmt.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Record updated !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                    
               } 
                else
                        JOptionPane.showMessageDialog(null, "Dispensary ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
             
         }catch (SQLException ex) { 
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}
    public void delete(String disID) {
      try{
          stmt = conn.prepareStatement("DELETE FROM DISPENSARY WHERE DISID = ?");

               if(!disID.equals("")){
                        stmt.setString(1,disID);
  
                     
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record had been deleted !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                    
               } 
                else
                        JOptionPane.showMessageDialog(null, "Dispensary ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
             
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//admin done
package da;

import domain.DatabaseAdmin;
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
public class ConnectAdmin {
    ConnectDb db = new ConnectDb();
 
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String tableName = "ADMIN";
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
     public ConnectAdmin() {
           conn = db.createConnection();
    }
     
       public DatabaseAdmin getCurrentRecord() {
        DatabaseAdmin programme = null;
        try {
            programme = new DatabaseAdmin(rs.getString(1), rs.getString(2), rs.getBoolean(3));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return programme;
    }
       
       
        public ArrayList<DatabaseAdmin> getProgrammes() {
         ArrayList<DatabaseAdmin> programme = new ArrayList<DatabaseAdmin>();
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
        
        
        public String MatchProgrammes(String acc) {
            
            
         ArrayList<DatabaseAdmin> programme = new ArrayList<DatabaseAdmin>();
        try {
            
            stmt = conn.prepareStatement("SELECT * FROM ADMIN WHERE ACCOUNT = '" + acc + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                programme.add(getCurrentRecord());
            }
            
            if(programme.size()==1)
            { 
                return programme.get(0).getId();
            }
            else
            {
                return null;
            }
            
            
       
        } catch (SQLException ex) {
             JOptionPane.showConfirmDialog(null, ex, "Check Information", JOptionPane.YES_NO_OPTION);
            ex.getMessage();
        }
            return null;
        
        }

        
         public DatabaseAdmin getRecord(String title) {
        DatabaseAdmin p = null;
        try {
            rs.beforeFirst();
            boolean found = false;
            while (!found && rs.next()) {
                if (title.equals(rs.getString("ACCOUNT"))) {
                    found = true;
                }
            }
            if (found)
                p = new DatabaseAdmin(rs.getString(1), rs.getString(2), rs.getBoolean(3));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }
         
          public void insert(String account,String password,boolean status) {
      try{
        
                    stmt = conn.prepareStatement("INSERT INTO ADMIN VALUES(?, ?, ?)");
           if(!account.equals("")){
                        stmt.setString(1, account);  
                        stmt.setString(2, password);
                        stmt.setBoolean(3, status); 

                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "account created !", "DONE",JOptionPane.INFORMATION_MESSAGE);
              }
              else
                        JOptionPane.showMessageDialog(null, "accoutn name is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}
    
          
    public void edit(String account,String password,boolean status) {
      try{
          stmt = conn.prepareStatement("UPDATE ADMIN SET PASSWORD=?,STATUS=? WHERE ACCOUNT=?");

               if(!account.equals("")){
                stmt.setString(1,password);
                stmt.setBoolean(2,status);
                stmt.setString(3,account);

                stmt.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Record updated !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                    
               } 
                else
                        JOptionPane.showMessageDialog(null, "Account is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
             
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

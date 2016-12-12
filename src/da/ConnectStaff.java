package da;

import domain.DatabaseStaff;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


public class ConnectStaff {

    
    ConnectDb db = new ConnectDb();
    private String tableName = "STAFF";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
    public ConnectStaff() {
       
       conn = db.createConnection();
    }
    
    public DatabaseStaff getCurrentRecord() {
        DatabaseStaff programme = null;
        try {
            programme = new DatabaseStaff(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return programme;
    }
    /* P7Q2 */
    public ArrayList<DatabaseStaff> getProgrammes() {
         ArrayList<DatabaseStaff> programme = new ArrayList<DatabaseStaff>();
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
    
    public DatabaseStaff getRecord(String id) {
        DatabaseStaff p = null;
        try {
            rs.beforeFirst();
            boolean found = false;
            while (!found && rs.next()) {
                if (id.equals(rs.getString("STAFFID"))) {
                    found = true;
                }
            }
            if (found)
                p = new DatabaseStaff(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }

   
  public void insert(String sid, String sname, String sic,String saddress,String sgender,String sphone,String sage,String semail) {
      try{
        
                    stmt = conn.prepareStatement("INSERT INTO STAFF VALUES(?,?,?,?,?,?,?,?)");
           if(!sid.equals("")){
                        stmt.setString(1, sid);  
                        stmt.setString(2, sname);
                        stmt.setString(3, sic);  
                        stmt.setString(4, saddress);
                        stmt.setString(5, sgender);  
                        stmt.setString(6, sphone);
                        stmt.setString(7, sage);  
                        stmt.setString(8, semail);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record created !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                   
       
          
              }
       
             else
                        JOptionPane.showMessageDialog(null, "Staff ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
      
}
    
    public void edit(String editSid, String editSname, String editSic,String editSaddress,String editSgender,String editSphone,String editSage,String editSemail) {
      try{
          stmt = conn.prepareStatement("UPDATE STAFF SET STAFFNAME=?,STAFFIC=?,STAFFADDRESS=?,SGENDER=?,STAFFPHONE=?,STAFFAGE=?,STAFFEMAIL=? WHERE STAFFID=?");
               if(!editSid.equals("")){
                     stmt.setString(1,editSname);
                     stmt.setString(2,editSic);
                     stmt.setString(3,editSaddress);
                     stmt.setString(4,editSgender);
                     stmt.setString(5,editSphone);
                     stmt.setString(6,editSage);
                     stmt.setString(7,editSemail);
                     stmt.setString(8,editSid);  
                     stmt.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Record updated !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                    
               } 
                else
                        JOptionPane.showMessageDialog(null, "Staff ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
             
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}
    public void delete(String deleteID) {
      try{
          stmt = conn.prepareStatement("DELETE FROM STAFF  WHERE STAFFID=?");
               if(!deleteID.equals("")){
                     
                     stmt.setString(1,deleteID);  
                     stmt.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Record deleted !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                    
               } 
                else
                        JOptionPane.showMessageDialog(null, "Staff ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
             
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}
}

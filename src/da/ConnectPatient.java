package da;

import domain.DatabasePatient;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


public class ConnectPatient {

    
    ConnectDb db = new ConnectDb();
    private String tableName = "PATIENT";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
    public ConnectPatient() {
       
       conn = db.createConnection();
    }
    
    public DatabasePatient getCurrentRecord() {
        DatabasePatient programme = null;
        try {
            programme = new DatabasePatient(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return programme;
    }
    /* P7Q2 */
    public ArrayList<DatabasePatient> getProgrammes() {
         ArrayList<DatabasePatient> programme = new ArrayList<DatabasePatient>();
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
    
    public DatabasePatient getRecord(String id) {
        DatabasePatient p = null;
        try {
            rs.beforeFirst();
            boolean found = false;
            while (!found && rs.next()) {
                if (id.equals(rs.getString("PATID"))) {
                    found = true;
                }
            }
            if (found)
                p = new DatabasePatient(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }

   
  public void insert(String id, String name, String ic,String address,String gender,String phone,String age,String email,String bloodType) {
      try{
        
                    stmt = conn.prepareStatement("INSERT INTO PATIENT VALUES(?, ?, ?, ?,?,?,?,?,?)");
           if(!id.equals("")){
                        stmt.setString(1, id);  
                        stmt.setString(2, name);
                        stmt.setString(3, ic);  
                        stmt.setString(4, address);
                        stmt.setString(5, gender);  
                        stmt.setString(6, phone);
                        stmt.setString(7, age);  
                        stmt.setString(8, email);
                        stmt.setString(9, bloodType); 
  
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record created !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                   
       
          
              }
       
             else
                        JOptionPane.showMessageDialog(null, "Patient ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
      
}
    
    public void edit(String editId, String editName, String editIc,String editAddress,String editGender,String editPhone,String editAge,String editEmail,String editBloodType) {
      try{
          stmt = conn.prepareStatement("UPDATE PATIENT SET PATNAME=?,PATIC=?,PATADDRESS=?,PGENDER=?,PATPHONE=?,PATAGE=?,PATEMAIL=?,BLOODTYPE=? WHERE PATID=?");
               if(!editId.equals("")){
                     stmt.setString(1,editName);
                     stmt.setString(2,editIc);
                     stmt.setString(3,editAddress);
                     stmt.setString(4,editGender);
                     stmt.setString(5,editPhone);
                     stmt.setString(6,editAge);
                     stmt.setString(7,editEmail);
                     stmt.setString(8,editBloodType);
                     stmt.setString(9,editId);  
                     
                     stmt.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Record updated !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                    
               } 
                else
                        JOptionPane.showMessageDialog(null, "Patient ID is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
             
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}

}

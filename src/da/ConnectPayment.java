
package da;

import domain.DatabasePayment;
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
public class ConnectPayment {
    ConnectDb db = new ConnectDb();
 
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String tableName = "PAYMENT";
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
     public ConnectPayment() {
           conn = db.createConnection();
    }
     
       public DatabasePayment getCurrentRecord() {
        DatabasePayment programme = null;
        try {
            programme = new DatabasePayment(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return programme;
    }
       
        public ArrayList<DatabasePayment> getProgrammes() {
         ArrayList<DatabasePayment> programme = new ArrayList<DatabasePayment>();
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
        
         public DatabasePayment getRecord(String title) {
        DatabasePayment p = null;
        try {
            rs.beforeFirst();
            boolean found = false;
            while (!found && rs.next()) {
                if (title.equals(rs.getString("PAYMENTCODE"))) {
                    found = true;
                }
            }
            if (found)
                p = new DatabasePayment(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }
         
          public void insert(String code,String id,String sID,String amount) {
      try{
        
                    stmt = conn.prepareStatement("INSERT INTO PAYMENT VALUES(?, ?, ?,?)");
           if(!code.equals("")){
                        stmt.setString(1, code);  
                        stmt.setString(2, id);
                        stmt.setString(3, sID);
                        stmt.setString(4, amount);

                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record created !", "DONE",JOptionPane.INFORMATION_MESSAGE);
              }
              else
                        JOptionPane.showMessageDialog(null, "Payment code is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}
    
    public void edit(String code,String id,String sID,String amount) {
      try{
          stmt = conn.prepareStatement("UPDATE PAYMENT SET  PAT_ID=?,STAFF_ID=?,AMOUNT=? WHERE PAYMENTCODE=?");

               if(!code.equals("")){
                stmt.setString(1,id);
                stmt.setString(2,sID);
                stmt.setString(3,amount);

                
                stmt.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Record updated !", "DONE",JOptionPane.INFORMATION_MESSAGE);
                    
               } 
                else
                        JOptionPane.showMessageDialog(null, "Payment code is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                
             
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
}

}

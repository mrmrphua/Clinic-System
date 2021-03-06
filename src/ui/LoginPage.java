
package ui;

import da.ConnectAdmin;
import da.ConnectDb;
import domain.DatabaseAdmin;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import last.AdminAction;



public class LoginPage extends javax.swing.JFrame {

     ConnectDb db = new ConnectDb(); 
      private Connection conn;
    public ArrayList<DatabaseAdmin> adminDetails;
    private ConnectAdmin adminConnection;
    
    
    public LoginPage() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Login");
        
        
        conn = db.createConnection();
        adminConnection = new ConnectAdmin();
        
        user1.addFocusListener(new FocusListener() {
        public void focusGained(FocusEvent e) {
        //jTextField1.setText("");
        }

        public void focusLost(FocusEvent e) {
        if(user1.getText().equals("")){
            user1.setText("Username....");
            }
        }
    });
        
        password1.addFocusListener(new FocusListener() {
        public void focusGained(FocusEvent e) {
        //jTextField1.setText("");
        }

        public void focusLost(FocusEvent e) {
        if(password1.getText().equals("")){
            password1.setText("Password...");
            }
        }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        user1 = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        Login = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 350));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("LOGIN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 30, 130, 70);

        user1.setText("Username....");
        user1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user1MouseClicked(evt);
            }
        });
        user1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user1ActionPerformed(evt);
            }
        });
        user1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                user1KeyPressed(evt);
            }
        });
        getContentPane().add(user1);
        user1.setBounds(70, 110, 170, 29);

        password1.setText("Password...");
        password1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                password1MouseClicked(evt);
            }
        });
        password1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                password1PropertyChange(evt);
            }
        });
        getContentPane().add(password1);
        password1.setBounds(70, 160, 170, 29);

        Login.setText("LOGIN");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login);
        Login.setBounds(70, 210, 170, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/logo1.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(270, 0, 400, 310);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/green.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 680, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user1MouseClicked
        if(user1.getText().equals("Username....")){
            user1.setText("");
        }
    }//GEN-LAST:event_user1MouseClicked

    private void user1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user1ActionPerformed
        
    }//GEN-LAST:event_user1ActionPerformed

    private void user1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user1KeyPressed

    }//GEN-LAST:event_user1KeyPressed

    private void password1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_password1MouseClicked
        
        if(password1.getText().equals("Password...")){
            password1.setText("");
        }
    }//GEN-LAST:event_password1MouseClicked

    private void password1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_password1PropertyChange

    }//GEN-LAST:event_password1PropertyChange

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
          String name = "abc";
        String pass = "12";
        //Testing
        
        
        
        String account = user1.getText();
        String passw = String.copyValueOf(password1.getPassword());
        if ((name.equals(user1.getText())) && (pass.equals(passw))) {
            JOptionPane.showMessageDialog(null, "You had loged in as admin!", "Check", JOptionPane.INFORMATION_MESSAGE);
            /*
            dispose();
            Menu menu=new Menu();
            menu.setVisible(true);
           */
                    AdminAction admin = new AdminAction();
                    admin.setVisible(true);
                    dispose();

        } 
        
        else if (user1.getText().equals("") || ((passw.equals("")))) {
            JOptionPane.showMessageDialog(null, "Can't be empty", "Check", JOptionPane.INFORMATION_MESSAGE);
        } 
        
        else if(adminConnection.MatchProgrammes(account)!=null)
        {
             String DatabasePassword =  adminConnection.MatchProgrammes(account);
             if(DatabasePassword.equals(passw) )
             {
                JOptionPane.showConfirmDialog(null,"you had loged in as "+ account, "Check Information", JOptionPane.YES_NO_OPTION);   
                
                dispose();
                Menu menu=new Menu();
                menu.setVisible(true);
             }
             else
             {
                 
                JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD", "Warning", JOptionPane.WARNING_MESSAGE);
                user1.setText("");
                password1.setText("");
             }
        }
        else 
            
        {
            
            
  /*
            adminDetails = adminConnection.getProgrammes();
            
            JOptionPane.showMessageDialog(null, adminDetails.get(0).getId(), "Check", JOptionPane.INFORMATION_MESSAGE);
            for (int i = 0; i < adminDetails.size(); ++i) {
                if(adminDetails.get(i).getAccount().equals(account))
                {
                    if(adminDetails.get(i).getId().equals("0505"))
                    {
                        
                    }
                }
            }*/
           // setTextFieldsDispensary(adminDetails.get(0));        
           
           
            
            //JOptionPane.showConfirmDialog(null,user1.getText(), "Check Information", JOptionPane.YES_NO_OPTION);
            //String test = user1.getText();
            //test = adminConnection.MatchProgrammes("yao");
            JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD", "Warning", JOptionPane.WARNING_MESSAGE);
               user1.setText("");
        password1.setText("");
       
        }

    }//GEN-LAST:event_LoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPasswordField password1;
    private javax.swing.JTextField user1;
    // End of variables declaration//GEN-END:variables
}

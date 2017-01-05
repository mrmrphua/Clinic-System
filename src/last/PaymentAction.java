
package last;


import da.ConnectDb;
import da.ConnectDispensary;
import da.ConnectPatient;
import da.ConnectPayment;
import da.ConnectStaff;
import domain.DatabaseDispensary;
import domain.DatabasePatient;
import domain.DatabasePayment;
import domain.DatabaseStaff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ui.Menu;

public class PaymentAction extends javax.swing.JFrame {
    ConnectDb db = new ConnectDb(); 
    private Connection conn;
    private ConnectPayment paymentConnection;
    private ConnectPatient patientConnection;
    private ConnectDispensary dispensaryConnection;
    private ConnectStaff staffConnection;
    public ArrayList<DatabasePayment> PaymentDetails;
    public ArrayList<DatabasePatient> PatientDetails;
    public ArrayList<DatabaseDispensary> DispensaryDetails;
    public ArrayList<DatabaseStaff> StaffDetails;
    private String[] paymentId;
     String dquantity ;
    DefaultTableModel model;
   
    public PaymentAction() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Payment");
        conn = db.createConnection();
        paymentConnection = new ConnectPayment();
        patientConnection=new ConnectPatient();
        dispensaryConnection=new ConnectDispensary();
        staffConnection=new ConnectStaff();
        paymentCount(); 
        getpatatinetid();
        getstaffid();
        getdispensaryid();
      
        model = (DefaultTableModel)jTable1.getModel();
    }
    
    public void paymentCount(){
              PaymentDetails = paymentConnection.getProgrammes();
          for(int i=0; i<PaymentDetails.size(); i++){     
             if(PaymentDetails.get(i).getCode().startsWith("PAY")){
                paymentId = PaymentDetails.get(i).getCode().split("-");     
             }
            
         }
           code.setText("PAY-"+String.valueOf(Integer.parseInt(paymentId[1])+1));
         }
    
     public void getpatatinetid(){
          PatientDetails = patientConnection.getProgrammes();
        for (int i = 0; i < PatientDetails.size(); ++i) {
          p_id.addItem(PatientDetails.get(i).getId());
        }
 }
     
        public void getstaffid(){
          StaffDetails = staffConnection.getProgrammes();
        for (int i = 0; i < StaffDetails.size(); ++i) {
          s_id.addItem(StaffDetails.get(i).getSid());
        }
 }
 public void getdispensaryid(){
          DispensaryDetails = dispensaryConnection.getProgrammes();
        for (int i = 0; i < DispensaryDetails.size(); ++i) {
          d_id.addItem(DispensaryDetails.get(i).getDisID());
        }
        d_id.addActionListener(new PaymentAction.SelectCountryListener2());
            setTextFieldsDispensary(DispensaryDetails.get(0));
 }
 
 private class SelectCountryListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DatabaseDispensary programme = DispensaryDetails.get(d_id.getSelectedIndex());
            setTextFieldsDispensary(programme);
        }
    }
        public void setTextFieldsDispensary(DatabaseDispensary programme) {
        Double.parseDouble(programme.getUnitPrice());
         d_price.setText(programme.getUnitPrice());    
         d_price1.setText(programme.getDisName());     
         d_price2.setText(programme.getDisUsage());   
            
    }

 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        p_id = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        s_id = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        d_id = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        d_price = new javax.swing.JTextField();
        d_quantity = new javax.swing.JTextField();
        d_price1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        d_price2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        all = new javax.swing.JTextField();
        PayBack = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Payment Information"));

        jLabel1.setText("Payment Code : ");

        code.setEditable(false);
        code.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Patient ID : ");

        p_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_idActionPerformed(evt);
            }
        });

        jLabel7.setText("Staff ID : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(code)
                    .addComponent(p_id, 0, 100, Short.MAX_VALUE)
                    .addComponent(s_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(code, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s_id, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dispensary Information"));

        jLabel3.setText("Dispensary ID : ");

        d_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_idMouseClicked(evt);
            }
        });

        jLabel4.setText("Unit Price : ");

        jLabel5.setText("Quantity : ");

        d_price.setEditable(false);
        d_price.setBackground(new java.awt.Color(204, 204, 204));
        d_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_priceActionPerformed(evt);
            }
        });

        d_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_quantityActionPerformed(evt);
            }
        });

        d_price1.setEditable(false);
        d_price1.setBackground(new java.awt.Color(204, 204, 204));
        d_price1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_price1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Dispensary Name : ");

        d_price2.setEditable(false);
        d_price2.setBackground(new java.awt.Color(204, 204, 204));
        d_price2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_price2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Usage:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d_price1)
                    .addComponent(d_price, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(d_quantity)
                    .addComponent(d_id, 0, 124, Short.MAX_VALUE)
                    .addComponent(d_price2))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d_price1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d_price2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d_price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bAdd.setText("ADD");
        bAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAddMouseClicked(evt);
            }
        });
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dispensary ID ", "Unit Price", "Quantity", "Line Total"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("Amount : ");

        all.setEditable(false);
        all.setBackground(new java.awt.Color(204, 204, 204));
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
            }
        });

        PayBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/last/back.png"))); // NOI18N
        PayBack.setText("BACK");
        PayBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayBackActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/last/create.png"))); // NOI18N
        jButton5.setText("CREATE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(all, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PayBack, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(all)
                        .addComponent(PayBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
     
        String amount;
        double unit,qty,Amount;
        boolean Valid = true;
        unit = Double.parseDouble(d_price.getText());
        qty = Double.parseDouble(d_quantity.getText());
        

        Amount = unit * qty;
        amount = String.format("%.02f", Amount);
        
        for(int i=0; i<model.getRowCount();i++){
            if(d_id.getSelectedItem().equals(model.getValueAt(i, 0))){
                JOptionPane.showMessageDialog(null, "Same Dispensary ID","Error Message",JOptionPane.ERROR_MESSAGE);
                Valid =false;
            }
              }
             if ( Valid == true){
               try{   
      
      PaymentValidate valid = new PaymentValidate (d_quantity.getText());  
                  model.insertRow(model.getRowCount(), new Object[]{d_id.getSelectedItem(),d_price.getText(),d_quantity.getText(),amount});
                    d_quantity.setText("");
        
        String totalAll;
        double calculate=0;
        for( int z = model.getRowCount(); z > 0; z-- ){
          calculate+=Double.parseDouble((String) model.getValueAt(z-1, 3));
      }
      totalAll = String.format("%.02f", calculate);
      all.setText(totalAll);
      
        
               for(int b=0; b<model.getRowCount(); b++)
        if(d_id.getSelectedItem().equals(model.getValueAt(b, 0))){
           dquantity=(String) model.getValueAt(b, 2);
           double tquantity;
            for(int a=0; a<DispensaryDetails.size();a++){
                if(DispensaryDetails.get(a).getDisID().equals(d_id.getSelectedItem())){
            tquantity =Double.parseDouble(DispensaryDetails.get(a).getQuantity());
            System.out.println(DispensaryDetails.get(a).getQuantity());
            tquantity=tquantity-Double.parseDouble(dquantity);
            String quantity= ""+tquantity;
            String ID= (String) d_id.getSelectedItem();
            String price= d_price.getText();
            String usage= d_price2.getText();
            
            dispensaryConnection.edit(ID,DispensaryDetails.get(a).getDisName(),price,quantity , usage);
                }
            }
            
            }
           
            
            
        
      
     }
                 catch(InvalidException invalid){
           JOptionPane.showMessageDialog(null, invalid.getMessage());
    
    
      }
                
            }
         
           
         
  
   
    
       
              
        

      
    
    }//GEN-LAST:event_bAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
   
        d_id.setSelectedItem(String.valueOf(model.getValueAt(jTable1.getSelectedRow(), 0)));
        d_price.setText(String.valueOf(model.getValueAt(jTable1.getSelectedRow(), 1)));
        d_quantity.setText(String.valueOf(model.getValueAt(jTable1.getSelectedRow(), 2)));
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void PayBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayBackActionPerformed
         Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_PayBackActionPerformed

    private void bAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddMouseClicked
        
    }//GEN-LAST:event_bAddMouseClicked

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed
       String totalAll;
        double calculate=0;
        for( int i = model.getRowCount(); i > 0; i-- ){
          calculate+=Double.parseDouble((String) model.getValueAt(i-1, 3));
      }
      totalAll = String.format("%.02f", calculate);
      all.setText(totalAll);
    }//GEN-LAST:event_allActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String message = "Payment Code: "+code.getText();
        message+= "\nPatient ID: "+p_id.getSelectedItem();
        message+= "\nStaff ID: "+s_id.getSelectedItem();
        message+="\nAmount:"+all.getText();

        message+="\n\nIs the information correct?";
        int returnVal = JOptionPane.showConfirmDialog(null, message, "Check Information", JOptionPane.YES_NO_OPTION);
        if(returnVal == JOptionPane.YES_OPTION){
            String Code=code.getText();
            String ID=(String) p_id.getSelectedItem();
            String sID=(String) s_id.getSelectedItem();
            String Amount=all.getText();

            paymentConnection.insert(Code,ID,sID,Amount);
        }
        PaymentDetails = paymentConnection.getProgrammes();

            paymentCount();
            
          
    }//GEN-LAST:event_jButton5ActionPerformed

    private void p_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_idActionPerformed

    private void d_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_quantityActionPerformed

    private void d_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_priceActionPerformed

    private void d_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_idMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_d_idMouseClicked

    private void d_price1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_price1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_price1ActionPerformed

    private void d_price2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_price2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_price2ActionPerformed
    
  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentAction().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PayBack;
    private javax.swing.JTextField all;
    private javax.swing.JButton bAdd;
    private javax.swing.JTextField code;
    private javax.swing.JComboBox d_id;
    private javax.swing.JTextField d_price;
    private javax.swing.JTextField d_price1;
    private javax.swing.JTextField d_price2;
    private javax.swing.JTextField d_quantity;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox p_id;
    private javax.swing.JComboBox s_id;
    // End of variables declaration//GEN-END:variables
}

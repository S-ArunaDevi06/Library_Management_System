/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package  com.mycompany.library_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abira
 */
public class employee_fines extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Creates new form fines
     */
    public employee_fines() {
        initComponents();
        
        try{
Class.forName("oracle.jdbc.OracleDriver");
//JOptionPane.showMessageDialog(this,"Driver Loaded!");
try {
con = DriverManager.getConnection("jdbc:oracle:thin:@ArunaDevi:1522:orcl","scott","anssggah");
//JOptionPane.showMessageDialog(this,"Connected to Oracle database!");
}
catch (SQLException ex) {
Logger.getLogger(employee_fines.class.getName()).log(Level.SEVERE,null, ex);
JOptionPane.showMessageDialog(this,ex.getMessage());
}
}
catch(ClassNotFoundException ex){
Logger.getLogger(employee_fines.class.getName()).log(Level.SEVERE,null, ex);
JOptionPane.showMessageDialog(this,ex.getMessage());

}
        fines_Load();
        
    }
    
    public void fines_Load()
    {
       try {
           int b;
           ps=con.prepareStatement("select * from fines");
           rs=ps.executeQuery();
           
           ResultSetMetaData rsd=rs.getMetaData();
           b=rsd.getColumnCount();
           DefaultTableModel d=(DefaultTableModel)fines_table.getModel();
           d.setRowCount(0);
           
           while(rs.next())
           {
               Vector v2 = new Vector();
               
               for(int i=1;i<=b;i++)
               {
                   v2.add(rs.getString("user_id"));
                   v2.add(rs.getString("book_id"));
                   v2.add(rs.getString("renewal_count"));
                   v2.add(rs.getString("due_amount"));
                   v2.add(rs.getString("paid_status"));
                   
               }
               d.addRow(v2);
           }
       } catch (SQLException ex) {
           Logger.getLogger(employee_fines.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fines_user_id = new javax.swing.JTextField();
        fines_book_id = new javax.swing.JTextField();
        fines_renewal_count = new javax.swing.JTextField();
        fines_due_amount = new javax.swing.JTextField();
        fines_paid_status = new javax.swing.JTextField();
        display = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fines_table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("FINES");

        jLabel2.setText("USER ID");

        jLabel3.setText("BOOK ID");

        jLabel4.setText("RENEWAL COUNT");

        jLabel5.setText("DUE AMOUNT");

        jLabel6.setText("PAID STATUS");

        display.setText("DISPLAY");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
            }
        });

        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        fines_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USER ID", "BOOK ID", "REN_COUNT", "DUE_AMT", "PAID_STATS"
            }
        ));
        jScrollPane1.setViewportView(fines_table);

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fines_paid_status, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fines_due_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fines_renewal_count, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fines_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(124, 124, 124)
                                        .addComponent(fines_user_id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(display)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1)
                                        .addGap(11, 11, 11)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exit)
                        .addGap(128, 128, 128)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(fines_user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addComponent(fines_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(fines_renewal_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(fines_due_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(fines_paid_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(display))
                            .addComponent(jButton1))
                        .addGap(26, 26, 26)
                        .addComponent(exit)
                        .addGap(33, 33, 33)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        MainForm m=new MainForm();
            this.hide();
            m.setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
        // TODO add your handling code here:
        fines_Load();
    }//GEN-LAST:event_displayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 int c;
        DefaultTableModel d1=(DefaultTableModel)fines_table.getModel();
        int selectIndex = fines_table.getSelectedRow();
        
        String user_id=fines_user_id.getText();
        try{
            ps=con.prepareStatement("select * from users where user_id=?");
            ps.setString(1, user_id);
            rs=ps.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)fines_table.getModel();
            d.setRowCount(0);
            
            while (rs.next())
            {
                Vector v2=new Vector();
                
                for (int i=0;i<=c;i++)
                {
                    v2.add(rs.getString("user_id"));
                    v2.add(rs.getString("book_id"));
                    v2.add(rs.getString("renewal_count"));
                    v2.add(rs.getString("due_amount"));
                    v2.add(rs.getString("paid_status"));
                }
                
                d.addRow(v2);
            }
            
        }
        catch(SQLException ex)
        {
             Logger.getLogger(User.class.getName()).log(Level.SEVERE,null, ex);
             JOptionPane.showMessageDialog(this,ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void fines_tableMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
    DefaultTableModel d = (DefaultTableModel) fines_table.getModel();
    int selectIndex = fines_table.getSelectedRow();

// Print the selected row index
System.out.println("Selected Row Index: " + selectIndex);

// Print all column names and values of the selected row for verification
for (int i = 0; i < d.getColumnCount(); i++) {
    System.out.println("Column " + i + " (" + d.getColumnName(i) + "): " + d.getValueAt(selectIndex, i));
}
// Fetch and set the text fields with the correct column indices
// Assuming your table columns are ordered as: ID, Name, Address, Stock
fines_user_id.setText(d.getValueAt(selectIndex, 0).toString());
fines_book_id.setText(d.getValueAt(selectIndex, 1).toString());
fines_renewal_count.setText(d.getValueAt(selectIndex, 2).toString());
fines_due_amount.setText(d.getValueAt(selectIndex, 3).toString());
fines_paid_status.setText(d.getValueAt(selectIndex, 4).toString());

    
    }
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
            java.util.logging.Logger.getLogger(employee_fines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee_fines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee_fines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee_fines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employee_fines().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton display;
    private javax.swing.JButton exit;
    private javax.swing.JTextField fines_book_id;
    private javax.swing.JTextField fines_due_amount;
    private javax.swing.JTextField fines_paid_status;
    private javax.swing.JTextField fines_renewal_count;
    private javax.swing.JTable fines_table;
    private javax.swing.JTextField fines_user_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

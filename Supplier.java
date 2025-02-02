/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.library_project;

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
 * @author aruna
 */
public class Supplier extends javax.swing.JFrame {

    /**
     * Creates new form Supplier
     */
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    
    public Supplier() {
        initComponents();
         try{
                Class.forName("oracle.jdbc.OracleDriver");
                //JOptionPane.showMessageDialog(this,"Driver Loaded!");
                try {
                       con = DriverManager.getConnection("jdbc:oracle:thin:@ArunaDevi:1522:orcl","scott","anssggah");
                        //JOptionPane.showMessageDialog(this,"Connected to Oracle database!");
                    }
                catch (SQLException ex) {
                        Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE,null, ex);
                        JOptionPane.showMessageDialog(this,ex.getMessage());
                    }
            }
            catch(ClassNotFoundException ex){
                    Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE,null, ex);
                    JOptionPane.showMessageDialog(this,ex.getMessage());
            }  
         display_supplier();
    }
    
    public void display_supplier()
    {
        int c;
        
        try{
            ps=con.prepareStatement("select * from supplier");
            rs=ps.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)supplier_table.getModel();
            d.setRowCount(0);
            
            while (rs.next())
            {
                Vector v2=new Vector();
                
                for (int i=0;i<=c;i++)
                {
                    v2.add(rs.getString("s_id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("phone"));
                    v2.add(rs.getString("mail"));
                }
                
                d.addRow(v2);
            }
            
        }
        catch(SQLException ex)
        {
             Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE,null, ex);
             JOptionPane.showMessageDialog(this,ex.getMessage());
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

        supplier_panel = new javax.swing.JPanel();
        supplier_si_id_label = new javax.swing.JLabel();
        supplier_s_id = new javax.swing.JTextField();
        supplier_name_label = new javax.swing.JLabel();
        supplier_name = new javax.swing.JTextField();
        supplier_phone_label = new javax.swing.JLabel();
        supplier_phone = new javax.swing.JTextField();
        supplier_mail_label = new javax.swing.JLabel();
        supplier_mail = new javax.swing.JTextField();
        supplier_update = new javax.swing.JButton();
        supplier_search = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        supplier_exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplier_table = new javax.swing.JTable();
        supplier_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        supplier_si_id_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplier_si_id_label.setText("S_id");

        supplier_name_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplier_name_label.setText("Name");

        supplier_phone_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplier_phone_label.setText("Phone");

        supplier_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_phoneActionPerformed(evt);
            }
        });

        supplier_mail_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplier_mail_label.setText("Mail");

        supplier_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_mailActionPerformed(evt);
            }
        });

        supplier_update.setText("UPDATE");
        supplier_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_updateActionPerformed(evt);
            }
        });

        supplier_search.setText("SEARCH");
        supplier_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_searchActionPerformed(evt);
            }
        });

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        supplier_exit.setText("EXIT");
        supplier_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout supplier_panelLayout = new javax.swing.GroupLayout(supplier_panel);
        supplier_panel.setLayout(supplier_panelLayout);
        supplier_panelLayout.setHorizontalGroup(
            supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplier_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(supplier_panelLayout.createSequentialGroup()
                        .addComponent(supplier_mail_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(supplier_mail, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addGroup(supplier_panelLayout.createSequentialGroup()
                        .addComponent(supplier_phone_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(supplier_phone))
                    .addGroup(supplier_panelLayout.createSequentialGroup()
                        .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplier_si_id_label, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplier_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supplier_s_id, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(supplier_name)))
                    .addGroup(supplier_panelLayout.createSequentialGroup()
                        .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clear)
                            .addComponent(supplier_update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplier_search)
                            .addComponent(supplier_exit))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        supplier_panelLayout.setVerticalGroup(
            supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplier_panelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplier_si_id_label)
                    .addComponent(supplier_s_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplier_name_label)
                    .addComponent(supplier_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplier_phone_label)
                    .addComponent(supplier_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplier_mail_label)
                    .addComponent(supplier_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplier_update)
                    .addComponent(supplier_search))
                .addGap(18, 18, 18)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear)
                    .addComponent(supplier_exit))
                .addContainerGap())
        );

        supplier_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_id", "name", "phone", "mail"
            }
        ));
        supplier_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplier_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supplier_table);

        supplier_label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        supplier_label.setText("    SUPPLIER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(supplier_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(supplier_label, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(supplier_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(supplier_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void supplier_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplier_phoneActionPerformed

    private void supplier_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplier_mailActionPerformed

    private void supplier_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplier_tableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel)supplier_table.getModel();
        int selectIndex = supplier_table.getSelectedRow();
        
        String S_id=d1.getValueAt(selectIndex,0).toString();
        supplier_s_id.setText(S_id);
        supplier_name.setText(d1.getValueAt(selectIndex,1).toString());
        supplier_phone.setText(d1.getValueAt(selectIndex,2).toString());
        supplier_mail.setText(d1.getValueAt(selectIndex,3).toString());
    }//GEN-LAST:event_supplier_tableMouseClicked

    private void supplier_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_updateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel)supplier_table.getModel();
        int selectIndex = supplier_table.getSelectedRow();
        
        String S_id=d1.getValueAt(selectIndex,0).toString();
        try {
            // TODO add your handling code here:
            String sql="update supplier set name=?,phone=?,mail=? where s_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(4,supplier_s_id.getText());
            ps.setString(1,supplier_name.getText());
            ps.setString(2,supplier_phone.getText());
            ps.setString(3,supplier_mail.getText());
            ps.execute();
            JOptionPane.showMessageDialog(this,"UPDATED!");
            display_supplier();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }//GEN-LAST:event_supplier_updateActionPerformed

    private void supplier_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_searchActionPerformed
        // TODO add your handling code here:
        int c;
        DefaultTableModel d1=(DefaultTableModel)supplier_table.getModel();
        int selectIndex = supplier_table.getSelectedRow();
        
        String S_id=supplier_s_id.getText();
        try{
            ps=con.prepareStatement("select * from supplier where s_id=?");
            ps.setString(1, S_id);
            rs=ps.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)supplier_table.getModel();
            d.setRowCount(0);
            
            while (rs.next())
            {
                Vector v2=new Vector();
                
                for (int i=0;i<=c;i++)
                {
                    v2.add(rs.getString("s_id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("phone"));
                    v2.add(rs.getString("mail"));
                }
                
                d.addRow(v2);
            }
            
        }
        catch(SQLException ex)
        {
             Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE,null, ex);
             JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }//GEN-LAST:event_supplier_searchActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        supplier_s_id.setText("");
        supplier_name.setText("");
        supplier_phone.setText("");
        supplier_mail.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void supplier_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_exitActionPerformed
        // TODO add your handling code here:
        MainForm m=new MainForm();
            this.hide();
            m.setVisible(true);
    }//GEN-LAST:event_supplier_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton supplier_exit;
    private javax.swing.JLabel supplier_label;
    private javax.swing.JTextField supplier_mail;
    private javax.swing.JLabel supplier_mail_label;
    private javax.swing.JTextField supplier_name;
    private javax.swing.JLabel supplier_name_label;
    private javax.swing.JPanel supplier_panel;
    private javax.swing.JTextField supplier_phone;
    private javax.swing.JLabel supplier_phone_label;
    private javax.swing.JTextField supplier_s_id;
    private javax.swing.JButton supplier_search;
    private javax.swing.JLabel supplier_si_id_label;
    private javax.swing.JTable supplier_table;
    private javax.swing.JButton supplier_update;
    // End of variables declaration//GEN-END:variables
}

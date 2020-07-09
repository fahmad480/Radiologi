/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.CardLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author 48faraaz
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
    }
    
    public MainGUI(String roles) {
        initComponents();
        
        lblRoles.setText(roles);
    }
    
    public MainGUI(String roles, String username) {
        initComponents();
        
        lblRoles.setText(roles);
        lblUsername.setText(username);
        lblUsername.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnDokter = new javax.swing.JButton();
        btnSuster = new javax.swing.JButton();
        btnStaff = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        lblRoles = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        pnlDokter = new javax.swing.JPanel();
        btnFormRadiologi = new javax.swing.JButton();
        pnlSuster = new javax.swing.JPanel();
        btnFormTambahpasien = new javax.swing.JButton();
        pnlStaff = new javax.swing.JPanel();
        btnFormMaintenance = new javax.swing.JButton();
        btnFormReport = new javax.swing.JButton();
        btnFormInventory = new javax.swing.JButton();
        pnlSupplier = new javax.swing.JPanel();
        btnFormInventoryRess = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/user-md.png"))); // NOI18N
        btnDokter.setText("Dokter");
        btnDokter.setFocusable(false);
        btnDokter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDokter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDokterActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDokter);

        btnSuster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/user-o.png"))); // NOI18N
        btnSuster.setText("Suster");
        btnSuster.setFocusable(false);
        btnSuster.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSuster.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSuster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSusterActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSuster);

        btnStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/user.png"))); // NOI18N
        btnStaff.setText("Staff");
        btnStaff.setFocusable(false);
        btnStaff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStaff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffActionPerformed(evt);
            }
        });
        jToolBar1.add(btnStaff);

        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/user-plus.png"))); // NOI18N
        btnSupplier.setText("Supplier");
        btnSupplier.setFocusable(false);
        btnSupplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplier.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSupplier);

        mainPanel.setLayout(new java.awt.CardLayout());

        lblRoles.setText("jLabel1");
        mainPanel.add(lblRoles, "card6");

        lblUsername.setText("jLabel1");
        mainPanel.add(lblUsername, "card6");

        pnlDokter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFormRadiologi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/medkit.png"))); // NOI18N
        btnFormRadiologi.setText("Form Radiologi");
        btnFormRadiologi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormRadiologiActionPerformed(evt);
            }
        });
        pnlDokter.add(btnFormRadiologi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        mainPanel.add(pnlDokter, "cardDokter");

        pnlSuster.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFormTambahpasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/user-circle-o.png"))); // NOI18N
        btnFormTambahpasien.setText("Tambah Pasien");
        btnFormTambahpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormTambahpasienActionPerformed(evt);
            }
        });
        pnlSuster.add(btnFormTambahpasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        mainPanel.add(pnlSuster, "cardSuster");

        pnlStaff.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFormMaintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/gears.png"))); // NOI18N
        btnFormMaintenance.setText("Maintenance");
        btnFormMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormMaintenanceActionPerformed(evt);
            }
        });
        pnlStaff.add(btnFormMaintenance, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnFormReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/files-o.png"))); // NOI18N
        btnFormReport.setText("Print Radiologi Report");
        btnFormReport.setToolTipText("");
        btnFormReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormReportActionPerformed(evt);
            }
        });
        pnlStaff.add(btnFormReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        btnFormInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/inbox.png"))); // NOI18N
        btnFormInventory.setText("Manage Inventory");
        btnFormInventory.setToolTipText("");
        btnFormInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormInventoryActionPerformed(evt);
            }
        });
        pnlStaff.add(btnFormInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        mainPanel.add(pnlStaff, "cardStaff");

        pnlSupplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFormInventoryRess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/inbox.png"))); // NOI18N
        btnFormInventoryRess.setText("Manage Inventory");
        btnFormInventoryRess.setToolTipText("");
        btnFormInventoryRess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormInventoryRessActionPerformed(evt);
            }
        });
        pnlSupplier.add(btnFormInventoryRess, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        mainPanel.add(pnlSupplier, "cardSupplier");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDokterActionPerformed
        if(lblRoles.getText() == "dokter") {
            cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "cardDokter");
        } else {
            JOptionPane.showMessageDialog(this, "Kamu tidak bisa masuk ke menu ini", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDokterActionPerformed

    private void btnSusterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSusterActionPerformed
        if(lblRoles.getText() == "suster") {
            cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "cardSuster");
        } else {
            JOptionPane.showMessageDialog(this, "Kamu tidak bisa masuk ke menu ini", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSusterActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        if(lblRoles.getText() == "staff") {
            cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "cardStaff");
        } else {
            JOptionPane.showMessageDialog(this, "Kamu tidak bisa masuk ke menu ini", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierActionPerformed
        if(lblRoles.getText() == "supplier") {
            cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "cardSupplier");
        } else {
            JOptionPane.showMessageDialog(this, "Kamu tidak bisa masuk ke menu ini", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSupplierActionPerformed

    private void btnFormRadiologiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormRadiologiActionPerformed
        new RadiologiGUI().setVisible(true);
    }//GEN-LAST:event_btnFormRadiologiActionPerformed

    private void btnFormTambahpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormTambahpasienActionPerformed
        new AddPasienGUI("suster", lblUsername.getText()).setVisible(true);
    }//GEN-LAST:event_btnFormTambahpasienActionPerformed

    private void btnFormMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormMaintenanceActionPerformed
        new MTGUI().setVisible(true);
    }//GEN-LAST:event_btnFormMaintenanceActionPerformed

    private void btnFormReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormReportActionPerformed
        new ReportGUI().setVisible(true);
    }//GEN-LAST:event_btnFormReportActionPerformed

    private void btnFormInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormInventoryActionPerformed
        new InventoryGUI("staff", lblUsername.getText()).setVisible(true);
    }//GEN-LAST:event_btnFormInventoryActionPerformed

    private void btnFormInventoryRessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormInventoryRessActionPerformed
        new InventoryGUI("supplier", lblUsername.getText()).setVisible(true);
    }//GEN-LAST:event_btnFormInventoryRessActionPerformed

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
    
    private CardLayout cl;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDokter;
    private javax.swing.JButton btnFormInventory;
    private javax.swing.JButton btnFormInventoryRess;
    private javax.swing.JButton btnFormMaintenance;
    private javax.swing.JButton btnFormRadiologi;
    private javax.swing.JButton btnFormReport;
    private javax.swing.JButton btnFormTambahpasien;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnSuster;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblRoles;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pnlDokter;
    private javax.swing.JPanel pnlStaff;
    private javax.swing.JPanel pnlSupplier;
    private javax.swing.JPanel pnlSuster;
    // End of variables declaration//GEN-END:variables
}

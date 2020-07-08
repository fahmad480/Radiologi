/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Converter.ConvertPasienToObject;
import Entity.Pasien;
import Entity.Suster;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 48faraaz
 */
public class AddPasienGUI extends javax.swing.JFrame {
    public String suster = "";

    /**
     * Creates new form GuiRadiologiTambahPasien
     */
    public AddPasienGUI() {
        initComponents();
        setDataPasien();
    }
    
    public AddPasienGUI(String ktpSuster) {
        initComponents();
        setDataPasien();
        suster = ktpSuster;
    }
    
    private void setDataPasien() {
        ConvertPasienToObject cpto = new ConvertPasienToObject();
        String[][] dataPasien = cpto.getPasien();
        tblPasien.setModel(new javax.swing.table.DefaultTableModel(
                dataPasien,
            new String [] {
                "ktp", "nama", "alamat", "hp", "tempat lahir", "tanggal lahir", "kelamin"
            }
        ));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kelaminGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edtNamaPasien = new javax.swing.JTextField();
        edtTPasien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtAlamatPasien = new javax.swing.JTextArea();
        edtHpPasien = new javax.swing.JTextField();
        edtKtpPasien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edtTLPasien = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPasien = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        rP = new javax.swing.JRadioButton();
        rL = new javax.swing.JRadioButton();
        btnTambah = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nama Pasien");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel2.setText("Tempat, Tanggal Lahir");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel3.setText("Alamat");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel4.setText("Nomor HP");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel5.setText("Kelamin");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        edtNamaPasien.setName("EdtNama"); // NOI18N
        getContentPane().add(edtNamaPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 481, -1));

        edtTPasien.setName("EdtTTL"); // NOI18N
        getContentPane().add(edtTPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 339, -1));

        edtAlamatPasien.setColumns(20);
        edtAlamatPasien.setRows(5);
        edtAlamatPasien.setName("EdtAlamat"); // NOI18N
        jScrollPane1.setViewportView(edtAlamatPasien);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 481, 64));

        edtHpPasien.setName("EdtHp"); // NOI18N
        getContentPane().add(edtHpPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 481, -1));

        edtKtpPasien.setName("EdtKtp"); // NOI18N
        getContentPane().add(edtKtpPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 481, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tambah Pasien Baru");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        edtTLPasien.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(edtTLPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 135, -1));

        tblPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ktp", "nama", "alamat", "hp", "tempat lahir", "tanggal lahir", "kelamin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPasienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPasien);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 48, 660, 230));

        jLabel7.setText("Nomor KTP");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        kelaminGroup.add(rP);
        rP.setText("Wanita");
        getContentPane().add(rP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, -1, -1));

        kelaminGroup.add(rL);
        rL.setSelected(true);
        rL.setText("Laki Laki");
        getContentPane().add(rL, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, -1));

        btnTambah.setText("Tambah");
        btnTambah.setName("BtnTambah"); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.setName("BtnTambah"); // NOI18N
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, -1, -1));

        btnDelete.setText("Delete");
        btnDelete.setName("BtnTambah"); // NOI18N
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPasienMouseClicked
        int row = tblPasien.getSelectedRow();
        //"ktp", "nama", "alamat", "hp", "tempat lahir", "tanggal lahir"
        String ktp = tblPasien.getValueAt(row, 0).toString();
        String nama = tblPasien.getValueAt(row, 1).toString();
        String alamat = tblPasien.getValueAt(row, 2).toString();
        String hp = tblPasien.getValueAt(row, 3).toString();
        String tmp_lahir = tblPasien.getValueAt(row, 4).toString();
        String tgl_lahir = tblPasien.getValueAt(row, 5).toString();
        String kelamin = tblPasien.getValueAt(row, 6).toString();
        
        edtNamaPasien.setText(nama);
        edtTPasien.setText(tmp_lahir);
        
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        try {
            Date date = ft.parse(tgl_lahir);
            edtTLPasien.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        edtKtpPasien.setText(ktp);
        edtHpPasien.setText(hp);
        edtAlamatPasien.setText(alamat);
        if(kelamin.equals("l")) {
            rL.setSelected(true);
        } else {
            rP.setSelected(true);
        }
    }//GEN-LAST:event_tblPasienMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String nama = edtNamaPasien.getText();
        String tmp_lahir = edtTPasien.getText();
        Date tgl_lahir = edtTLPasien.getDate();
        String ktp = edtKtpPasien.getText();
        String hp = edtHpPasien.getText();
        String alamat = edtAlamatPasien.getText();
        String kelamin = "";
        if(rL.isSelected()) {
            kelamin = "l";
        } else {
            kelamin = "w";
        }
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        
        Exec.ExecuteSuster eSuster = new Exec.ExecuteSuster();
        Suster IdSuster = eSuster.getRow(suster);
        
        Pasien pasien = new Pasien(ktp, nama, alamat, hp, kelamin, tmp_lahir, ft.format(tgl_lahir), IdSuster);
        Exec.ExecutePasien ePs = new Exec.ExecutePasien();
        //int result = ePs.
    }//GEN-LAST:event_btnTambahActionPerformed

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
            java.util.logging.Logger.getLogger(AddPasienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPasienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPasienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPasienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPasienGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextArea edtAlamatPasien;
    private javax.swing.JTextField edtHpPasien;
    private javax.swing.JTextField edtKtpPasien;
    private javax.swing.JTextField edtNamaPasien;
    private com.toedter.calendar.JDateChooser edtTLPasien;
    private javax.swing.JTextField edtTPasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup kelaminGroup;
    private javax.swing.JRadioButton rL;
    private javax.swing.JRadioButton rP;
    private javax.swing.JTable tblPasien;
    // End of variables declaration//GEN-END:variables
}

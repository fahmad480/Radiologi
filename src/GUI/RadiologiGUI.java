/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Connection.ConnectionManager;
import Converter.ConvertInventoryRadiologiToObject;
import Converter.ConvertPasienToObject;
import Converter.ConvertScanRadiologiToObject;
import Entity.Dokter;
import Entity.Inventory;
import Entity.Pasien;
import Entity.Radiologi;
import Entity.Scan;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 48faraaz
 */
public class RadiologiGUI extends javax.swing.JFrame {

    /**
     * Creates new form GuiRadiologi
     */
    public RadiologiGUI() {
        initComponents();
        getPasienListToComboBox();
        getDokterListToComboBox();
        getPemeriksaanListToComboBox();
        getFilmListToComboBox();
        getRadiologiListToComboBox();
    }
    
    private void getPasienListToComboBox() {
        String query = "select ktp from pasien";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            boxPasianMain.addItem("");
            while(rs.next()) {
                boxPasianMain.addItem(rs.getString("ktp"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getDokterListToComboBox() {
        String query = "select ktp from dokter";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            boxDokterMain.addItem("");
            while(rs.next()) {
                boxDokterMain.addItem(rs.getString("ktp"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getPemeriksaanListToComboBox() {
        String query = "select id from scan";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                edtKodePemeriksaan.addItem(rs.getString("id"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getFilmListToComboBox() {
        String query = "select id from inventory WHERE jenis='barang'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                edtKodeFilm.addItem(rs.getString("id"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getRadiologiListToComboBox() {
        String query = "select id from radiologi";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            edtNoBuktiMain.removeItem("baru");
            edtNoBuktiMain.addItem("baru");
            while(rs.next()) {
                edtNoBuktiMain.removeItem(rs.getString("id"));
                edtNoBuktiMain.addItem(rs.getString("id"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setDataPemeriksaan(String idRadiologi) {
        ConvertScanRadiologiToObject csrto = new ConvertScanRadiologiToObject();
        String[][] dataScan = csrto.getScan(idRadiologi);
        tablePemeriksaanMain.setModel(new javax.swing.table.DefaultTableModel(
            dataScan,
            new String [] {
                "Kode", "kode scan", "Nama", "Tarif"
            }
        ));
    }
    
    private void setDataFilm(String idRadiologi) {
        ConvertInventoryRadiologiToObject cirto = new ConvertInventoryRadiologiToObject();
        String[][] dataFilm = cirto.getInventoryradiologiAktif(idRadiologi);
        tableFilmMain.setModel(new javax.swing.table.DefaultTableModel(
            dataFilm,
            new String [] {
                "Kode", "Kode film", "Nama", "Satuan", "Kuantitas"
            }
        ));
    }
    
    private void hitungHargaDanLembar(String idRadiologi) {
        int harga = 0;
        int lembar = 0;
        String query = "SELECT a.id, a.id_inventory, a.kuantitas, b.harga, (a.kuantitas * b.harga) AS total FROM inventoryradiologi a INNER JOIN inventory b ON a.id_inventory = b.id WHERE a.id_radiologi='"+idRadiologi+"'";
        ConnectionManager conMan = new ConnectionManager();
        java.sql.Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                lembar += rs.getInt("kuantitas");
                harga += rs.getInt("total");
            }
        } catch (SQLException ex) {
            
        }
        
        String query2 = "SELECT a.id, a.id_scan, b.harga FROM scanradiologi a INNER JOIN scan b ON a.id_scan = b.id WHERE a.id_radiologi='"+idRadiologi+"'";
        try {
            Statement stms = conn.createStatement();
            ResultSet rss = stms.executeQuery(query2);
            while(rss.next()) {
                harga += rss.getInt("harga");
            }
        } catch (SQLException ex) {
            
        }
        
        edtBiayaMain.setText(String.valueOf(harga));
        edtTotalMain.setText(String.valueOf(lembar));
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
        edtTotalMain = new javax.swing.JTextField();
        edtNoBuktiMain = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boxPasianMain = new javax.swing.JComboBox();
        boxDokterMain = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePemeriksaanMain = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFilmMain = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        edtBiayaMain = new javax.swing.JTextField();
        btnSimpanMain = new javax.swing.JButton();
        btnTutupMain = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        edtCatatanMain = new javax.swing.JTextArea();
        edtTanggal = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        pnlPemeriksaan1 = new javax.swing.JPanel();
        btnDeleteFilm = new javax.swing.JButton();
        btnTambahFilm = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        edtNamaFilm = new javax.swing.JTextField();
        edtKodeFilm = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        edtHargaFilm = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        edtQtyFilm = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        pnlPemeriksaan = new javax.swing.JPanel();
        btnDeletePemeriksaan = new javax.swing.JButton();
        btnTambahPemeriksaan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        edtKodePemeriksaan = new javax.swing.JComboBox();
        edtNamaPemeriksaan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        edtTarifPemeriksaan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnBaruRadiologi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tanggal");

        jLabel2.setText("No. Bukti");

        edtTotalMain.setEnabled(false);
        edtTotalMain.setName("EdtBukti"); // NOI18N

        edtNoBuktiMain.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                edtNoBuktiMainItemStateChanged(evt);
            }
        });

        jLabel4.setText("Pasien");

        jLabel5.setText("Pemeriksa");

        boxPasianMain.setName("ComboPasien"); // NOI18N

        boxDokterMain.setName("ComboPemeriksa"); // NOI18N

        jLabel6.setText("Pemeriksaan");

        tablePemeriksaanMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode", "kode scan", "Nama", "Tarif"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePemeriksaanMain.setName("TblPemeriksaan"); // NOI18N
        tablePemeriksaanMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePemeriksaanMainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePemeriksaanMain);

        jLabel7.setText("Film Radiologi");

        tableFilmMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode", "kode film", "Nama", "Satuan", "Kuantitas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFilmMain.setName("TblRadiologi"); // NOI18N
        tableFilmMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFilmMainMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableFilmMain);

        jLabel8.setText("Total Film");

        jLabel9.setText("Biaya");

        jLabel10.setText("lembar");

        edtBiayaMain.setEnabled(false);
        edtBiayaMain.setName("EdtBukti"); // NOI18N

        btnSimpanMain.setText("Simpan");
        btnSimpanMain.setName("BtnSimpan"); // NOI18N
        btnSimpanMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanMainActionPerformed(evt);
            }
        });

        btnTutupMain.setText("Reset");
        btnTutupMain.setName("BtnTutup"); // NOI18N
        btnTutupMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupMainActionPerformed(evt);
            }
        });

        jLabel11.setText("Catatan Dokter");

        edtCatatanMain.setColumns(20);
        edtCatatanMain.setRows(5);
        jScrollPane3.setViewportView(edtCatatanMain);

        edtTanggal.setDateFormatString("yyyy-MM-dd");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Radiologi Rs. Kasih Sayang Wibu");

        pnlPemeriksaan1.setBorder(javax.swing.BorderFactory.createTitledBorder("Jenis Film Radiologi"));
        pnlPemeriksaan1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteFilm.setText("Delete");
        btnDeleteFilm.setName("BtnSimpan"); // NOI18N
        btnDeleteFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFilmActionPerformed(evt);
            }
        });
        pnlPemeriksaan1.add(btnDeleteFilm, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        btnTambahFilm.setText("Tambah");
        btnTambahFilm.setName("BtnSimpan"); // NOI18N
        btnTambahFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahFilmActionPerformed(evt);
            }
        });
        pnlPemeriksaan1.add(btnTambahFilm, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        jLabel15.setText("Kode");
        pnlPemeriksaan1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        edtNamaFilm.setEnabled(false);
        pnlPemeriksaan1.add(edtNamaFilm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, -1));

        edtKodeFilm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                edtKodeFilmItemStateChanged(evt);
            }
        });
        pnlPemeriksaan1.add(edtKodeFilm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 230, -1));

        jLabel16.setText("Nama");
        pnlPemeriksaan1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        edtHargaFilm.setEnabled(false);
        pnlPemeriksaan1.add(edtHargaFilm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 230, -1));

        jLabel17.setText("Harga/pc");
        pnlPemeriksaan1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        pnlPemeriksaan1.add(edtQtyFilm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 230, -1));

        jLabel18.setText("Qty");
        pnlPemeriksaan1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        pnlPemeriksaan.setBorder(javax.swing.BorderFactory.createTitledBorder("Jenis Pemeriksaan"));
        pnlPemeriksaan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeletePemeriksaan.setText("Delete");
        btnDeletePemeriksaan.setName("BtnSimpan"); // NOI18N
        btnDeletePemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePemeriksaanActionPerformed(evt);
            }
        });
        pnlPemeriksaan.add(btnDeletePemeriksaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        btnTambahPemeriksaan.setText("Tambah");
        btnTambahPemeriksaan.setName("BtnSimpan"); // NOI18N
        btnTambahPemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPemeriksaanActionPerformed(evt);
            }
        });
        pnlPemeriksaan.add(btnTambahPemeriksaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jLabel3.setText("Kode");
        pnlPemeriksaan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        edtKodePemeriksaan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                edtKodePemeriksaanItemStateChanged(evt);
            }
        });
        pnlPemeriksaan.add(edtKodePemeriksaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 230, -1));

        edtNamaPemeriksaan.setEnabled(false);
        pnlPemeriksaan.add(edtNamaPemeriksaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, -1));

        jLabel12.setText("Nama");
        pnlPemeriksaan.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        edtTarifPemeriksaan.setEnabled(false);
        pnlPemeriksaan.add(edtTarifPemeriksaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 230, -1));

        jLabel14.setText("Tarif");
        pnlPemeriksaan.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        btnBaruRadiologi.setText("Baru");
        btnBaruRadiologi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruRadiologiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel13))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(edtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(boxPasianMain, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(edtNoBuktiMain, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnBaruRadiologi)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addGap(11, 11, 11)
                        .addComponent(boxDokterMain, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(pnlPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(245, 245, 245)
                        .addComponent(jLabel8)
                        .addGap(13, 13, 13)
                        .addComponent(edtTotalMain, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(40, 40, 40)
                                .addComponent(edtBiayaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpanMain)
                                .addGap(15, 15, 15)
                                .addComponent(btnTutupMain)))))
                .addGap(7, 7, 7)
                .addComponent(pnlPemeriksaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(edtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(boxPasianMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(edtNoBuktiMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBaruRadiologi)
                            .addComponent(jLabel5)
                            .addComponent(boxDokterMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pnlPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(edtTotalMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(edtBiayaMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSimpanMain)
                                    .addComponent(btnTutupMain)))))
                    .addComponent(pnlPemeriksaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtKodePemeriksaanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_edtKodePemeriksaanItemStateChanged
        Exec.ExecuteScan eS = new Exec.ExecuteScan();
        Scan sc = eS.getRow(String.valueOf(edtKodePemeriksaan.getModel().getSelectedItem()));
        edtNamaPemeriksaan.setText(sc.getNama());
        edtTarifPemeriksaan.setText(String.valueOf(sc.getHarga()));
    }//GEN-LAST:event_edtKodePemeriksaanItemStateChanged

    private void edtKodeFilmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_edtKodeFilmItemStateChanged
        Exec.ExecuteInventory eInv = new Exec.ExecuteInventory();
        Inventory inv = eInv.getRow(String.valueOf(edtKodeFilm.getModel().getSelectedItem()));
        edtNamaFilm.setText(inv.getNama());
        edtHargaFilm.setText(String.valueOf(inv.getHarga()));
    }//GEN-LAST:event_edtKodeFilmItemStateChanged

    private void edtNoBuktiMainItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_edtNoBuktiMainItemStateChanged
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        
        if(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()).equals("baru")) {
            btnBaruRadiologi.setEnabled(true);
            btnBaruRadiologi.setText("Tambah");
            Date date = new Date();
            edtTanggal.setDate(date);
            boxPasianMain.setSelectedItem("");
            boxDokterMain.setSelectedItem("");
            
            btnTambahPemeriksaan.setEnabled(false);
            btnDeletePemeriksaan.setEnabled(false);
            btnTambahFilm.setEnabled(false);
            btnDeleteFilm.setEnabled(false);
        } else {
            btnBaruRadiologi.setEnabled(true);
            btnBaruRadiologi.setText("baru");
            Exec.ExecuteRadiologi eRad = new Exec.ExecuteRadiologi();
            Radiologi radiologi = eRad.getRow(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
            
            boxPasianMain.setSelectedItem(radiologi.getPasien().getKtp());
            boxDokterMain.setSelectedItem(radiologi.getDokter().getKtp());
            edtCatatanMain.setText(String.valueOf(radiologi.getKeterangan()));
            
            try {
                Date date = ft.parse(radiologi.getDate());
                edtTanggal.setDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            setDataPemeriksaan(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
            setDataFilm(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
            hitungHargaDanLembar(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
            
            btnTambahPemeriksaan.setEnabled(true);
            btnDeletePemeriksaan.setEnabled(true);
            btnTambahFilm.setEnabled(true);
            btnDeleteFilm.setEnabled(true);
        }
    }//GEN-LAST:event_edtNoBuktiMainItemStateChanged

    private void btnBaruRadiologiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruRadiologiActionPerformed
        if(btnBaruRadiologi.getText().equals("baru")) {
            edtNoBuktiMain.setSelectedItem("baru");
        } else if(btnBaruRadiologi.getText().equals("Tambah")) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Apakah kamu yakin ingin membuat tindakan radiologi baru?","Tambah Radiologi Baru", dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                if(String.valueOf(boxPasianMain.getModel().getSelectedItem()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Pilih terlebih dahulu pasiennya!", "Gagal", JOptionPane.ERROR_MESSAGE);
                } else {
                    if(String.valueOf(boxDokterMain.getModel().getSelectedItem()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Pilih terlebih dahulu dokter yang akan memeriksanya!", "Gagal", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //add new radiologi
                        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                        
                        String pasien = String.valueOf(boxPasianMain.getModel().getSelectedItem());
                        
                        Exec.ExecutePasien ePas = new Exec.ExecutePasien();
                        Pasien pas = ePas.getRow(pasien);
                        
                        String dokter = String.valueOf(boxDokterMain.getModel().getSelectedItem());
                        
                        Exec.ExecuteDokter eDok = new Exec.ExecuteDokter();
                        Dokter dok = eDok.getRow(dokter);
                        
                        String date = ft.format(edtTanggal.getDate());
                        String keterangan = edtCatatanMain.getText();
                        
                        Radiologi rad = new Radiologi(pas, dok, date, keterangan);
                        
                        Exec.ExecuteRadiologi eRad = new Exec.ExecuteRadiologi();
                        int result = eRad.insertRadiologi(rad);
                        if(result == 1) {
                            JOptionPane.showMessageDialog(this, "Tambah radiologi baru berhasil, silahkan ubah no bukti ke paling terbaru", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                            getRadiologiListToComboBox();
                        } else {
                            JOptionPane.showMessageDialog(this, "Tambah radiologi baru gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
            
    }//GEN-LAST:event_btnBaruRadiologiActionPerformed

    private void btnTambahPemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPemeriksaanActionPerformed
        String id_scan = String.valueOf(edtKodePemeriksaan.getModel().getSelectedItem());
        String id_radiologi = String.valueOf(edtNoBuktiMain.getModel().getSelectedItem());
        
        Exec.ExecuteScan eScan = new Exec.ExecuteScan();
        int result = eScan.insertScanRadiologi(id_scan, id_radiologi);
        if(result == 1) {
            JOptionPane.showMessageDialog(this, "Tambah scan radiologi berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            setDataPemeriksaan(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
            hitungHargaDanLembar(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
        } else {
            JOptionPane.showMessageDialog(this, "Tambah scan radiologi gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahPemeriksaanActionPerformed

    private void tablePemeriksaanMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePemeriksaanMainMouseClicked
        int row = tablePemeriksaanMain.getSelectedRow();
        String id = tablePemeriksaanMain.getValueAt(row, 0).toString();
        String id_scan = tablePemeriksaanMain.getValueAt(row, 1).toString();
        
        edtKodePemeriksaan.setSelectedItem(id_scan);
    }//GEN-LAST:event_tablePemeriksaanMainMouseClicked

    private void btnDeletePemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePemeriksaanActionPerformed
        int row = tablePemeriksaanMain.getSelectedRow();
        String id = tablePemeriksaanMain.getValueAt(row, 0).toString();
        
        Exec.ExecuteScan eScan = new Exec.ExecuteScan();
        int result = eScan.deleteScanRadiologi(id);
        if(result == 1) {
            JOptionPane.showMessageDialog(this, "Hapus scan radiologi berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            setDataPemeriksaan(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
            hitungHargaDanLembar(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
        } else {
            JOptionPane.showMessageDialog(this, "Hapus scan radiologi gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletePemeriksaanActionPerformed

    private void btnTambahFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahFilmActionPerformed
        String idInv = String.valueOf(edtKodeFilm.getModel().getSelectedItem());
        String id_radiologi = String.valueOf(edtNoBuktiMain.getModel().getSelectedItem());
        String qty = edtQtyFilm.getText();
        
        Exec.ExecuteInventory eInv = new Exec.ExecuteInventory();
        int result = eInv.insertInventoryRadiologi(idInv, id_radiologi, qty);
        if(result == 1) {
            JOptionPane.showMessageDialog(this, "Tambah film radiologi berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            setDataFilm(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
            hitungHargaDanLembar(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
        } else {
            JOptionPane.showMessageDialog(this, "Tambah film radiologi gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahFilmActionPerformed

    private void btnDeleteFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFilmActionPerformed
        int row = tableFilmMain.getSelectedRow();
        String id = tableFilmMain.getValueAt(row, 0).toString();
        String id_inv = tableFilmMain.getValueAt(row, 1).toString();
        String qty = tableFilmMain.getValueAt(row, 4).toString();
        
        Exec.ExecuteInventory eInv = new Exec.ExecuteInventory();
        int result = eInv.deleteInventoryRadiologi(id);
        if(result == 1) {
            JOptionPane.showMessageDialog(this, "Hapus film radiologi berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            setDataFilm(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
            hitungHargaDanLembar(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
        } else {
            JOptionPane.showMessageDialog(this, "Hapus film radiologi gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteFilmActionPerformed

    private void tableFilmMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFilmMainMouseClicked
        int row = tableFilmMain.getSelectedRow();
        String id = tableFilmMain.getValueAt(row, 0).toString();
        String id_inv = tableFilmMain.getValueAt(row, 1).toString();
        String qty = tableFilmMain.getValueAt(row, 4).toString();
        
        edtKodeFilm.setSelectedItem(id_inv);
        edtQtyFilm.setText(qty);
    }//GEN-LAST:event_tableFilmMainMouseClicked

    private void btnTutupMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupMainActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Apakah kamu yakin ingin reset data radiologi ini?","Reset Radiologi", dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION) {
                Exec.ExecuteRadiologi eRad = new Exec.ExecuteRadiologi();
                int delete = eRad.deleteRadiologi(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
                if(delete == 1) {
                    JOptionPane.showMessageDialog(this, "Reset radiologi berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                    setDataFilm(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
                    setDataPemeriksaan(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
                    hitungHargaDanLembar(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
                    edtNoBuktiMain.removeItem(String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
                    getRadiologiListToComboBox();
                } else {
                    JOptionPane.showMessageDialog(this, "Reset radiologi gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
            }
    }//GEN-LAST:event_btnTutupMainActionPerformed

    private void btnSimpanMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanMainActionPerformed
        String keterangan = edtCatatanMain.getText();
        
        Exec.ExecuteRadiologi eRad = new Exec.ExecuteRadiologi();
        int update = eRad.updateKeteranganRadiologi(keterangan, String.valueOf(edtNoBuktiMain.getModel().getSelectedItem()));
        if(update == 1) {
            JOptionPane.showMessageDialog(this, "Radiologi berhasil diupdate/disimpan", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Radiologi gagal diupdate/disimpan", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanMainActionPerformed

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
            java.util.logging.Logger.getLogger(RadiologiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RadiologiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RadiologiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RadiologiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RadiologiGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxDokterMain;
    private javax.swing.JComboBox boxPasianMain;
    private javax.swing.JButton btnBaruRadiologi;
    private javax.swing.JButton btnDeleteFilm;
    private javax.swing.JButton btnDeletePemeriksaan;
    private javax.swing.JButton btnSimpanMain;
    private javax.swing.JButton btnTambahFilm;
    private javax.swing.JButton btnTambahPemeriksaan;
    private javax.swing.JButton btnTutupMain;
    private javax.swing.JTextField edtBiayaMain;
    private javax.swing.JTextArea edtCatatanMain;
    private javax.swing.JTextField edtHargaFilm;
    private javax.swing.JComboBox edtKodeFilm;
    private javax.swing.JComboBox edtKodePemeriksaan;
    private javax.swing.JTextField edtNamaFilm;
    private javax.swing.JTextField edtNamaPemeriksaan;
    private javax.swing.JComboBox edtNoBuktiMain;
    private javax.swing.JTextField edtQtyFilm;
    private com.toedter.calendar.JDateChooser edtTanggal;
    private javax.swing.JTextField edtTarifPemeriksaan;
    private javax.swing.JTextField edtTotalMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlPemeriksaan;
    private javax.swing.JPanel pnlPemeriksaan1;
    private javax.swing.JTable tableFilmMain;
    private javax.swing.JTable tablePemeriksaanMain;
    // End of variables declaration//GEN-END:variables
}

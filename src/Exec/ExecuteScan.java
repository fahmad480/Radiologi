/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Radiologi;
import Entity.Scan;
import Entity.Scan;
import Entity.Scanradiologi;
import Entity.Staff;
import Entity.Supplier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 48faraaz
 */
public class ExecuteScan {
    public List<Scan> getAllScan() {
        List<Scan> listM = new ArrayList<>();
        String query = "SELECT * FROM scan";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Scan mL = new Scan();
                mL.setId(rs.getString("id"));
                mL.setNama(rs.getString("nama"));
                mL.setHarga(rs.getInt("harga"));
                listM.add(mL);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteScan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listM;
    }
    
    public List<Scanradiologi> getAllScanradiologi(String id) {
        List<Scanradiologi> listM = new ArrayList<>();
        String query = "SELECT * FROM scanradiologi WHERE id_radiologi='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Scanradiologi mL = new Scanradiologi();
                mL.setId(rs.getString("id"));
                
                Exec.ExecuteRadiologi eRad = new Exec.ExecuteRadiologi();
                Radiologi rad = eRad.getRow(rs.getString("id_radiologi"));
                
                Exec.ExecuteScan eScan = new Exec.ExecuteScan();
                Scan scan = eScan.getRow(rs.getString("id_scan"));
                
                mL.setRadiologi(rad);
                mL.setScan(scan);
                
                listM.add(mL);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteScan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listM;
    }
    
    public int insertScanRadiologi(String scan, String radiologi) {
        int hasil = 0;
        String query = "INSERT INTO scanradiologi(id_scan, id_radiologi) VALUES('"+scan+"','"+radiologi+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteScan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteScanRadiologi(String kode) {
        int hasil = 0;
        String query = "DELETE FROM scanradiologi WHERE id='"+kode+"'";
        System.out.println(query);
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteScan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public Scan getRow(String id) {
        Scan scan = new Scan();
        String query = "SELECT * FROM scan WHERE id='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                scan.setId(rs.getString("id"));
                scan.setNama(rs.getString("nama"));
                scan.setHarga(rs.getInt("harga"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return scan;
    }
}

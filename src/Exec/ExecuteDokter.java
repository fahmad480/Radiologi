/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Dokter;
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
public class ExecuteDokter {
    public List<Dokter> getAllDokter() {
        List<Dokter> listS = new ArrayList<>();
        String query = "SELECT * FROM dokter";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Dokter s = new Dokter();
                s.setKtp(rs.getString("ktp"));
                s.setNama(rs.getString("nama"));
                s.setAlamat(rs.getString("alamat"));
                s.setHp(rs.getString("hp"));
                s.setKelamin(rs.getString("kelamin"));
                listS.add(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listS;
    }
    
    public int insertDokter(Dokter ps) {
        int hasil = 0;
        String query = "INSERT INTO dokter(ktp, password, nama, alamat, hp, kelamin) VALUES('"+ps.getKtp()+"', '"+ps.getKtp()+"', '"+ps.getNama()+"', '"+ps.getAlamat()+"', '"+ps.getHp()+"', '"+ps.getKelamin()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteDokter(String id) {
        int hasil = 0;
        String query = "DELETE FROM dokter WHERE ktp='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updateDokter(Dokter ps) {
        int hasil = 0;
        String query = "UPDATE dokter SET ktp='"+ps.getKtp()+"', nama='"+ps.getNama()+"', alamat='"+ps.getAlamat()+"', hp='"+ps.getHp()+"', kelamin='"+ps.getKelamin()+"' WHERE ktp='"+ps.getKtp()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public Dokter getRow(String ktp) {
        Dokter dokter = new Dokter();
        String query = "SELECT * FROM dokter WHERE ktp='"+ktp+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                dokter.setKtp(rs.getString("ktp"));
                dokter.setNama(rs.getString("nama"));
                dokter.setHp(rs.getString("hp"));
                dokter.setAlamat(rs.getString("alamat"));
                dokter.setKelamin(rs.getString("kelamin"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return dokter;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Dokter;
import Entity.Pasien;
import Entity.Radiologi;
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
public class ExecuteRadiologi {
    public List<Radiologi> getAllPs() {
        List<Radiologi> listPs = new ArrayList<>();
        String query = "SELECT * FROM radiologi";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Radiologi ps = new Radiologi();
                ps.setId(rs.getString("id"));
                
                Exec.ExecutePasien ePas = new Exec.ExecutePasien();
                Pasien pasien = ePas.getRow(rs.getString("id_pasien"));
                
                Exec.ExecuteDokter eDok = new Exec.ExecuteDokter();
                Dokter dokter = eDok.getRow(rs.getString("id_dokter"));
                
                ps.setPasien(pasien);
                ps.setDokter(dokter);
                ps.setDate(rs.getString("date"));
                listPs.add(ps);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRadiologi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listPs;
    }
    
    public int insertRadiologi(Radiologi ps) {
        int hasil = 0;
        String query = "INSERT INTO radiologi(id_pasien, id_dokter, date, keterangan) VALUES('"+ps.getPasien().getKtp()+"','"+ps.getDokter().getKtp()+"','"+ps.getDate()+"','"+ps.getKeterangan()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRadiologi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteRadiologi(String id) {
        int hasil = 0;
        String query = "DELETE FROM radiologi WHERE id='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRadiologi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updateRadiologi(Radiologi ps) {
        int hasil = 0;
        String query = "UPDATE radiologi SET id_pasien='"+ps.getPasien().getKtp()+"', id_dokter='"+ps.getDokter().getKtp()+"', keterangan='"+ps.getKeterangan()+"' WHERE id='"+ps.getId()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRadiologi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public Radiologi getRow(String id) {
        Radiologi radiologi = new Radiologi();
        String query = "SELECT * FROM radiologi WHERE id='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                radiologi.setId(rs.getString("id"));
                
                Exec.ExecutePasien ePas = new Exec.ExecutePasien();
                Pasien pasien = ePas.getRow(rs.getString("id_pasien"));
                
                Exec.ExecuteDokter eDok = new Exec.ExecuteDokter();
                Dokter dokter = eDok.getRow(rs.getString("id_dokter"));
                
                radiologi.setPasien(pasien);
                radiologi.setDokter(dokter);
                radiologi.setDate(rs.getString("date"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return radiologi;
    }
}

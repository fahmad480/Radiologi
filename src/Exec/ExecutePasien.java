/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Pasien;
import Entity.Suster;
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
public class ExecutePasien {
    public List<Pasien> getAllPs() {
        List<Pasien> listPs = new ArrayList<>();
        String query = "SELECT * FROM pasien";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Pasien ps = new Pasien();
                ps.setKtp(rs.getString("ktp"));
                ps.setNama(rs.getString("nama"));
                ps.setAlamat(rs.getString("alamat"));
                ps.setHp(rs.getString("hp"));
                ps.setKelamin(rs.getString("kelamin"));
                ps.setTmpLahir(rs.getString("tmp_lahir"));
                ps.setTglLahir(rs.getString("tgl_lahir"));
                
                Exec.ExecuteSuster eSuster = new Exec.ExecuteSuster();
                Suster suster = eSuster.getRow(rs.getString("id_suster"));
                
                ps.setSuster(suster);
                listPs.add(ps);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listPs;
    }
    
    public int insertPasien(Pasien ps) {
        int hasil = 0;
        String query = "INSERT INTO pasien(ktp, nama, alamat, hp, kelamin, tmp_lahir, tgl_lahir, id_suster) VALUES('"+ps.getKtp()+"', '"+ps.getNama()+"', '"+ps.getAlamat()+"', '"+ps.getHp()+"', '"+ps.getKelamin()+"', '"+ps.getTmpLahir()+"', '"+ps.getTglLahir()+"', '"+ps.getSuster().getKtp()+"')";
        System.out.println(query);
        System.out.println(ps.getSuster().toString());
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deletePasien(String id) {
        int hasil = 0;
        String query = "DELETE FROM pasien WHERE ktp='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updatePasien(Pasien ps) {
        int hasil = 0;
        String query = "UPDATE pasien SET ktp='"+ps.getKtp()+"', nama='"+ps.getNama()+"', alamat='"+ps.getAlamat()+"', hp='"+ps.getHp()+"', kelamin='"+ps.getKelamin()+"', tmp_lahir='"+ps.getTmpLahir()+"', tgl_lahir='"+ps.getTglLahir()+"', id_suster='"+ps.getSuster().getKtp()+"' WHERE ktp='"+ps.getKtp()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public Pasien getRow(String ktp) {
        Pasien pasien = new Pasien();
        String query = "SELECT * FROM pasien WHERE ktp='"+ktp+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                pasien.setKtp(rs.getString("ktp"));
                pasien.setNama(rs.getString("nama"));
                pasien.setHp(rs.getString("hp"));
                pasien.setAlamat(rs.getString("alamat"));
                pasien.setKelamin(rs.getString("kelamin"));
                
                Exec.ExecuteSuster eSus = new Exec.ExecuteSuster();
                Suster sus = eSus.getRow(rs.getString("id_suster"));
                pasien.setSuster(sus);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return pasien;
    }
}

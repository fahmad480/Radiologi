/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Suster;
import Entity.Suster;
import static java.lang.Integer.parseInt;
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
public class ExecuteSuster {
    public List<Suster> getAllSuster() {
        List<Suster> listS = new ArrayList<>();
        String query = "SELECT * FROM suster";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Suster s = new Suster();
                s.setKtp(rs.getString("ktp"));
                s.setNama(rs.getString("nama"));
                s.setAlamat(rs.getString("alamat"));
                s.setHp(rs.getString("hp"));
                s.setKelamin(rs.getString("kelamin"));
                listS.add(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSuster.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listS;
    }
    
    public int insertSuster(Suster ps) {
        int hasil = 0;
        String query = "INSERT INTO suster(ktp, password, nama, alamat, hp, kelamin) VALUES('"+ps.getKtp()+"', '"+ps.getKtp()+"', '"+ps.getNama()+"', '"+ps.getAlamat()+"', '"+ps.getHp()+"', '"+ps.getKelamin()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSuster.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteSuster(String id) {
        int hasil = 0;
        String query = "DELETE FROM suster WHERE ktp='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSuster.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updateSuster(Suster ps) {
        int hasil = 0;
        String query = "UPDATE suster SET ktp='"+ps.getKtp()+"', nama='"+ps.getNama()+"', alamat='"+ps.getAlamat()+"', hp='"+ps.getHp()+"', kelamin='"+ps.getKelamin()+"' WHERE ktp='"+ps.getKtp()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSuster.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public Suster getRow(String ktp) {
        Suster suster = new Suster();
        String query = "SELECT * FROM suster WHERE ktp='"+ktp+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                suster.setKtp(rs.getString("ktp"));
                suster.setNama(rs.getString("nama"));
                suster.setHp(rs.getString("hp"));
                suster.setAlamat(rs.getString("alamat"));
                suster.setKelamin(rs.getString("kelamin"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return suster;
    }
}

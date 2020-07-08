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
}

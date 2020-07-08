/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Suster;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 48faraaz
 */
public class ExecuteSuster {
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

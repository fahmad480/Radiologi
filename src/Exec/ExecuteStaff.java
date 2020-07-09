/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Staff;
import Entity.Suster;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 48faraaz
 */
public class ExecuteStaff {
    public Staff getRow(String ktp) {
        Staff staff = new Staff();
        String query = "SELECT * FROM staff WHERE ktp='"+ktp+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                staff.setKtp(rs.getString("ktp"));
                staff.setNama(rs.getString("nama"));
                staff.setHp(rs.getString("hp"));
                staff.setAlamat(rs.getString("alamat"));
                staff.setKelamin(rs.getString("kelamin"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return staff;
    }
}

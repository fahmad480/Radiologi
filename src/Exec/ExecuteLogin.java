/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 48faraaz
 */
public class ExecuteLogin {
    public int login(String ktp, String password, String roles) {
        int hasil = 0;
        String query;
        if(roles == "dokter") {
            query = "SELECT * FROM dokter WHERE ktp='"+ktp+"' AND password='"+password+"'";
        } else if(roles == "suster") {
            query = "SELECT * FROM suster WHERE ktp='"+ktp+"' AND password='"+password+"'";
        } else if(roles == "staff") {
            query = "SELECT * FROM staff WHERE ktp='"+ktp+"' AND password='"+password+"'";
        } else {
            query = "SELECT * FROM supplier WHERE ktp='"+ktp+"' AND password='"+password+"'";
        }
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                if(rs.getString("ktp").equals(ktp)) {
                    hasil = 1;
                } else {
                    hasil = 0;
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
}

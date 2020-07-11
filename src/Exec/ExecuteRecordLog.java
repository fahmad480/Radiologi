/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Recordlog;
import Entity.Staff;
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
public class ExecuteRecordLog {
    public List<Recordlog> getAllRecord() {
        List<Recordlog> listM = new ArrayList<>();
        String query = "SELECT * FROM record_log";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Recordlog mL = new Recordlog();
                mL.setId(rs.getString("id"));
                mL.setKeterangan(rs.getString("keterangan"));
                
                Exec.ExecuteStaff eStaff = new Exec.ExecuteStaff();
                Staff staff = eStaff.getRow(rs.getString("id_staff"));
                mL.setStaff(staff);
                
                mL.setDate(String.valueOf(rs.getDate("date")));
                listM.add(mL);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRecordLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listM;
    }
}

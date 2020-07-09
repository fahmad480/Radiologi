/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Maintenancelog;
import Entity.Pasien;
import Entity.Staff;
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
public class ExecuteMaintenance {
    public List<Maintenancelog> getAllM() {
        List<Maintenancelog> listM = new ArrayList<>();
        String query = "SELECT * FROM maintenance_log";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Maintenancelog mL = new Maintenancelog();
                mL.setId(rs.getString("id"));
                mL.setKeterangan(rs.getString("keterangan"));
                
                Exec.ExecuteStaff eStaff = new Exec.ExecuteStaff();
                Staff staff = eStaff.getRow(rs.getString("id_staff"));
                mL.setStaff(staff);
                
                mL.setDate(rs.getString("date"));
                listM.add(mL);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listM;
    }
    
    public int insertMaintenance(Maintenancelog m) {
        int hasil = 0;
        String query = "INSERT INTO maintenance_log(keterangan, id_staff, date) VALUES('"+m.getKeterangan()+"', '"+m.getStaff().getKtp()+"', '"+m.getDate()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteMaintenance(String id) {
        int hasil = 0;
        String query = "DELETE FROM maintenance_log WHERE id='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updateMaintenance(Maintenancelog m) {
        int hasil = 0;
        Exec.ExecuteStaff eStaff = new Exec.ExecuteStaff();
        Staff staff = eStaff.getRow(m.getStaff().getKtp());
        String query = "UPDATE maintenance_log SET keterangan='"+m.getKeterangan()+"', id_staff='"+staff.getKtp()+"', date='"+m.getDate()+"' WHERE id='"+m.getId()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
}

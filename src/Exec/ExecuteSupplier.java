/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Supplier;
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
public class ExecuteSupplier {
    public List<Supplier> getAllSupplier() {
        List<Supplier> listS = new ArrayList<>();
        String query = "SELECT * FROM supplier";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Supplier s = new Supplier();
                s.setId(rs.getString("ktp"));
                s.setNama(rs.getString("nama"));
                listS.add(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listS;
    }
    
    public int insertSupplier(Supplier ps) {
        int hasil = 0;
        String query = "INSERT INTO supplier(ktp, password, nama) VALUES('"+ps.getId()+"', '"+ps.getId()+"', '"+ps.getNama()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteSupplier(String id) {
        int hasil = 0;
        String query = "DELETE FROM supplier WHERE ktp='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updateSupplier(Supplier ps) {
        int hasil = 0;
        String query = "UPDATE supplier SET ktp='"+ps.getId()+"', nama='"+ps.getNama()+"' WHERE ktp='"+ps.getId()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public Supplier getRow(String id) {
        Supplier supplier = new Supplier();
        String query = "SELECT * FROM supplier WHERE ktp='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                supplier.setId(rs.getString("ktp"));
                supplier.setNama(rs.getString("nama"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return supplier;
    }
}

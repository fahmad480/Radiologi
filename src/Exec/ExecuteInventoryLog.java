/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Inventory;
import Entity.Inventorylog;
import Entity.Staff;
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
public class ExecuteInventoryLog {
    public List<Inventorylog> getAllInv(String supplier) {
        List<Inventorylog> listInv = new ArrayList<>();
        String query = "";
        if(supplier.equals("")) {
            query = "SELECT * FROM Inventory_log WHERE status='pending' or status='ditolak'";
        } else {
            query = "SELECT * FROM Inventory_log WHERE id_supplier='"+supplier+"' AND status='pending' or status='ditolak'";
        }
        System.out.println(query);
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Inventorylog inv = new Inventorylog();
                inv.setId(rs.getString("id"));
                inv.setInventory(rs.getString("nama_inv"));
                inv.setKeterangan(rs.getString("keterangan"));
                inv.setStatus(rs.getString("status"));
                
                Exec.ExecuteSupplier eSupp = new Exec.ExecuteSupplier();
                Supplier supp = eSupp.getRow(rs.getString("id_supplier"));
                
                Exec.ExecuteStaff eStaff = new Exec.ExecuteStaff();
                Staff staff = eStaff.getRow(rs.getString("id_staff"));
                
                inv.setSupplier(supp);
                inv.setStaff(staff);
                listInv.add(inv);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteInventoryLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listInv;
    }
    
    public int insertInventoryPending(Inventorylog inv) {
        int hasil = 0;
        String query = "INSERT INTO inventory_log(id_staff, nama_inv, id_supplier, keterangan, status) VALUES('"+inv.getStaff().getKtp()+"','"+inv.getInventory()+"','"+inv.getSupplier().getId()+"','"+inv.getKeterangan()+"','"+inv.getStatus()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteInventoryLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteInventoryPending(String id) {
        int hasil = 0;
        String query = "DELETE FROM inventory_log WHERE id='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteInventoryLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updateInventoryPending(Inventorylog inv) {
        int hasil = 0;
        String query = "UPDATE inventory_log SET id_staff='"+inv.getStaff().getKtp()+"', nama_inv='"+inv.getInventory()+"', id_supplier='"+inv.getSupplier().getId()+"', keterangan='"+inv.getKeterangan()+"', status='"+inv.getStatus()+"'  WHERE id='"+inv.getId()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteInventoryLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
}

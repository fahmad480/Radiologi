/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Inventory;
import Entity.Inventory;
import Entity.Inventory;
import Entity.Inventory;
import Entity.Supplier;
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
 * @author IdeaPad
 */
public class ExecuteInventory {
    public List<Inventory> getAllInv() {
        List<Inventory> listInv = new ArrayList<>();
        String query = "SELECT * FROM inventory";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Inventory inv = new Inventory();
                inv.setId(rs.getString("id"));
                inv.setNama(rs.getString("nama"));
                inv.setJenis(rs.getString("jenis"));
                inv.setKuantitas(rs.getInt("kuantitas"));
                inv.setHarga(rs.getInt("harga"));
                Exec.ExecuteSupplier eSupp = new Exec.ExecuteSupplier();
                Supplier supp = eSupp.getRow(rs.getString("id_supplier"));
                
                inv.setSupplier(supp);
                listInv.add(inv);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listInv;
    }
    
    public int insertInventory(Inventory inv) {
        int hasil = 0;
        String query = "INSERT INTO inventory(id, nama, jenis, kuantitas, id_supplier, harga) VALUES('"+inv.getId()+"','"+inv.getNama()+"','"+inv.getJenis()+"','"+String.valueOf(inv.getKuantitas())+"','"+inv.getSupplier().getId()+"','"+inv.getHarga()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteInventory(String id) {
        int hasil = 0;
        String query = "DELETE FROM inventory WHERE id='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updateInventory(Inventory inv) {
        int hasil = 0;
        String query = "UPDATE inventory SET id='"+inv.getId()+"', harga='"+inv.getHarga()+"', nama='"+inv.getNama()+"', jenis='"+inv.getJenis()+"', kuantitas='"+inv.getKuantitas()+"', id_supplier='"+inv.getSupplier().getId()+"' WHERE id='"+inv.getId()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public Inventory getRow(String id) {
        Inventory inventory = new Inventory();
        String query = "SELECT * FROM inventory WHERE id='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                inventory.setId(rs.getString("id"));
                inventory.setNama(rs.getString("nama"));
                inventory.setJenis(rs.getString("jenis"));
                inventory.setKuantitas(rs.getInt("kuantitas"));
                inventory.setHarga(rs.getInt("harga"));
                
                Exec.ExecuteSupplier eSupp = new Exec.ExecuteSupplier();
                Supplier supp = eSupp.getRow(rs.getString("id_supplier"));
                inventory.setSupplier(supp);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return inventory;
    }
}

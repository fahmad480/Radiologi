/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Inventory;
import java.sql.Connection;
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
  public List<Inventory> getInventory(){
   List<Inventory>listInventory = new ArrayList<>();
    String query="select * from inventory";
    ConnectionManager conMan = new ConnectionManager();
    Connection conn = conMan.LogOn();
    try{
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while(rs.next()){
        Inventory inv = new Inventory();
        inv.setId(rs.getString("id"));//database
        inv.setNama(rs.getString("nama")); //database
        inv.setJenis(rs.getString("jenis"));//database
        inv.setKuantitas(rs.getString("kuantitas"));//database
        inv.setSupplier(rs.getString("supplier"));//database
        
        listInventory.add(inv);
        
        }
    }catch(SQLException ex){
        Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE,null,ex);
    }
    conMan.LogOff();
    return listInventory;
  }
  public int insertInventory(Inventory inv){
      int hsail = 0;
      String query = "Insert into inventory(id,nama,jenis,kuantitas,supllier)"
              +"value("+inv.getId()+",'"+
              inv.getNama()+"','"+inv.getJenis()+"','"+inv.getKuantitas()+"','"+
              inv.getSupplier()+"')";
      ConnectionManager conMan = new ConnectionManager();
      Connection conn = conMan.LogOn();
      try{
          Statement stm = conn.createStatement();
          hasil = stm.executeUpdate(query);
      }catch (SQLException ex){
          Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE,null,ex);
      }
      conMan.LogOff();
      return hasil;
      }
  public int deleteInventory(String delid_inventory){
      int hasil = 0;
      String query = "delete from inventory where id='"+delid_inventory+"'";
      ConnectionManager conMan = new ConnectionManager();
      Connection conn = conMan.LogOn();
      try{
          Statement stm = conn.createStatement();
          hasil = stm.executeUpdate(query);
      }catch (SQLException){
          Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE,null,ex);
      }
      conMan.LogOff();
      return hasil;
  }
  public int updateInventory(Inventory newinv){
      int hasil = 0;
      String query="update inventory set nama='"+newinv.getNama()+"',jenis='"+newinv.getJenis()"',kuantitas='"+
                newinv.getKuantitas()+"',supplier='"+newinv.getSupplier()+"'where id='"newinv.getId()+"'";
      ConnectionManager conMan = new ConnectionManager();
      Connection conn = conMan.LogOn();
      try{
          Statement stm = conn.createStatement();
          hasil = stm.executeUpdate(query);
      }catch (SQLException ex){
          Logger.getLogger(ExecuteInventory.class.getName()).log(Level.SEVERE,null,ex);
      }
      conMan.LogOff();
      return hasil;
    
  }   
}

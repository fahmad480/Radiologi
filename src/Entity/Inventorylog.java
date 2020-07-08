/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author 48faraaz
 */
public class Inventorylog {
    private String id;
    private Staff staff;
    private Inventory inventory;
    private String keterangan;

    public Inventorylog() {
    }

    public Inventorylog(String id, Staff staff, Inventory inventory, String keterangan) {
        this.id = id;
        this.staff = staff;
        this.inventory = inventory;
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "Inventorylog{" + "id=" + id + ", staff=" + staff + ", inventory=" + inventory + ", keterangan=" + keterangan + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
}

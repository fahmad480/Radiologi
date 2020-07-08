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
    private Supplier supplier;
    private String keterangan;
    private String status;

    public Inventorylog() {
    }

    public Inventorylog(String id, Staff staff, Inventory inventory, Supplier supplier, String keterangan, String status) {
        this.id = id;
        this.staff = staff;
        this.inventory = inventory;
        this.supplier = supplier;
        this.keterangan = keterangan;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Inventorylog{" + "id=" + id + ", staff=" + staff + ", inventory=" + inventory + ", supplier=" + supplier + ", keterangan=" + keterangan + ", status=" + status + '}';
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

            
}

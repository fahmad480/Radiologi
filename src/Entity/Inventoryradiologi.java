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
public class Inventoryradiologi {
    private String id;
    private Inventory inventory;
    private Radiologi radiologi;
    private int kuantitas;

    public Inventoryradiologi() {
    }

    public Inventoryradiologi(String id, Inventory inventory, Radiologi radiologi, int kuantitas) {
        this.id = id;
        this.inventory = inventory;
        this.radiologi = radiologi;
        this.kuantitas = kuantitas;
    }

    @Override
    public String toString() {
        return "Inventoryradiologi{" + "id=" + id + ", inventory=" + inventory + ", radiologi=" + radiologi + ", kuantitas=" + kuantitas + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Radiologi getRadiologi() {
        return radiologi;
    }

    public void setRadiologi(Radiologi radiologi) {
        this.radiologi = radiologi;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }
    
    
}

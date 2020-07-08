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
public class Inventory {
    private String id;
    private String nama;
    private String jenis;
    private String kuantitas;
    private Supplier supplier;

    public Inventory() {
    }

    public Inventory(String id, String nama, String jenis, String kuantitas, Supplier supplier) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.kuantitas = kuantitas;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", nama=" + nama + ", jenis=" + jenis + ", kuantitas=" + kuantitas + ", supplier=" + supplier + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(String kuantitas) {
        this.kuantitas = kuantitas;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    
}

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
    private int kuantitas;
    private int harga;
    private Supplier supplier;

    public Inventory() {
    }    

    public Inventory(String id, String nama, String jenis, int kuantitas, int harga, Supplier supplier) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.kuantitas = kuantitas;
        this.harga = harga;
        this.supplier = supplier;
    }

    public Inventory(String nama, String jenis, int kuantitas, int harga, Supplier supplier) {
        this.nama = nama;
        this.jenis = jenis;
        this.kuantitas = kuantitas;
        this.harga = harga;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", nama=" + nama + ", jenis=" + jenis + ", kuantitas=" + kuantitas + ", harga=" + harga + ", supplier=" + supplier + '}';
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

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

        
}

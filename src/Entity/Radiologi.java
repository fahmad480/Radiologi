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
public class Radiologi {
    private String id;
    private Pasien pasien;
    private Dokter dokter;
    private Scanradiologi scanradiologi;
    private Inventoryradiologi inventoryradiologi;
    private String date;
    private String keterangan;

    public Radiologi() {
    }

    public Radiologi(String id, Pasien pasien, Dokter dokter, Scanradiologi scanradiologi, Inventoryradiologi inventoryradiologi, String date, String keterangan) {
        this.id = id;
        this.pasien = pasien;
        this.dokter = dokter;
        this.scanradiologi = scanradiologi;
        this.inventoryradiologi = inventoryradiologi;
        this.date = date;
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "Radiologi{" + "id=" + id + ", pasien=" + pasien + ", dokter=" + dokter + ", scanradiologi=" + scanradiologi + ", inventoryradiologi=" + inventoryradiologi + ", date=" + date + ", keterangan=" + keterangan + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Scanradiologi getScanradiologi() {
        return scanradiologi;
    }

    public void setScanradiologi(Scanradiologi scanradiologi) {
        this.scanradiologi = scanradiologi;
    }

    public Inventoryradiologi getInventoryradiologi() {
        return inventoryradiologi;
    }

    public void setInventoryradiologi(Inventoryradiologi inventoryradiologi) {
        this.inventoryradiologi = inventoryradiologi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
}

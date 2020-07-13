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
    private String date;
    private String keterangan;

    public Radiologi() {
    }

    public Radiologi(String id, Pasien pasien, Dokter dokter, String date, String keterangan) {
        this.id = id;
        this.pasien = pasien;
        this.dokter = dokter;
        this.date = date;
        this.keterangan = keterangan;
    }

    public Radiologi(Pasien pasien, Dokter dokter, String date, String keterangan) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.date = date;
        this.keterangan = keterangan;
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

    @Override
    public String toString() {
        return "Radiologi{" + "id=" + id + ", pasien=" + pasien + ", dokter=" + dokter + ", date=" + date + ", keterangan=" + keterangan + '}';
    }    
}

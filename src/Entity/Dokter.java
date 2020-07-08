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
public class Dokter {
    private String ktp;
    private String nama;
    private String alamat;
    private String hp;
    private String kelamin;

    public Dokter() {
    }

    public Dokter(String ktp, String nama, String alamat, String hp, String kelamin) {
        this.ktp = ktp;
        this.nama = nama;
        this.alamat = alamat;
        this.hp = hp;
        this.kelamin = kelamin;
    }

    @Override
    public String toString() {
        return "Dokter{" + "ktp=" + ktp + ", nama=" + nama + ", alamat=" + alamat + ", hp=" + hp + ", kelamin=" + kelamin + '}';
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }
    
    
}

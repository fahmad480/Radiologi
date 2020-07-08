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
public class Pasien {
    private String ktp;
    private String nama;
    private String alamat;
    private String hp;
    private String kelamin;
    private String tmpLahir;
    private String tglLahir;
    private Suster suster;

    public Pasien() {
    }

    public Pasien(String ktp, String nama, String alamat, String hp, String kelamin, String tmpLahir, String tglLahir, Suster suster) {
        this.ktp = ktp;
        this.nama = nama;
        this.alamat = alamat;
        this.hp = hp;
        this.kelamin = kelamin;
        this.tmpLahir = tmpLahir;
        this.tglLahir = tglLahir;
        this.suster = suster;
    }

    @Override
    public String toString() {
        return "Pasien{" + "ktp=" + ktp + ", nama=" + nama + ", alamat=" + alamat + ", hp=" + hp + ", kelamin=" + kelamin + ", tmpLahir=" + tmpLahir + ", tglLahir=" + tglLahir + ", suster=" + suster + '}';
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

    public String getTmpLahir() {
        return tmpLahir;
    }

    public void setTmpLahir(String tmpLahir) {
        this.tmpLahir = tmpLahir;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Suster getSuster() {
        return suster;
    }

    public void setSuster(Suster suster) {
        this.suster = suster;
    }

    
}

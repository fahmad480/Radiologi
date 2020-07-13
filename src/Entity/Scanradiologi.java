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
public class Scanradiologi {
    private String id;
    private Scan scan;
    private Radiologi radiologi;

    public Scanradiologi() {
    }

    public Scanradiologi(String id, Scan scan, Radiologi radiologi) {
        this.id = id;
        this.scan = scan;
        this.radiologi = radiologi;
    }

    @Override
    public String toString() {
        return "Scanradiologi{" + "id=" + id + ", scan=" + scan + ", radiologi=" + radiologi + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }

    public Radiologi getRadiologi() {
        return radiologi;
    }

    public void setRadiologi(Radiologi radiologi) {
        this.radiologi = radiologi;
    }
}

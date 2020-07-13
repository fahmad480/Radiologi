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
public class Recordlog {
    private String id;
    private Staff staff;
    private String date;

    public Recordlog(String id, Staff staff, String date) {
        this.id = id;
        this.staff = staff;
        this.date = date;
    }

    public Recordlog() {
    }

    @Override
    public String toString() {
        return "Recordlog{" + "id=" + id + ", staff=" + staff + ", date=" + date + '}';
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}

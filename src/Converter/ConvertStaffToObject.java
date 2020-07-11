/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Staff;
import Exec.ExecuteStaff;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertStaffToObject {
    public String[][] getStaff() {
        List<Staff> myPs = new ArrayList<Staff>();
        ExecuteStaff ePs = new ExecuteStaff();
        myPs = ePs.getAllStaff();
        String[][] dataStaff = new String[myPs.size()][5];
        int i=0;
        for(Staff ps : myPs) {
            dataStaff[i][0] = ps.getKtp();
            dataStaff[i][1] = ps.getNama();
            dataStaff[i][2] = ps.getAlamat();
            dataStaff[i][3] = ps.getHp();
            dataStaff[i][4] = ps.getKelamin();
            i++;
        }
        return dataStaff;
    }
}

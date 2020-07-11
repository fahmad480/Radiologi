/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Suster;
import Exec.ExecuteSuster;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertSusterToObject {
    public String[][] getSuster() {
        List<Suster> myPs = new ArrayList<Suster>();
        ExecuteSuster ePs = new ExecuteSuster();
        myPs = ePs.getAllSuster();
        String[][] dataSuster = new String[myPs.size()][5];
        int i=0;
        for(Suster ps : myPs) {
            dataSuster[i][0] = ps.getKtp();
            dataSuster[i][1] = ps.getNama();
            dataSuster[i][2] = ps.getAlamat();
            dataSuster[i][3] = ps.getHp();
            dataSuster[i][4] = ps.getKelamin();
            i++;
        }
        return dataSuster;
    }
}

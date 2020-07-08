/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Pasien;
import Exec.ExecutePasien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertPasienToObject {
    public String[][] getPasien() {
        List<Pasien> myPs = new ArrayList<Pasien>();
        ExecutePasien ePs = new ExecutePasien();
        myPs = ePs.getAllPs();
        String[][] dataPasien = new String[myPs.size()][7];
        int i=0;
        for(Pasien ps : myPs) {
            dataPasien[i][0] = ps.getKtp();
            dataPasien[i][1] = ps.getNama();
            dataPasien[i][2] = ps.getAlamat();
            dataPasien[i][3] = ps.getHp();
            dataPasien[i][4] = ps.getTmpLahir();
            dataPasien[i][5] = ps.getTglLahir();
            dataPasien[i][6] = ps.getKelamin();
            i++;
        }
        return dataPasien;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Dokter;
import Exec.ExecuteDokter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertDokterToObject {
    public String[][] getDokter() {
        List<Dokter> myPs = new ArrayList<Dokter>();
        ExecuteDokter ePs = new ExecuteDokter();
        myPs = ePs.getAllDokter();
        String[][] dataDokter = new String[myPs.size()][5];
        int i=0;
        for(Dokter ps : myPs) {
            dataDokter[i][0] = ps.getKtp();
            dataDokter[i][1] = ps.getNama();
            dataDokter[i][2] = ps.getAlamat();
            dataDokter[i][3] = ps.getHp();
            dataDokter[i][4] = ps.getKelamin();
            i++;
        }
        return dataDokter;
    }
}

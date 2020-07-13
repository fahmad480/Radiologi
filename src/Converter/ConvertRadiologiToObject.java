/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Radiologi;
import Exec.ExecuteRadiologi;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertRadiologiToObject {
    public String[][] getRadiologi() {
        List<Radiologi> rad = new ArrayList<Radiologi>();
        ExecuteRadiologi eRad = new ExecuteRadiologi();
        rad = eRad.getAllRadiologi();
        String[][] dataRecord = new String[rad.size()][4];
        int i=0;
        for(Radiologi rd : rad) {
            dataRecord[i][0] = rd.getId();
            dataRecord[i][1] = rd.getPasien().getNama();
            dataRecord[i][2] = rd.getDokter().getNama();
            dataRecord[i][3] = rd.getDate();
            i++;
        }
        return dataRecord;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Scanradiologi;
import Exec.ExecuteScan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertScanRadiologiToObject {
    public String[][] getScan(String id) {
        List<Scanradiologi> mM = new ArrayList<Scanradiologi>();
        ExecuteScan eM = new ExecuteScan();
        mM = eM.getAllScanradiologi(id);
        String[][] dataScan = new String[mM.size()][4];
        int i=0;
        for(Scanradiologi ps : mM) {
            dataScan[i][0] = ps.getId();
            dataScan[i][1] = String.valueOf(ps.getScan().getId());
            dataScan[i][2] = String.valueOf(ps.getScan().getNama());
            dataScan[i][3] = String.valueOf(ps.getScan().getHarga());
            i++;
        }
        return dataScan;
    }
}

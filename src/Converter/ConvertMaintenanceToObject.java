/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Maintenancelog;
import Exec.ExecuteMaintenance;
import Exec.ExecutePasien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertMaintenanceToObject {
    public String[][] getMaintenance() {
        List<Maintenancelog> mM = new ArrayList<Maintenancelog>();
        ExecuteMaintenance eM = new ExecuteMaintenance();
        mM = eM.getAllM();
        String[][] dataPasien = new String[mM.size()][4];
        int i=0;
        for(Maintenancelog ps : mM) {
            dataPasien[i][0] = ps.getId();
            dataPasien[i][1] = ps.getKeterangan();
            dataPasien[i][2] = ps.getStaff().getKtp();
            dataPasien[i][3] = ps.getDate();
            i++;
        }
        return dataPasien;
    }
}

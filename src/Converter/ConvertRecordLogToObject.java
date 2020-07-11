/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Recordlog;
import Exec.ExecuteRecordLog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertRecordLogToObject {
    public String[][] getRecord() {
        List<Recordlog> mM = new ArrayList<Recordlog>();
        ExecuteRecordLog eM = new ExecuteRecordLog();
        mM = eM.getAllRecord();
        String[][] dataRecord = new String[mM.size()][3];
        int i=0;
        for(Recordlog ps : mM) {
            dataRecord[i][0] = ps.getId();
            dataRecord[i][1] = ps.getDate();
            dataRecord[i][2] = ps.getStaff().getKtp();
            i++;
        }
        return dataRecord;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Supplier;
import Exec.ExecuteSupplier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertSupplierToObject {
    public String[][] getSupplier() {
        List<Supplier> myPs = new ArrayList<Supplier>();
        ExecuteSupplier ePs = new ExecuteSupplier();
        myPs = ePs.getAllSupplier();
        String[][] dataSupplier = new String[myPs.size()][2];
        int i=0;
        for(Supplier ps : myPs) {
            dataSupplier[i][0] = ps.getId();
            dataSupplier[i][1] = ps.getNama();
            i++;
        }
        return dataSupplier;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Inventorylog;
import Exec.ExecuteInventoryLog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertInventoryLogToObject {
    public String[][] getInventoryPending(String supplier) {
        List<Inventorylog> myInv = new ArrayList<Inventorylog>();
        ExecuteInventoryLog eInv = new ExecuteInventoryLog();
        myInv = eInv.getAllInv(supplier);
        String[][] dataInventory = new String[myInv.size()][6];
        int i=0;
        for(Inventorylog inv : myInv) {
            dataInventory[i][0] = inv.getId();
            dataInventory[i][1] = inv.getStaff().getKtp();
            dataInventory[i][2] = inv.getInventory();
            dataInventory[i][3] = inv.getSupplier().getId();
            dataInventory[i][4] = inv.getKeterangan();
            dataInventory[i][5] = inv.getStatus();
            i++;
        }
        return dataInventory;
    }
}

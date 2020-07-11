/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Inventory;
import Exec.ExecuteInventory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IdeaPad
 */
public class ConvertInventoryToObject {
    public String[][] getInventoryAktif() {
        List<Inventory> myInv = new ArrayList<Inventory>();
        ExecuteInventory eInv = new ExecuteInventory();
        myInv = eInv.getAllInv();
        String[][] dataInventory = new String[myInv.size()][6];
        int i=0;
        for(Inventory inv : myInv) {
            dataInventory[i][0] = inv.getId();
            dataInventory[i][1] = inv.getNama();
            dataInventory[i][2] = inv.getJenis();
            dataInventory[i][3] = String.valueOf(inv.getKuantitas());
            dataInventory[i][4] = String.valueOf(inv.getHarga());
            dataInventory[i][5] = inv.getSupplier().getId();
            i++;
        }
        return dataInventory;
    }
}

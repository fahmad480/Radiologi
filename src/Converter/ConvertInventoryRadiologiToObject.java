/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Inventoryradiologi;
import Exec.ExecuteInventory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class ConvertInventoryRadiologiToObject {
    public String[][] getInventoryradiologiAktif(String idRadiologi) {
        List<Inventoryradiologi> myInv = new ArrayList<Inventoryradiologi>();
        ExecuteInventory eInv = new ExecuteInventory();
        myInv = eInv.getInventoryRadiologi(idRadiologi);
        String[][] dataInventoryradiologi = new String[myInv.size()][5];
        int i=0;
        for(Inventoryradiologi inv : myInv) {
            dataInventoryradiologi[i][0] = inv.getId();
            dataInventoryradiologi[i][1] = String.valueOf(inv.getInventory().getId());
            dataInventoryradiologi[i][2] = inv.getInventory().getNama();
            dataInventoryradiologi[i][3] = String.valueOf(inv.getInventory().getHarga());
            dataInventoryradiologi[i][4] = String.valueOf(inv.getKuantitas());
            i++;
        }
        return dataInventoryradiologi;
    }
}

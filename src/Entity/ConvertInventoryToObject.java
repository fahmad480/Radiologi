/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Exec.ExecuteInventory;

/**
 *
 * @author IdeaPad
 */
public class ConvertInventoryToObject {
   public String[][]getInventory(){
     List<Inventory> myInv = new ArrayList <Inventory>();
     ExecuteInventory ein = new ExecuteInventory();
     myInv = ein.getInventory();
     String[][] dataInventory = new String [myInv.size()[4]];
     int i = 0;
     for (Inventory iv : myInv){
         dataInventory[i][0] = iv.getId();
         dataInventory[i][1] = iv.getNama();
         dataInventory[i][2] = iv.getJenis();
         dataInventory[i][3] = iv.getKuantitas();
         dataInventory[i][4] = iv.getSupplier();
     }
     return dataInventory;
   } 
}

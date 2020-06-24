/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import com.mysql.jdbc.Connection;

/**
 *
 * @author 48faraaz
 */
public class ConnectionTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        System.out.println("Koneksi Tersedia");
    }
    
}

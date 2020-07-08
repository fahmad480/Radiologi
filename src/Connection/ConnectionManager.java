/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 48faraaz
 */
public class ConnectionManager {
   private Connection conn;
   private String driver = "com.sql.jdbc.Driver2";
   private String url = "jdbc:mysql://localhost:3306/radiologi";
   private String Username = "root";
   private String Password = "";
      
   
    public Connection LogOn(){
       try {
           conn = (Connection) DriverManager.getConnection(url,Username,Password);
       } catch (SQLException ex){
           Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
       }
       return conn;
    }
    
    public void LogOff(){
       try {
           conn.close();
       } catch (SQLException ex) {
           Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retail;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kadek William Darmawan 2201010631
 */
public class Koneksi {
        public static java.sql.Connection getConnection() {
        java.sql.Connection cnn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/retail", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed Connect to Database");
        }
        
        return cnn;
    }

    boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

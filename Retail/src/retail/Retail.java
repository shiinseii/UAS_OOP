/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package retail;

import java.sql.SQLException;

/**
 *
 * @author 2201010631 Kadek William Darmawan
 */
public class Retail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        login lg = new login();
        lg.setResizable(false);
        lg.setVisible(true);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.util;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Experiment_Utils {
    public static Connection getConnection() {
        Connection c = null;
        
        com.mysql.cj.jdbc.Driver driver;
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            String url = "jdbc:mysql://127.0.0.1:3306/experiment_db";
            String username = "root";
            String password = "502467";
            
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Experiment_Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }
    
    public static void closeConnection(Connection c) {
        try {
            if(c != null) 
                c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

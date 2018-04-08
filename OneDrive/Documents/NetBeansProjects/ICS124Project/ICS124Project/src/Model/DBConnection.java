/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author drvid
 */
public class DBConnection {

    public static String url = "jdbc:sqlite:C:\\Users\\Public\\TeamPapsie.db";
    public static Connection con = null;
        public static Connection getConnection(){
        try {
            con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

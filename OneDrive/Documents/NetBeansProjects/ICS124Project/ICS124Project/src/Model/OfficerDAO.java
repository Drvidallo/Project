/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author drvid
 */
public class OfficerDAO {
     public static List<Officer> getOfficerList(){
        List<Officer> of = new ArrayList<Officer>();
        try{
        String sql = "SELECT * FROM OFFICERS where is_uniwide='FALSE'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String stdn = rs.getString("studno");
            String fn = rs.getString("firstname");
            String ln = rs.getString("lastname");
            String mn = rs.getString("middlename");
            String db = rs.getString("dateofBirth");
            String em = rs.getString("emailAddress");
            String deg = rs.getString("degree");
            String col = rs.getString("college");
            String ys = rs.getString("yearsec");
            String org = rs.getString("organization");
            String orgP = rs.getString("orgPosition");
            String ay = rs.getString("acadYear");
            Officer officer = new Officer(stdn, fn, ln, mn, db, em, deg, col, ys, org, orgP, ay);
            of.add(officer);
        }
        stmt = con.createStatement();
        stmt.execute(sql);
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
        }
        return of;
     }
      public static List<Officer> getOfficerUniwideList(){
        List<Officer> of = new ArrayList<Officer>();
        try{
        String sql = "SELECT * FROM OFFICERS where is_uniwide='TRUE'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String stdn = rs.getString("studno");
            String fn = rs.getString("firstname");
            String ln = rs.getString("lastname");
            String mn = rs.getString("middlename");
            String db = rs.getString("dateofBirth");
            String em = rs.getString("emailAddress");
            String deg = rs.getString("degree");
            String col = rs.getString("college");
            String ys = rs.getString("yearsec");
            String org = rs.getString("organization");
            String orgP = rs.getString("orgPosition");
            String ay = rs.getString("acadYear");
            Officer officer = new Officer(stdn, fn, ln, mn, db, em, deg, col, ys, org, orgP, ay);
            of.add(officer);
        }
        stmt = con.createStatement();
        stmt.execute(sql);
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
        }
        return of;
     }
     
     public static List<Officer> getOfficerUniwideList(String orgU){
        List<Officer> of = new ArrayList<Officer>();
        try{
        String sql = "SELECT * FROM OFFICERS where is_uniwide='TRUE' and organization = '"+orgU+"'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
  
        while(rs.next()){
            String stdn = rs.getString("studno");
            String fn = rs.getString("firstname");
            String ln = rs.getString("lastname");
            String mn = rs.getString("middlename");
            String db = rs.getString("dateofBirth");
            String em = rs.getString("emailAddress");
            String deg = rs.getString("degree");
            String col = rs.getString("college");
            String ys = rs.getString("yearsec");
            String org = rs.getString("organization");
            String orgP = rs.getString("orgPosition");
            String ay = rs.getString("acadYear");
            Officer officer = new Officer(stdn, fn, ln, mn, db, em, deg, col, ys, org, orgP, ay);
            of.add(officer);
        }
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return of;
     }
     
      public static List<Officer> getOfficerList(String orgU){
        List<Officer> of = new ArrayList<Officer>();
        try{
        String sql = "SELECT * FROM OFFICERS where is_uniwide='FALSE' and organization = '"+orgU+"'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
  
        while(rs.next()){
            String stdn = rs.getString("studno");
            String fn = rs.getString("firstname");
            String ln = rs.getString("lastname");
            String mn = rs.getString("middlename");
            String db = rs.getString("dateofBirth");
            String em = rs.getString("emailAddress");
            String deg = rs.getString("degree");
            String col = rs.getString("college");
            String ys = rs.getString("yearsec");
            String org = rs.getString("organization");
            String orgP = rs.getString("orgPosition");
            String ay = rs.getString("acadYear");
            Officer officer = new Officer(stdn, fn, ln, mn, db, em, deg, col, ys, org, orgP, ay);
            of.add(officer);
        }
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return of;
     }
}


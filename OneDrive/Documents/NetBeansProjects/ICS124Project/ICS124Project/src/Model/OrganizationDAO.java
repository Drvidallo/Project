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

/**
 *
 * @author drvid
 */
public class OrganizationDAO {
    
    public static List<Organization> getUniWideList(){
        List<Organization> org_list = new ArrayList<Organization>();
        
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE is_uwide=TRUE";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            int org_id = rs.getInt("org_id");
            String name = rs.getString("name");
            String year = rs.getString("year_established");
            Organization org = new Organization(org_id, name, year);
            org_list.add(org);
        }
       
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
        }
        return org_list;
    }
 
    public static List<String> getUniWideListStringName(){
        List<String> org_list = new ArrayList<String>();

        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE is_uwide='TRUE'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
     public static List<String> getLocalColEducListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='College of Education'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
      
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
          public static List<String> getLocalColArchiListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='College of Architecture'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
 public static List<String> getLocalColCommListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='College of Commerce & Business Administration'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
  public static List<String> getLocalColNursingListName(){
        List<String> org_list = new ArrayList<String>();
        // databaseHandler DatabaseHandler;
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='College of Nursing'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
     public static List<String> getLocalConMusicListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Conservatory of Music'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
    
   public static List<String> getLocalColRehabListName(){
        List<String> org_list = new ArrayList<String>();
        // databaseHandler DatabaseHandler;
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='College of Rehabilitation Science'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
   public static List<String> getLocalColFineArtsListName(){
        List<String> org_list = new ArrayList<String>();
        // databaseHandler DatabaseHandler;
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='College of Fine Arts & Design'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
  
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
   public static List<String> getLocalfacEccleListName(){
        List<String> org_list = new ArrayList<String>();
        // databaseHandler DatabaseHandler;
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Eccleastical Faculties'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
        rs.close();
        stmt.close();
          con.close();
//            stmt = con.createStatement();
//            stmt.execute(sql);
//            
        }catch(SQLException e){
            
        }
        return org_list;
    }
   public static List<String> getLocalfacCivilLawListName(){
        List<String> org_list = new ArrayList<String>();
        // databaseHandler DatabaseHandler;
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Faculty of Civil Law'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
    public static List<String> getLocalfacMedListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Faculty of Medicine & Surgery'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
     public static List<String> getLocalfacPharmaListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Faculty of Pharmacy'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
  
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }

      public static List<String> getLocalcolScienceListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='College of Science'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
   
       public static List<String> getLocalcolTourismListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='College of Tourism'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
    
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
        public static List<String> getLocalfacEngListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Faculty of Engineering'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
 
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
         public static List<String> getLocalfacArtsListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Faculty of Arts & Letters'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
 
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
         public static List<String> getLocalInstInfoListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Institute of Information & Computing Sciences'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
         public static List<String> getLocalInstPhysicalListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='Institute of Physical Education & Athletics'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
 
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
          public static List<String> getLocalUstSeniorListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='UST Senior High School'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
 
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
           public static List<String> getLocalUstJuniorListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='UST Junior High School'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }

            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
            public static List<String> getLocalGradSchoolListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='UST Graduate School'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
 
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
             public static List<String> getLocalUstEducListName(){
        List<String> org_list = new ArrayList<String>();
        try{
        String sql = "SELECT * FROM ORGANIZATION WHERE code_college='UST Education High School'";
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            String name = rs.getString("name");
            org_list.add(name);
        }
 
            rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            
        }
        return org_list;
    }
}

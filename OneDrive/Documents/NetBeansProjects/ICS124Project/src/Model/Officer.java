/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author drvid
 */
public class Officer {

    private  SimpleStringProperty firstname;
    private  SimpleStringProperty lastname;
    private  SimpleStringProperty middlename;
    private  SimpleStringProperty college;
    private  SimpleStringProperty organization;
    private  SimpleStringProperty orgPosition;
    private  SimpleStringProperty acadYear;
    private  String is_uniwide;
//lipat mo nga dun sa may pindot sa gilid
    public Officer(String firstname, String lastname, String middlename, String college, String organization, String orgPosition, String acadYear ) {
 
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.middlename = new SimpleStringProperty(middlename);
        this.college = new SimpleStringProperty(college);
        this.organization = new SimpleStringProperty(organization);
        this.orgPosition = new SimpleStringProperty(orgPosition);
        this.acadYear = new SimpleStringProperty(acadYear);
    
    }

    public String getOrganization() {
        return organization.get();
    }

    public void setOrganization(SimpleStringProperty organization) {
        this.organization = organization;
    }

    public String getFirstname() {
        return firstname.get();
    }

    public String getIs_uniwide(){
        return is_uniwide;
    }

    public void setIs_uniwide(String is_uniwide) {
        this.is_uniwide = is_uniwide;
    }
    public void setFirstname(SimpleStringProperty firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname.get();
    }
    public void setLastname(SimpleStringProperty lastname) {
        this.lastname = lastname;
    }
    public String getMiddlename() {
        return middlename.get();
    }
     public void setMiddlename(SimpleStringProperty middlename) {
        this.middlename = middlename;
    }
   
    public String getCollege() {
        return college.get();
    }
    public void setCollege(SimpleStringProperty college) {
        this.college= college;
    } 
  
    public String getOrgPosition() {
        return orgPosition.get();
    }
    public void setOrgPosition(SimpleStringProperty orgPosition) {
        this.orgPosition= orgPosition;
    } 
    
    public String getAcadYear() {
        return acadYear.get();
    }    
    public void setAcadYear(SimpleStringProperty acadYear) {
        this.acadYear= acadYear;
    }   
    

    

    

   

    

    
    
    
}

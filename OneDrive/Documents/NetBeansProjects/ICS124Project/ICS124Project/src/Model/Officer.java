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
    private  SimpleStringProperty studno;
    private  SimpleStringProperty firstname;
    private  SimpleStringProperty lastname;
    private  SimpleStringProperty middlename;
    private  SimpleStringProperty dateofBirth;
    private  SimpleStringProperty emailAddress;
    private  SimpleStringProperty degree;
    private  SimpleStringProperty college;
    private  SimpleStringProperty yearsec;
    private  SimpleStringProperty organization;
    private  SimpleStringProperty orgPosition;
    private  SimpleStringProperty acadYear;
//lipat mo nga dun sa may pindot sa gilid
    public Officer(String studno, String firstname, String lastname, String middlename, String dateofBirth, String emailAddress, String degree, String college, String yearsec, String organization, String orgPosition, String acadYear) {
        this.studno = new SimpleStringProperty(studno);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.middlename = new SimpleStringProperty(middlename);
        this.dateofBirth = new SimpleStringProperty(dateofBirth);
        this.emailAddress = new SimpleStringProperty(emailAddress);
        this.degree = new SimpleStringProperty(degree);
        this.college = new SimpleStringProperty(college);
        this.yearsec = new SimpleStringProperty(yearsec);
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

    public String getStudno() {
        return studno.get();
    }
    public void setStudno(SimpleStringProperty studno) {
        this.studno = studno;
    }
    public String getFirstname() {
        return firstname.get();
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
    public String getDateofBirth() {
        return dateofBirth.get();
    }
    public void setDateofBirth(SimpleStringProperty dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
    public String getEmailAddress() {
        return emailAddress.get();
    }
    public void setEmailAddress(SimpleStringProperty emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getDegree() {
        return degree.get();
    }
    public void setDegree(SimpleStringProperty degree) {
        this.degree= degree;
    } 
    public String getCollege() {
        return college.get();
    }
    public void setCollege(SimpleStringProperty college) {
        this.college= college;
    } 
    public String getYearsec() {
        return yearsec.get();
    }
    public void setYearsec(SimpleStringProperty yearsec) {
        this.yearsec= yearsec;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author drvid
 */
public class Organization {
    private int org_id;
    private String name;
    private String year_established;
    private String is_uwide;
  
    
    public Organization(int org_id, String name, String year_established){
        this.org_id = org_id;
        this.name = name;
        this.year_established = year_established;
        
    }
    public Organization(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }
    
    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear_established() {
        return year_established;
    }

    public void setYear_established(String year_established) {
        this.year_established = year_established;
    }

    public String getIs_uwide() {
        return is_uwide;
    }

    public void setIs_uwide(String is_uwide) {
        this.is_uwide = is_uwide;
    }
 
    
    
}

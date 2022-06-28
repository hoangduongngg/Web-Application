/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author hoangduongngg
 */
public class Student {
    private String id;
    private String name ;
    private String dob;
    private String department ;
    private int approved;

    public Student() {
    }

    public Student(String id, String name, String dob, String department, int approved) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.approved = approved;
    }

    

    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    

    

    public String getDepartment() {
        return department;
    }

    public int getApproved() {
        return approved;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    

    

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }
    
    
}

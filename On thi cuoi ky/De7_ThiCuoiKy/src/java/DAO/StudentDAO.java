/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Student;

/**
 *
 * @author hoangduongngg
 */
public class StudentDAO extends DAO{
    
    public void addStudent(Student s) {
        String query = "insert into student value(?, ?, ?, ?, 0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDob());
            ps.setString(4, s.getDepartment());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
}

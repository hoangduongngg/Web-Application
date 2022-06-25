/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.House;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangduongngg
 */
public class HouseDAO extends DAO{
    private String tableName = "house";
    public HouseDAO() {
    }
    
    public List<House> getHouseNotApproved() {
        List<House> list = new ArrayList<>();
        String query = "select * from " + tableName + " where approved = 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                list.add(new House(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public void approveHouse(String id) {
        String query = "update " + tableName + " set approved=1 where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteHouse (String id) {
        String query = "delete from " + tableName + " where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public House getHouseByID(String id) {
        String query = "select * from " + tableName + " where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                return (new House(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
}

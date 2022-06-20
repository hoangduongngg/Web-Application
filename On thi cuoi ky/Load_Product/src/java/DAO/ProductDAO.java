/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangduongnggs
 */
public class ProductDAO extends DAO{
    private String tableName = "product3";

    public ProductDAO() {
    }
    
    
    public Product getProductbyID(String id) {
        String query = "select * from " + tableName + " where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4)
                );
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<Product> getAllProduct() {
        String query = "select * from " + tableName;
        List<Product> listP = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                listP.add(new Product(
                   rs.getInt(1),
                   rs.getString(2),
                   rs.getString(3),
                   rs.getFloat(4)
                   ) 
                );
            }
            
        } catch (Exception e) {
        }
        
        return listP;
    }
    
    public void addProduct(Product p) {
        String query = "insert into " + tableName + "(name, des, price) value(?,?,?)";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDes());
            ps.setFloat(3, p.getPrice());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    
    public void editProduct (Product p) {
        String query = "update " + tableName + " set name=?, des=?, price=? where id=?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDes());
            ps.setFloat(3, p.getPrice());
            ps.setInt(4, p.getId());
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
        }
    }
    
    public void deleteProduct(String id) {
        String query = "delete from " + tableName + " where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}

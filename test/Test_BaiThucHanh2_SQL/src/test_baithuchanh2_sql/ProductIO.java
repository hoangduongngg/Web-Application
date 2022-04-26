/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_baithuchanh2_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangduongngg
 */
public class ProductIO {
    private String tableName = "product";
    
    public static Connection connection = 
            DBConnection.getConnection(
                    "localhost", 
                    "product_maintenance", //name_database
                    "root",                 //username
                    "123456789");           //password
    
    public List<Product>getAll(){
        List<Product>list = new ArrayList<>();
        String sql = "select * from " + tableName;
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while(re.next()){
                Product p = new Product();
                p.setCode(re.getNString("code"));
                p.setDescription(re.getNString("description"));
                p.setPrice(re.getNString("price"));
                list.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public void delete(String code){
        String sql = "delete from "+tableName+" where code = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1, code);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void insert(Product p){
        String sql = "insert into "+tableName+" values(?,?,?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setNString(1, p.getCode());
            st.setNString(2, p.getDescription());
            st.setNString(3, p.getPrice());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void update(Product p){
        String sql = "update Product set description=?,price=? where code =?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setNString(1, p.getDescription());
            st.setNString(2, p.getPrice());
            st.setNString(3, p.getCode());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public Product getProductByCode(String code){
        String sql = "select * from "+tableName+" where code=?";
        try {
            PreparedStatement rs = connection.prepareStatement(sql);
            rs.setNString(1, code);
            ResultSet re = rs.executeQuery();
            while( re.next() ){
                Product p = new Product();
                p.setCode(re.getNString("code"));
                p.setDescription(re.getNString("description"));
                p.setPrice(re.getNString("price"));
                return p;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        ProductIO c = new ProductIO();
        List<Product> p = c.getAll();
        
        for (Product a:p) {
            System.out.println(a.getCode());
        }
    }
}

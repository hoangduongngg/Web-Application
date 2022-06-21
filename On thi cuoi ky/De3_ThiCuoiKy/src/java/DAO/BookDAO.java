/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Book;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangduongngg
 */
public class BookDAO  extends DAO{
    private String tableName = "book";
    public BookDAO() {
    }
    
    public List<Book> searchBook (Book b) {
        List<Book> list = new ArrayList<>();
        String query = "select * from " + tableName 
                + " where bookcode like ? "
                + "and title like ? "
                + "and author like ? "
                + "and category like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + b.getBookcode() + "%");
            ps.setString(2, "%" + b.getTitle() + "%");
            ps.setString(3, "%" + b.getAuthor() + "%");
            ps.setString(4, "%" + b.getCategory() + "%");
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Book(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public void bookingBook(String bookcode) {
        String query = "update " + tableName + " set booked=? where bookcode = ?";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, 1);
            ps.setString(2, bookcode);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}

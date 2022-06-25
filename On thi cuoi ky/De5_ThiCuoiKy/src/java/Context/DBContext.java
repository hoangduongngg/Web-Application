/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Context;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hoangduongngg
 */
public class DBContext {
    private String dbName = "thi_cuoi_ky";
    private String user = "root";
    private String pass = "123456789";
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" + dbName ;
            return DriverManager.getConnection(url,user, pass );
        } catch (Exception e) {
        }
        return null;
    }
}

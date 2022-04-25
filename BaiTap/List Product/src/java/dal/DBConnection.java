/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Hieu
 */
public class DBConnection {
    public static Connection getConnection(String strServer, String strDatabase, String username, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String strCon = "jdbc:mysql://"+strServer+":3306/"+strDatabase;
            return DriverManager.getConnection(strCon, username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}

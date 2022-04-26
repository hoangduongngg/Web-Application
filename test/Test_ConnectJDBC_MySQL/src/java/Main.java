
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoangduongngg
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = JDBC_Connection.getJDBCConnection();
        if (connection != null) {
            System.out.println("Right");
        }
        else {            System.out.println("no");
        }
        
        
    }
}

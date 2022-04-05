package context;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
    public Connection getConnection()throws Exception {
        String url = "jdbc:mysql://localhost:3306/" + dbName;
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, userID, password);
    }   
    private final String dbName = "hello"; 
    private final String userID = "root";
    private final String password = "123456789";
}
 
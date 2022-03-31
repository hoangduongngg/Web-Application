package test_jdbc_mysql2;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hoangduongngg
 */
public class JDBC_Connection {

    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = getJDBCConnection();
        if (connection != null) {
            System.out.println("Right");
        }
        else {
            System.out.println("no");
        }
    }
    
    
    public static Connection getJDBCConnection() throws ClassNotFoundException  {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/hello";
            String user = "root";
            String password = "";
            
            return DriverManager.getConnection(url, user, password);
        } 
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

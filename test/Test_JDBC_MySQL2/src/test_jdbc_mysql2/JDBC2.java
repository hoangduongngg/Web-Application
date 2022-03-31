package test_jdbc_mysql2;
import java.sql.SQLException;

/**
 *
 * @author hoangduongngg
 */
public class JDBC2 {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Done");
        } 
        catch(ClassNotFoundException e) {
            System.out.println("Fail");
            e.printStackTrace();
        }
    }
}


    

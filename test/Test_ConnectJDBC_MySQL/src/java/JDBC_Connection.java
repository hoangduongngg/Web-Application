
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author hoangduongngg
 */
@WebServlet(urlPatterns = {"/JDBC_Connection"})
public class JDBC_Connection {
    public static Connection getJDBCConnection()  {
        
        final String url = "jdbc:mysql://localhost:3306/hello";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        Connection connection = getJDBCConnection();
//        if (connection != null) {
//            System.out.println("Right");
//        }
//        else {
//            System.out.println("no");
//        }
//        
//        
//    }
}

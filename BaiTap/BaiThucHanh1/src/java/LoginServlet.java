
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoangduongngg
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = "index.jsp";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = checkUser(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            url = "login.jsp";
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    public static User checkUser(String username, String password ) throws FileNotFoundException, IOException {
                //Kiem tra xem da ton tai chua
        File file = new File("WEB-INF/login.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = in.readLine();
        while (line != null) {
            StringTokenizer t = new StringTokenizer(line);
            String userData = t.nextToken();
            String passData = t.nextToken();
            if (username.equals(userData) && password.equals(passData)) {
                User user = new User(username, password);
                return user;
            }
        }
        return null;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

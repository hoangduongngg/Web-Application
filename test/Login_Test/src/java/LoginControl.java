import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author hoangduongngg
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginControl extends HttpServlet{
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.setAttribute("user", username);
        request.setAttribute("pass", password);
        
        request.getRequestDispatcher("showAccount.jsp").forward(request, response); 
    }
    
    protected void doPost (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

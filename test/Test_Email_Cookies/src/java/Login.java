
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoangduongngg
 */
@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String email = request.getParameter("email");
       
        if (email == null  || !email.equals("hd@gmail.com")) {
            response.sendRedirect("/Test_Email_Cookies/login");

        }
        else {
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60); //60s
            response.addCookie(cookie);
            response.sendRedirect("/Test_Email_Cookies/home");
        }
        
        
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

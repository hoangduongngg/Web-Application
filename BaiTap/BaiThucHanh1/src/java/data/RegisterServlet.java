
package data;

import business.User;
import static data.LoginServlet.checkUser;
import java.io.IOException;
import javax.servlet.ServletContext;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/login.jsp";

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("WEB-INF/login.txt");
        
        User user = checkUser(username, password, path);
        HttpSession session = request.getSession();
        String errorLogin = "";
        
        if (user != null) {
            url = "register.jsp";
            errorLogin = "The account already exists.";
        }
        else {
            String line = user.getUsername() + "|" + user.getPassword();
            session.setAttribute("user", user);
        }
        session.setAttribute("errorLogin", errorLogin);
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
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

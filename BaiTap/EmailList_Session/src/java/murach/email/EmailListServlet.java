package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import murach.business.User;
//import murach.data.UserDB;

@WebServlet(urlPatterns = {"/emailList"})
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.jsp";
        // get current action 
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // default action 
        }
// perform action and set URL to appropriate page  
        if (action.equals("join")) {
            url = "/index.jsp"; // the "join" page  
        } else if (action.equals("add")) {
            // get parameters from the request 
            String email = request.getParameter("email");
//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
//            String gender = request.getParameter("gender");
//            String edu = request.getParameter("education");
            String firstName = "";
            String lastName = "";
            String gender = "";
            String edu = "";
//             store data in User object and save User object in db  
//            User user = new User(firstName, lastName, email, gender, edu);
            //UserDB.insert(user); 

            // set User object in request object and set URL  
//            request.setAttribute("user", user);

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            
            if (user == null || email.equals(user.getEmail())) {
                user = new User(firstName, lastName, email, gender, edu);
                session.setAttribute("user", user);
                String checkEmail = user.getEmail();
                session.setAttribute("checkEmail", checkEmail);
            }
            else {
                String checkEmail = "Not Logged";
                session.setAttribute("checkEmail", checkEmail);
            }
            
            url = "/thanks.jsp"; // the "thanks" page  
        }

        // forward request and response objects to specified URL  
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
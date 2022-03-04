package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import murach.business.User;
import murach.business.Message;
//import murach.data.UserDB;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        String url = "/index.html";
        // get current action 
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // default action 
        }
// perform action and set URL to appropriate page  
        if (action.equals("join")) {
            url = "/index.html"; // the "join" page  
        } else if (action.equals("add")) {
            // get parameters from the request 
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String edu = request.getParameter("education");
                    // store data in User object
        User user = new User(firstName, lastName, email, gender, edu);

        // validate the parameters
        String message_fn = "", message_ln ="", message_email="";
        
        Message message = new Message(message_fn, message_ln, message_email);
        url = "/display_email_list.jsp";
        if (firstName.trim().equals("")) {
            message_fn = "Please fill out text box.";
            url = "/index.jsp";
        } 
        if (lastName.trim().equals("")) {
            message_ln = "Please fill out text box.";
            url = "/index.jsp";
        }
        if (email.trim().equals("")) {
            message_email = "Please fill out text box.";
            url = "/index.jsp";
        }
        
        request.setAttribute("message_fn", message_fn);
        request.setAttribute("message_ln", message_ln);
        request.setAttribute("message_email", message_email);

        request.setAttribute("user", user);
//        request.setAttribute("message", message);

        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}

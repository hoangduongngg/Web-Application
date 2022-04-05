package data;


import business.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
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
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/index.jsp";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("WEB-INF/login.txt");
        
        User user = checkUser(username, password, path);
        HttpSession session = request.getSession();
        String announcement = "";
        if (user != null) {
            session.setAttribute("user", user);
            url = "/login.jsp";
        }
        else {
            announcement = "The account does not exist.";
        }
        request.setAttribute("announcement", announcement);
        request.setAttribute("time", getTime());
        request.setAttribute("IPAdress", getIPAdress());
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    public User checkUser(String username, String password, String path ) 
            throws FileNotFoundException, IOException {
                //Kiem tra xem da ton tai chua              
        BufferedReader in = new BufferedReader(new FileReader(new File(path)));
        String line = in.readLine();
        while (line != null) {
            StringTokenizer t = new StringTokenizer(line, "|");
            String userData = t.nextToken();
            String passData = t.nextToken();
            if (username.equals(userData) && password.equals(passData)) {
                User user = new User(username, password);
                return user;
            }
            line = in.readLine();
        }
        in.close();
        return null;
    }
    
    private String getTime () {
    //khai báo một đổi tượng current thuộc class LocalDateTime
    LocalDateTime current = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //sử dụng phương thức format() để định dạng ngày giờ hiện tại rồi gán cho chuỗi formatted
    String formatted = current.format(formatter);
    return formatted;
    }
    
    private String getIPAdress() throws UnknownHostException {
        InetAddress myIP=InetAddress.getLocalHost();
        return myIP.getHostAddress();
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

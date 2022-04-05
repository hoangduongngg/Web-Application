package data;


import business.User;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        if (user != null) {
            session.setAttribute("user", user);
            url = "/login.jsp";
        }
        else {
            request.setAttribute("announcement", "Wrong username or password.");
        }
        
        request.setAttribute("time", getTime());
        request.setAttribute("IPAdress", getIPAdress());
        request.setAttribute("hits_counter", Hits_counter());
        
        
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
    
    private String Hits_counter () throws FileNotFoundException, IOException {  
        String url_file = 
//                "WEB-INF/hits_counter.txt";
        "C:\\CODE\\Web Programming\\Web-Progamming-PTIT\\BaiTap\\BaiThucHanh1\\web\\WEB-INF\\hits_counter.txt";

        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileInputStream fis = new FileInputStream(url_file);
            DataInputStream dis = new DataInputStream(fis);
            //Bước 2: Đọc dữ liệu
            int n = dis.readInt(); 
            fis.close();
            dis.close();
            //Hiển thị nội dung đọc từ file
//            return String.valueOf(n + 1);
            return "2";
        } catch (IOException e) {
             e.printStackTrace();
           }
        return "1";
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

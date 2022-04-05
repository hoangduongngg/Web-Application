
package data;

import java.io.BufferedWriter;
import business.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/register.jsp";

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("repassword");
        
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("WEB-INF/login.txt");
        
        User user = checkUser(username, password, path);
        HttpSession session = request.getSession();
        
        String announcement = "";
        if (!password.equals(rePassword)) {
            announcement = "Kiem tra lai mat khau";
        }
        else {
            if (user != null) {
                url = "/register.jsp";
                announcement = "The account already exists.";
            }
            else {
                User user_new = new User(username, password);
                WriteUser(user_new);
                url = "/index.jsp";
                announcement = "Dang ky thanh cong.";
            }
        }
        
        
        request.setAttribute("announcement", announcement);
        
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

    public User checkUser(String username, String password, String path ) throws FileNotFoundException, IOException {
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
    
    public void WriteUser (User user) throws FileNotFoundException, IOException {
        String line = user.getUsername() + "|" + user.getPassword() + "\n";
        String url_file = 
//                "WEB-INF/login.txt";
        "C:\\CODE\\Web Programming\\Web-Progamming-PTIT\\BaiTap\\BaiThucHanh1\\web\\WEB-INF\\login.txt";

        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
                File file = new File(url_file);
                // kiểm tra nếu file chưa có thì tạo file mới
                if (!file.exists()) {
                    file.createNewFile();
                }
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(line);
         } catch (IOException e) {
                e.printStackTrace();
         } finally {
                try {
                    if (bw != null)
                            bw.close();
                    if (fw != null)
                            fw.close();
             } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
    
}

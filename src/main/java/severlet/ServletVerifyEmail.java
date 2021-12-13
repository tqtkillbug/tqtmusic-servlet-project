package severlet;

import DAO.UserDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Role;
import model.User;
import services.JacksonParser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet(name = "ServletVerifyEmail", value = "/ServletVerifyEmail")
public class ServletVerifyEmail extends HttpServlet {


    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputCode = request.getParameter("code-input");
        Cookie[] cookies = request.getCookies();
        String json = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user"))
                    json = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
            }
        } else{
            System.out.println("Cookie Is Null");
        }
        User user = JacksonParser.INSTANCE.toObject(json, User.class);
        String systemCode = user.getCode();
        if (systemCode.equals(inputCode)) {
            String fullname  = user.getFullName();
            String username  = user.getUsername();
            String email  = user.getEmail();
            String password  = user.getPassword();
            String role  = user.getRole();
            String status = user.getStatus();
            User newUser = new User(fullname, username, email, password,role,status);
            System.out.println(newUser);
            try {
                userDAO.insertUser(newUser);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Code dung dang ki tai khoan thanh cong");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {
            System.out.println("Code sai dang ki khong thanh cong, hay dang ki lai");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }

        Cookie killMyCookie = new Cookie("user", null);
        killMyCookie.setMaxAge(0);
        response.addCookie(killMyCookie);

    }
}

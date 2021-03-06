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
import java.sql.SQLOutput;

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
        HttpSession session = request.getSession(true);
        User userRegister = (User) session.getAttribute("userRegister");
        System.out.println(userRegister);
        if (userRegister.getCode().equals(inputCode)) {
            try {
                userDAO.insertUser(userRegister);
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

    }
}

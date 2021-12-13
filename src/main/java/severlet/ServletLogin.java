package severlet;

import DAO.UserDAO;
import model.User;
import services.IUserService;
import services.Login;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {

    private UserDAO userDAO;
    private IUserService userService;

    public void init(){
        userDAO = new UserDAO();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.login(username, password)){
            System.out.println("Dang nhap thanh cong");
            User user = userService.getUser(username,password);
            if (user.getRole().equals("USER")){
                request.setAttribute("username", username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
                dispatcher.forward(request, response);
            }
            if (user.getRole().equals("ADMIN") || user.getRole().equals("BOSS")){
                request.setAttribute("username", username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
                dispatcher.forward(request, response);
            }
        } else{
            String message = "Login failed, Plase check username and password";
            request.setAttribute("message",message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}

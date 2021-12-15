package severlet;

import model.User;
import services.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {

    private IUserService userService;
    private ISongService songService;

    public void init(){
        userService = new UserService();
        songService = new SongService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logOut":
                logOutUser(request, response);
                break;
        }
    }

    private void logOutUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.removeAttribute("userLogin");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User userLogin = null;
        HttpSession session = request.getSession(true);
        if (userService.login(username, password)){
            userLogin = userService.getByUsername(username);
            session.setAttribute("userLogin",userLogin);
            if (userLogin.getRole().equals("USER")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
                dispatcher.forward(request, response);
            }
            if (userLogin.getRole().equals("ADMIN") || userLogin.getRole().equals("BOSS")){
                ArrayList<Integer> quantityList = new ArrayList<>();
                int adminQuantity = userService.getCountByRole("ADMIN");
                int userQuantity = userService.getCountByRole("USER");
                int songQuantity = songService.getSongCount();
                quantityList.add(adminQuantity);
                quantityList.add(userQuantity);
                quantityList.add(songQuantity);
                request.setAttribute("quantity", quantityList);
                request.setAttribute("admin",userLogin);
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

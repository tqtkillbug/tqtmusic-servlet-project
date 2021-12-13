package severlet;

import model.User;
import services.IUserService;
import services.SendKeyToMail;
import services.UserService;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletAdmin", value = "/pages")
public class ServletAdmin extends HttpServlet {

    private IUserService userService;

    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "usermanager":
                showListUser(request, response);
                break;
            case "musicmanager":
                listMusic(request, response);
                break;
            case "block":
                try {
                    setStatus(request, response,"BLOCKED");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "active":
                try {
                    setStatus(request, response,"ACTIVE");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void listMusic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/musicmanager.jsp");
        dispatcher.forward(request, response);
    }

    private void setStatus(HttpServletRequest request, HttpServletResponse response, String status) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getById(id);
        if (user.getId() == 1){
            request.setAttribute("message", "You cannot block Boss");
        } else{
            user.setStatus(status);
            System.out.println(user);
            userService.updateUser(user);
            request.setAttribute("message", status +" "+ user.getFullName() + " Success!");
        }
        encoding(request, response);
        List<User> listUser = userService.getUsers();
        String username = request.getParameter("adminname");
        User admin =  userService.getByUsername(username);
        request.setAttribute("admin",admin);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/usermanager.jsp");
        dispatcher.forward(request, response);
    }



    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        encoding(request, response);
        List<User> listUser = userService.getUsers();
        String username = request.getParameter("username");
        User admin =  userService.getByUsername(username);
        System.out.println(admin);
        request.setAttribute("admin",admin);
        request.setAttribute("listUser", listUser);
        request.setAttribute("username", username);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/usermanager.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addnewadmin":
                try {
                    addNewAdmin(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "sendmailtouser":
                try {
                    sendMailToUser(request, response);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void sendMailToUser(HttpServletRequest request, HttpServletResponse response) throws MessagingException, IOException, ServletException {
        String title = request.getParameter("titleEmail");
        String content = request.getParameter("contentMail");
        String emailUser = request.getParameter("emailuser");
        String from = request.getParameter("inputFromAdmin");
        String contentMail = "\n" + title + "\n" + content + "\n" + "From: " +from;
        SendKeyToMail.send(emailUser, contentMail);
        encoding(request, response);
        List<User> listUser = userService.getUsers();
        String username = request.getParameter("inputFromAdmin");
        User admin =  userService.getByUsername(username);
        request.setAttribute("message", "Send Mail To " + emailUser +" Success!");
        request.setAttribute("admin",admin);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/usermanager.jsp");
        dispatcher.forward(request, response);
    }

    private void addNewAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String fullName = request.getParameter("inputFullname");
        String username = request.getParameter("inputUsername");
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        String role = "ADMIN";
        String status = "ACTIVE";
        User user = new User(fullName, username, email, password, role, status);
        String adminName = request.getParameter("adminNameform");
        userService.addUser(user);
        encoding(request, response);
        User admin =  userService.getByUsername(adminName);
        request.setAttribute("admin",admin);
        List<User> listUser = userService.getUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/usermanager.jsp");
        dispatcher.forward(request, response);
    }

    private void encoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    }
}

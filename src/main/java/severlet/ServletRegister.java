package severlet;

import model.User;
import services.*;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ServletRegister", value = "/ServletRegister")
public class ServletRegister extends HttpServlet {

   private IUserService userService;

   public void init(){
       userService = new UserService();
   }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String systemCode = RandomKeyGenerated.randomString();
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = "USER";
        String status = "ACTIVE";
        System.out.println(systemCode);
        User newuser = userService.getByUsername(username);
        User user = userService.getByEmail(email);
        System.out.println(user);
        System.out.println(newuser);
        if (newuser == null && user == null){
            User userRegister = new User(fullname, username, email, password,role,systemCode,status);
            try {
                String contentMail = "Key Verify Email From TQT MUSIC IS: " + systemCode;
                SendKeyToMail.send(email, contentMail);
                System.out.println("gui mail thanh cong");
            } catch (MessagingException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("userRegister",userRegister);
            request.setAttribute("email",email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/verify-email.jsp");
            dispatcher.forward(request, response);
        } else{
            String message = "Username or email already exists, please try again";
            request.setAttribute("message",message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }

    }

}


package services;

import DAO.UserDAO;
import model.User;

public class Login {
    public static boolean Log(String username, String password) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.selectUser(username, password);
        return user != null;
    }
}

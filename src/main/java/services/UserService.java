package services;

import DAO.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public boolean login(String username, String password) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.selectUser(username, password);
        return user != null;
    }

    @Override
    public User getUser(String username, String password) {
        return userDAO.selectUser(username, password);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.selectAllUser();
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    @Override
    public User getById(int id) throws SQLException {
        return userDAO.getUserById(id);
    }

    @Override
    public void addUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }

    @Override
    public User getByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public int getCountByRole(String role) {
        return userDAO.getCount(role);
    }

    @Override
    public User getByEmail(String email) {
        return userDAO.selectUserByEmail(email);
    }
}

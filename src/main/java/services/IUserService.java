package services;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {


    boolean login(String username, String password);

    User getUser(String username, String password);

    List<User> getUsers();

    boolean updateUser(User user) throws SQLException;

    User getById(int id) throws SQLException;

    void addUser(User user) throws SQLException;

    User getByUsername(String username);

    int getCountByRole(String role);

    User getByEmail(String email);
}

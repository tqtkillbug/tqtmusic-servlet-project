package DAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;

    User getUserById(int id) throws SQLException;

    User getUserByUsername(String username);

    User selectUser(String username, String password);

    List<User> selectAllUser();

//    public boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}

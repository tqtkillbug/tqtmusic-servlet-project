package DAO;

import model.User;
import repository.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {


    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "tientran123@";

    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "select username,password,role from user where username = ? and password = ? ";
    private static final String INSERT_USERS_SQL = "INSERT INTO user (fullname,username,email,password,role,status) VALUES (?, ?,?,?,?,?);";
    private static final String SELECT_USERS_SQL = "select id,fullname,email,gender from user where id =?, email= ?";
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String SELECT_USER_BY_ID = "select id,fullname,email,username,role,status from user where id = ?;";
    private static final String SELECT_USER_BY_USERNAME = "select id,fullname,email,username,role,status from user where username = ?;";
    private static final String UPDATE_USERS_SQL = "update user set fullname = ?,email= ?, role =?, status= ? where id = ?;";
    //    private static final String DELETE_USERS_SQL = "delete from account where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update user set email = ?,where id = ?;";


    public UserDAO() {
        MysqlConnection.init("tqtmusicdatabase");
    }


    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        System.out.println(user);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole() );
            preparedStatement.setString(6, user.getStatus() );
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String role = rs.getString("role");
                String status = rs.getString("status");
                user = new User(id, fullname, email, username,role,status);
            }
        } catch (SQLException ignored) {
        }
        return user;
    }
 @Override
 public User getUserByUsername(String username){
     User user = null;
     // Step 1: Establishing a Connection
     try (Connection connection = MysqlConnection.getInstance().getConnection();
          // Step 2:Create a statement using connection object
          PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);) {
         preparedStatement.setString(1, username);
         System.out.println(preparedStatement);
         // Step 3: Execute the query or update query
         ResultSet rs = preparedStatement.executeQuery();

         // Step 4: Process the ResultSet object.
         while (rs.next()) {
             int id = rs.getInt("id");
             String fullname = rs.getString("fullname");
             String email = rs.getString("email");
             String role = rs.getString("role");
             String status = rs.getString("status");
             user = new User(id, fullname, email, username,role,status);
         }
      } catch (SQLException ignored) {
     }
     return user;
 }
    @Override
    public User selectUser(String ipusername, String ippassword) {
        User user = null;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD);) {
            preparedStatement.setString(1, ipusername);
            preparedStatement.setString(2, ippassword);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                user = new User(userName, password, role);
            }
        } catch (SQLException ignored) {
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String role = rs.getString("role");
                String status = rs.getString("status");
                users.add(new User(id, fullname,email, username, role,status));
            }
        } catch (SQLException ignored) {
        }
        return users;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = MysqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getRole());
            statement.setString(4, user.getStatus());
            statement.setInt(5, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}

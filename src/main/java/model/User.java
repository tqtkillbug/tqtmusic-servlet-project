package model;

public class User {
    private int id;
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String role;
    private String code;
    private String status;

    public User() {
    }

    public User(String fullName, String username, String email, String password, String role,String status) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public User(String fullName, String username, String email, String password, String role) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User( String fullName, String username, String email, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User( String username,String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String fullName, String username, String email, String password, String role, String code, String status) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.code = code;
        this.status = status;
    }

    public User(int id, String fullname,String email, String username, String role, String status) {
        this.id = id;
        this.fullName = fullname;
        this.email =email;
        this.username = username;
        this.role = role;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

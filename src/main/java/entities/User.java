package entities;

import java.util.Date;

public class User {
    private int user_id;
    private String username;
    private String password;
    private Date signupDate;

    public User() {
    }

    public User(String username, String password, Date signupDate) {
        this.username = username;
        this.password = password;
        this.signupDate = signupDate;
    }

    public User(int user_id, String username, String password, Date signupDate) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.signupDate = signupDate;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }
}

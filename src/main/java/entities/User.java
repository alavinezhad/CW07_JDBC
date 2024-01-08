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
}

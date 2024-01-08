package service;

import entities.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    private final Scanner scanner = new Scanner(System.in);
    UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public void addUser() throws SQLException {
        System.out.println("***** add a user *****");
        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        long lastId = userRepository.save(new User(username, password));
        if (lastId != -1)
            System.out.println("new user is added and its id is " + lastId);
        else
            System.out.println("user is not added.try again");
    }
    public User findUserById(int userId) throws SQLException {
        return userRepository.load(userId);
    }
    public void updateUser(User user) throws SQLException {
        System.out.println("***** Edit username and password *****");
        System.out.println("your current username: \'" + user.getUsername() + '\'');
        System.out.println("Enter new username: ");
        String username = scanner.nextLine();
        System.out.println("Enter new password: ");
        String password = scanner.nextLine();

        int updateResult = userRepository.update(new User(user.getUser_id(),
                username, password, user.getSignupDate()));
        if (updateResult == 1)
            System.out.println("Username and password are changed.");
        else
            System.out.println("username and password are not changed, try again.");
    }
    public void deleteUser(User user) throws SQLException {
        int deleteResult = userRepository.delete(user);
        if (deleteResult == 1)
            System.out.println("user with Id: \'" + user.getUser_id() + "\' is delete.");
        else
            System.out.println("deletion is not successful!");
    }
}

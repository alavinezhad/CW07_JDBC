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
}

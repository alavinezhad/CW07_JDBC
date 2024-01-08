import entities.User;
import service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();

        userService.addUser();
        User foundUser = userService.findUserById(2);
        System.out.println(foundUser);

        User user1 = userService.findUserById(4);
        userService.updateUser(user1);
        User user8 = userService.findUserById(8);
        userService.deleteUser(user8);
        userService.loadAllUsers();
    }

    private static User[] makeBunchOfUsers() {
        User[] users = new User[4];
        users[0] = new User("Username1", "1223344");
        users[1] = new User("Username2", "2334455");
        users[2] = new User("Username3", "3445566");
        users[3] = new User("Username4", "4556677");
        return users;
    }
}

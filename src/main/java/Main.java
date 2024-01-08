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
}

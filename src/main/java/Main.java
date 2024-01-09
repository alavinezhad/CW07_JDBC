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
        User[] bunchOfUsers = makeBunchOfUsers();
        userService.insertBunchOfUsers(bunchOfUsers);
    }

    private static User[] makeBunchOfUsers() {
        User[] users = new User[8];
        users[0] = new User("alavi1349", "111111");
        users[1] = new User("farzadafi", "222222");
        users[2] = new User("ghazi123", "333333");
        users[3] = new User("sharifi12", "444444");
        users[4] = new User("parisa123", "555555");
        users[5] = new User("ariana246", "666666");
        users[6] = new User("shamim456", "777777");
        users[7] = new User("dehdari84", "888888");
        return users;
    }
}

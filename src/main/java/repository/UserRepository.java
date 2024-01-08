package repository;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {
    private final JdbcConnection jdbcConnection = new JdbcConnection();
    private final Connection connection = jdbcConnection.getConnection();

    public UserRepository() throws SQLException {
    }

    public int save(User user) throws SQLException {
        String addUser = "INSERT INTO \"user\" (username, password, signup_date)\n" +
                "VALUES (?, ?, now());";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());

        return preparedStatement.executeUpdate();
    }

}

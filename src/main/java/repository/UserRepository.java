package repository;

import entities.User;

import java.sql.*;

public class UserRepository {
    private final JdbcConnection jdbcConnection = new JdbcConnection();
    private final Connection connection = jdbcConnection.getConnection();

    public UserRepository() throws SQLException {
    }

    public long save(User user) throws SQLException {
        String addUser = "INSERT INTO \"user\" (username, password, signup_date)\n" +
                "VALUES (?, ?, now());";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());

        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next())
                return resultSet.getLong(1);
        }
        return -1;
    }

    public User load(int userId) {
        String findUser = "SELECT * FROM \"user\" WHERE user_id = ?;";
        return null;
    }
}

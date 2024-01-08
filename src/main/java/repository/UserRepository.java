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

    public User load(int userId) throws SQLException {
        String findUser = "SELECT * FROM \"user\" WHERE user_id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setInt(1, userId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int userId1 = resultSet.getInt("user_id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            Date signupDate = resultSet.getDate("signup_date");

            return new User(userId1, username, password, signupDate);
        }
        return null;
    }
}

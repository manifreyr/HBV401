package is.hi.hbv401g.Bakendi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UserRepository {
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM User";
        List<User> userList = new ArrayList<>();

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("SSNo"),
                        resultSet.getString("phone"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName")
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void addUser(User user) {
        String sql = "INSERT INTO User (SSNo, phone, firstName, lastName) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getUserPhone());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM User WHERE SSNo = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws SQLException {
        User user = new User("1809933479", "8976756", "Rosa", "Smith");
        User nyr = new User("0909902359", "7797967", "TestNew", "User");
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(nyr);
        for (User u : userRepository.getAllUsers()) {
            System.out.println(u.toString());
        }
    }

}

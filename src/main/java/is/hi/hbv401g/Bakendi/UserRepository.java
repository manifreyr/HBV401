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

}

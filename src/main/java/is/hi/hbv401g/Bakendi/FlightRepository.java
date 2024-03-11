package is.hi.hbv401g.Bakendi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    public List<Flight> getAllFlights() throws SQLException {
        String sql = "SELECT * FROM Flight";
        List<Flight> flightList = new ArrayList<>();

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){

            while(resultSet.next()){
                Flight flight = new Flight(resultSet.getString("flightNumber"),
                        resultSet.getString("departureCity"),
                        resultSet.getString("arrivalCity"),
                        resultSet.getDate("day"),
                        resultSet.getInt("price"));
                flightList.add(flight);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightList;
    }

}

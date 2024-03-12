package is.hi.hbv401g.Bakendi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class FlightRepository {

    public List<Flight> getAllFlights() throws SQLException {
        String sql = "SELECT * FROM Flight";
        List<Flight> flightList = new ArrayList<>();

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while(resultSet.next()){
            Flight flight = new Flight(resultSet.getString("flightNumber"),
                    resultSet.getString("departureCity"),
                    resultSet.getString("arrivalCity"),
                    LocalDate.parse(resultSet.getString("day")),
                    resultSet.getInt("price"),
                    resultSet.getInt("flightDuration"));
            flightList.add(flight);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightList;
    }

    public static void main(String[] args) throws SQLException {

        FlightRepository flightRepository = new FlightRepository();
        try {
            List<Flight> flights = flightRepository.getAllFlights();
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

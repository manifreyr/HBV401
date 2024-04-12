package is.hi.hbv401g.Bakendi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import javafx.collections.*;

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
                    resultSet.getInt("flightDuration"),
                    resultSet.getInt("departureTime"),
                    resultSet.getInt("availableSeats"));
            flightList.add(flight);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightList;
    }
    public void addFlight(Flight flight) throws SQLException {
        String sql = "INSERT INTO Flight (flightNumber, departureCity, arrivalCity, day, price, flightDuration) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
             preparedStatement.setString(1, flight.getFlightNumber());
             preparedStatement.setString(2, flight.getDepartureCity());
             preparedStatement.setString(3, flight.getArrivalCity());
             preparedStatement.setString(4, flight.getDay().toString());
             preparedStatement.setInt(5, flight.getPrice());
             preparedStatement.setInt(6, flight.getFlightDuration());
             }
    }
    public void deleteFlight(Flight flight) {
        String sql = "DELETE FROM Flight WHERE flightNumber = ?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void decreaseAvailableSeats(Flight flight) {
        String sql = "UPDATE Flight SET availableSeats = availableSeats - 1 WHERE flightNumber = ?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void increaseAvailableSeats(Flight flight) {
        String sql = "UPDATE Flight SET availableSeats = availableSeats + 1 WHERE flightNumber = ?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {

        FlightRepository flightRepository = new FlightRepository();
        List<Flight> listi = flightRepository.getAllFlights();
        flightRepository.decreaseAvailableSeats(listi.get(0));
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

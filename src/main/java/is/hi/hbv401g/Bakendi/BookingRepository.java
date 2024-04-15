package is.hi.hbv401g.Bakendi;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    public List<Booking> getAllBookings() throws SQLException {
        String sql = "SELECT * FROM Bookings";
        List<Booking> bookingList = new ArrayList<>();

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Booking booking = new Booking(
                        resultSet.getString("userSSNo"),
                        resultSet.getString("flightNumber"),
                        resultSet.getDate("flightDay").toLocalDate(),
                        resultSet.getString("bookingID")
                );
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookingList;
    }

    public void addBooking(Booking booking) {
        String sql = "INSERT INTO Bookings VALUES (?, ?, ?, ?)";
        sqlConnection(booking, sql);
    }

    public void deleteBooking(Booking booking) {
        String sql = "DELETE FROM Bookings WHERE bookingID = ? AND userSSNo = ? AND flightNumber = ? AND flightDay = ?";
        sqlConnection(booking, sql);
    }

    private void sqlConnection(Booking booking, String sql) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(2, booking.getUserID());
            preparedStatement.setString(3, booking.getFlightID());
            preparedStatement.setDate(4, Date.valueOf(booking.getFlightDay()));
            preparedStatement.setString(1, booking.getBookingID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Booking> getBookingsByUserID(String userID) {
        String sql = "SELECT * FROM Bookings WHERE userSSNo = ?";
        List<Booking> bookingList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Booking booking = new Booking(
                        resultSet.getString("userSSNo"),
                        resultSet.getString("flightNumber"),
                        resultSet.getDate("flightDay").toLocalDate(),
                        resultSet.getString("bookingID")
                );
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookingList;
    }
    public Booking getbookingByBookingID(String bookingID) {
        String sql = "SELECT * FROM Bookings WHERE bookingID = ?";
        Booking booking = null;
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, bookingID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                booking = new Booking(
                        resultSet.getString("userSSNo"),
                        resultSet.getString("flightNumber"),
                        resultSet.getDate("flightDay").toLocalDate(),
                        resultSet.getString("bookingID")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return booking;
    }
    public static void main(String[] args) throws SQLException {
        BookingRepository bookingRepository = new BookingRepository();
        Booking booking = bookingRepository.getbookingByBookingID("OG1212024-06-011709982359");
        System.out.println(booking);
    }
}

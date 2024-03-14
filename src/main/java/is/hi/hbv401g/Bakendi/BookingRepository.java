package is.hi.hbv401g.Bakendi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                        resultSet.getDate("day").toLocalDate(),
                        resultSet.getString("seatID")
                );
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookingList;
    }
    public Booking getBookingByUserSSNo(User user){
        String sql = "SELECT * FROM Bookings WHERE userSSNo = ?";
        Booking booking = null;
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUserID());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                booking = new Booking(
                        resultSet.getString("userSSNo"),
                        resultSet.getString("flightNumber"),
                        resultSet.getDate("day").toLocalDate(),
                        resultSet.getString("seatID")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return booking;
    }
    public void createBooking(Booking booking){
        String sql = "INSERT INTO Bookings (userSSNo, flightNumber, flightDay, seatID) VALUES (?, ?, ?, ?)";
        connectToDatabase(booking, sql);
    }
    public void deleteBooking(Booking booking){
        String sql = "DELETE FROM Bookings WHERE userSSNo = ? AND flightNumber = ? AND flightDay = ? AND seatID = ?";
        connectToDatabase(booking, sql);
    }

    private void connectToDatabase(Booking booking, String sql) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, booking.getUserID());
            preparedStatement.setString(2, booking.getFlightID());
            preparedStatement.setDate(3, java.sql.Date.valueOf(booking.getFlightDay()));
            preparedStatement.setString(4, booking.getSeat());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        BookingRepository bookingRepository = new BookingRepository();
        try {
            List<Booking> bookings = bookingRepository.getAllBookings();
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

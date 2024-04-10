package is.hi.hbv401g.Bakendi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                        resultSet.getString("seatID")
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
        String sql = "DELETE FROM Bookings WHERE seatID = ? AND userSSNo = ? AND flightNumber = ? AND flightDay = ?";
        sqlConnection(booking, sql);
    }

    private void sqlConnection(Booking booking, String sql) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(2, booking.getUserID());
            preparedStatement.setString(3, booking.getFlightID());
            preparedStatement.setDate(4, java.sql.Date.valueOf(booking.getFlightDay()));
            preparedStatement.setString(1, booking.getSeat());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookingRepository bookingRepository = new BookingRepository();
        User user = new User("1809893479", "8976756", "Grace", "Kelly");
        Flight flight = new Flight("OB989", "Reykjavík", "Athens", LocalDate.now(), 80000, 8);
        Booking newBooking = new Booking(user.getUserID(), flight.getFlightNumber(), flight.getDay(), "1A");
        bookingRepository.addBooking(newBooking);
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

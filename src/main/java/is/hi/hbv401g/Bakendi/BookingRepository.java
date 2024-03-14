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

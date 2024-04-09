package is.hi.hbv401g.Bakendi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private final BookingRepository bookingRepository = new BookingRepository();
    public void addBooking(Booking booking) {
        bookingRepository.addBooking(booking);
    }
    public void deleteBooking(Booking booking) {
        bookingRepository.deleteBooking(booking);
    }
    public void getAllBookings() throws SQLException {
        bookingRepository.getAllBookings();
    }

}

package is.hi.hbv401g.Bakendi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private UserRepository userRepository = new UserRepository();
    private BookingRepository bookingRepository = new BookingRepository();
    public void addBooking(Booking booking) {
        bookingRepository.addBooking(booking);
    }
    public void deleteBooking(Booking booking) {
        bookingRepository.deleteBooking(booking);
    }
    public void getAllBookings() throws SQLException {
        bookingRepository.getAllBookings();
    }
    public List<User> getAllUsers() throws SQLException {
        return userRepository.getAllUsers();
    }
    public void addUser(User user) {
        userRepository.addUser(user);
    }
    public void createBooking(Flight flight, User user){
        Booking booking = new Booking(user.getUserID(), flight.getFlightNumber(), flight.getDay(), (flight.getFlightNumber())+flight.getDay()+user.getUserID());
        addBooking(booking);
    }
}

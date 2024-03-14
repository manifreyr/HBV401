package is.hi.hbv401g.Bakendi;

import java.util.List;

public class BookingController {
    private BookingRepository bookingRepository;

    public void createBooking(User user, Flight flight, Seat seat) {
        String bookingID = user.getUserID() + flight.getFlightNumber();
        Booking booking = new Booking(user.getUserID(), flight.getFlightNumber(), flight.getDay(), seat.getSeatID());
        //bookingRepository.createBooking(booking);
    }
    public void deleteBooking(User user, Flight flight, Seat seat) {
        String bookingID = user.getUserID() + flight.getFlightNumber();
        Booking booking = new Booking(user.getUserID(), flight.getFlightNumber(), flight.getDay(), seat.getSeatID());
        //bookingRepository.createBooking(booking);
    }

}

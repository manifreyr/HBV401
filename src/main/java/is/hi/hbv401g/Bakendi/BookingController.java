package is.hi.hbv401g.Bakendi;

import java.util.List;

public class BookingController {
    private BookingRepository bookingRepository;

    public void createBooking(User user, Flight[] flights, String bookingID, List<Seat> seats) {
        Booking booking = new Booking(user, flights, bookingID, seats);
        //bookingRepository.createBooking(booking);
    }
    public void updateBooking(User user, Flight[] flights,String bookingID, List<Seat> seats) {
        Booking booking = new Booking(user, flights, bookingID, seats);
        //bookingRepository.updateBooking(booking);
    }
    public void deleteBooking(User user, Flight[] flights, String bookingID, List<Seat> seats) {
        Booking booking = new Booking(user, flights, bookingID, seats);
        //bookingRepository.deleteBooking(booking);
    }


}

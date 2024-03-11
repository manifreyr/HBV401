package is.hi.hbv401g.Bakendi;

public class BookingController {

    public void createBooking(User user, Flight[] flights,String bookingID,Seat[] seats) {
        Booking booking = new Booking(user, flights, bookingID, seats);
    }


}

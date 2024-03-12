package is.hi.hbv401g.Bakendi;

import java.util.List;

public class Booking {
    private User user;
    private Flight[] flights;
    private String bookingID;
    private List<Seat> seats;

    public Booking(User user, Flight[] flights, String bookingID, List<Seat> seats) {
        this.user = user;
        this.flights = flights;
        this.bookingID = bookingID;
        this.seats = seats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }


}

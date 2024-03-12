package is.hi.hbv401g.Bakendi;

import java.time.LocalDate;

public class Booking {
    private String userID;
    private String flightID;
    private LocalDate flightDay;
    private String seat;

    public Booking(String userID, String flightID, LocalDate flightDay, String seat) {
        this.userID = userID;
        this.flightID = flightID;
        this.flightDay = flightDay;
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlights(Flight flight) {
        this.flight = flight;
    }

    public String getBookingID() {
        return flightDay;
    }

    public void setBookingID(String bookingID) {
        this.flightDay = bookingID;
    }

    public Seat getSeats() {
        return seat;
    }

    public void setSeats(Seat seat) {
        this.seat = seat;
    }


}

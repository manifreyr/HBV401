package is.hi.hbv401g.Bakendi;

import java.sql.Date;
import java.time.LocalDate;

public class Booking {
    private String userID;
    private String flightID;
    private LocalDate flightDay;

    private String bookingID;

    private UserRepository userRepository = new UserRepository();

    public Booking(String userID, String flightID, LocalDate flightDay, String bookingID) {
        this.userID = userID;
        this.flightID = flightID;
        this.flightDay = flightDay;
        this.bookingID = bookingID;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public LocalDate getFlightDay() {
        return flightDay;
    }

    public void setFlightDay(LocalDate flightDay) {
        this.flightDay = flightDay;
    }


    public String getBookingID() {
        return bookingID;
    }
    public String toString() {
        return  userRepository.getUserBySSNo(userID)+ " " + flightID + " " + flightDay + " " + bookingID;
    }
}

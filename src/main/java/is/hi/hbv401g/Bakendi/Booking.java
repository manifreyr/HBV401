package is.hi.hbv401g.Bakendi;

import java.time.LocalDate;

public class Booking {
    private String userID;
    private String flightID;
    private LocalDate flightDay;
    private String seat;
    private User user;


    public Booking(String userID, String flightID, LocalDate flightDay, String seat) {
        this.userID = userID;
        this.flightID = flightID;
        this.flightDay = flightDay;
        this.seat = seat;
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
    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }



    public static void main(String[] args) {
        User user1 = new User("user1", "123456789", "John", "Doe");
        Flight flight = new Flight("OB123", "Reykjavík", "London", LocalDate.now(), 5000, 4);
        Booking booking = new Booking(user1.getUserID(), flight.getFlightNumber(), flight.getDay(), "1A");
    }

}

package is.hi.hbv401g.Bakendi;

public class User {
    private Flight[] flights;
    private Booking[] bookings;
    private int carbonEmission;
    private String userID;
    private String userName;
    public User(Flight[] flights, Booking[] bookings, int carbonEmission, String userID, String userName) {
        this.flights = flights;
        this.bookings = bookings;
        this.carbonEmission = carbonEmission;
        this.userID = userID;
        this.userName = userName;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public int getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(int carbonEmission) {
        this.carbonEmission = carbonEmission;
    }
}

package is.hi.hbv401g.Bakendi;

public class User {
    private Booking[] bookings;
    private String userID;
    private String userName;
    private String userEmail;
    public User(Booking[] bookings, String userEmail, String userID, String userName) {
        this.bookings = bookings;
        this.userEmail = userEmail;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

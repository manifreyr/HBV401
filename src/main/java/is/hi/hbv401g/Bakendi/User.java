package is.hi.hbv401g.Bakendi;

public class User {
    //private Booking[] bookings;
    private String userID;
    private String userPhone;
    private String firstName;
    private String lastName;
    public User(String userID, String userPhone, String firstName, String lastName) {
        this.userPhone = userPhone;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUserName() {
        return firstName + " " + lastName;
    }

    public void setUserName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String toString() {
        return userID + " " + userPhone + " " + firstName + " " + lastName;
    }

    public static void main(String[] args) {

    }

}

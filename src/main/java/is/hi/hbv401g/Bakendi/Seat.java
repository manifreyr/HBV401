package is.hi.hbv401g.Bakendi;

public class Seat {
    private String seatID;
    private String flightID;
    private boolean isReserved;

    public Seat(String seatID, String flightID, boolean isReserved) {
        this.seatID = seatID;
        this.flightID = flightID;
        this.isReserved = isReserved;
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void reserveSeat(Seat seat) {
        seat.setReserved(true);
    }
    public void freeSeat(Seat seat){
        seat.setReserved(false);
    }
}

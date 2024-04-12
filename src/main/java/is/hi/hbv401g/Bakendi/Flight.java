package is.hi.hbv401g.Bakendi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Flight {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private LocalDate day;
    private int price;
    private int flightDuration;
    private int departureTime;
    private int availableSeats;

    public Flight(String flightNumber, String departureCity, String arrivalCity, LocalDate day, int price, int flightDuration, int departureTime, int availableSeats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.day = day;
        this.price = price;
        this.flightDuration = flightDuration;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public String displayDepartureTime(){
        if (departureTime < 10) {
            return "0" + departureTime + ":00";
        }else {
            return departureTime + ":00";
        }
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return flightNumber + ": " + departureCity + " << " + arrivalCity + " << " + day.format(formatter)
                + "\n " + "Price " + price + " ISK " + "\n " + "Flight duration " + flightDuration + " hours"
                + "\n"  + "Departure time " + displayDepartureTime() + " hours"
                + "\n" + "Available seats " + availableSeats;
    }


}

package is.hi.hbv401g.Bakendi;

import java.time.LocalDate;

public class FlightConnect {
    private String arrivalCity;
    private String departureCity;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    public FlightConnect(String arrivalCity, String departureCity, LocalDate departureDate, LocalDate arrivalDate) {
        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
}

package is.hi.hbv401g.Mock;

import is.hi.hbv401g.Bakendi.Flight;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockFlightRepository {
    List<Flight> flights= new ArrayList<>();
    LocalDate date = LocalDate.now();

    public MockFlightRepository(){
        flights.add(new Flight("AB123", "Reykjavik", "New York", date, 30000, 6));
        flights.add(new Flight("AB124", "Reykjavik", "London", date, 15000, 3));
        flights.add(new Flight("AB125", "Reykjavik", "Paris", date, 20000, 3));
        flights.add(new Flight("AB126", "Reykjavik", "Berlin", date, 17000, 4));
        flights.add(new Flight("AB127", "Reykjavik", "Copenhagen", date, 12000, 2));
        flights.add(new Flight("AB128", "Reykjavik", "Amsterdam", date, 20000, 3));
    }
    public List<Flight> getAllFlights(){
        return flights;
    }
    public void addFlight(Flight flight){
        flights.add(flight);
    }

}

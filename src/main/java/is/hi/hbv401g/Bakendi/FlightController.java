package is.hi.hbv401g.Bakendi;

import is.hi.hbv401g.Mock.MockFlightRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlightController {
    private MockFlightRepository mockFlightRepository = new MockFlightRepository();

    public void createFlight(Flight flight){
        mockFlightRepository.addFlight(flight);
    }
    public void updateFlightDate(Flight flight, LocalDate date){
        flight.setDay(date);
    }
    public void updateFlightPrice(Flight flight, int price){
        flight.setPrice(price);
    }
    public Flight getFlightByNumber(String flightNumber){
        for(Flight flight: mockFlightRepository.getAllFlights()){
            if(flight.getFlightNumber().equals(flightNumber)){
                return flight;
            }
        }
        return null;
    }
    public List<Flight> getFlightsByDate(LocalDate date){
        List<Flight> flights = new ArrayList<>();
        for(Flight flight: mockFlightRepository.getAllFlights()){
            if(flight.getDay().equals(date)){
                flights.add(flight);
            }
        }
        return flights;
    }
    public List<Flight> getAllFlights(){
        return mockFlightRepository.getAllFlights();
    }
    public List<Flight> getFlightsByDepartureCity(String departureCity){
        List<Flight> flights = new ArrayList<>();
        for(Flight flight: mockFlightRepository.getAllFlights()){
            if(flight.getDepartureCity().equals(departureCity)){
                flights.add(flight);
            }
        }
        return flights;
    }
    public List<Flight> getFlightsByArrivalCity(String arrivalCity){
        List<Flight> flights = new ArrayList<>();
        for(Flight flight: mockFlightRepository.getAllFlights()){
            if(flight.getArrivalCity().equals(arrivalCity)){
                flights.add(flight);
            }
        }
        return flights;
    }
    public boolean flightExists(Flight flight){
        for(Flight f: mockFlightRepository.getAllFlights()){
            if(f.getFlightNumber().equals(flight.getFlightNumber())){
                return true;
            }
        }
        return false;
    }
    public void sortFlightsByPrice(List<Flight> flights){
        flights.sort(Comparator.comparingInt(Flight::getPrice));
    }
    public void sortFlightsByDate(List<Flight> flights){
        flights.sort(Comparator.comparing(Flight::getDay));
    }
    public void sortFlightsByDepartureCity(List<Flight> flights){
        flights.sort(Comparator.comparing(Flight::getDepartureCity));
    }
    public void sortFlightsByArrivalCity(List<Flight> flights){
        flights.sort(Comparator.comparing(Flight::getArrivalCity));
    }
}

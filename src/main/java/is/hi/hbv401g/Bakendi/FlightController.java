package is.hi.hbv401g.Bakendi;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlightController {
    private final FlightRepository flightRepository = new FlightRepository();

    public void createFlight(Flight flight) throws SQLException {
        flightRepository.addFlight(flight);
    }

    public void updateFlightDate(Flight flight, LocalDate date) {
        flight.setDay(date);
    }

    public void updateFlightPrice(Flight flight, int price) {
        flight.setPrice(price);
    }

    public Flight getFlightByNumber(String flightNumber) throws SQLException {
        for (Flight flight : flightRepository.getAllFlights()) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public List<Flight> getFlightsByDate(LocalDate date) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        for (Flight flight : flightRepository.getAllFlights()) {
            if (flight.getDay().equals(date)) {
                flights.add(flight);
            }
        }
        return flights;
    }

    public List<Flight> getAllFlights() throws SQLException {
        return flightRepository.getAllFlights();
    }

    public List<Flight> getFlightsByDepartureCity(String departureCity) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        for (Flight flight : flightRepository.getAllFlights()) {
            if (flight.getDepartureCity().equals(departureCity)) {
                flights.add(flight);
            }
        }
        return flights;
    }

    public List<Flight> getFlightsByArrivalCity(String arrivalCity) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        for (Flight flight : flightRepository.getAllFlights()) {
            if (flight.getArrivalCity().equals(arrivalCity)) {
                flights.add(flight);
            }
        }
        return flights;
    }

    public boolean flightExists(Flight flight) throws SQLException {
        for (Flight f : flightRepository.getAllFlights()) {
            if (f.getFlightNumber().equals(flight.getFlightNumber())) {
                return true;
            }
        }
        return false;
    }

    public List<Flight> sortFlightsByPrice(List<Flight> flights) {
        flights.sort(Comparator.comparingInt(Flight::getPrice));
        return flights;
    }

    public void sortFlightsByDate(List<Flight> flights) {
        flights.sort(Comparator.comparing(Flight::getDay));
    }

    public void sortFlightsByDepartureCity(List<Flight> flights) {
        flights.sort(Comparator.comparing(Flight::getDepartureCity));
    }

    public void sortFlightsByArrivalCity(List<Flight> flights) {
        flights.sort(Comparator.comparing(Flight::getArrivalCity));
    }

    public void deleteFlight(Flight flight) {
        flightRepository.deleteFlight(flight);
    }

    public List<String> getAllDepartures() throws SQLException {
        List<String> departures = new ArrayList<>();
        for (Flight flight : flightRepository.getAllFlights()) {
            if (!departures.contains(flight.getDepartureCity())) {
                departures.add(flight.getDepartureCity());
            }
        }
        return departures;
    }

    public List<String> getAllArrivals() throws SQLException {
        List<String> arrivals = new ArrayList<>();
        for (Flight flight : flightRepository.getAllFlights()) {
            if (!arrivals.contains(flight.getArrivalCity())) {
                arrivals.add(flight.getArrivalCity());
            }
        }
        return arrivals;
    }
    public List<Flight> returnAvailableFlights(FlightConnect flightConnect) throws SQLException {
        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight : flightRepository.getAllFlights()) {
            if (flight.getDepartureCity().equals(flightConnect.getDepartureCity()) && flight.getArrivalCity().equals(flightConnect.getArrivalCity()) && flight.getDay().equals(flightConnect.getDepartureDate())) {
                availableFlights.add(flight);
            }
        }
        return availableFlights;
    }
    public static void main(String[] args) throws SQLException {
        FlightConnect flightConnect = new FlightConnect("New York", "Reykjavik", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 1));
        FlightController flightController = new FlightController();
        System.out.print(flightController.returnAvailableFlights(flightConnect));
    }

}

package is.hi.hbv401g.Mock;

import is.hi.hbv401g.Bakendi.Flight;
import is.hi.hbv401g.Bakendi.FlightController;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FlightControllerTest {
    MockFlightRepository mockFlightRepository;
    private FlightController flightController;
    private Flight flight;
    private final int listLength = 7;
    @Before
    public void setUp() {
        mockFlightRepository = new MockFlightRepository();
        this.flightController = new FlightController();
        this.flight = new Flight("OB123", "Reykjavik", "Moscow", LocalDate.now(), 40000, 8);
        flightController.createFlight(flight);
    }
    @Test
    public void testCreateFlight() {
        flightController.createFlight(flight);
        assertTrue(flightController.flightExists(flight));
    }
    @Test
    public void testFindByNumber() {
        Flight flightByNumber = flightController.getFlightByNumber("OB123");
        assertEquals(flightByNumber, flight);
    }
    @Test
    public void testGetFlightsByDate() {
        List<Flight> flightsByDate = flightController.getFlightsByDate(LocalDate.now());
        assertTrue(flightsByDate.contains(flight));
    }

    @Test
    public void testUpdateFlightDate() {
        LocalDate newDate = LocalDate.of(2021, 12, 12);
        flightController.updateFlightDate(flight, newDate);
        assertEquals(newDate, flight.getDay());
    }
    @Test
    public void testUpdateFlightPrice() {
        int newPrice = 50000;
        flightController.updateFlightPrice(flight, newPrice);
        assertEquals(newPrice, flight.getPrice());
    }
    @Test
    public void testGetFlightsByDepartureCity() {
        List<Flight> flightsByDepartureCity = flightController.getFlightsByDepartureCity("Reykjavik");
        assertEquals(listLength, flightsByDepartureCity.size());
    }
    @Test
    public void testGetFlightsByArrivalCity() {
        List<Flight> flightsByArrivalCity = flightController.getFlightsByArrivalCity("Moscow");
        assertEquals(flight.getArrivalCity(), flightsByArrivalCity.get(0).getArrivalCity());
    }
    @Test
    public void testSortFlightsByPrice() {
        List<Flight> flightsByPrice = mockFlightRepository.getAllFlights();
        flightController.sortFlightsByPrice(flightsByPrice);
        assertEquals(12000, flightsByPrice.get(0).getPrice());
        assertEquals(15000, flightsByPrice.get(1).getPrice());
        assertEquals(17000, flightsByPrice.get(2).getPrice());
        assertEquals(20000, flightsByPrice.get(3).getPrice());
        assertEquals(20000, flightsByPrice.get(4).getPrice());
        assertEquals(30000, flightsByPrice.get(5).getPrice());
    }
    @Test
    public void testSortFlightsByDate() {
       Flight flight1 = new Flight("OB123", "Reykjavik", "Moscow", LocalDate.of(2024, 6, 17), 40000, 8);
       Flight flight2 = new Flight("OB124", "Reykjavik", "London", LocalDate.of(2024, 6, 18), 40000, 3);
       Flight flight3 = new Flight("OB125", "Reykjavik", "Paris", LocalDate.of(2024, 6, 19), 40000, 4);
       Flight flight4 = new Flight("OB126", "Reykjavik", "Berlin", LocalDate.of(2024, 6, 20), 40000, 5);

       List<Flight> flightsByDate = new ArrayList<>();
       flightsByDate.add(flight4);
       flightsByDate.add(flight3);
       flightsByDate.add(flight2);
       flightsByDate.add(flight1);

       flightController.sortFlightsByDate(flightsByDate);

       assertEquals(LocalDate.of(2024, 6, 17), flightsByDate.get(0).getDay());
       assertEquals(LocalDate.of(2024, 6, 18), flightsByDate.get(1).getDay());
       assertEquals(LocalDate.of(2024, 6, 19), flightsByDate.get(2).getDay());
       assertEquals(LocalDate.of(2024, 6, 20), flightsByDate.get(3).getDay());
    }
}

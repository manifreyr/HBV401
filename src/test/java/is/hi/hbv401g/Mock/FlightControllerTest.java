package is.hi.hbv401g.Mock;

import is.hi.hbv401g.Bakendi.Flight;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
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
}

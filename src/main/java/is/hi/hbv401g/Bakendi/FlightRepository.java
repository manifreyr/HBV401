package is.hi.hbv401g.Bakendi;

import java.sql.Connection;
import java.util.List;

public class FlightRepository {
    Connection connection = DatabaseConnector.connect();

    public List<Flight> getAllFlights() {
        String sql = "SELECT * FROM Flight";


    }

}

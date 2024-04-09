package is.hi.hbv401g.Framendi;
import is.hi.hbv401g.Bakendi.*;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private ListView<Flight> Fxflights; //Listi með flugum
    private FlightRepository flightRepository = new FlightRepository();

    public void initialize()throws SQLException{
        Fxflights.setItems(flightRepository.getAllFlights());
    }
    public static void main(String[] args) throws SQLException {

    }
}

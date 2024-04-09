package is.hi.hbv401g.Framendi;
import is.hi.hbv401g.Bakendi.*;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.FXPermission;

public class Controller {

    @FXML
    private ListView<Flight> fxFlights; //Listi með flugum

    private final FlightRepository flightRepository = new FlightRepository();

    public void initialize() throws SQLException{
        ObservableList<Flight> observableFlightList = FXCollections.observableArrayList(flightRepository.getAllFlights());
        fxFlights.setItems(observableFlightList);
    }
    public static void main(String[] args) throws SQLException {

    }
}

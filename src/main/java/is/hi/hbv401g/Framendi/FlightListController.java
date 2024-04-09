package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.Flight;
import is.hi.hbv401g.Bakendi.FlightController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;

public class FlightListController {
    private forsidaController fController;
    @FXML
    private ListView<Flight> fxFlights;

    private final FlightController flightController = new FlightController();
    public void initialize() throws SQLException {
        fController = (forsidaController) ViewSwitcher.lookup(View.OPNA);
        ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(flightController.returnAvailableFlights(fController.getFlightConnect()));
        fxFlights.setItems(flightObservableList);
    }



}

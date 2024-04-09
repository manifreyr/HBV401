package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.Flight;
import is.hi.hbv401g.Bakendi.FlightController;
import is.hi.hbv401g.Bakendi.FlightView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.SQLException;

public class FlightListController {
    private forsidaController fController;
    private ListView<Flight> fxFlights;

    private final FlightController flightController = new FlightController();
    public void initialize() throws SQLException {
        fController = (forsidaController) ViewSwitcher.lookup(View.OPNA);
        ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(flightController.returnAvailableFlights(fController.getFlightView()));
        System.out.println(flightController.returnAvailableFlights(fController.getFlightView()));
        fxFlights.setItems(flightObservableList);
    }

}

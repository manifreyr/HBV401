package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.Flight;
import is.hi.hbv401g.Bakendi.FlightController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;

import java.sql.SQLException;

public class FlightListController {
    private forsidaController fController;
    @FXML
    private ListView<Flight> fxFlights;
    @FXML
    private MenuButton fxSort;
    private final FlightController flightController = new FlightController();
    public void initialize() throws SQLException {
        fController = (forsidaController) ViewSwitcher.lookup(View.OPNA);
        ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(flightController.returnAvailableFlights(fController.getOutBoundConnect()));
        fxFlights.setItems(flightObservableList);
    }
    public void nextScene(ActionEvent event){
        ViewSwitcher.switchTo(View.RETURN);
    }
    public void pastScene(ActionEvent event){
        ViewSwitcher.switchTo(View.OPNA);
    }
    public void sortLowHigh(ActionEvent event){
        fxSort.setText("Price: Low to high");
        ObservableList<Flight> currentFlights = fxFlights.getItems();
        ObservableList<Flight> sortedFlights = FXCollections.observableArrayList(flightController.sortFlightsByPrice(currentFlights));
        fxFlights.setItems(sortedFlights);
    }
    public void sortHighLow(ActionEvent event){
        fxSort.setText("Price: High to low");
        ObservableList<Flight> currentFlights = fxFlights.getItems();
        ObservableList<Flight> sortedFlights = FXCollections.observableArrayList(flightController.sortFlightsByPrice(currentFlights));
        fxFlights.setItems(sortedFlights);
    }

    public void sortDefault(ActionEvent event) throws SQLException {
        fxSort.setText("Sort by");
        fController = (forsidaController) ViewSwitcher.lookup(View.OPNA);
        ObservableList<Flight> flightObservableList = FXCollections.observableArrayList(flightController.returnAvailableFlights(fController.getOutBoundConnect()));
        fxFlights.setItems(flightObservableList);
    }

    @FXML
    void pastScene(ActionEvent event) {
        ViewSwitcher.switchTo(View.OPNA);
    }
    @FXML
    void nextScene(ActionEvent event) {
        ViewSwitcher.switchTo(View.DETAIL);
    }





}

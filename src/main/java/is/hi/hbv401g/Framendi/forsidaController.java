package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.FlightController;
import is.hi.hbv401g.Bakendi.FlightConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class forsidaController {

    @FXML
    private DatePicker fxArrivalDate;
    @FXML
    private DatePicker fxDepartureDate;
    @FXML
    private ComboBox<String> fxFrom; //Listi með flugum
    @FXML
    private ComboBox<String> fxTo;
    private final FlightController flightController = new FlightController();
    private FlightConnect flightConnect;

    public void initialize() throws SQLException {
        ObservableList<String> departureObservableList = FXCollections.observableArrayList(flightController.getAllDepartures());
        ObservableList<String> arrivalObservableList = FXCollections.observableArrayList(flightController.getAllArrivals());
        fxFrom.setItems(departureObservableList);
        fxTo.setItems(arrivalObservableList);
    }
    @FXML
    void felaArrivalDate(MouseEvent event) {
        fxArrivalDate.setVisible(!fxArrivalDate.isVisible());
    }
    @FXML
    void nextScene(ActionEvent event) {
        System.out.println(fxTo.getValue() + fxDepartureDate.getValue());
        flightConnect = new FlightConnect(fxTo.getValue(), fxFrom.getValue(), fxDepartureDate.getValue(),  fxArrivalDate.getValue());
        ViewSwitcher.switchTo(View.FLIGHT);
    }
    public FlightConnect getFlightConnect(){
        return flightConnect;
    }


}

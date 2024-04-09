package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.Flight;
import is.hi.hbv401g.Bakendi.FlightController;
import is.hi.hbv401g.Bakendi.FlightRepository;
import is.hi.hbv401g.Bakendi.FlightView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.time.LocalDate;

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
    private FlightView flightView;

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
        flightView = new FlightView(fxTo.getValue(), fxFrom.getValue(), fxDepartureDate.getValue(),  fxArrivalDate.getValue());
        ViewSwitcher.switchTo(View.FLIGHT);
    }
    public FlightView getFlightView(){
        return flightView;
    }


}

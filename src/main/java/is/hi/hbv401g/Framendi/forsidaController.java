package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.List;

public class forsidaController {

    @FXML
    private DatePicker fxArrivalDate;
    @FXML
    private DatePicker fxDepartureDate;
    @FXML
    private CheckBox fxCheckbox;
    @FXML
    private ComboBox<String> fxFrom; //Listi með flugum
    @FXML
    private ComboBox<String> fxTo;
    @FXML
    private TextField fxSSN;

    @FXML
    private Button fxBookingSearch;
    private final FlightController flightController = new FlightController();
    private BookingRepository bookingRepository = new BookingRepository();
    private FlightConnect outBoundConnect;
    private FlightConnect returnConnect;
    private List<Booking> searchedBookings;
    private String SSN;


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
        if(fxCheckbox.isSelected()){
            outBoundConnect = new FlightConnect(fxTo.getValue(), fxFrom.getValue(), fxDepartureDate.getValue(),  fxArrivalDate.getValue());
            returnConnect = new FlightConnect(fxFrom.getValue(), fxTo.getValue(), fxArrivalDate.getValue(),  fxDepartureDate.getValue());
            ViewSwitcher.switchTo(View.FLIGHT);
        }
        else{
            outBoundConnect = new FlightConnect(fxTo.getValue(), fxFrom.getValue(), fxDepartureDate.getValue(),  fxArrivalDate.getValue());
            ViewSwitcher.switchTo(View.FLIGHT);
        }
    }
    public FlightConnect getOutBoundConnect(){
        return outBoundConnect;
    }
    public FlightConnect getReturnConnect(){
        return returnConnect;
    }
    public boolean isCheckBoxSelected(){
        return fxCheckbox.isSelected();
    }
    public void bookingSearch(ActionEvent event) throws SQLException {
        SSN = fxSSN.getText();
        searchedBookings = bookingRepository.getBookingsByUserID(SSN);
        ViewSwitcher.switchTo(View.BOOKINGSEARCH);
    }
    public List<Booking> getSearchedBookings(){
        return searchedBookings;
    }
    public void clear(){
        fxDepartureDate.setValue(null);
        fxArrivalDate.setValue(null);
        fxFrom.getSelectionModel().clearSelection();
        fxTo.getSelectionModel().clearSelection();
        fxFrom.setPromptText("Outbound destination");
        fxTo.setPromptText("Arrival destination");
    }
    public void clearSSN(){
        fxSSN.setText("");
    }

}

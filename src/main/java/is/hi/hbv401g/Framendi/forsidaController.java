package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.Flight;
import is.hi.hbv401g.Bakendi.FlightRepository;
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

public class forsidaController {

    @FXML
    private DatePicker arrivalDate;
    @FXML
    private ComboBox<String> fxFrom; //Listi með flugum


    private FlightRepository flightRepository = new FlightRepository();


    public void initialize() throws SQLException {
        //ObservableList<String> flightObservableList = FXCollections.observableArrayList(flightRepository.getAllFlights());
        //fxFrom.setItems(flightObservableList);
    }
    @FXML
    void felaArrivalDate(MouseEvent event) {
        if (arrivalDate.isVisible() == false) {
            arrivalDate.setVisible(true);
        } else {
            arrivalDate.setVisible(false);
        }
    }
    @FXML
    void nextScene(ActionEvent event) {
        System.out.print("smellt á takka");
        ViewSwitcher.switchTo(View.DETAIL);

    }


}

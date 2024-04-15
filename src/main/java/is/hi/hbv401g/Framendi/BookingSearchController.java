package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.Booking;
import is.hi.hbv401g.Bakendi.BookingRepository;
import is.hi.hbv401g.Bakendi.FlightController;
import is.hi.hbv401g.Bakendi.FlightRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;

public class BookingSearchController {
    @FXML
    private ListView<Booking> fxBookings;
    private final BookingRepository bookingRepository = new BookingRepository();
    private final FlightRepository flightRepository = new FlightRepository();
    private FlightController flightController = new FlightController();
    private forsidaController fController;
    private ObservableList<Booking> bookings;

    public void initialize(){
        fController = (forsidaController) ViewSwitcher.lookup(View.OPNA);
        bookings = FXCollections.observableArrayList(fController.getSearchedBookings());
        fxBookings.setItems(bookings);
    }

    public void pastScene(ActionEvent event){
        ViewSwitcher.switchTo(View.OPNA);
    }
    public void delete(ActionEvent event) throws SQLException {
        flightRepository.increaseAvailableSeats(flightController.getFlightByNumber(fxBookings.getSelectionModel().getSelectedItem().getFlightID()));
        bookingRepository.deleteBooking(fxBookings.getSelectionModel().getSelectedItem());
        bookings.remove(fxBookings.getSelectionModel().getSelectedItem());
        fxBookings.setItems(bookings);
    }
}

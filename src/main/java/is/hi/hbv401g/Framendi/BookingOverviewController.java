package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.Booking;
import is.hi.hbv401g.Bakendi.BookingRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class BookingOverviewController {
    @FXML
    private ListView<Booking> fxBookings;
    private final BookingRepository bookingRepository = new BookingRepository();
    private forsidaController fController;
    public void initialize(){
        fController = (forsidaController) ViewSwitcher.lookup(View.OPNA);
        ObservableList<Booking> bookings = FXCollections.observableArrayList(fController.getSearchedBookings());
        fxBookings.setItems(bookings);
    }

    public void pastScene(ActionEvent event){
        ViewSwitcher.switchTo(View.OPNA);
    }
    public void delete(ActionEvent event){
        bookingRepository.deleteBooking(fxBookings.getSelectionModel().getSelectedItem());
    }
}

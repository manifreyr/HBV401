package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.util.List;

public class FinalReturnController {
    @FXML
    private Label fxName;
    @FXML
    private Label fxSSN;
    @FXML
    private Label fxPhone;
    @FXML
    private Label fxOutBoundNr;
    @FXML
    private Label fxOutBoundDur;
    @FXML
    private Label fxOutBoundDep;
    @FXML
    private Label fxOutBoundArr;
    @FXML
    private Label fxOutBoundPrice;
    @FXML
    private Label fxOutBoundDate;
    @FXML
    private Label fxTotalPrice;
    @FXML
    private Label fxReturnNr;
    @FXML
    private Label fxReturnDur;
    @FXML
    private Label fxReturnDep;
    @FXML
    private Label fxReturnArr;
    @FXML
    private Label fxReturnPrice;
    @FXML
    private Label fxReturnDate;
    @FXML
    private MenuButton fxPassengerSelection;

    private PassengerController pController;
    private FlightListController fController;
    private ReturnController rController;
    private ForsidaController forsidaController;
    private UserRepository userRepository = new UserRepository();
    private FlightRepository flightRepository = new FlightRepository();
    private BookingController bookingController = new BookingController();
    private BookingRepository bookingRepository = new BookingRepository();

    private List<User> users;

    public void initialize(){
        forsidaController = (ForsidaController) ViewSwitcher.lookup(View.OPNA);
        pController = (PassengerController) ViewSwitcher.lookup(View.DETAIL);
        fController = (FlightListController) ViewSwitcher.lookup(View.FLIGHT);
        rController = (ReturnController) ViewSwitcher.lookup(View.RETURN);
        users = pController.getAddedUsers();
        setData();
        for(int i=1; i<=users.size(); i++){
            MenuItem item = new MenuItem(String.valueOf(i));
            item.setOnAction(event -> changeUser(item));
            fxPassengerSelection.getItems().add(item);
        }
    }
    public void setData(){
        fxName.setText(users.get(0).getFirstName() + " " + users.get(0).getLastName());
        fxPhone.setText(users.get(0).getUserPhone());
        fxSSN.setText(users.get(0).getUserID());

        fxOutBoundArr.setText(fController.getSelectedOutBoundFlight().getArrivalCity());
        fxOutBoundDep.setText(fController.getSelectedOutBoundFlight().getDepartureCity());
        fxOutBoundDate.setText(fController.getSelectedOutBoundFlight().getDay().toString());
        fxOutBoundDur.setText(String.valueOf(fController.getSelectedOutBoundFlight().getFlightDuration()) + " Hours");
        fxOutBoundPrice.setText(String.valueOf(fController.getSelectedOutBoundFlight().getPrice()) + " ISK");
        fxOutBoundNr.setText(fController.getSelectedOutBoundFlight().getFlightNumber());
        fxOutBoundPrice.setText(String.valueOf(fController.getSelectedOutBoundFlight().getPrice()));

        fxReturnArr.setText(rController.getSelectedReturnFlight().getArrivalCity());
        fxReturnDep.setText(rController.getSelectedReturnFlight().getDepartureCity());
        fxReturnDate.setText(rController.getSelectedReturnFlight().getDay().toString());
        fxReturnDur.setText(String.valueOf(rController.getSelectedReturnFlight().getFlightDuration()));
        fxReturnPrice.setText(String.valueOf(rController.getSelectedReturnFlight().getPrice()) + " ISK");
        fxReturnNr.setText(rController.getSelectedReturnFlight().getFlightNumber());

        fxTotalPrice.setText(String.valueOf(fController.getSelectedOutBoundFlight().getPrice() +
                rController.getSelectedReturnFlight().getPrice()) + " ISK");
    }
    public void pastScene(ActionEvent event){
        ViewSwitcher.switchTo(View.DETAIL);
    }
    public void confirm(ActionEvent event){
        for(User user : users){
            userRepository.addUser(user);
            flightRepository.decreaseAvailableSeats(fController.getSelectedOutBoundFlight());
            bookingController.createBooking(fController.getSelectedOutBoundFlight(), user);
        }
    dialog();

    }
    public void frontPage(){
        forsidaController.clear();
        ViewSwitcher.switchTo(View.OPNA);
    }
    public void dialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Confirmation");
        alert.setHeaderText(null);  // No header text
        alert.setContentText(dialogText());

        alert.showAndWait();
    }
    public String dialogText() {
        StringBuilder message = new StringBuilder();
        if(users.size() == 1){
            message.append("You have confirmed a booking for:").append("\n");
        }
        else{
            message.append("You have confirmed bookings for:").append("\n");
        }
        if (users.size() == 1) {
            message.append(users.get(0).getUserName()).append("\n").append("Booking ID: ")
                    .append(bookingRepository.getBookingByFlightNrAndUserSSNo(fController.getSelectedOutBoundFlight().getFlightNumber(),users.get(0).getUserID()).getBookingID());
        } else {
            for (User user : users) {
                message.append(user.getUserName()).append("\n").append("Booking ID: ")
                        .append(bookingRepository.getBookingByFlightNrAndUserSSNo(fController.getSelectedOutBoundFlight().getFlightNumber(), user.getUserID()).getBookingID()).append("\n").append("\n");
            }
        }
        return message.toString();
    }
    public void changeUser(MenuItem item){
        fxName.setText(users.get(Integer.parseInt(item.getText()) - 1).getFirstName() + " " + users.get(Integer.parseInt(item.getText()) - 1).getLastName());
        fxPhone.setText(users.get(Integer.parseInt(item.getText()) - 1).getUserPhone());
        fxSSN.setText(users.get(Integer.parseInt(item.getText()) - 1).getUserID());
    }

}

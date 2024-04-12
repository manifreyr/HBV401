package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

    private passengerController pController;
    private FlightListController fController;
    private ReturnController rController;
    private UserRepository userRepository = new UserRepository();

    public void initialize(){
        pController = (passengerController) ViewSwitcher.lookup(View.DETAIL);
        fController = (FlightListController) ViewSwitcher.lookup(View.FLIGHT);
        rController = (ReturnController) ViewSwitcher.lookup(View.RETURN);
        setData();
    }
    public void setData(){
        fxName.setText(pController.getAddedUser().getFirstName() + " " + pController.getAddedUser().getLastName());
        fxPhone.setText(pController.getAddedUser().getUserPhone());
        fxSSN.setText(pController.getAddedUser().getUserID());

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
    public void nextScene(ActionEvent event){
        userRepository.addUser(pController.getAddedUser());
    }

}

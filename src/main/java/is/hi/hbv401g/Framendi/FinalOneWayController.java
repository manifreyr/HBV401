package is.hi.hbv401g.Framendi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FinalOneWayController {
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
    private passengerController pController;
    private FlightListController fController;

    public void initialize(){
        pController = (passengerController) ViewSwitcher.lookup(View.DETAIL);
        fController = (FlightListController) ViewSwitcher.lookup(View.FLIGHT);
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
        fxTotalPrice.setText(String.valueOf(fController.getSelectedOutBoundFlight().getPrice()) + " ISK");
    }
    public void pastScene(ActionEvent event){
        ViewSwitcher.switchTo(View.DETAIL);
    }
    public void nextScene(ActionEvent event){

    }
}

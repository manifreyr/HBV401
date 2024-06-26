package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class PassengerController {

    @FXML
    private TextField fxFirstName;
    @FXML
    private TextField fxLastName;
    @FXML
    private TextField fxPhone;
    @FXML
    private Label fxPassengerNumber;
    @FXML
    private TextField fxSSN;
    private List<User> addedUsers = new ArrayList<>();
    private ForsidaController fController;

    private final UserRepository userRepository= new UserRepository();
    private int passengerCounter;

    public void initialize(){
        fController = (ForsidaController) ViewSwitcher.lookup(View.OPNA);
        passengerCounter = 1;
    }

    @FXML
    void saveUserInfo(ActionEvent event) {
        addedUsers.add(new User(fxSSN.getText(), fxPhone.getText(), fxFirstName.getText(), fxLastName.getText()));
        passengerCounter++;

        if(fController.isCheckBoxSelected()){
            ViewSwitcher.switchTo(View.FINALRETURN);
        }
        else{
            ViewSwitcher.switchTo(View.FINALONEWAY);
        }
    }
    @FXML
    void pastScene(ActionEvent event){
        ViewSwitcher.switchTo(View.FLIGHT);
    }
    public void addPassenger(ActionEvent event){
        addedUsers.add(new User(fxSSN.getText(), fxPhone.getText(), fxFirstName.getText(), fxLastName.getText()));
        reset();
        passengerCounter++;
        fxPassengerNumber.setText(String.valueOf(passengerCounter));
    }
    public List<User> getAddedUsers(){
        return addedUsers;
    }
    public void reset(){
        fxPhone.setText("");
        fxSSN.setText("");
        fxFirstName.setText("");
        fxLastName.setText("");
    }
    public int getNumPassengers(){
        return passengerCounter;
    }
}


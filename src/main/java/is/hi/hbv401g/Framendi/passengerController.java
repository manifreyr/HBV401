package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.List;

public class passengerController {

    @FXML
    private TextField fxFirstName;
    @FXML
    private TextField fxLastName;
    @FXML
    private TextField fxPhone;
    @FXML
    private TextField fxSSN;
    private User addedUser;
    private forsidaController fController;

    private final UserRepository userRepository= new UserRepository();

    public void initialize(){
        fController = (forsidaController) ViewSwitcher.lookup(View.OPNA);
    }

    @FXML
    void saveUserInfo(ActionEvent event) {
        addedUser = new User(fxSSN.getText(), fxPhone.getText(), fxFirstName.getText(), fxLastName.getText());
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
    public User getAddedUser(){
        return addedUser;
    }
}


package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Bakendi.User;
import is.hi.hbv401g.Bakendi.UserRepository;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import javax.swing.*;
import java.util.ArrayList;

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

    private final UserRepository userRepository= new UserRepository();

    @FXML
    void saveUserInfo(ActionEvent event) {
        User user = new User(fxSSN.getText(), fxPhone.getText(), fxFirstName.getText(), fxLastName.getText());
        userRepository.addUser(user);
        addedUser = user;
        ViewSwitcher.switchTo(View.FINAL);
    }
    @FXML
    void pastScene(ActionEvent event){
        ViewSwitcher.switchTo(View.FLIGHT);
    }
    public User getAddedUser(){
        return addedUser;
    }
}


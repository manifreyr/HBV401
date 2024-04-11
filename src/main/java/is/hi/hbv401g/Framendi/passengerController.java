package is.hi.hbv401g.Framendi;

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
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phone;
    @FXML
    private TextField ssn;

    @FXML
    void saveUserInfo(ActionEvent event) {

        String first = firstName.getText();
        String last = lastName.getText();
        String phoneNumber = phone.getText();
        String ssnNumber = ssn.getText();


        ViewSwitcher.switchTo(View.FINAL);
    }
    @FXML
    void pastScene(ActionEvent event){
        ViewSwitcher.switchTo(View.FLIGHT);
    }
}


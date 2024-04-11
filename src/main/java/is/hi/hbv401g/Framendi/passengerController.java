package is.hi.hbv401g.Framendi;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;

import javax.swing.*;

public class passengerController {

    @FXML
    void pastScene(ActionEvent event) {
        ViewSwitcher.switchTo(View.OPNA);
    }

    @FXML
    void nextScene(ActionEvent event) {
        ViewSwitcher.switchTo(View.FLIGHT);
    }



    @FXML TabPane tabPane;
    @FXML Tab passenger1;
    @FXML
    private Label numPassengers;
    private int passengerCount = 1;


    @FXML
    public void plusPassenger(ActionEvent event){
        passengerCount++;
        updatePassengerCount();
        cloneGrid();
        System.out.print("nýr tab");
    }
    @FXML
    void minusPassenger(ActionEvent event) {
        if (passengerCount > 1) {
            passengerCount--;
            updatePassengerCount();
            ObservableList<Tab> tabs = tabPane.getTabs();
            Tab lastTab = tabs.get(tabs.size() - 1);
            tabs.remove(lastTab);
            System.out.print(" kúkapiss ");
        }


    }
    private void updatePassengerCount() {
        numPassengers.setText(String.valueOf(passengerCount));
    }
    private void cloneGrid(){
        Tab newTab = new Tab("Passenger" + passengerCount);

        GridPane clonedGridPane = new GridPane();
        clonedGridPane.getChildren().addAll(passenger1.getContent());

        newTab.setContent(clonedGridPane);
        tabPane.getTabs().add(newTab);

        //velur nýjasta tabinn
        tabPane.getSelectionModel().select(newTab);
    }









}

package is.hi.hbv401g.Framendi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class passengerController {

    @FXML
    void pastScene(ActionEvent event) {
        System.out.print("smellt á takka");
        ViewSwitcher.switchTo(View.OPNA);
    }

    @FXML
    void nextScene(ActionEvent event) {
        System.out.print("smellt á takka");
        ViewSwitcher.switchTo(View.FLIGHT);
    }





}

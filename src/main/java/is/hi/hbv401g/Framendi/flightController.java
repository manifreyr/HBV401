package is.hi.hbv401g.Framendi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class flightController {

    @FXML
    void pastScene(ActionEvent event) {
        System.out.print("smellt á takka");
        ViewSwitcher.switchTo(View.DETAIL);
    }

}

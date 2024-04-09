package is.hi.hbv401g.Framendi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class forsidaController {

    @FXML
    private DatePicker arrivalDate;

    @FXML
    void felaArrivalDate(MouseEvent event) {
        if (arrivalDate.isVisible() == false) {
            arrivalDate.setVisible(true);
        } else {
            arrivalDate.setVisible(false);
        }
    }

    @FXML
    void nextScene(ActionEvent event) {
        System.out.print("smellt á takka");
        ViewSwitcher.switchTo(View.DETAIL);
    }

}


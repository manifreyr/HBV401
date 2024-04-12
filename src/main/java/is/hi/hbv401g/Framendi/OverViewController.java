package is.hi.hbv401g.Framendi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.w3c.dom.Text;

public class OverViewController {
    @FXML
    private Label fxUser;
    private passengerController controller;

    public void initialize(){
        controller = (passengerController) ViewSwitcher.lookup(View.DETAIL);
        fxUser.setText(controller.getAddedUser().toString());
    }
}

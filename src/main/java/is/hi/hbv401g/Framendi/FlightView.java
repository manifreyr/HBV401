package is.hi.hbv401g.Framendi;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class FlightView extends VBox {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FlightView.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

}

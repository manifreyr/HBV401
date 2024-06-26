package is.hi.hbv401g.Framendi;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

import java.io.IOException;


public class FlightView extends VBox {
    public FlightView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FlightView.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

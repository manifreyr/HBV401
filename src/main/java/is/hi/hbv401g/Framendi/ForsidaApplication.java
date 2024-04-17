package is.hi.hbv401g.Framendi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ForsidaApplication extends Application {
  @Override
    public void start(Stage stage) throws IOException {
      Scene scene = new Scene( new Pane(), 380,460  );
      ViewSwitcher.setScene(scene);
      ViewSwitcher.switchTo(View.OPNA);
      stage.setScene(scene);
      stage.setTitle("Flight Booking");
      stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}

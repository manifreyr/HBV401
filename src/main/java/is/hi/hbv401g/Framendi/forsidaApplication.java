package is.hi.hbv401g.Framendi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class forsidaApplication extends Application {
  @Override
    public void start(Stage stage) throws IOException {
      //FXMLLoader loader = new FXMLLoader(forsidaApplication.class.getResource("/is.hi.hbvg401g.Framendi/Forsida.fxml"));
      Scene scene = new Scene( new Pane(), 380,460  );
      ViewSwitcher.setScene(scene);
      ViewSwitcher.switchTo(View.OPNA);
      stage.setScene(scene);
      stage.setTitle("forsíða");
      stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}

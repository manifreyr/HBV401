package is.hi.hbv401g.Framendi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class forsidaApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(forsidaApplication.class.getResource("Forsida.fxml"));
        Scene scene = new Scene( loader.load() );
        stage.setScene(scene);
        stage.show();
    }
}

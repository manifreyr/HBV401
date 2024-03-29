package is.hi.hbv401g.Framendi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Vidmot/Forsida.fxml")));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Forsida.fxml")); //src/main/resources/Vidmot/Forsida.fxml
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("horPumpKúkr");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }


}

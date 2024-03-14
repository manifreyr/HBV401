package is.hi.hbv401g.Framendi;

import is.hi.hbv401g.Framendi.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ViewSwitcher {
    private static Map<is.hi.hbv401g.Framendi.View, Parent> cache = new HashMap<>();

    private static Scene scene;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    public static void switchTo(is.hi.hbv401g.Framendi.View view) {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root;
            System.out.println("Loading from FXML");

            root = FXMLLoader.load(
                    ViewSwitcher.class.getResource(view.getFileName())
            );

            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

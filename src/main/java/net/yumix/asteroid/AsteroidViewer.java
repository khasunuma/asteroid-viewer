package net.yumix.asteroid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AsteroidViewer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/AsteroidViewer.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Asteroid Viewer");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

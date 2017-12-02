package net.yumix.asteroid;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.ParallelCamera;
import javafx.scene.PointLight;
import javafx.scene.SubScene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import net.yumix.asteroid.color.ColorPosition;
import net.yumix.asteroid.color.ColorTemperature;
import net.yumix.asteroid.color.XYZColor;

public class AsteroidViewerController implements Initializable {

    @FXML
    private SubScene subScene;

    @FXML
    private Sphere sphere;

    @FXML
    private PhongMaterial material;

    @FXML
    private PointLight pointLight;

    @FXML
    private AmbientLight ambientLight;

    @FXML
    private ParallelCamera camera;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label label;

    @FXML
    public void onAction(ActionEvent event) {
        String name = comboBox.getSelectionModel().getSelectedItem();

        Asteroid asteroid = Asteroid.valueOf(name);

        label.setText(asteroid.toString());

        sphere.setRadius(asteroid.getPolarRadius() / 20.0);
        sphere.setScaleX(asteroid.getEquatorLongRadius() / asteroid.getPolarRadius());
        sphere.setScaleY(asteroid.getEquatorLongRadius() / asteroid.getEquatorShortRadius());

        double Teff = new ColorTemperature(asteroid.getColorIndex()).get();
        ColorPosition colorPosition = ColorPosition.of(Teff);
        Color color = XYZColor.of(colorPosition).toColor();
        material.setDiffuseColor(color);
        material.setSpecularColor(color.brighter());

        pointLight.setColor(Color.gray(asteroid.getAlbedo()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections
                .observableArrayList(Arrays.stream(Asteroid.values()).map(e -> e.name()).toArray(i -> new String[i]));
        comboBox.setItems(list);
    }

}

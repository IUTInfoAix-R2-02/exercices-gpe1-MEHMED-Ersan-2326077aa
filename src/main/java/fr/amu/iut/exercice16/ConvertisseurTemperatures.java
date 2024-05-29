package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox panneauCelsius = new VBox(30);

        Label celsuis_label = new Label("°C");
        Slider c_slider = new Slider(0,100,0);

        c_slider.setOrientation(Orientation.VERTICAL);
        c_slider.setShowTickLabels(true);
        c_slider.setShowTickMarks(true);
        c_slider.setBlockIncrement(10);
        c_slider.setMajorTickUnit(10);
        c_slider.setMinHeight(450);

        TextField celsuis_field = new TextField();

        celsuis_field.setMaxWidth(80);

        panneauCelsius.getChildren().addAll(celsuis_label, c_slider, celsuis_field);


        VBox panneauFahrenheit = new VBox(30);

        Label fahrenheit_label = new Label("°F");
        Slider f_slider = new Slider(0, 212, 32);

        f_slider.setOrientation(Orientation.VERTICAL);
        f_slider.setMinHeight(450);
        f_slider.setShowTickMarks(true);
        f_slider.setShowTickLabels(true);
        f_slider.setBlockIncrement(10);

        TextField fahrenheit_field = new TextField();

        fahrenheit_field.setMaxWidth(80);

        panneauFahrenheit.getChildren().addAll(fahrenheit_label,f_slider,fahrenheit_field);

        //panneauFahrenheit.getChildren().addAll(fahrenheit_field,f_slider,fahrenheit_field);


        c_slider.valueProperty().addListener((observableValue, oldV, newV) -> {
            f_slider.setValue(newV.doubleValue() * 9/5 + 32);
        });
        f_slider.valueProperty().addListener((observableValue, oldV, newV) -> {
            c_slider.setValue((newV.doubleValue() - 32) * 5/9 );
        });

        Bindings.bindBidirectional(celsuis_field.textProperty(), c_slider.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(fahrenheit_field.textProperty(), f_slider.valueProperty(), new NumberStringConverter());



        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
package fr.amu.iut.exercice3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MaPremiereFenetreJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        String name = "";

        Label label = new Label("Bonjour à toi" + name);
        vBox.getChildren().add(label);

        TextField nameField = new TextField();
        nameField.setPromptText("Veuillez saisir un nom");

        nameField.setMaxWidth(180.0);
        nameField.setFont(Font.font("Courier", FontWeight.NORMAL, 12));
        vBox.getChildren().add(nameField);

        Button button = new Button("");
        vBox.getChildren().add(button);

        Image img = new Image("exercice3/Bonjour.jpg");

        ImageView iv = new ImageView();
        iv.setFitHeight(64);
        iv.setFitWidth(64);
        iv.setImage(img);

        button.setGraphic(iv);


        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

            label.setText("Bonjour à toi, " + nameField.getText());
            nameField.clear();
        });


        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("exercice3/Bonjour.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("La page d'un Pro de JavaFX");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}

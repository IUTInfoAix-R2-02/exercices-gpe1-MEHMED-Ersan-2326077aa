package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new BorderPane();

        HBox top = new HBox();
        top.setAlignment(Pos.CENTER);

        label = new Label("caca");
        label.setFont(Font.font("Courier", FontWeight.NORMAL, 12));
        top.getChildren().add(label);


        panneau = new Pane();
        panneau.setPrefSize(400,100);

        bas = new HBox();
        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(0,0,10,10));
        bas.setSpacing(12);

        vert = new Button("Vert");
        rouge = new Button("rouge");
        bleu = new Button("bleu");

        vert.setId("green");
        rouge.setId("red");
        bleu.setId("blue");

        bas.getChildren().addAll(vert,rouge,bleu);

        // event handler
        EventHandler<MouseEvent> buttonClickHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent mouseEvent) {
                Button b = (Button)mouseEvent.getSource();
                panneau.setStyle("-fx-background-color: "+b.getId());
                if (b.getId().equals("green")) {
                    nbVert++;
                    label.setText("Vert choisi " + nbVert + " fois");
                }
                if (b.getId().equals("red")){
                    nbRouge++;
                    label.setText("Rouge choisi " + nbRouge + " fois");
                }
                if (b.getId().equals("blue")) {
                    nbBleu++;
                    label.setText("Bleu choisi " + nbBleu + " fois");
                }
            }
        };

        vert.setOnMouseClicked(buttonClickHandler);
        rouge.setOnMouseClicked(buttonClickHandler);
        bleu.setOnMouseClicked(buttonClickHandler);

        root.setTop(top);
        root.setCenter(panneau);
        root.setBottom(bas);

        Scene scene = new Scene(root);


        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}


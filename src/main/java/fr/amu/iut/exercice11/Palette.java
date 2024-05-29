package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private IntegerProperty nbfois;



    private StringProperty message;
    private StringProperty couleurPanneau;
    private StringProperty couleurText;



    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */

        this.nbfois = new SimpleIntegerProperty();
        this.message = new SimpleStringProperty();
        this.couleurPanneau = new SimpleStringProperty("#00000");
        this.couleurText = new SimpleStringProperty("#00000");

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            this.nbfois.set(++nbVert);
            this.message.set(vert.getText());
            this.couleurPanneau.set("-fx-background-color: #00ff7f");
            this.couleurText.set("-fx-text-fill: #00ff7f");
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            this.nbfois.set(++nbRouge);
            this.message.set(rouge.getText());
            this.couleurPanneau.set("-fx-background-color: #ff3100");
            this.couleurText.set("-fx-text-fill: #ff3100");
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            this.nbfois.set(++nbBleu);
            this.message.set(bleu.getText());
            this.couleurPanneau.set("-fx-background-color: #00acff");
            this.couleurText.set("-fx-text-fill: #00acff");
        });


        boutons.getChildren().addAll(vert, rouge, bleu);

        createBindings();

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBindings() {
        BooleanProperty pasEncoreDeClick = new SimpleBooleanProperty(false);
        pasEncoreDeClick.bind(Bindings.equal(nbfois,0));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClick).then("Cliquer sur le bouton").otherwise(
                Bindings.concat(message, " choisi ", nbfois.asString(), " fois")
        ));
        texteDuBas.textProperty().bind(Bindings.when(pasEncoreDeClick).then("").otherwise(
                Bindings.concat("Le ", message, " est une jolie couleur ! ")
        ));
        panneau.styleProperty().bind(couleurPanneau);
        texteDuBas.styleProperty().bind(couleurText);
    }
}


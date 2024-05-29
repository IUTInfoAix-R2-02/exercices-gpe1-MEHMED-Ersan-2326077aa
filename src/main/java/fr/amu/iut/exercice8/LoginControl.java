package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private PasswordField pwd;

    @FXML
    private TextField txt;

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

    @FXML
    private void okClicked() {

    }

    @FXML
    private void cancelClicked() {
        txt.clear();
        pwd.clear();
    }
}
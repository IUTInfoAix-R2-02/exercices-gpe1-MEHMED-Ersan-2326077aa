package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okBtn;

    @FXML
    private Button cancelBtn;

    public void initialize() {
        createBindings();
    }

    private void createBindings() {
        // MÉTHODE À COMPLÉTER

        pwd.editableProperty().bind(
                Bindings.when(Bindings.lessThan(userId.lengthProperty(),8)).then(false).otherwise(true)
        );

        cancelBtn.disableProperty().bind(
                Bindings.when(userId.lengthProperty().isEqualTo(0).and(pwd.lengthProperty().isEqualTo(0)))
                        .then(true).otherwise(false)
        );

        BooleanBinding pwd_conditions = new BooleanBinding() {
            {
                this.bind(pwd.textProperty());
            }
            @Override
            protected boolean computeValue() {
                boolean has_number = false;
                boolean has_maj = false;
                for (char c : pwd.getText().toCharArray()) {
                    if (Character.isDigit(c)) has_number = true;
                    if (Character.isUpperCase(c)) has_maj = true;
                }

                return has_number && has_maj;
            }
        };

        okBtn.disableProperty().bind(
                Bindings.when(pwd.lengthProperty().greaterThanOrEqualTo(8).and(pwd_conditions))
                        .then(false)
                        .otherwise(true)
        );
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}
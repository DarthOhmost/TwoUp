package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
public class Controller {

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    public void loginButtonOnAction(ActionEvent e) {

        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            loginMessageLabel.setText("Please Enter Valid Username or Password");
        } else {
            loginMessageLabel.setText("Please Enter Username or Password");
        }

    }
    @FXML
    private Button quitButton;

    @FXML
    private void quitButtonOnAction(ActionEvent e) {
        Stage    stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

}
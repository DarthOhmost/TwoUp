package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label Twice;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application! Attempting to Learn");
    }
    @FXML
    protected void onSignInButtonClick() {
        Twice.setText("Sign In Successful");
    }
}
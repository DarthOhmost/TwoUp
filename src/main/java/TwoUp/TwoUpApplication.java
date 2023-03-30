package TwoUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class TwoUpApplication extends Application {

    public void start(Stage stage) throws IOException {

        //Setting up The Login Page
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene sceneLogin = new Scene(root);
        stage.setTitle("Two Up");
        stage.setScene(sceneLogin);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
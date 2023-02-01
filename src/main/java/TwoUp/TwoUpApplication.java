package TwoUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TwoUpApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Setting up The Login Page
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene sceneLogin = new Scene(root);
        stage.setTitle("Two Up");
        stage.setScene(sceneLogin);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
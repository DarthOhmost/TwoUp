package TwoUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TwoUpApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TwoUpApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage.setTitle("Two Up");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
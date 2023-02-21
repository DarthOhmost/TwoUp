package TwoUp;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TwoUpController {

    List<Image> images = new ArrayList<>();
    Image coin1 = new Image("src/main/resources/Images/hh/hh01.png");
    Image coin2 = new Image("src/main/resources/Images/hh/hh02.png");
    Image coin3 = new Image("src/main/resources/Images/hh/hh02.png");
    Image coin4 = new Image("src/main/resources/Images/hh/hh02.png");
    Image coin5 = new Image("src/main/resources/Images/hh/hh02.png");
    Transition animation = new Transition() {
        {
            setCycleDuration(Duration.millis(1000)); // total time for animation
        }
        protected void interpolate(double fraction) {
            int index = (int) (fraction*(images.size()-1));
            coinAnimation.setImage(images.get(index));
        }
    };

    @FXML
    private ImageView coinAnimation;

    @FXML
    private Label currentScoreDisplay;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label resultsLabel;

    @FXML
    private Button headsButton;

    @FXML
    private Button quitButton2;

    @FXML
    private Label highscoreNumberDisplay;

    public int highNum = 0;

    public int num = 0;

    public int randomNumber() {

        Random num = new Random();
        int upperbound = 3;

        int aNumber = num.nextInt(upperbound);

        return aNumber;
    }

    @FXML
    public void headsButtonOnAction(ActionEvent e) {
        animation.play();
        TwoUpController aNumber = new TwoUpController();
        int randomNumber = aNumber.randomNumber();
        if (randomNumber == 1){
            resultsLabel.setText("Win");
            num = num + 1;
            if (num > highNum){
                highscoreNumberDisplay.setText(String.valueOf(num));
            }
        } else if (randomNumber == 0){
            resultsLabel.setText("Roll Again");
        } else {
            resultsLabel.setText("Lose");
        }


        currentScoreDisplay.setText(String.valueOf(num));
    }

    @FXML
    public void tailsButtonOnAction(ActionEvent e) {
        animation.play();
        TwoUpController aNumber = new TwoUpController();
        int randomNumber = aNumber.randomNumber();
        if (randomNumber == 2){
            resultsLabel.setText("Win");
            num = num + 1;
            if (num > highNum){
                highscoreNumberDisplay.setText(String.valueOf(num));
            }
        } else if (randomNumber == 0){
            resultsLabel.setText("Roll Again");
        } else {
            resultsLabel.setText("Lose");
        }

        currentScoreDisplay.setText(String.valueOf(num));
    }

    @FXML
    private void quitButton2OnAction(ActionEvent e) {
        Stage stage = (Stage) quitButton2.getScene().getWindow();
        stage.close();
    }
}

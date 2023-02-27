package TwoUp;

import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TwoUpController {

    //Animation Loop for Heads/Heads Result
    List<Image> Heads = new ArrayList<>();
    Image heads1 = new Image("file:src/main/resources/Images/hh/hh01.png");
    Image heads2 = new Image("file:src/main/resources/Images/hh/hh02.png");
    Image heads3 = new Image("file:src/main/resources/Images/hh/hh03.png");
    Image heads4 = new Image("file:src/main/resources/Images/hh/hh04.png");
    Image heads5 = new Image("file:src/main/resources/Images/hh/hh05.png");
    Transition animationHeads = new Transition() {
        {
            setCycleDuration(Duration.millis(1000)); // total time for animation
        }
        protected void interpolate(double fraction) {
            Heads.add(heads1);
            Heads.add(heads2);
            Heads.add(heads3);
            Heads.add(heads4);
            Heads.add(heads5);
            int index = (int) (fraction*(Heads.size()-1));
            coinAnimation.setImage(Heads.get(index));
        }
    };

    //Animation Loop For Tails/Tails Result

    List<Image> Tails = new ArrayList<>();
    Image Tails1 = new Image("file:src/main/resources/Images/tt/tt01.png");
    Image Tails2 = new Image("file:src/main/resources/Images/tt/tt02.png");
    Image Tails3 = new Image("file:src/main/resources/Images/tt/tt03.png");
    Image Tails4 = new Image("file:src/main/resources/Images/tt/tt04.png");
    Image Tails5 = new Image("file:src/main/resources/Images/tt/tt05.png");
    Transition animationTails = new Transition() {
        {
            setCycleDuration(Duration.millis(1000)); // total time for animation
        }
        protected void interpolate(double fraction) {
            Tails.add(Tails1);
            Tails.add(Tails2);
            Tails.add(Tails3);
            Tails.add(Tails4);
            Tails.add(Tails5);
            int index = (int) (fraction*(Tails.size()-1));
            coinAnimation.setImage(Tails.get(index));
        }
    };

    //Animation Loops For Heads/Tails Result
    List<Image> HeadsTails = new ArrayList<>();
    Image HS1 = new Image("file:src/main/resources/Images/ht/ht01.png");
    Image HS2 = new Image("file:src/main/resources/Images/ht/ht02.png");
    Image HS3 = new Image("file:src/main/resources/Images/ht/ht03.png");
    Image HS4 = new Image("file:src/main/resources/Images/ht/ht04.png");
    Image HS5 = new Image("file:src/main/resources/Images/ht/ht05.png");
    Transition animationHeadsTails = new Transition() {
        {
            setCycleDuration(Duration.millis(1000)); // total time for animation
        }
        protected void interpolate(double fraction) {
            HeadsTails.add(HS1);
            HeadsTails.add(HS2);
            HeadsTails.add(HS3);
            HeadsTails.add(HS4);
            HeadsTails.add(HS5);
            int index = (int) (fraction*(HeadsTails.size()-1));
            coinAnimation.setImage(HeadsTails.get(index));
        }
    };

    @FXML
    private ImageView coinAnimation;

    @FXML
    private Label rank1;

    @FXML
    private Label rank2;

    @FXML
    private Label rank3;

    @FXML
    private Label rank4;

    @FXML
    private Label rank5;

    @FXML
    private Label rank6;

    @FXML
    private Label rank7;

    @FXML
    private Label rank8;

    @FXML
    private Label rank9;

    @FXML
    private Label rank10;

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
    public Label highscoreNumberDisplay;

    @FXML
    public Label userNum;

    @FXML
    public Label passNum;

    public int highNum = 0;

    public int num = 0;

    public void startupleader(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection st = connectNow.getConnection();
        ObservableList data = FXCollections.observableArrayList();
        ObservableList data2 = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = st.prepareStatement("select Firstname From two_up_users order by UserScore desc");
            ResultSet rs = ps.executeQuery();
            ObservableList row = null;
            while (rs.next()) {
                row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }

                //System.out.println("Row [1] added" + row);

                data.add(row);

            }
            //Testing for Correct User Info
            //System.out.println(data.get(2));
            rank1.setText(String.valueOf(data.get(2)));

        }catch (Exception e){

        }
        try {
            PreparedStatement ps = st.prepareStatement("select UserScore From two_up_users order by UserScore desc");
            ResultSet rs =ps.executeQuery();

            while(rs.next()){
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                //System.out.println("Row [1] added" + row);
                data2.add(row);
            }

        }catch (Exception e){

        }
        rank1.setText((String.valueOf(data.get(0)))+" " +(String.valueOf(data2.get(0))));
        rank2.setText((String.valueOf(data.get(1)))+" " +(String.valueOf(data2.get(1))));
        rank3.setText((String.valueOf(data.get(2)))+" " +(String.valueOf(data2.get(2))));
        rank4.setText((String.valueOf(data.get(3)))+" " +(String.valueOf(data2.get(3))));
        rank5.setText((String.valueOf(data.get(4)))+" " +(String.valueOf(data2.get(4))));
        rank6.setText((String.valueOf(data.get(5)))+" " +(String.valueOf(data2.get(5))));
        rank7.setText((String.valueOf(data.get(6)))+" " +(String.valueOf(data2.get(6))));
        rank8.setText((String.valueOf(data.get(7)))+" " +(String.valueOf(data2.get(7))));
        rank9.setText((String.valueOf(data.get(8)))+" " +(String.valueOf(data2.get(8))));
        rank10.setText((String.valueOf(data.get(9)))+" " +(String.valueOf(data2.get(9))));
    }

    public void setLabelTextu(String text){
        usernameLabel.setText(text);
    }
    public void setLabelTexth(String text){
        highscoreNumberDisplay.setText(text);
    }
    public void setLabelTextun(String text){
        userNum.setText(text);
    }
    public void setLabelTextup(String text){
        passNum.setText(text);
    }

    public int randomNumber() {

        Random num = new Random();
        int upperbound = 3;

        int aNumber = num.nextInt(upperbound);

        return aNumber;
    }

    @FXML
    public void headsButtonOnAction(ActionEvent e) {
        TwoUpController aNumber = new TwoUpController();
        int randomNumber = aNumber.randomNumber();
        if (randomNumber == 1){
            animationHeads.play();
            resultsLabel.setText("Win");
            num = num + 1;
            if (num > highNum){
                highscoreNumberDisplay.setText(String.valueOf(num));
            }
        } else if (randomNumber == 0){
            animationHeadsTails.play();
            resultsLabel.setText("Roll Again");
        } else {
            animationTails.play();
            resultsLabel.setText("Lose");
            num = num + -1;
        }
        //Test To See if Username and Password was being passed to This Controller
        //System.out.println(userNum + " " + passNum);

        currentScoreDisplay.setText(String.valueOf(num));
    }

    @FXML
    public void tailsButtonOnAction(ActionEvent e) {
        TwoUpController aNumber = new TwoUpController();
        int randomNumber = aNumber.randomNumber();
        if (randomNumber == 2){
            animationTails.play();

            resultsLabel.setText("Win");
            num = num + 1;
            if (num > highNum){
                highscoreNumberDisplay.setText(String.valueOf(num));
            }
        } else if (randomNumber == 0){
            animationHeadsTails.play();
            resultsLabel.setText("Roll Again");
        } else {
            animationHeads.play();
            resultsLabel.setText("Lose");
            num = num + -1;
        }

        currentScoreDisplay.setText(String.valueOf(num));
    }

    @FXML
    private void quitButton2OnAction(ActionEvent e) throws SQLException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection st = connectNow.getConnection();
        String query = "update two_up_users set UserScore = '"+ Integer.parseInt (highscoreNumberDisplay.getText()) +"' WHERE username = '" + Integer.parseInt (userNum.getText()) + "' AND password = '" + Integer.parseInt (passNum.getText()) + "'";
        String track = "INSERT INTO database1.two_up_tracker(UserName) VALUES ("+Integer.parseInt (userNum.getText())+")";
        try {
            Statement upda = st.createStatement();
            Integer update = upda.executeUpdate(query);
            Statement tra = st.createStatement();
            Integer trac = tra.executeUpdate(track);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        Stage stage = (Stage) quitButton2.getScene().getWindow();
        stage.close();
    }
}

package TwoUp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {

    //Setting up FXML components
    private Stage stage;

    private Scene scene;

    private Parent root;

    public static String Fir;

    public String Las;

    public Integer High;
    @FXML

    private Button loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    //Action for when the Login Button is clicked

    @FXML
    public void loginButtonOnAction(ActionEvent e) throws IOException {

        //Checks if login is valid with Username and Password the user has entered and if either is missing or if it doesn't match
        //Database then Asks User to Enter Password and Username again
        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            //loginMessageLabel.setText("Please Enter Valid Username or Password");
            validateLogin();

        } else {
            loginMessageLabel.setText("Please Enter Username or Password");
        }

    }
    @FXML
    private Button quitButton;

    //Scene Trigger for when a valid login signs in.

    @FXML
    private void sceneTrigger() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainGame.fxml"));
        Parent root = loader.load();
        TwoUpController twoUpController = loader.getController();
        twoUpController.setLabelTextu(Fir+" "+Las);
        twoUpController.setLabelTexth(String.valueOf(High));
        twoUpController.setLabelTextun(usernameTextField.getText());
        twoUpController.setLabelTextup(passwordPasswordField.getText());
        twoUpController.startupleader();

        stage = (Stage)loginMessageLabel.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Action for when quit button is pressed

    @FXML
    private void quitButtonOnAction(ActionEvent e) {
        Stage    stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    //Validation for user Login

    @FXML
    public void validateLogin() {
        //Connects to Database
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        //Setting Up Queries
        String verifyLogin = "select count(1) FROM two_up_users WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
        String fName = "select Firstname FROM two_up_users WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
        String lName = "select Lastname FROM two_up_users WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
        String hScore = "select UserScore FROM two_up_users WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
        try {
            //Connects to database then uses queries set up to gather if it's a valid login and then gathers the user's Firstname, Lastname, Usernumber and their Highscore
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            Statement first = connectDB.createStatement();
            ResultSet fist = first.executeQuery(fName);
            Statement last = connectDB.createStatement();
            ResultSet las = last.executeQuery(lName);
            Statement high = connectDB.createStatement();
            ResultSet hi = high.executeQuery(hScore);

            //If Valid
            while(queryResult.next()) {
                if (queryResult.getInt(1) == 1) {

                    while (fist.next()) {
                        Fir = fist.getString("Firstname");
                        //System.out.println(Fir);
                    }
                    while (las.next()) {
                        Las = las.getString("Lastname");
                        //System.out.println(Las);
                    }
                    while (hi.next()) {
                        High = Integer.valueOf(hi.getString("UserScore"));
                        //System.out.println(hi);
                    }
                    loginMessageLabel.setText(String.valueOf(Fir +" "+ Las));



                    sceneTrigger();
                    //If Invalid
                } else{
                    loginMessageLabel.setText("Invalid Login Please Try Again");
                }
            }

        } catch (Exception e){
                e.printStackTrace();
        }


    }


}
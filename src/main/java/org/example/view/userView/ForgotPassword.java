package org.example.view.userView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.InputScanner;
import org.example.controller.JsonController;
import org.example.controller.userControllers.LoginMenuController;
import org.example.controller.userControllers.SignupMenuController;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.outputs.LoginMenuOutput;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ForgotPassword extends Application  {

    public TextField answerQ;
    public PasswordField passwordField;
    public Label errorPassword;
    public Label changePassword;
    // public PasswordField password;
    Label errorAnswer;
     Label errorUsername;
    
    Label questionCheck;
   
    static Stage stage;
    int number = 0;
    TextField username;
    TextField answer;
    private final SignupMenuController signupMenuController = new SignupMenuController();
    protected
    String successfulMessage = String.format("-fx-text-fill: Green;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");
    private final LoginMenuController loginMenuController = new LoginMenuController();

    @Override
    public void start(Stage stage) throws Exception {
        // setQuestionCheck();
        // System.out.println(loginMenuController.findUserSecurityQuestion().getQuestion());
        ForgotPassword.stage = stage;
        URL url = MainMenu.class.getResource("/FXML/forgotPassword.fxml");
        questionCheck = new Label();
        questionCheck.setText("");
        Button button = new Button("ok");
        button.setLayoutX(430.0);
        button.setLayoutY(120.0);
        questionCheck.setLayoutY(180.0);
        questionCheck.setLayoutX(150.0);
        username = new TextField();
        username.setLayoutX(273.0);
        username.setLayoutY(120.0);
        errorUsername = new Label();
        errorUsername.setStyle(errorMessage);
        errorUsername.setText("");
        errorUsername.setLayoutX(229.0);
        errorUsername.setLayoutY(155.0);
        answer = new TextField();
        answer.setLayoutX(273.0);
        answer.setLayoutY(181.0);
        errorAnswer = new Label();
        errorAnswer.setStyle(errorMessage);
        errorAnswer.setText("");
        errorAnswer.setLayoutX(229.0);
        errorAnswer.setLayoutY(213.0);
        Button checker = new Button("check");
        checker.setLayoutX(430.0);
        checker.setLayoutY(181.0);
        EventHandler<ActionEvent> sell = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                forgetPassword(username.getText());
            }
        };
        EventHandler<ActionEvent> checkAnswer = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
              //  String answerQ = answer.getText();
                byte[] salt = JsonController.makeSalt();
                String answerQ = JsonController.getPassHashSha256(answer.getText(), salt);
                if (loginMenuController.checkSecurityQuestion(answerQ)) {
                    errorAnswer.setText("");
                    answer.setStyle(successStyle);
                }
                else
                    errorAnswer.setText("answer dose not match with the picked question");

            }
        };
        checker.setOnAction(checkAnswer);
        button.setOnAction(sell);
        Pane pane = FXMLLoader.load(url);
        pane.getChildren().add(questionCheck);
        pane.getChildren().add(button);
        pane.getChildren().add(username);
        pane.getChildren().add(errorUsername);
        pane.getChildren().add(answer);
        pane.getChildren().add(errorAnswer);
        pane.getChildren().add(checker);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();




    }

    protected void forgetPassword(String username1) {
        loginMenuController.setUsername(username.getText());
        if (loginMenuController.checkMatchUsername()) {
            username.setStyle(successStyle);
            errorUsername.setText("");
            questionCheck.setText(loginMenuController.findUserSecurityQuestion().getQuestion());
            System.out.println(loginMenuController.findUserSecurityQuestion().getQuestion());


        }
        else
        errorUsername.setText("username dose not exist");

    }



    private void resettingUserPassword(String username) {
        System.out.println(LoginMenuOutput.ENTER_YOUR_NEW_PASSWORD.getOutput());
        String newPassword = passwordField.getText();
        SignupMenuController signupMenuController = new SignupMenuController();
        signupMenuController.setUsername(username);
        signupMenuController.setPassword(newPassword);
        SignupMenuOutput status = SignupMenuController.passwordCheckErrors(newPassword);
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            System.out.println(LoginMenuOutput.ENTER_YOUR_PASSWORD_AGAIN.getOutput());



        }
    }

    private void passwordCheck() {
        switch (SignupMenuController.passwordCheckErrors(passwordField.getText())){
            case ERROR_PASSWORD_IS_TOO_SHORT :
                errorPassword.setStyle(errorMessage);
                errorPassword.setText("password must contains as least 6 characters");
                break;
            case CHECKED_SUCCESSFULLY:
                errorPassword.setStyle(successfulMessage);
                errorPassword.setText("");
                passwordField.setStyle(successStyle);
                signupMenuController.setPassword(passwordField.getText());
                break;
            default:
                errorPassword.setStyle(errorMessage);
                errorPassword.setText("password must contains at least a large,small,special characters,digit");
                passwordField.setStyle(errorStyle);
        }
    }


    @FXML
    public void initialize(){
        passwordField.textProperty().addListener((observable , oldText , newText)->{
            passwordCheck();
        } );
    }

    public void confirmChangePassword(MouseEvent event) {
        if(errorPassword.getText().equals("")&&errorUsername.getText().equals("")&&errorAnswer.getText().equals("")){
            changePassword.setStyle(successfulMessage);
            changePassword.setText("successful");
        }


    }


  /*  @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }*/
}

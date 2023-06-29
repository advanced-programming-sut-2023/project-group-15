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
    Label errorUsername;
    Label errorAnswer;
    public static int n1,n2;
    // public PasswordField password;
    public static String usernameError,answerError = new String();

    Label questionCheck;

    static Stage stage;
    int number = 0;
    public static TextField username;
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
        answer = new TextField();
        answer.setLayoutX(273.0);
        answer.setLayoutY(181.0);
        errorAnswer = new Label();
        errorAnswer.setStyle(errorMessage);
        errorAnswer.setText("");
        errorAnswer.setLayoutX(229.0);
        errorAnswer.setLayoutY(213.0);
        errorUsername = new Label();
        errorUsername.setStyle(errorMessage);
        errorUsername.setText("");
        errorUsername.setLayoutX(229.0);
        errorUsername.setLayoutY(155.0);
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
                //  byte[] salt = JsonController.makeSalt();
                //  String answerQ = JsonController.getPassHashSha256(answer.getText(), salt);
                System.out.println(answer.getText());
                System.out.println(loginMenuController.findUserSecurityQuestion());
                if (loginMenuController.checkSecurityQuestion(answer.getText())) {
                    errorAnswer.setText("");
                    answer.setStyle(successStyle);
                    answerError = "";
                    n1 = 1;
                }
                else{
                    errorAnswer.setText("answer dose not match with the picked question");
                    answerError = "answer dose not match with the picked question";
                    n1 = 0;
                }


            }
        };
        checker.setOnAction(checkAnswer);
        button.setOnAction(sell);
        Pane pane = FXMLLoader.load(url);
        pane.getChildren().add(questionCheck);
        pane.getChildren().add(button);
        pane.getChildren().add(username);
        pane.getChildren().add(answer);
        pane.getChildren().add(errorUsername);
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
            usernameError = "";
            n2 = 1;
            questionCheck.setText(loginMenuController.findUserSecurityQuestion().getQuestion());
            System.out.println(loginMenuController.findUserSecurityQuestion().getQuestion());
            signupMenuController.setUsername(username.getText());

        }
        else{
            n2 = 0;
            errorUsername.setText("username dose not exist");
            usernameError = new String("");
            usernameError += "username dose not exist";
            System.out.println(usernameError);
        }


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

    public void confirmChangePassword(MouseEvent event) throws Exception {
        System.out.println(passwordField.getStyle()+n2+n1);
        System.out.println(answerError + "l" + usernameError);
        if(passwordField.getStyle().equals(successStyle)&&n1==1&&
                n2==1){
            changePassword.setStyle(successfulMessage);
            changePassword.setText("successful");
            signupMenuController.setPassword(passwordField.getText());
            signupMenuController.changeForgetPassword(username.getText(),passwordField.getText());
            new LoginMenu().start(ForgotPassword.stage);
        }


    }


  /*  @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }*/
}
//this class is completed!
package org.example.view.userView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.example.InputScanner;
import org.example.controller.userControllers.SignupMenuController;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;


import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;

import static org.example.view.userView.ForgotPassword.*;

public class SignupMenu extends  Application {
    public static Stage stage;
    public TextField email;
    public Label errorEmail;
    public TextField nickname;
    public Label errorNickname;
    public TextField passwordShow;
    public CheckBox chaneMode;
    public PasswordField password;
    public Label errorUsername;
    public TextField username;
    public int count = 0 ;
    public Label errorPassword;
    public Label successfulSignup;
    private Popup popup;

    public 
    @FXML
    void changeVisibility(ActionEvent event){
        if(chaneMode.isSelected()){
            passwordShow.setText(password.getText());
            passwordShow.setVisible(true);
            password.setVisible(false);
            return;
        }
        password.setText(passwordShow.getText());
        password.setVisible(true);
        passwordShow.setVisible(false);
    }
    protected
    String successfulMessage = String.format("-fx-text-fill: Green;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    @Override
    public void start (Stage stage ) throws Exception
    {
        SignupMenu.stage = stage;
        URL url = SignupMenu.class.getResource("/FXML/SignUp.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
    private final SignupMenuController signupMenuController = new SignupMenuController();
    private boolean questionFlag = true;

   /* public void run(Matcher signupMenuMatcher)  {
        SignupMenuOutput status;
        classifyParameters(signupMenuMatcher);
        status = usernameCheck();
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            status = passwordCheck();
            if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                status = sloganCheck();
                if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                    status = signupMenuController.signupUserCheck();
                    if (status.equals(SignupMenuOutput.SECURITY_QUESTION)) {
                        if (questionFlag)
                            pickQuestion();
                        signupMenuController.signingsComplete();
                        System.out.println(SignupMenuOutput.USER_CREATED_SUCCESSFULLY.getOutput());
                        return;
                    } else
                        System.out.println(status.getOutput());
                } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
                    return;
                } else
                    System.out.println(status.getOutput());
            } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
                return;
            } else {
                System.out.println(status.getOutput());
            }
        } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
            return;
        } else {
            System.out.println(status.getOutput());
        }
    }*/

   /* private SignupMenuOutput sloganCheck() {
        if (signupMenuController.getSlogan() == null) {
            signupMenuController.setSlogan("empty");
            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
        }
        else if (signupMenuController.getSlogan().matches("\\s*random\\s*")) {
            signupMenuController.showSlogans();
            System.out.println("choose one of these slogans (enter the number):");
            while (true) {
                String input = InputScanner.getScanner().nextLine();
                if (Integer.parseInt(input) <= 11 || Integer.parseInt(input) >= 1) {
                    signupMenuController.selectSlogan(input);
                    return SignupMenuOutput.CHECKED_SUCCESSFULLY;
                } else if (input.matches("^\\s*quit\\s*$")) {
                    return SignupMenuOutput.QUIT_FROM_PROCESS;
                } else
                    System.out.println("you entered invalid input, try again! or enter \"quit\" to exit");
            }
        }
        return SignupMenuOutput.CHECKED_SUCCESSFULLY;
    }*/

 /*   @FXML
    private SignupMenuOutput pickQuestion() {
        Matcher signupMenuMatcher;
        System.out.println("pick a question from these questions:");
        signupMenuController.showQuestions();
        while (true) {
            String input = InputScanner.getScanner().nextLine();
            if ((signupMenuMatcher = SignupMenuEnum.getMatcher(input, SignupMenuEnum.PICK_QUESTION)) != null) {
                SignupMenuOutput status = signupMenuController.pickSecurityQuestion(signupMenuMatcher);
                if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                    return status;
                } else
                    System.out.println(status.getOutput());
            } else if (input.matches("^\\s*quit\\s*$")) {
                return SignupMenuOutput.QUIT_FROM_PROCESS;
            } else
                System.out.println("invalid command!,\ntry again!\ntype \"quit\" to cancel the process");
        }
    }*/

    private void passwordCheck() {
        switch (SignupMenuController.passwordCheckErrors(password.getText())){
            case ERROR_PASSWORD_IS_TOO_SHORT :
                errorPassword.setStyle(errorMessage);
                errorPassword.setText("password must contains as least 6 characters");
                password.setStyle(errorStyle);
                break;
            case CHECKED_SUCCESSFULLY:
                errorPassword.setStyle(successfulMessage);
                errorPassword.setText("");
                password.setStyle(successStyle);
                signupMenuController.setPassword(password.getText());
                break;
            default:
                errorPassword.setStyle(errorMessage);
                errorPassword.setText("password must contains at least a large,small,special characters,digit");
                password.setStyle(errorStyle);
        }
    }

    private void usernameCheck() {
        SignupMenuOutput result = SignupMenuController.usernameCheckErrors(username.getText());
        if (result.equals(SignupMenuOutput.USERNAME_EXISTS)) {
            signupMenuController.usernameSuggestionGenerator();
            errorUsername.setStyle(errorMessage);
            errorUsername.setText("this username exists you can use " + signupMenuController.getUsername());
            username.setStyle(errorStyle);
    }
        if (result.equals(SignupMenuOutput.INVALID_USERNAME_FORMAT))
        {
            errorUsername.setStyle(errorMessage);
            errorUsername.setText("invalid username , must contains letters , digits , _ !");
            username.setStyle(errorStyle);
        }

        if (result.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY))
        {
            errorUsername.setStyle(successfulMessage);
            errorUsername.setText("");
            username.setStyle(successStyle);
            signupMenuController.setUsername(username.getText());
        }

    }

   /* public void classifyParameters(Matcher matcher) {
        signupMenuController.setUsername(matcher.group("username"));
        signupMenuController.setPassword(matcher.group("password"));
        signupMenuController.setNickname(matcher.group("nickname"));
        signupMenuController.setClipBoard(matcher.group("configuration"));
        signupMenuController.setEmail(matcher.group("email"));
        signupMenuController.setSlogan(matcher.group("slogan"));
    }
*/
    public void slogan(MouseEvent mouseEvent) {
        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("slogan");
        sloganInput.setContentText("enter your slogan");
        Optional<String> result = sloganInput.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setSlogan(sloganInput.getEditor().getText());
        }

    }

    public void backToMainMenu(MouseEvent mouseEvent) throws Exception {
        new MainMenu().start(SignupMenu.stage);
    }


    public void signup(MouseEvent mouseEvent) throws Exception{
        if(email.getText().isBlank()) {
            errorEmail.setStyle(errorMessage);
            errorEmail.setText("email field is blank");
            email.setStyle(errorStyle);
        }
        if(!email.getText().isBlank()&& SignupMenuController.emailCheck(email.getText()).equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)){
            signupMenuController.setEmail(email.getText());
            errorEmail.setText("");
            email.setStyle(successStyle);
        }
        else{
            String emailField = email.getText();
            switch (SignupMenuController.emailCheck(emailField)){
                case DUPLICATE_EMAIL_ERROR :
                    errorEmail.setStyle(errorMessage);
                    errorEmail.setText("this email exists");
                    email.setStyle(errorStyle);
                    break;
                case INVALID_EMAIL_FORMAT:
                    errorEmail.setStyle(errorMessage);
                    errorEmail.setText("(something@something.something)!");
                    email.setStyle(errorStyle);
            }
        }

        if(nickname.getText().isBlank()) {
            errorNickname.setStyle(errorMessage);
            errorNickname.setText("nickname field is blank");
            nickname.setStyle(errorStyle);
        }

        if(!nickname.getText().isBlank() ){
            signupMenuController.setNickname(nickname.getText());

            errorNickname.setText("");
            nickname.setStyle(successStyle);
           // System.out.println(errorNickname.getText());
        }

        if(username.getText().isBlank()) {
            errorUsername.setStyle(errorMessage);
            errorUsername.setText("username field is blank");
            username.setStyle(errorStyle);
        }

        if(password.getText().isBlank()) {
            errorPassword.setStyle(errorMessage);
            errorPassword.setText("password field is blank");
            password.setStyle(errorStyle);
        }

        if(!password.getText().isBlank()){
            passwordCheck();
        }

        if(!username.getText().isBlank()){
            passwordCheck();
        }

        if(errorNickname.getText().equals("") && errorEmail.getText().equals("") && errorPassword.getText().equals("") &&
                errorUsername.getText().equals("")){
            System.out.println(signupMenuController.getEmail() + " " +
                    signupMenuController.getNickname() + signupMenuController.getPassword() + " " + signupMenuController.getUsername());
            signupMenuController.signingsComplete();
            successfulSignup.setStyle(successfulMessage);
            successfulSignup.setText("successful signup");
            popup.show(SignupMenu.stage);
            new MainMenu().start(SignupMenu.stage);
        }

    }


    @FXML
    public void initialize(){
        username.textProperty().addListener((observable , oldText , newText)->{
            usernameCheck();
                }


                );
        password.textProperty().addListener((observable , oldText , newText)->{
            passwordCheck();
        } );
    }


    public void pickQuestion1(MouseEvent mouseEvent) {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my father's name?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my father's name?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }
    }

    public void pickQuestion2(MouseEvent mouseEvent) {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my brother's name?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my brother's name?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }

    }

    public void pickQuestion3(MouseEvent mouseEvent) {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my hair color?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my hair color?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }

    }
    public void pickQuestion4(MouseEvent mouseEvent) {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my car color?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my car color?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }

    }
    public void pickQuestion5(MouseEvent mouseEvent) {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my favorite food?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my favorite food?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }

    }


    public void pickQuestion6(MouseEvent mouseEvent) {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my cellphone model?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my cellphone model?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());

        }

    }

    public void randomPassword(MouseEvent mouseEvent) throws Exception {
        password.setText(signupMenuController.generateRandomPassword());
    }

    public void randomSlogan(MouseEvent mouseEvent) throws Exception {
        new ChooseRandomSlogan().start(SignupMenu.stage);
    }
}

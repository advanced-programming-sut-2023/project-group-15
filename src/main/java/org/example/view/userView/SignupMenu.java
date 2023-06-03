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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.example.InputScanner;
import org.example.controller.userControllers.SignupMenuController;
import org.example.model.Styles;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;

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
    Styles styles = new Styles();

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



    @Override
    public void start (Stage stage ) throws Exception
    {
        SignupMenu.stage = stage;
        URL url = SignupMenu.class.getResource("/FXML/SignUp.fxml");
        Pane pane = FXMLLoader.load(url);
        Image background = new Image(getClass().getResource("/Images/04.jpg").toString());
        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        pane.setBackground(bGround);
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
                errorPassword.setStyle(styles.getErrorMessage());
                errorPassword.setText("password must contains as least 6 characters");
                password.setStyle(styles.getErrorStyle());
                break;
            case CHECKED_SUCCESSFULLY:
                errorPassword.setStyle(styles.getSuccessfulMessage());
                errorPassword.setText("");
                password.setStyle(styles.getSuccessfulMessage());
                signupMenuController.setPassword(password.getText());
                break;
            default:
                errorPassword.setStyle(styles.getErrorMessage());
                errorPassword.setText("password must contains at least a large,small,special characters,digit");
                password.setStyle(styles.getErrorStyle());
        }
    }

    private void usernameCheck() {
        SignupMenuOutput result = SignupMenuController.usernameCheckErrors(username.getText());
        if (result.equals(SignupMenuOutput.USERNAME_EXISTS)) {
            signupMenuController.usernameSuggestionGenerator();
            errorUsername.setStyle(styles.getErrorMessage());
            errorUsername.setText("this username exists you can use " + signupMenuController.getUsername());
            username.setStyle(styles.getErrorStyle());
    }
        if (result.equals(SignupMenuOutput.INVALID_USERNAME_FORMAT))
        {
            errorUsername.setStyle(styles.getErrorMessage());
            errorUsername.setText("invalid username , must contains letters , digits , _ !");
            username.setStyle(styles.getErrorStyle());
        }

        if (result.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY))
        {
            errorUsername.setStyle(styles.getSuccessfulMessage());
            errorUsername.setText("");
            username.setStyle(styles.getSuccessStyle());
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
            errorEmail.setStyle(styles.getErrorMessage());
            errorEmail.setText("email field is blank");
            email.setStyle(styles.getErrorStyle());
        }
        if(!email.getText().isBlank()&& SignupMenuController.emailCheck(email.getText()).equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)){
            signupMenuController.setEmail(email.getText());
            errorEmail.setText("");
            email.setStyle(styles.getSuccessStyle());
        }
        else{
            String emailField = email.getText();
            switch (SignupMenuController.emailCheck(emailField)){
                case DUPLICATE_EMAIL_ERROR :
                    errorEmail.setStyle(styles.getErrorMessage());
                    errorEmail.setText("this email exists");
                    email.setStyle(styles.getErrorStyle());
                    break;
                case INVALID_EMAIL_FORMAT:
                    errorEmail.setStyle(styles.getErrorMessage());
                    errorEmail.setText("(something@something.something)!");
                    email.setStyle(styles.getErrorStyle());
            }
        }

        if(nickname.getText().isBlank()) {
            errorNickname.setStyle(styles.getErrorMessage());
            errorNickname.setText("nickname field is blank");
            nickname.setStyle(styles.getErrorStyle());
        }

        if(!nickname.getText().isBlank() ){
            signupMenuController.setNickname(nickname.getText());

            errorNickname.setText("");
            nickname.setStyle(styles.getSuccessStyle());
           // System.out.println(errorNickname.getText());
        }

        if(username.getText().isBlank()) {
            errorUsername.setStyle(styles.getErrorMessage());
            errorUsername.setText("username field is blank");
            username.setStyle(styles.getErrorStyle());
        }

        if(password.getText().isBlank()) {
            errorPassword.setStyle(styles.getErrorMessage());
            errorPassword.setText("password field is blank");
            password.setStyle(styles.getErrorStyle());
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
            successfulSignup.setStyle(styles.getSuccessfulMessage());
            successfulSignup.setText("successful signup");
            new MainMenu().start(SignupMenu.stage);
        }

    }


    @FXML
    public void initialize(){
      /*  username.textProperty().addListener((observable , oldText , newText)->{
            usernameCheck();
                }


                );*/
        password.textProperty().addListener((observable , oldValue , newValue)->{
            System.out.println(newValue.length());
            if(newValue.length() < 6)
            {
                errorPassword.setStyle(styles.getErrorMessage());
                errorPassword.setText("password must contains as least 6 characters");
                password.setStyle(styles.getErrorStyle());
            }
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

}

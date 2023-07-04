//this class is completed!
package org.example.view.userView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.controller.userControllers.SignupMenuController;
import org.example.model.Styles;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.net.URL;
import java.util.Optional;
import java.util.Random;

import static org.example.Utility.captchaStringGen;
import static org.example.Utility.displacementMap;

public class SignupMenu extends  Application {
    public static Stage stage;
    public TextField email;
    public Label errorEmail;
    public TextField nickname;
    public Label errorNickname;
    private boolean slogan = false;
    private boolean randomPass = false;
    public TextField passwordShow;
    public CheckBox showPass;
    public PasswordField password;
    public Label errorUsername;
    public TextField username;
    private Stage stage1 = new Stage();
    public Label errorPassword;
    public Label successfulSignup;
    Image background = new Image(getClass().getResource("/Images/01.jpg").toString());
    Boolean submitted = false;
    private boolean security = false;
    String randomPassword;
    BackgroundImage bImg = new BackgroundImage(background,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1, 1.0, true, true, false, false));
    Background bGround = new Background(bImg);
    Styles styles = new Styles();



    public
    @FXML
    void showPass(ActionEvent event) {
        if(showPass.isSelected()){
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
    public void start(Stage stage) throws Exception {
        SignupMenu.stage = stage;
        URL url = SignupMenu.class.getResource("/FXML/SignUp.fxml");
        Pane pane = FXMLLoader.load(url);

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
        switch (SignupMenuController.passwordCheckErrors(password.getText())) {
            case ERROR_PASSWORD_IS_TOO_SHORT:
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

    private void usernameCheck(String username) {
        SignupMenuOutput result = SignupMenuController.usernameCheckErrors(username);
        System.out.println(result.getOutput());
        if (result.equals(SignupMenuOutput.USERNAME_EXISTS)) {
            signupMenuController.usernameSuggestionGenerator();
            errorUsername.setStyle(styles.getErrorMessage());
            Random random = new Random();
            errorUsername.setText("this username exists you can use " + (char) (random.nextInt(26) + 'a'));
            System.out.println(errorUsername.getText());
            //  username.setStyle(styles.getErrorStyle());
        }
        if (result.equals(SignupMenuOutput.INVALID_USERNAME_FORMAT)) {
            errorUsername.setStyle(styles.getErrorMessage());
            errorUsername.setText("invalid username , must contains letters , digits , _ !");
            //   username.setStyle(styles.getErrorStyle());
        }

        if (result.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            errorUsername.setStyle(styles.getSuccessfulMessage());
            errorUsername.setText("");
            //  username.setStyle(styles.getSuccessStyle());
            signupMenuController.setUsername(username);
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
            slogan = true;
            signupMenuController.setSlogan(sloganInput.getEditor().getText());
        }

    }

    public void backToMainMenu(MouseEvent mouseEvent) throws Exception {
        new StartingMenu().start(SignupMenu.stage);
    }


    public void signup(MouseEvent mouseEvent) throws Exception {
        if (email.getText().isBlank()) {
            errorEmail.setStyle(styles.getErrorMessage());
            errorEmail.setText("email field is blank");
            email.setStyle(styles.getErrorStyle());
        }
        if (!email.getText().isBlank() && SignupMenuController.emailCheck(email.getText()).equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            signupMenuController.setEmail(email.getText());
            errorEmail.setText("");
            email.setStyle(styles.getSuccessStyle());
        } else {
            String emailField = email.getText();
            switch (SignupMenuController.emailCheck(emailField)) {
                case DUPLICATE_EMAIL_ERROR:
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
        if(!security)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText("please choose a security question");
        }

        if (nickname.getText().isBlank()) {
            errorNickname.setStyle(styles.getErrorMessage());
            errorNickname.setText("nickname field is blank");
            nickname.setStyle(styles.getErrorStyle());
        }
        if(randomPass)
        {
            if(!password.getText().equals(randomPassword));
            {
                System.out.println("hhhh");
                errorPassword.setStyle(styles.getErrorMessage());
                errorPassword.setText("you haven't entered the random password");
                password.setStyle(styles.getErrorStyle());
            }
        }

        if (!nickname.getText().isBlank()) {
            signupMenuController.setNickname(nickname.getText());

            errorNickname.setText("");
            nickname.setStyle(styles.getSuccessStyle());
            // System.out.println(errorNickname.getText());
        }

        if (username.getText().isBlank()) {
            errorUsername.setStyle(styles.getErrorMessage());
            errorUsername.setText("username field is blank");
            username.setStyle(styles.getErrorStyle());
        }



        if (password.getText().isBlank()) {
            errorPassword.setStyle(styles.getErrorMessage());
            errorPassword.setText("password field is blank");
            password.setStyle(styles.getErrorStyle());
        }

        if (!password.getText().isBlank()) {
            passwordCheck();
        }

        if (!username.getText().isBlank()) {
            passwordCheck();
        }

        if (errorNickname.getText().equals("") && errorEmail.getText().equals("") && errorPassword.getText().equals("") &&
                errorUsername.getText().equals("") && security) {
            if(!slogan)
                signupMenuController.setSlogan("slogan is empty");
            signupMenuController.signingsComplete();
            successfulSignup.setStyle(styles.getSuccessfulMessage());
            successfulSignup.setText("successful signup");
            successfulSignup.setVisible(true);
            new StartingMenu().start(stage);

        }

    }

    public void securityQuestions() {
        Label message = new Label("please press submit button after choosing your question");
        Button submit = new Button();
        submit.setText("submit");
        Label title = new Label("choose your security question");
        RadioButton question1 = new RadioButton("What's my father's name?");
        RadioButton question2 = new RadioButton("What's my brother's name?");
        RadioButton question3 = new RadioButton("What's my hair color?");
        RadioButton question4 = new RadioButton("What's my car color?");
        RadioButton question5 = new RadioButton("What's my favorite food?");
        RadioButton question6 = new RadioButton("What's my cellphone model?");
        VBox questions = new VBox();
        ToggleGroup toggleGroup = new ToggleGroup();
        question1.setToggleGroup(toggleGroup);
        question2.setToggleGroup(toggleGroup);
        question3.setToggleGroup(toggleGroup);
        question4.setToggleGroup(toggleGroup);
        question5.setToggleGroup(toggleGroup);
        question6.setToggleGroup(toggleGroup);
        questions.getChildren().addAll(title, question1, question2, question3, question4, question5, question6, submit);
        questions.setTranslateX(50);
        questions.setTranslateY(30);
        questions.setSpacing(10);
        questions.setPadding(new Insets(0, 10, 0, 10));
        questions.setAlignment(Pos.CENTER_LEFT);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle o, Toggle n) {
                RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();

                submitted = true;
                if (rb != null) {

                    String chosenQuestion = String.valueOf(rb.getText());
                    switch (chosenQuestion) {
                        case "What's my father's name?":
                            pickQuestion1();
                            break;
                        case "What's my brother's name?":
                            pickQuestion2();
                            break;
                        case "What's my hair color?":
                            pickQuestion3();
                            break;
                        case "What's my car color?":
                            pickQuestion4();
                            break;
                        case "What's my favorite food?":
                            pickQuestion5();
                            break;
                        case "What's my cellphone model?":
                            pickQuestion6();
                            break;
                    }
                }

            }
        });

        Scene scene1 = new Scene(questions, 300, 300);
        stage1.setScene(scene1);
        stage1.show();
        submit.setOnAction(e ->
        {
            captchaShower();

        });

    }
    private void captchaShower() {
        Label captchaMessage = new Label("please enter the below captcha");
        Button submit2 = new Button("submit");
        TextField captchaInput = new TextField();
        captchaInput.setId("captcha");
        Label error = new Label();
        error.setText("wrong captcha");
        error.setStyle(styles.getErrorMessage());
        error.setVisible(false);
        error.setTranslateY(100);
        error.setTranslateY(200);
        Scene scene = new Scene(new Group(), 300, 300);
        ObservableList content = ((Group) scene.getRoot()).getChildren();
        String[] captcha;
        captcha = captchaStringGen();
        captchaMessage.setTranslateX(50);
        captchaMessage.setTranslateY(50);
        submit2.setTranslateX(100);
        submit2.setTranslateY(200);
        captchaInput.setTranslateX(50);
        captchaInput.setTranslateY(70);
        content.add(displacementMap(captcha[0]));
        content.addAll(captchaMessage, submit2, captchaInput , error);
        stage1.setScene(scene);
        stage1.show();
        //todo the error labels are not shown
        submit2.setOnAction(e ->
        {
            if (!captchaInput.getText().isBlank() && submitted) {
                if (captchaInput.getText().equals(captcha[0])) {
                    security = true;
                    stage1.close();
                }

                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("wrong captcha");
                    alert.show();
                    captchaShower();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("sign up error");
                alert.setContentText("please fill the required parts");
                alert.showAndWait();
            }
        });
    }








    @FXML
    public void initialize() {
        username.textProperty().addListener((observable, oldText, newText) -> {
                    usernameCheck(username.getText());
                }

        );
        password.textProperty().addListener((observable, oldText, newText) -> {
            passwordCheck();
        });
    }

    public void pickQuestion1() {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my father's name?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my father's name?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }
    }


    public void pickQuestion2() {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my brother's name?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my brother's name?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }

    }

    public void pickQuestion3() {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my hair color?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my hair color?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }

    }

    public void pickQuestion4() {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my car color?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my car color?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }

    }

    public void pickQuestion5() {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my favorite food?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my favorite food?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());
        }

    }


    public void pickQuestion6() {
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Question");
        input.setContentText("What's my cellphone model?");
        Optional<String> result = input.showAndWait();
        if (result.isPresent()) {
            signupMenuController.setPassRecoveryQuestion("What's my cellphone model?");
            signupMenuController.setPassRecoveryAnswer(input.getEditor().getText());

        }

    }


    public void chooseSlogan(MouseEvent mouseEvent) {
        RadioButton slogan1 = new RadioButton("Build. Defend. Conquer.");
        RadioButton slogan2 = new RadioButton("Create Your Own Kingdom and Conquer the World.");
        RadioButton slogan3 = new RadioButton("The desert is a cruel place to fight mi'lord, are you sure you have the heart for it?");
        RadioButton slogan4 = new RadioButton("Prepare for battle! My banner will fly atop your keep before this day is out.");
        RadioButton slogan5 = new RadioButton("Raise Your Siege Skills and Crush Your Enemy.");
        RadioButton slogan6 = new RadioButton("Prepare for battle! My banner will fly atop your keep before this day is out.");
        ToggleGroup tg = new ToggleGroup();
        slogan1.setToggleGroup(tg);
        slogan2.setToggleGroup(tg);
        slogan3.setToggleGroup(tg);
        slogan4.setToggleGroup(tg);
        slogan5.setToggleGroup(tg);
        slogan6.setToggleGroup(tg);
        VBox slogans = new VBox();
        slogans.getChildren().addAll(slogan1 , slogan2 , slogan3 , slogan4 , slogan5 , slogan6);
        Scene scene = new Scene(slogans);
        stage1.setScene(scene);
        stage1.show();
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle o, Toggle n) {
                RadioButton rb = (RadioButton) tg.getSelectedToggle();

                if (rb != null) {
                    signupMenuController.setSlogan(rb.getText());
                    slogan = true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("slogan choose");
                    alert.setContentText("your slogan was chosen successfully");
                    stage1.close();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("slogan error");
                    alert.setContentText("please choose a slogan");

                }

            }
        });
    }
    public void randomPassword(MouseEvent mouseEvent)
    {
        password.setText(signupMenuController.generateRandomPassword());

    }

    public void randomSlogan(MouseEvent mouseEvent) throws Exception {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(11);
            if(rand !=0 && rand < 7) break;
        }
        slogan = true;
        signupMenuController.selectSlogan(String.valueOf(rand));


    }

}

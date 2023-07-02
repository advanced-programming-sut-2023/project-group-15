//this class is completed!
package org.example.view.userView;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.controller.*;
import org.example.controller.userControllers.LoginMenuController;
import org.example.controller.userControllers.MainMenuController;
import org.example.model.Styles;
import org.example.model.User;
import org.example.Server.gameData.GameDataBase;
import org.example.Server.gameData.GameInformation;
import org.example.view.enums.outputs.LoginMenuOutput;

import java.net.URL;
import java.util.regex.Matcher;

import static org.example.Utility.captchaStringGen;
import static org.example.Utility.displacementMap;

public class LoginMenu extends StartingMenu {
    public final LoginMenuController loginMenuController = new LoginMenuController();

    public TextField passwordShow;
    public CheckBox changeMode;
    public PasswordField password;
    public TextField username;
    public Label errorUsername;
    public Label errorPassword;
    public Label successfulLogin;
    private Matcher loginMenuMatcher;
    MainMenuController mainMenuController = new MainMenuController();
    public static Stage stage;
    private static Stage stage1 = new Stage();
    Image background = new Image(getClass().getResource("/Images/01.jpg").toString());
    BackgroundImage bImg = new BackgroundImage(background,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1, 1.0, true, true, false, false));
    Background bGround = new Background(bImg);
    Styles styles = new Styles();

    @FXML
    void changeMode(ActionEvent event){
        if(changeMode.isSelected()){
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
    public void start (Stage stage) throws Exception
    {
        LoginMenu.stage = stage ;
        URL url = StartingMenu.class.getResource("/FXML/Login.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(new Group(), 600, 400);
        ObservableList content = ((Group) scene.getRoot()).getChildren();
        pane.setBackground(bGround);
        String[] captcha;
        captcha = captchaStringGen();

        content.add(displacementMap(captcha[0]));
        content.add(pane);

        stage.setScene(scene);
        stage.show();



    }

    /*   public void run() {
           GameInformation.setCurrentPlayer(GameDataBase.getUserByUsername(loginMenuController.getUsername()));
           String userInput;
           System.out.println(LoginMenuOutput.SHOW_OPTIONS.getOutput());
           ProfileMenu profileMenu = new ProfileMenu(loginMenuController);
           while (true) {
               userInput = InputScanner.getScanner().nextLine();
               if (userInput.matches(LoginMenuEnum.USER_LOGOUT.getRegex())) {
                   loginMenuController.logOut();
                   return;
               } else if (userInput.matches(LoginMenuEnum.EXIT.getRegex())) {
                   System.exit(0);
               } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_PROFILE_USERNAME)) != null) {
                   profileMenu.changeUserUsername(loginMenuMatcher);
               } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_PASSWORD)) != null) {
                   profileMenu.changeUserPassword(loginMenuMatcher);
               } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_PROFILE_EMAIL)) != null) {
                   profileMenu.changeUserEmail(loginMenuMatcher);
               } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_PROFILE_NICKNAME)) != null) {
                   profileMenu.changeUserNickname(loginMenuMatcher);
               } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_SLOGAN)) != null) {
                   profileMenu.changeUserSlogan(loginMenuMatcher);
               } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.REMOVE_SLOGAN) != null) {
                   profileMenu.removeUserSlogan();
               } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.DISPLAY_USER_PROFILE) != null) {
                   profileMenu.displayUserProfile();
               } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.DISPLAY_USER_SLOGAN) != null) {
                   profileMenu.displayUserSlogan();
               } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.DISPLAY_USER_RANK) != null) {
                   profileMenu.displayUserRank();
               } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.DISPLAY_PROFILE) != null) {
                   profileMenu.displayUserInfo();
               } else if ((loginMenuMatcher = GameStartMenuEnum.getMatcher(userInput, GameStartMenuEnum.START_NEW_GAME)) != null) {
                   GameStartMenu gameStartMenu = new GameStartMenu(loginMenuController);
                   gameStartMenu.startNewGame();
               } else if ((loginMenuMatcher = GameStartMenuEnum.getMatcher(userInput, GameStartMenuEnum.ADD_PLAYER)) != null) {
                   gameStartMenu.addPlayer(loginMenuController.getUsername(), loginMenuMatcher);
               } else if (GameStartMenuEnum.getMatcher(userInput, GameStartMenuEnum.ENTER_GAME) != null) {
                   new GameMenu(loginMenuController).run();
   //                new UserTurn(loginMenuController).enterGame();
               } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.LOGOUT) != null) {
                   System.out.println(ProfileMenuOutput.LOGGED_OUT_SUCCESSFULLY.getOutput());
                   break;
               } else {
                   System.out.println(ProfileMenuOutput.INVALID_COMMAND.getOutput());
               }
           }
       }
   */
    public void loginInCheck(String username , String password) throws Exception {
        classify(username, password);
        LoginMenuOutput status = loginMenuController.loginUser();
        if (status.equals(LoginMenuOutput.LOGGED_IN_SUCCESSFULLY)) {
          //  System.out.println(status.getOutput());
            successfulLogin.setStyle(styles.getSuccessfulMessage());

            successfulLogin.setText("successful login");
            for(User user : GameDataBase.getAllUsers()) {
                if (user.getUsername().equals(username)) {
                    MainMenuController.setCurrentUser(user);
                    GameInformation.setCurrentPlayer(user);
                }
            }
            captchaShower();
            //new MainMenu().start(StartingMenu.stage);
        } else if(status.equals(LoginMenuOutput.USER_AND_PASS_MATCH_ERROR)){
            successfulLogin.setStyle(styles.getErrorMessage());
            successfulLogin.setText("username and password doesn't match");
        }
        else if(status.equals(LoginMenuOutput.USER_DOES_NOT_EXIST)){
            successfulLogin.setStyle(styles.getErrorMessage());
            successfulLogin.setText("username doesn't exist");
        }

    }

    private void classify(String username , String pass) {
        loginMenuController.setUsername(username);
        String password = pass;
        byte[] salt = JsonController.makeSalt();
        loginMenuController.setPassword(JsonController.getPassHashSha256(password, salt));
        loginMenuController.setClipBoard(password);
       /* if (matcher.group("logged") != null)
            loginMenuController.setStayLoggedInFlag(true);*/
    }

    /*protected void forgetPassword(String username) {
        loginMenuController.setUsername(username);
        if (loginMenuController.checkMatchUsername()) {
            System.out.println(loginMenuController.findUserSecurityQuestion().getQuestion());
            while (true) {
                String answer = InputScanner.getScanner().nextLine();
                byte[] salt = JsonController.makeSalt();
                answer = JsonController.getPassHashSha256(answer, salt);
                if (loginMenuController.checkSecurityQuestion(answer)) {
                    resettingUserPassword(username);
                } else if (LoginMenuEnum.getMatcher(answer, LoginMenuEnum.QUIT_THE_PROCESS) != null) {
                    break;
                } else
                    System.out.println(LoginMenuOutput.WRONG_ANSWER_FOR_SECURITY_QUESTION.getOutput());
            }
        }
        System.out.println(LoginMenuOutput.USER_DOES_NOT_EXIST.getOutput());
    }*/

   /* private void resettingUserPassword(String username) {
        System.out.println(LoginMenuOutput.ENTER_YOUR_NEW_PASSWORD.getOutput());
        String newPassword = InputScanner.getScanner().nextLine();
        SignupMenuController signupMenuController = new SignupMenuController();
        signupMenuController.setUsername(username);
        signupMenuController.setPassword(newPassword);
        SignupMenuOutput status = SignupMenuController.passwordCheckErrors(newPassword);
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            System.out.println(LoginMenuOutput.ENTER_YOUR_PASSWORD_AGAIN.getOutput());
            while (true) {
                newPassword = InputScanner.getScanner().nextLine();
                signupMenuController.setClipBoard(newPassword);
                if (signupMenuController.checkPasswordWithConfiguration()) {
                    System.out.println(LoginMenuOutput.PASSWORD_SET_SUCCESSFULLY.getOutput());
                    signupMenuController.setPassword(newPassword);
                    signupMenuController.changeForgetPassword();
                    return;
                } else if (newPassword.matches(LoginMenuEnum.QUIT_THE_PROCESS.getRegex())) {
                    return;
                } else
                    System.out.println(SignupMenuOutput.ERROR_PASSWORD_DONOT_MATCH_WITH_CONFIGURATION.getOutput());
            }
        }
    }*/

    public void loggedInUserInformation(String name, String password, String nickname, String email, String slogan, String passwordRecoveryQuestion, String passwordRecoveryAnswer, String rank, String highScore) {
        loginMenuController.setUsername(name);
        loginMenuController.setPassword(password);
        loginMenuController.setNickname(nickname);
        loginMenuController.setEmail(email);
        loginMenuController.setSlogan(slogan);
        loginMenuController.setPassRecoveryQuestion(passwordRecoveryQuestion);
        loginMenuController.setPassRecoveryAnswer(passwordRecoveryAnswer);
        loginMenuController.setRank(Integer.parseInt(rank));
        loginMenuController.setHighScore(Integer.parseInt(highScore));

        // run();
    }

    public void backToMainMenu(MouseEvent mouseEvent) throws Exception {
        new StartingMenu().start(LoginMenu.stage);
    }

    public void forgotPassword(MouseEvent mouseEvent) throws Exception{
        new ForgotPassword().start(LoginMenu.stage);
    }
    public void captchaShower()
    {
        Label captchaMessage = new Label("please enter the below captcha");
        Button submit2 = new Button("submit");
        TextField captchaInput = new TextField();
        captchaInput.setId("captcha");
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
        content.addAll(captchaMessage, submit2, captchaInput);
        stage1.setScene(scene);
        stage1.show();
        //todo the error labels are not shown
        submit2.setOnAction(e ->
        {
            if (!captchaInput.getText().isBlank()) {
                if (captchaInput.getText().equals(captcha[0])) {
                    stage1.close();
                    try {
                        new MainMenu().start(stage);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("captcha error");
                    alert.show();
                    captchaShower();
                }


            }
        });
    }


    public void loginUser(MouseEvent mouseEvent) throws Exception {
        if(password.getText().isBlank())
        {
            errorPassword.setStyle(styles.getErrorMessage());
            errorPassword.setText("password field is blank");
            password.setStyle(styles.getErrorStyle());
        }
        if(username.getText().isBlank())
        {
            errorUsername.setStyle(styles.getErrorMessage());
            errorUsername.setText("password field is blank");
            username.setStyle(styles.getErrorStyle());
        }
        else if(!password.getText().isBlank() && !username.getText().isBlank())
        {
            loginInCheck(username.getText() , password.getText());
        }
    }
}

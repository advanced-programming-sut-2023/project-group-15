//this class is completed!
package org.example.view.userView;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.InputScanner;
import org.example.controller.*;
import org.example.controller.userControllers.LoginMenuController;
import org.example.controller.userControllers.ProfileMenuController;
import org.example.controller.userControllers.SignupMenuController;
import org.example.view.GameStartMenu;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.outputs.LoginMenuOutput;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.net.URL;
import java.util.regex.Matcher;

public class LoginMenu extends MainMenu {
    private final LoginMenuController loginMenuController = new ProfileMenuController();
    private final GameStartMenu gameStartMenu = new GameStartMenu(loginMenuController);
    private Matcher loginMenuMatcher;
    public static Stage stage;
    @Override
    public void start (Stage stage) throws Exception
    {
        LoginMenu.stage = stage ;
        URL url = MainMenu.class.getResource("/FXML/Login.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
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
    public void loginInCheck(Matcher matcher) {
        classify(matcher);
        LoginMenuOutput status = loginMenuController.loginUser();
        if (status.equals(LoginMenuOutput.LOGGED_IN_SUCCESSFULLY)) {
            System.out.println(status.getOutput());
          //  run();
        } else
            System.out.println(status.getOutput());
    }

    private void classify(Matcher matcher) {
        loginMenuController.setUsername(matcher.group("username"));
        String password = matcher.group("password");
        byte[] salt = JsonController.makeSalt();
        loginMenuController.setPassword(JsonController.getPassHashSha256(password, salt));
        loginMenuController.setClipBoard(matcher.group("password"));
        if (matcher.group("logged") != null)
            loginMenuController.setStayLoggedInFlag(true);
    }

    protected void forgetPassword(String username) {
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
    }

    private void resettingUserPassword(String username) {
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
    }

    public void loggedInUserInformation(String name, String password, String nickname, String email, String slogan, String passwordRecoveryQuestion, String passwordRecoveryAnswer, String rank, String highScore) {
        loginMenuController.setUsername(name);
        loginMenuController.setPassword(password);
        loginMenuController.setNickname(nickname);
        loginMenuController.setEmail(email);
        loginMenuController.setSlogan(slogan);
        loginMenuController.setPassRecoveryQuestion(loginMenuController.findUserSecurityQuestion(passwordRecoveryQuestion));
        loginMenuController.setPassRecoveryAnswer(passwordRecoveryAnswer);
        loginMenuController.setRank(Integer.parseInt(rank));
        loginMenuController.setHighScore(Integer.parseInt(highScore));
       // run();
    }

    public void backToMainMenu(MouseEvent mouseEvent) throws Exception {
        new MainMenu().start(LoginMenu.stage);
    }

    public void forgotPassword(MouseEvent mouseEvent) throws Exception{
        new ForgotPassword().start(LoginMenu.stage);
    }
}

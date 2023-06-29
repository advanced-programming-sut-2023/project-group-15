//this class is completed!
package org.example.view.userView;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.controller.userControllers.LoginMenuController;
import org.example.controller.userControllers.ProfileMenuController;
import org.example.view.enums.outputs.ProfileMenuOutput;

import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;

public class ProfileMenu extends Application {
    public void start (Stage stage) throws Exception
    {
        MainMenu.stage = stage ;
        URL url = MainMenu.class.getResource("/FXML/ProfileMenu.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }/*
    private final ProfileMenuController profileMenuController;
    public ProfileMenu(LoginMenuController currentUserController) {
        this.profileMenuController = (ProfileMenuController) currentUserController;
    }
    protected void changeUserUsername(Matcher matcher) {
        String username = matcher.group("username");
        System.out.println(profileMenuController.changeUsername(username).getOutput());
    }
    protected void changeUserPassword(Matcher matcher) {
        String oldPass = matcher.group("oldPass");
        String newPass = matcher.group("newPass");
        System.out.println(profileMenuController.changePassword(oldPass,newPass).getOutput());
    }
    protected void changeUserNickname(Matcher matcher) {
        String nickName = matcher.group("nickname");
        System.out.println(profileMenuController.changeNickname(nickName).getOutput());
    }
    protected void changeUserEmail(Matcher matcher) {
        String email = matcher.group("email");
        System.out.println(profileMenuController.changeEmail(email).getOutput());
    }
    protected void changeUserSlogan(Matcher matcher) {
        String slogan = matcher.group("slogan");
        System.out.println(profileMenuController.changeSlogan(slogan).getOutput());
    }
    protected void removeUserSlogan() {
        System.out.println(profileMenuController.removeSlogan().getOutput());
    }
    protected void displayUserProfile() {
        profileMenuController.showUserHighestScore();
    }
    protected void displayUserRank() {
        profileMenuController.showUserRank();
    }
    protected void displayUserSlogan() {
        profileMenuController.showUserSlogan();

    }
    protected void displayUserInfo() {
        profileMenuController.showUserProfileDisplay();
    }

    public void changeEmail(MouseEvent mouseEvent) {

        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("new slogan");
        sloganInput.setContentText("enter new slogan");
        Optional<String> result = sloganInput.showAndWait();
        String output;
        if(result.isPresent())
        {
            output = String.valueOf(profileMenuController.changeEmail(String.valueOf(result)));
            if(output.equals(ProfileMenuOutput.INVALID_NEW_EMAIL))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("email change error");
                alert.setContentText("your email should be in following format something@somthing.gmail");
                alert.showAndWait();
            }

        }
    }

    public void changeUsername(MouseEvent mouseEvent) {
    }

    public void changeNickname(MouseEvent mouseEvent) {

        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("new nickname");
        sloganInput.setContentText("enter new nickname");
        Optional<String> result = sloganInput.showAndWait();
        if(result.isPresent())
        {
            profileMenuController.changeNickname(String.valueOf(result));
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("please enter a nickname");
        }

    }

    public void changePassword(MouseEvent mouseEvent) {
    }

    public void chooseAvatar(MouseEvent mouseEvent) throws Exception{
        new ChooseAvatar().start(MainMenu.stage);
    }

    public void removeSlogan(MouseEvent mouseEvent) {
        profileMenuController.removeSlogan();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("remove slogan");
        alert.setContentText("your slogan removed successfully");
    }

    public void changeSlogan(MouseEvent mouseEvent) {
        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("new slogan");
        sloganInput.setContentText("enter new slogan");
        Optional<String> result = sloganInput.showAndWait();
        if(result.isPresent())
        {
            profileMenuController.changeSlogan(String.valueOf(result));
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("please enter a slogan");
        }
    }

   */
}

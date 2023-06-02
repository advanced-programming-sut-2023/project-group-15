//this class is completed!
package org.example.view.userView;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

    }
    private ProfileMenuController profileMenuController;
    /*public ProfileMenu(LoginMenuController currentUserController) {
        this.profileMenuController = (ProfileMenuController) currentUserController;
    }*/

    public ProfileMenu() {

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
    public void profileDisplay()
    {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Label username = new Label(profileMenuController.getCurrentUser().getUsername());
        Label password = new Label(profileMenuController.getCurrentUser().getPassword());
        Label nickname = new Label(profileMenuController.getCurrentUser().getNickname());
        Label email = new Label(profileMenuController.getEmail());
        vbox.getChildren().addAll(username , password , nickname , email);
        Pane pane = new Pane();
        Stage stage = new Stage();
        Scene scene = new Scene(vbox , 300 , 300);
        stage.setScene(scene);
        stage.show();
    }



    public void changeEmail(MouseEvent mouseEvent) {

        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("new slogan");
        sloganInput.setContentText("enter new slogan");
        Optional<String> result = sloganInput.showAndWait();
        String userInput;
        if(result.isPresent())
        {
            userInput =String.valueOf(result);
            switch (profileMenuController.changeEmail(userInput))
            {
                case EMAIL_CHANGED_SUCCESSFULLY:
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("email changed");
                    alert.setContentText("your email updated successfully");
                    alert.showAndWait();
                    break;
                case INVALID_NEW_EMAIL:

                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("email change error");
                alert2.setContentText("please enter a valid username");
                alert2.showAndWait();
            }
        }

        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("email is empty");
            alert.setContentText("please enter a email");
            alert.showAndWait();
        }
    }

    public void changeUsername(MouseEvent mouseEvent) {
        TextInputDialog newUsername = new TextInputDialog();
        newUsername.setTitle("new username");
        newUsername.setContentText("please enter your new username");
        Optional<String> result = newUsername.showAndWait();
        String userInput;
        if(result.isPresent())
        {
            userInput = String.valueOf(result);
            switch (profileMenuController.changeUsername(userInput)) {
                case INVALID_NEW_USERNAME:
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("username change");
                    alert.setContentText("please enter a valid username");
                    alert.showAndWait();
                    break;

            }

        }
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
        //TODO check letter by letter and have input for both new and old password
        TextInputDialog passwordDialog = new TextInputDialog();
        passwordDialog.setTitle("password change");

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
        if(result.isPresent()) {
            profileMenuController.changeSlogan(String.valueOf(result));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("slogan change");
            alert.setContentText("your slogan was changed successfully");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("please enter a slogan");
            alert.showAndWait();
        }
    }
  /*  public void initialize(){
        username.textProperty().addListener((observable , oldText , newText)->{
                    usernameCheck();
                }


        );
        password.textProperty().addListener((observable , oldText , newText)->{
            passwordCheck();
        } );
    }*/


}

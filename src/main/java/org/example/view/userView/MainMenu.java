package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.controller.userControllers.LoginMenuController;
import org.example.controller.userControllers.MainMenuController;
import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.view.GameStartMenu;

import java.beans.EventHandler;
import java.net.URL;

public class MainMenu extends Application {
    LoginMenuController loginMenuController= new LoginMenuController();
    GameStartMenu gameStartMenu = new GameStartMenu(loginMenuController);

    Image background = new Image(getClass().getResource("/Images/05.jpg").toString());
    BackgroundImage bImg = new BackgroundImage(background,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1, 1.0, true, true, false, false));
    Background bGround = new Background(bImg);
    public void start (Stage stage) throws Exception{
        URL url = MainMenu.class.getResource("/FXML/MainMenu.fxml");
        Pane pane = FXMLLoader.load(url);
        pane.setBackground(bGround);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    public void enterProfileMenu(MouseEvent mouseEvent) throws Exception {
        new ProfileMenu().start(StartingMenu.stage);
    }

    public void addPlayer(MouseEvent mouseEvent) {
        TextArea textArea = new TextArea();
        for(User user : GameDataBase.getAllUsers())
        textArea.appendText(user.getUsername() + "\n");
        TextField textField = new TextField();
        Label label = new Label();
        label.setText("enter player name");
        Button button = new Button();
        button.setText("choose");
        button.setOnAction(e ->
        {
           int output = gameStartMenu.addPlayer(MainMenuController.getCurrentUser().getUsername() , textField.textProperty().toString() );
        switch (output){
            case(1):

        }
        });
    }
}

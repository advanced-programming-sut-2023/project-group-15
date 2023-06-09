package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.controller.userControllers.MainMenuController;
import org.example.model.gameData.GameDataBase;

import java.net.URL;

public class MainMenu extends Application {

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
}

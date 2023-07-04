package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.controller.userControllers.MainMenuController;

import java.net.URL;

public class StartingMenu extends Application {
    public static Stage stage;
    Image background = new Image(getClass().getResource("/Images/04.jpg").toString());
    BackgroundImage bImg = new BackgroundImage(background,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1, 1.0, true, true, false, false));
    Background bGround = new Background(bImg);
    @Override
    public void start(Stage stage) throws Exception {
        new MainMenuController().checkJsonDirectory();
        StartingMenu.stage = stage;
        URL url = StartingMenu.class.getResource("/FXML/StartingMenu.fxml");
        Pane pane = FXMLLoader.load(url);
        pane.setBackground(bGround);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void signUp() throws Exception {
        new SignupMenu().start(StartingMenu.stage);
    }

    public void login() throws Exception {
        new LoginMenu().start(StartingMenu.stage);
    }

    public void exit() {
        stage.close();
    }


}

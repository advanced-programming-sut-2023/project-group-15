package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.controller.userControllers.LoginMenuController;
import org.example.controller.userControllers.MainMenuController;
import org.example.gameMap.GamePanel;
import org.example.gameMap.Main;
import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;
import org.example.view.GameStartMenu;
import org.example.view.enums.outputs.GameStartMenuOutput;

import javax.swing.*;
import java.net.URL;

public class MainMenu extends Application {
    private static String username;
    LoginMenuController loginMenuController = new LoginMenuController();

    GameStartMenu gameStartMenu = new GameStartMenu(loginMenuController);

    Image background = new Image(getClass().getResource("/Images/05.jpg").toString());
    BackgroundImage bImg = new BackgroundImage(background,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1, 1.0, true, true, false, false));
    Background bGround = new Background(bImg);

    public void start(Stage stage) throws Exception {
        URL url = MainMenu.class.getResource("/FXML/MainMenu.fxml");
        Pane pane = FXMLLoader.load(url);
        pane.setBackground(bGround);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    public void enterProfileMenu() throws Exception {
        new ProfileMenu().start(StartingMenu.stage);
    }

    public void addPlayer() {
        TextArea textArea = new TextArea();
        for (User user : GameDataBase.getAllUsers())
            textArea.appendText(user.getUsername() + "\n");
        TextField textField = new TextField();
        Label label = new Label();
        label.setText("enter player name");

        Button button = new Button();
        button.setText("choose");
        button.setOnAction(e ->
        {
          /*  for(User player: GameInformation.getAllPlayers())
            System.out.println(player.getUsername());*/
            GameStartMenuOutput gameStartMenuOutput = gameStartMenu.addPlayer(MainMenuController.getCurrentUser().getUsername(),
                    GameDataBase.getUserByUsername(textField.getText()));
            if (gameStartMenuOutput.equals(GameStartMenuOutput.PLAYER_CAPACITY_IS_FULL)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("sorry there already 8 players in the game");
                alert.showAndWait();

            } else if (gameStartMenuOutput.equals(GameStartMenuOutput.User_DOESNT_EXIST)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(gameStartMenuOutput.getOutput());
                alert.showAndWait();
            } else if (gameStartMenuOutput.equals(GameStartMenuOutput.ADD_USER_FORBIDDEN)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(gameStartMenuOutput.getOutput());
                alert.showAndWait();
            } else if (gameStartMenuOutput.equals(GameStartMenuOutput.GAME_IS_NOT_STARTED)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(gameStartMenuOutput.getOutput());
                alert.showAndWait();
            } else if (gameStartMenuOutput.equals(GameStartMenuOutput.PLAYER_IN_THE_GAME)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(gameStartMenuOutput.getOutput());
                alert.showAndWait();
            } else if (gameStartMenuOutput.equals(GameStartMenuOutput.ADD_USER_SUCCESS)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(gameStartMenuOutput.getOutput());
                alert.showAndWait();
            }

        });
        textArea.setPrefWidth(200);
        textArea.setPrefHeight(200);
        textArea.setTranslateX(208);
        textArea.setTranslateY(67);
        textArea.setEditable(false);
        textField.setTranslateX(233);
        textField.setTranslateY(307);
        label.setTranslateX(122);
        label.setTranslateY(23);
        button.setTranslateX(294);
        button.setTranslateY(361);
        Pane pane = new Pane();
        pane.setPrefWidth(639);
        pane.setPrefHeight(400);
        pane.getChildren().addAll(label, textArea, textField, button);
        pane.setBackground(bGround);
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void startGame() {
        // gameStartMenu.startNewGame();
        GameInformation.setNewGameAccess(true);
        GameInformation.getCurrentPlayer().setUserNO(1);
        GameInformation.getCurrentPlayer().setGovernment(new Government(GameInformation.getCurrentPlayer().getUsername()));
    }

    public void enterGame() {
        new Main().startingGame();
    }

    public void logout() throws Exception {
        StartingMenu.stage.close();
        new StartingMenu().start(new Stage());
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MainMenu.username = username;
    }
}

package org.example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.controller.TradingMenuController;
import org.example.model.User;
import org.example.model.gameData.GameInformation;

import java.net.URL;

public class NewTrade extends Application {
    public TextField user;
    public User chosen;
    public TradingMenuController tradingMenuController;
    public TextArea users = new TextArea();
    public void start(Stage stage) throws Exception{
        URL url = NewTrade.class.getResource("/FXML/newTrade.fxml");
        for(User player : GameInformation.getAllPlayers())
        users.appendText(player.getUsername() + "\n");
        users.setEditable(false);
        users.setTranslateX(208);
        users.setPrefHeight(200);
        users.setPrefWidth(200);
        users.setTranslateY(67);
        Pane pane = FXMLLoader.load(url);
        pane.getChildren().add(users);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    public void startTrade(MouseEvent mouseEvent) {
        String input = user.getText();

        for(User player : GameInformation.getAllPlayers())
        {
            if(player.getUsername().equals(input))
                chosen = player;

        }


    }
}

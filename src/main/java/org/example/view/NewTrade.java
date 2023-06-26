package org.example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.model.User;
import org.example.model.gameData.GameInformation;

import java.net.URL;

public class NewTrade extends Application {
    public TextField user;
    public void start(Stage stage) throws Exception{
        URL url = NewTrade.class.getResource("/FXML/newTrade.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    public void startTrade(MouseEvent mouseEvent) {
        String input = user.getText();
        User user;
        for(User player : GameInformation.getAllPlayers())
        {
            if(player.getUsername().equals(input))
                user = player;

        }

    }
}

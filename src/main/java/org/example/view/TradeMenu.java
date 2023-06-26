package org.example.view;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.model.User;
import org.example.model.gameData.GameInformation;

import java.awt.*;

public class TradeMenu {
    public void newTrade(MouseEvent mouseEvent) throws Exception {
        new NewTrade().start(new Stage());

    }

    public void showHistory(MouseEvent mouseEvent) {

    }
}

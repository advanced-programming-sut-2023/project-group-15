package org.example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controller.TradingMenuController;
import org.example.controller.userControllers.MainMenuController;
import org.example.model.User;

import java.net.URL;

public class TradeMenu extends Application {
    User currentUser = MainMenuController.getCurrentUser();
    TradingMenuController tradingMenuController = new TradingMenuController(currentUser.getUsername());
    public void start(Stage stage) throws Exception{
        URL url = TradeMenu.class.getResource("FXML/TradeRequest.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void newTrade(MouseEvent mouseEvent) throws Exception {
        new NewTrade().start(new Stage());

    }

    public void showHistory(MouseEvent mouseEvent) {
        TextArea textArea = new TextArea();
        textArea.setText(tradingMenuController.showTradeHistory());
        textArea.setEditable(false);
        VBox vBox = new VBox();
        vBox.getChildren().add(textArea);
        Stage stage = new Stage();
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}

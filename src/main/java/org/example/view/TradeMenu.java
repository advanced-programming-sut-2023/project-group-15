package org.example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controller.TradingMenuController;
import org.example.controller.userControllers.MainMenuController;
import org.example.model.User;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Trade;
import org.example.view.enums.outputs.GameInformationOutput;

import java.net.URL;

public class TradeMenu extends Application {
    User currentUser = MainMenuController.getCurrentUser();
    TradingMenuController tradingMenuController = new TradingMenuController(currentUser.getUsername());
    public void start(Stage stage) throws Exception{
        URL url = TradeMenu.class.getResource("FXML/TradingMenu.fxml");
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

    public void showTrade(MouseEvent mouseEvent) {
        Alert alertResource = new Alert(Alert.AlertType.ERROR);
        alertResource.setContentText("not enough resources");
        Alert alertCoins = new Alert(Alert.AlertType.ERROR);
        alertCoins.setContentText("seems the sender doesn't have enough coin now");
        Alert alertAccept = new Alert(Alert.AlertType.INFORMATION);
        alertAccept.setContentText("accepted successfully");
        TextArea textArea = new TextArea();
        textArea.appendText(Trade.showTrades());
        Pane pane = new Pane();
        pane.setPrefHeight(410);
        pane.setPrefWidth(630);
        textArea.setPrefHeight(232);
        textArea.setPrefWidth(460);
        TextField textField = new TextField();
        textField.setTranslateX(252);
        textField.setTranslateY(311);
        textArea.setTranslateX(85);
        textArea.setTranslateY(42);
        Button accept = new Button();
        accept.setText("accept");
        accept.setTranslateX(276);
        accept.setTranslateY(362);
        Label index = new Label();
        index.setText("index");
        index.setTranslateX(167);
        index.setTranslateY(315);
        accept.setOnAction(e ->
        {
            GameInformationOutput output = tradingMenuController.acceptRequest(Integer.parseInt(index.getText()));
                if(output.equals(GameInformationOutput.NOT_ENOUGH))
                alertResource.showAndWait();
                else if(output.equals(GameInformationOutput.NOT_ENOUGH_COIN))
                    alertCoins.showAndWait();
                    else if(output.equals(GameInformationOutput.ACCEPTED_SUCCESSFULLY))
                        alertAccept.showAndWait();
        });
        pane.getChildren().addAll(index , textArea , textField , accept);
        Stage stage = new Stage();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}

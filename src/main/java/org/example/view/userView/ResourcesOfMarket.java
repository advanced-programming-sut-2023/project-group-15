package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.controller.MarketController;

import java.net.URL;
import java.util.HashMap;

public class ResourcesOfMarket extends Application {
    public ImageView image;
    private String name ;
    private static Stage stage;
    private final MarketController marketController = new MarketController();
   // public Market market = new Market();
    @Override
    public void start(Stage stage) throws Exception {
        HashMap<String, Integer> number = new HashMap<>(marketController.show1());
        HashMap<String, Integer> sellCoin = new HashMap<>(marketController.show2());
        HashMap<String, Integer> buyCoin = new HashMap<>(marketController.show3());
        ResourcesOfMarket.stage = stage;
        URL url = SignupMenu.class.getResource("/FXML/ResourcesOfMarket.fxml");
        Label nameItem = new Label();
        Label numberOfProduct = new Label();
        nameItem.setLayoutX(105.0);
        nameItem.setLayoutY(134.0);
        numberOfProduct.setLayoutX(105.0);
        numberOfProduct.setLayoutY(101.0);
        Button sellItem = new Button("sell   " + sellCoin.get(marketController.getName()));
        Button buyItem = new Button("sell   " + sellCoin.get(marketController.getName()));




        sellItem.setLayoutX(300.0);
        sellItem.setLayoutY(115.0);
        buyItem.setLayoutX(300.0);
        buyItem.setLayoutY(157);
        sellItem.prefWidth(156.0);
        sellItem.prefHeight(35.0);
        buyItem.prefWidth(156.0);
        buyItem.prefHeight(35.0);
        //System.out.println(market.name);
        numberOfProduct.setText(marketController.getName().toString());
        Pane pane = FXMLLoader.load(url);
        pane.getChildren().add(sellItem);
        pane.getChildren().add(buyItem);
        pane.getChildren().add(numberOfProduct);
        pane.getChildren().add(nameItem);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void sell(MouseEvent mouseEvent) {
    }

    public void buy(MouseEvent mouseEvent) {
    }

    public void setName(String name1) {
        this.name = name1;
    }

    public String getName() {
        return this.name;
    }
}

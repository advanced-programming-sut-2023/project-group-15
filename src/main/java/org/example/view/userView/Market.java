package org.example.view.userView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.example.controller.MarketController;
import org.example.controller.userControllers.SignupMenuController;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Market extends Application implements Initializable {
    private final MarketController marketController = new MarketController();
    public ImageView wood;
    public ImageView bread;
    public ImageView apple;
    public ImageView iron;
    public ImageView rock;
    public ImageView spear;
    public ImageView meat;
    public ImageView vest;
    public ImageView archer;
    public ImageView sword;
    public ImageView wheat;
    public ImageView pitch;
    public ImageView hop;
    public ImageView lather;
    public ImageView mace;
    public ImageView cheese;

    Pane pane;
    private static Stage stage;
    public static String name;
    
    private final SignupMenuController signupMenuController = new SignupMenuController();

    public
    String successfulMessage = String.format("-fx-text-fill: Black;");
    @FXML
    public void showResource(MouseEvent mouseEvent) {

        if(apple.isPressed())
            setName("apple");
        else if(archer.isPressed())
            setName("archer");
        else if(bread.isPressed())
            setName("bread");
        else if(hop.isPressed())
            setName("hop");
        else if(cheese.isPressed())
            setName("cheese");
        else if(pitch.isPressed())
            setName("pitch");
        else if(sword.isPressed())
            setName("sword");
        else if(spear.isPressed())
            setName("spear");
        else if(rock.isPressed())
            setName("rock");
        else if(iron.isPressed())
            setName("iron");
        else if(lather.isPressed())
            setName("lather");
        else if(mace.isPressed())
            setName("mace");
        else if(wheat.isPressed())
            setName("wheat");
        else if(vest.isPressed())
            setName("vest");
        else if(wood.isPressed())
            setName("wood");
        else
            setName("meat");

        try {
            String successfulMessage = String.format("-fx-text-fill: Green;");
            String errorMessage = String.format("-fx-text-fill: RED;");
            HashMap<String, Integer> number = new HashMap<>(marketController.show1());
            HashMap<String, Integer> sellCoin = new HashMap<>(marketController.show2());
            HashMap<String, Integer> buyCoin = new HashMap<>(marketController.show3());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/ResourcesOfMarket.fxml"));

            Label nameItem = new Label();
            Label numberOfProduct = new Label();
            nameItem.setLayoutX(210.0);
            nameItem.setLayoutY(75.0);
            numberOfProduct.setLayoutX(210.0);
            numberOfProduct.setLayoutY(120.0);
            Button sellItem = new Button("sell      " + buyCoin.get(name));
            Button buyItem = new Button("buy        " + sellCoin.get(name));
            Label successSell = new Label("successful sell...");
            Label successBuy = new Label("successful buy...");
            Label errorSell = new Label("error sell!");
            Label errorBuy = new Label("error buy!");
            successSell.setStyle("-fx-background-color: white;");
            successSell.setStyle(successfulMessage);
            successBuy.setStyle(successfulMessage);
            errorBuy.setStyle(errorMessage);
            errorSell.setStyle(errorMessage);
            Popup popupMessage = new Popup();
            Stage stage = new Stage();
            EventHandler<ActionEvent> sell = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e)
                {
                  switch (marketController.sell(name,1)){
                      case SUCCESSFUL_SELL : System.out.println("successful");
                          HashMap<String, Integer> newNumber = new HashMap<>(marketController.show1());
                          System.out.println(newNumber.get(name));
                          numberOfProduct.setText("number: " + (newNumber.get(name)));
                          popupMessage.setX(730);
                          popupMessage.setY(280);
                          popupMessage.getContent().add(successSell);
                          break;
                      default:
                          popupMessage.setX(730);
                          popupMessage.setY(280);
                          popupMessage.getContent().add(errorSell);
                  }

                    if (!popupMessage.isShowing())
                        popupMessage.show(stage);
                    else
                        popupMessage.hide();
                }
            };

            EventHandler<ActionEvent> buy = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                    switch (marketController.buy(name,1)){
                        case SUCCESSFUL_BUY : System.out.println("successful");
                            HashMap<String, Integer> newNumber = new HashMap<>(marketController.show1());
                            numberOfProduct.setText(("number: " + newNumber.get(name)));
                            popupMessage.setX(730);
                            popupMessage.setY(280);
                            popupMessage.getContent().add(successSell);
                            break;
                        default:
                            popupMessage.setX(730);
                            popupMessage.setY(280);
                            popupMessage.getContent().add(errorBuy);
                    }
                }
            };
            buyItem.setOnAction(buy);
            sellItem.setOnAction(sell);
            nameItem.setText(name);
            nameItem.setFont(Font.font("century"));
            numberOfProduct.setText("number: " + (number.get(name)));
            numberOfProduct.setFont(Font.font("century"));
            sellItem.setLayoutX(300.0);
            sellItem.setLayoutY(65.0);
            buyItem.setLayoutX(300.0);
            buyItem.setLayoutY(110.0);
            sellItem.setMinSize(156.0 , 35.0);
            buyItem.setMinSize(156.0 , 35.0);

            Pane pane = fxmlLoader.load();

            pane.getChildren().add(sellItem);
            pane.getChildren().add(buyItem);
            pane.getChildren().add(numberOfProduct);
            pane.getChildren().add(nameItem);
          //  pane.getChildren().add(confirm);


            stage.setTitle("Resource");
            stage.setScene(new Scene(pane));
            stage.show();
        } catch (Exception e){
            System.out.println("can not");
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
       Market.stage = stage;
        URL url = SignupMenu.class.getResource("/FXML/Market.fxml");

        pane = FXMLLoader.load(url);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Market.name = name;
    }
}




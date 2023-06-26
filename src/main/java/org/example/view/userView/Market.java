package org.example.view.userView;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.controller.MarketController;
import org.example.controller.userControllers.SignupMenuController;

import java.io.FileNotFoundException;
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
    public ImageView image;
    public ImageView image1;

    Pane pane;
    private static Stage stage;
    public static String name;
    
    private final SignupMenuController signupMenuController = new SignupMenuController();

    public
    String successfulMessage = String.format("-fx-text-fill: Black;");
    @FXML
    public void showResource(MouseEvent mouseEvent) throws FileNotFoundException {

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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML2/ResourcesOfMarket.fxml"));

            Image back = new Image(getClass().getResource("/images/0_0img22.png").toString());
            ImageView backIcon = new ImageView(back);
            backIcon.setLayoutX(26.0);
            backIcon.setLayoutY(114.0);
            Label numberOfProduct = new Label();
            numberOfProduct.setLayoutX(230.0);
            numberOfProduct.setLayoutY(115.0);
            Text sellLable = new Text("sell      " + buyCoin.get(name));
            sellLable.setFont(Font.font("Century",14));
            sellLable.setLayoutX(330.0);
            sellLable.setLayoutY(85);
            Image button = new Image((getClass().getResource("/images/0_0img47.png").toString()));
            ImageView sellItem = new ImageView(button);
            Text buyLable = new Text("buy        " + sellCoin.get(name));
            buyLable.setFont(Font.font("Century",14));
            buyLable.setLayoutX(330.0);
            buyLable.setLayoutY(130.0);
            ImageView buyItem = new ImageView(button);
            String address = "/images/"+name+".png";
            System.out.println(address);
            Image image2 = new Image((getClass().getResource(address).toString()));
            ImageView imageView = new ImageView(image2);
            imageView.setLayoutX(220.0);
            imageView.setLayoutY(58);
          //  imageView.setPreserveRatio(true);
           // imageView.setLayoutX(0);
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
            EventHandler<MouseEvent> backToGame = (EventHandler<MouseEvent>) e -> {
                stage.close();
            };
            EventHandler<MouseEvent> sell = (EventHandler<MouseEvent>) e -> {
                switch (marketController.sell(name, 1)) {
                    case SUCCESSFUL_SELL:
                        System.out.println("successful");
                        HashMap<String, Integer> newNumber = new HashMap<>(marketController.show1());
                        System.out.println(newNumber.get(name));
                        numberOfProduct.setText(String.valueOf(newNumber.get(name)));
                        popupMessage.setX(730);
                        popupMessage.setY(260);
                        popupMessage.getContent().add(successSell);
                        break;
                    default:
                        popupMessage.setX(730);
                        popupMessage.setY(260);
                        popupMessage.getContent().add(errorSell);
                }

                if (!popupMessage.isShowing())
                    popupMessage.show(stage);
                else
                    popupMessage.hide();
            };

            EventHandler<MouseEvent> buy = (EventHandler<MouseEvent>) e ->{

                    switch (marketController.buy(name,1)){
                        case SUCCESSFUL_BUY : System.out.println("successful");
                            HashMap<String, Integer> newNumber = new HashMap<>(marketController.show1());
                            numberOfProduct.setText(String.valueOf((newNumber.get(name))));
                            popupMessage.setX(730);
                            popupMessage.setY(260);
                            popupMessage.getContent().add(successSell);
                            break;
                        default:
                            popupMessage.setX(730);
                            popupMessage.setY(260);
                            popupMessage.getContent().add(errorBuy);
                    }

            };
            buyLable.setOnMouseClicked(buy);
            sellLable.setOnMouseClicked(sell);
            backIcon.setOnMouseClicked(backToGame);
            buyItem.setOnMouseClicked(buy);
            sellItem.setOnMouseClicked(sell);
            numberOfProduct.setText(String.valueOf((number.get(name))));
            numberOfProduct.setFont(Font.font("century",18));
            sellItem.setLayoutX(300.0);
            sellItem.setLayoutY(65.0);
            buyItem.setLayoutX(300.0);
            buyItem.setLayoutY(110.0);
          //  sellItem.setMinSize(156.0 , 35.0);
          //  buyItem.setMinSize(156.0 , 35.0);


            Pane pane = fxmlLoader.load();
            pane.getChildren().add(sellItem);
            pane.getChildren().add(imageView);
            pane.getChildren().add(sellLable);
            pane.getChildren().add(buyItem);
            pane.getChildren().add(buyLable);
            pane.getChildren().add(numberOfProduct);
            pane.getChildren().add(backIcon);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Resource");
            stage.setScene(new Scene(pane));
            stage.show();
        } catch (Exception e){
            System.out.println(e);

            Image image2 = new Image((getClass().getResource("/images/0_0img47.png").toString()));
            ImageView imageView = new ImageView(image2);
            imageView.setPreserveRatio(true);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
       Market.stage = stage;
        URL url = SignupMenu.class.getResource("/FXML2/Market.fxml");

        pane = FXMLLoader.load(url);

        Scene scene = new Scene(pane);
        stage.initStyle(StageStyle.UNDECORATED);
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

    public void backToGame(MouseEvent event) {
        stage.close();
    }
}




package org.example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.model.enums.Products;

import java.net.URL;
import java.util.ArrayList;

import static org.example.model.enums.Products.*;

public class TradeRequest extends Application {
    NewTrade newTrade = new NewTrade();
    public Label wood;
    public Label bread;
    public Label vest;
    public Label hop;
    public Label mace;
    public Label sword;
    public Label wheat;
    public Label pitch;
    public Label archer;
    public Label apple;

    public Label iron;
    public Label meat;
    public Label spear;
    public Label armour;
    public Label cheese;
    public Label rock;
    public ImageView Wood;
    public ImageView Bread;
    public ImageView Apple;
    public ImageView Iron;
    public ImageView Rock;
    public ImageView Spear;
    public ImageView Meat;
    public ImageView Vest;
    public ImageView Archer;
    public ImageView Sword;
    public ImageView Wheat;
    public ImageView Pitch;
    public ImageView Hop;
    public ImageView Lather;
    public ImageView Mace;
    public ImageView Cheese;
    public ImageView image;
    public Label reName = new Label();
    Pane pane;
    private static Stage stage;
    public static String name;
    private ArrayList<Products> products = new ArrayList<>();


    public void start(Stage stage) throws Exception {
        URL url = TradeRequest.class.getResource("/FXML/TradeRequest.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        this.products.add(WOOD);
        this.products.add(APPLE);
        this.products.add(ARCHER);
        this.products.add(ARMOUR);
        this.products.add(ROCK);
        this.products.add(CHEESE);
        this.products.add(SPEAR);
        this.products.add(MEAT);
        this.products.add(MACE);
        this.products.add(IRON);
        this.products.add(HOP);
        this.products.add(PITCH);
        this.products.add(SWORD);
        this.products.add(WEAT);
        this.products.add(BREAD);
        this.products.add(VEST);
    }

    public void showResource(MouseEvent mouseEvent) {

        if (Apple.isPressed()) {
            setName("apple");
            reName.setText("apple");
        } else if (Archer.isPressed()) {
            setName("archer");
            reName.setText("archer");
        } else if (Bread.isPressed()) {
            setName("bread");
            reName.setText("bread");
        } else if (Hop.isPressed()) {
            setName("hop");
            reName.setText("hop");
        } else if (Cheese.isPressed()) {
            setName("cheese");
            reName.setText("cheese");
        } else if (Pitch.isPressed()) {
            setName("pitch");
            reName.setText("pitch");
        } else if (Sword.isPressed()) {
            setName("sword");
            reName.setText("sword");
        } else if (Spear.isPressed()) {
            setName("spear");
            reName.setText("spear");
        } else if (Rock.isPressed()) {
            setName("rock");
            reName.setText("rock");
        } else if (Iron.isPressed()) {
            setName("iron");
            reName.setText("iron");
        } else if (Lather.isPressed()) {
            setName("lather");
            reName.setText("lather");
        } else if (Mace.isPressed()) {
            setName("mace");
            reName.setText("mace");
        } else if (Wheat.isPressed()) {
            setName("wheat");
            reName.setText("wheat");
        } else if (Vest.isPressed()) {
            setName("vest");
            reName.setText("vest");
        } else if (Wood.isPressed()) {
            setName("wood");
            reName.setText("wood");
        } else {
            setName("meat");
            reName.setText("meat");
        }
        try {
            String successfulMessage = String.format("-fx-text-fill: Green;");
            String errorMessage = String.format("-fx-text-fill: RED;");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/ResourcesInTrade.fxml"));
            Button request = new Button();
            Button donate = new Button();
            TextField message = new TextField();
            TextField cost = new TextField();
            TextField number = new TextField();
            request.setText("Request");
            request.setTranslateX(511);
            request.setTranslateY(90);
            donate.setTranslateX(513);
            donate.setTranslateY(39);
            donate.setText("Donate");
            message.setTranslateX(81);
            message.setTranslateY(30);
            number.setTranslateX(81);
            number.setTranslateY(98);
            reName.setTranslateX(294);
            reName.setTranslateY(115);
            cost.setTranslateX(81);
            cost.setTranslateY(65);
            number.setPrefHeight(25);
            number.setPrefWidth(99);
            message.setPrefHeight(25);
            message.setPrefWidth(99);
            cost.setPrefHeight(25);
            cost.setPrefWidth(99);
            request.setOnAction(e ->
            {
                if (message.getText().isBlank() || cost.getText().isBlank() || number.getText().isBlank()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error in trade");
                    alert.setContentText("please fill all the fields properly");
                    alert.showAndWait();
                } else {
                    newTrade.tradingMenuController.sendTradeRequest(name, Integer.parseInt(number.getText()), message.getText()
                            , Double.parseDouble(cost.getText()), newTrade.chosen);

                }
            });
            donate.setOnAction(e -> {
                        newTrade.tradingMenuController.sendTradeDonate(name, Integer.parseInt(number.getText()), message.getText(),
                                Double.parseDouble(cost.getText()), newTrade.chosen);
                    }
            );
            Image back = new Image(getClass().getResource("/images1/0_0img22.png").toString());
            ImageView backIcon = new ImageView(back);
            backIcon.setLayoutX(26.0);
            backIcon.setLayoutY(114.0);
            String address = "/images1/" + name + ".png";
            Image image2 = new Image((getClass().getResource(address).toString()));
            ImageView imageView = new ImageView(image2);
            imageView.setLayoutX(220.0);
            imageView.setLayoutY(58);
            Pane pane1 = fxmlLoader.load();
            pane1.getChildren().addAll(request, donate, imageView, number, message, backIcon, cost, reName);
            Scene scene = new Scene(pane1);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void setName(String name) {
        TradeRequest.name = name;
    }


}

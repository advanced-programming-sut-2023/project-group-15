package org.example.view.userView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.controller.GameMenuController;

import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class GovermentMenu extends Application implements Initializable {
    private GameMenuController gameMenuController = new GameMenuController();
    private static Stage stage;
    public Button setRate;
    public Button setTaxRate;
    public Button setFoodRate;
    public Button setFearRate;

    Pane root;
    Stage stage1;
    @Override
    public void start(Stage stage) throws Exception {
        GovermentMenu.stage = stage ;
        URL url = MainMenu.class.getResource("/FXML/Goverment.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

   /* public void gameInformation(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/GameInformation.fxml"));
            Pane root = fxmlLoader.load();
            Slider slider = new Slider();
            slider.setId("custom");
            slider.setPrefHeight(25.0);
            slider.setPrefWidth(180.0);
            root.getChildren().add(slider);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root);
            Path path = Paths.get("/Css/MainMenuStyle.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/Css/MainMenuStyle.css").toExternalForm());
          //  System.out.println(getClass().getResource("/Css/MainMenu.css").getPath());
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }*/

    public void gameInformation(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/setRate.fxml"));
            Pane root1 = fxmlLoader.load();
            ImageView backToGameMenu = new ImageView(String.valueOf(getClass().getResource("/images/0_0img73.png")));
            backToGameMenu.prefWidth(174);
            backToGameMenu.prefHeight(35);
            backToGameMenu.setLayoutX(78);
            backToGameMenu.setLayoutY(299);
            setRate = new Button();
            setRate.setId("setRate");
            Stage stage = new Stage();
            EventHandler<MouseEvent> backToGame = (EventHandler<MouseEvent>) e -> {
                stage.close();
            };
            backToGameMenu.setOnMouseClicked(backToGame);
            stage.initStyle(StageStyle.UNDECORATED);
            root1.getChildren().add(backToGameMenu);
            Scene scene = new Scene(root1);
            Path path = Paths.get("/Css/setRate.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/Css/setRate.css").toExternalForm());
            //  System.out.println(getClass().getResource("/Css/MainMenu.css").getPath());
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void setRate(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/setRateOptions.fxml"));
            Pane root = fxmlLoader.load();
            ImageView backToGameMenu = new ImageView(String.valueOf(getClass().getResource("/images/0_0img73.png")));
            backToGameMenu.prefWidth(174);
            backToGameMenu.prefHeight(35);
            backToGameMenu.setLayoutX(78);
            backToGameMenu.setLayoutY(299);
            Stage stage = new Stage();
            EventHandler<MouseEvent> backToGame = (EventHandler<MouseEvent>) e -> {
                stage.close();
            };
            backToGameMenu.setOnMouseClicked(backToGame);
            stage.initStyle(StageStyle.UNDECORATED);
            root.getChildren().add(backToGameMenu);
            Scene scene = new Scene(root);
            Path path = Paths.get("/Css/setRateOptions.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/Css/setRateOptions.css").toExternalForm());
            //  System.out.println(getClass().getResource("/Css/MainMenu.css").getPath());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

  /*   try {
      */



    public void backToSetRate(MouseEvent event) {
        stage1.close();
    }

    public void setFearRate(ActionEvent event) {
     try{   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/GameInformation.fxml"));
        Pane root = fxmlLoader.load();
        Slider slider = new Slider();
        slider.setId("custom");
        slider.setPrefHeight(25.0);
        slider.setPrefWidth(180.0);
        slider.setLayoutX(312);
        slider.setLayoutY(69);
        ImageView left = new ImageView(String.valueOf(getClass().getResource("/images/0_0img22.png")));
        left.setLayoutX(283);
        left.setLayoutY(69);
        left.prefWidth(36);
        left.prefHeight(30);
         ImageView right = new ImageView(String.valueOf(getClass().getResource("/images/0_0img277.png")));
         right.setFitWidth(36);
         right.setFitHeight(35);
         right.setLayoutX(486);
         right.setLayoutY(69);
         root.getChildren().add(right);
        root.getChildren().add(left);
        root.getChildren().add(slider);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        Path path = Paths.get("/Css/MainMenuStyle.css");
        String address = String.valueOf(path.toAbsolutePath());
        System.out.println(address);
        scene.getStylesheets().add(getClass().getResource("/Css/MainMenuStyle.css").toExternalForm());
        //  System.out.println(getClass().getResource("/Css/MainMenu.css").getPath());
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        System.out.println(e);
    }
    }

    Label foodCoins;
    Label numberOfPeople;
    Slider foodSlider = new Slider();
    Label foodInfo;
    public void setFoodRate(ActionEvent event) {
        try{   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/GameInformation.fxml"));
            Pane root = fxmlLoader.load();
            foodSlider.setId("custom");
            foodSlider.setPrefHeight(25.0);
            foodSlider.setPrefWidth(180.0);
            foodSlider.setLayoutX(312);
            foodSlider.setLayoutY(69);
            foodSlider.setMin(-2);
            foodSlider.setMax(2);
            ImageView left = new ImageView(String.valueOf(getClass().getResource("/images/0_0img22.png")));
            left.setLayoutX(283);
            left.setLayoutY(69);
            left.prefWidth(36);
            left.prefHeight(30);
            ImageView right = new ImageView(String.valueOf(getClass().getResource("/images/0_0img277.png")));
            right.setFitWidth(36);
            right.setFitHeight(35);
            right.setLayoutX(486);
            right.setLayoutY(69);
            ImageView food = new ImageView(String.valueOf(getClass().getResource("/images/0_0img92.png")));
            food.setFitHeight(80);
            food.setFitWidth(80);
            food.setLayoutY(37);
            food.setLayoutX(46);
            ImageView foodImage = new ImageView(String.valueOf(getClass().getResource("/images/0_0img93.png")));
            foodImage.setLayoutX(468);
            foodImage.setLayoutY(29);
            foodImage.setFitWidth(35);
            foodImage.setFitHeight(30);
            ImageView person = new ImageView(String.valueOf(getClass().getResource("/images/0_0img126.png")));
            person.setFitHeight(31);
            person.setFitWidth(30);
            person.setLayoutY(26);
            person.setLayoutX(300);
            Label label = new Label("Set Food Rate");
            label.setFont(Font.font("Century",24));
            label.setLayoutX(43);
            label.setLayoutY(14);
            foodCoins = new Label("food");
            foodCoins.setLayoutY(27);
            foodCoins.setLayoutX(430);
            foodCoins.setFont(Font.font("Century",18));
            numberOfPeople = new Label("person");
            numberOfPeople.setLayoutY(27);
            numberOfPeople.setLayoutX(330);
            numberOfPeople.setFont(Font.font("Century",18));
            foodInfo = new Label("Tax Information");
            foodInfo.setFont(Font.font("Century",18));
            foodInfo.setLayoutX(150);
            foodInfo.setLayoutY(120);
            Label equal = new Label("=");
            equal.setFont(Font.font("Century",18));
            equal.setLayoutY(12);
            root.getChildren().add(right);
            root.getChildren().add(left);
            root.getChildren().add(food);
            root.getChildren().add(person);
            root.getChildren().add(foodImage);
            root.getChildren().add(foodSlider);
            root.getChildren().add(foodCoins);
            root.getChildren().add(numberOfPeople);
            root.getChildren().add(foodInfo);
            root.getChildren().add(label);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root);
            Path path = Paths.get("/Css/MainMenuStyle.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/Css/MainMenuStyle.css").toExternalForm());
            //  System.out.println(getClass().getResource("/Css/MainMenu.css").getPath());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
Slider slider = new Slider();
    Label coins;
    Label people;
    Label taxInfo;
    public void setTaxRate(ActionEvent event) {
        try{   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/GameInformation.fxml"));
            Pane root = fxmlLoader.load();
            //slider = new Slider();
            slider.setId("custom");
            slider.setPrefHeight(25.0);
            slider.setPrefWidth(180.0);
            slider.setLayoutX(312);
            slider.setLayoutY(69);
            slider.setMin(-3);
            slider.setMax(8);
            coins = new Label("coin");
            coins.setLayoutY(27);
            coins.setLayoutX(430);
            coins.setFont(Font.font("Century",18));
            people = new Label("person");
            people.setLayoutY(27);
            people.setLayoutX(350);
            people.setFont(Font.font("Century",18));
            Label label = new Label("Set Tax Rate");
            label.setFont(Font.font("Century",24));
            label.setLayoutX(43);
            label.setLayoutY(14);
            taxInfo = new Label("Tax Information");
            taxInfo.setFont(Font.font("Century",18));
            taxInfo.setLayoutX(150);
            taxInfo.setLayoutY(120);
            ImageView tax = new ImageView(String.valueOf(getClass().getResource("/images/Untitled.png")));
            tax.setFitHeight(109);
            tax.setFitWidth(171);
            tax.setLayoutY(29);
            tax.setLayoutX(23);
            ImageView select = new ImageView(String.valueOf(getClass().getResource("/images/select.png")));
            select.setFitHeight(30);
            select.setFitWidth(30);
            select.setLayoutY(13);
            select.setLayoutX(555);
            Stage stage = new Stage();
            EventHandler<MouseEvent> setTax = (EventHandler<MouseEvent>) e -> {
                int number = (int) slider.getValue();
                gameMenuController.setTaxRate(number);
                stage.close();
            };
            select.setOnMouseClicked(setTax);
            ImageView left = new ImageView(String.valueOf(getClass().getResource("/images/0_0img22.png")));
            left.setLayoutX(283);
            left.setLayoutY(69);
            left.prefWidth(36);
            left.prefHeight(30);
            ImageView right = new ImageView(String.valueOf(getClass().getResource("/images/0_0img277.png")));
            right.setFitWidth(36);
            right.setFitHeight(35);
            right.setLayoutX(486);
            right.setLayoutY(69);
            ImageView coin = new ImageView(String.valueOf(getClass().getResource("/images/0_0img112.png")));
            coin.setLayoutX(468);
            coin.setLayoutY(25);
            coin.setFitWidth(41);
            coin.setFitHeight(30);
            ImageView person = new ImageView(String.valueOf(getClass().getResource("/images/0_0img126.png")));
            person.setFitHeight(39);
            person.setFitWidth(31);
            person.setLayoutY(19);
            person.setLayoutX(300);
            root.getChildren().add(person);
            root.getChildren().add(coin);
            root.getChildren().add(tax);
            root.getChildren().add(label);
            root.getChildren().add(right);
            root.getChildren().add(left);
            root.getChildren().add(slider);
            root.getChildren().add(coins);
            root.getChildren().add(people);
            root.getChildren().add(taxInfo);
            root.getChildren().add(select);

            stage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root);
            Path path = Paths.get("/Css/MainMenuStyle.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/Css/MainMenuStyle.css").toExternalForm());
            //  System.out.println(getClass().getResource("/Css/MainMenu.css").getPath());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int number1 = (int) slider.getValue();
                System.out.println(gameMenuController.showTaxRate(number1));
                String[] splitString = gameMenuController.showTaxRate(number1).split(">");
                coins.setText(splitString[0]);
                people.setText(splitString[1]);
                taxInfo.setText(splitString[2]);
            }
        });

        foodSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int number1 = (int) foodSlider.getValue();
                System.out.println(gameMenuController.showFoodRate(number1));
                String[] splitString = gameMenuController.showFoodRate(number1).split("-");
                foodCoins.setText(splitString[0]);
                numberOfPeople.setText("1");
                foodInfo.setText(splitString[1]);
            }
        });

    }
}

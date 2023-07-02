package org.example.view.userView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.controller.GameMenuController;
import org.example.controller.userControllers.MainMenuController;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class GovermentMenu extends Application implements Initializable {
    public Label coin;
    public Label popularity;
    public ImageView face;
    public static int number;
    public static int foodNumber;
    public static int fearNumber;
    private static Stage stage;
    public Button setRate;
    public Button setTaxRate;
    public Button setFoodRate;
    public Button setFearRate;
    private GameMenuController gameMenuController = new GameMenuController();
    public MainMenuController mainMenuController = new MainMenuController();
    Pane root;
    Stage stage1;
    @Override
    public void start(Stage stage) throws Exception {
        GovermentMenu.stage = stage ;
        URL url = MainMenu.class.getResource("/FXML/Goverment.fxml");
        ImageView showGardens = new ImageView(String.valueOf(getClass().getResource("/images/productive.png")));
        showGardens.setLayoutY(166);
        showGardens.setLayoutX(14);
        showGardens.setFitWidth(22);
        showGardens.setFitHeight(26);
        ImageView showCity = new ImageView(String.valueOf(getClass().getResource("/images/city.png")));
        showCity.setLayoutY(166);
        showCity.setLayoutX(43);
        showCity.setFitWidth(22);
        showCity.setFitHeight(26);
        ImageView showDefend = new ImageView(String.valueOf(getClass().getResource("/images/war.png")));
        showDefend.setLayoutY(166);
        showDefend.setLayoutX(71);
        showDefend.setFitWidth(22);
        showDefend.setFitHeight(26);
        ImageView showProductive = new ImageView(String.valueOf(getClass().getResource("/images/build.png")));
        showProductive.setLayoutY(166);
        showProductive.setLayoutX(96);
        showProductive.setFitWidth(22);
        showProductive.setFitHeight(26);
        ImageView showWar = new ImageView(String.valueOf(getClass().getResource("/images/castle.png")));
        showWar.setLayoutY(166);
        showWar.setLayoutX(122);
        showWar.setFitWidth(22);
        showWar.setFitHeight(26);
        ImageView showOthers = new ImageView(String.valueOf(getClass().getResource("/images/0_0img24.png")));
        showOthers.setLayoutY(166);
        showOthers.setLayoutX(147);
        showOthers.setFitWidth(22);
        showOthers.setFitHeight(26);
        Pane pane = FXMLLoader.load(url);

        ImageView appleGarden = new ImageView(String.valueOf(getClass().getResource("/images/buildings/gardens/APPLE_GARDEN.png")));
        appleGarden.setLayoutY(97);
        appleGarden.setLayoutX(34);
        appleGarden.setFitWidth(69);
        appleGarden.setFitHeight(57);

        ImageView beerGarden = new ImageView(String.valueOf(getClass().getResource("/images/buildings/gardens/BEER_MAKING.png")));
        beerGarden.setLayoutY(105);
        beerGarden.setLayoutX(126);
        beerGarden.setFitWidth(44);
        beerGarden.setFitHeight(57);

        ImageView barrak = new ImageView(String.valueOf(getClass().getResource("/images/buildings/gardens/BARRAK.png")));
        barrak.setLayoutY(105);
        barrak.setLayoutX(205);
        barrak.setFitWidth(58);
        barrak.setFitHeight(57);

        ImageView oat = new ImageView(String.valueOf(getClass().getResource("/images/buildings/gardens/OAT_FARM.png")));
        oat.setLayoutY(97);
        oat.setLayoutX(287);
        oat.setFitWidth(65);
        oat.setFitHeight(57);

        ImageView cathedral = new ImageView(String.valueOf(getClass().getResource("/images/buildings/house/CATHEDRAL.png")));
        cathedral.setLayoutY(100);
        cathedral.setLayoutX(33);
        cathedral.setFitWidth(42);
        cathedral.setFitHeight(39);

        ImageView mercerany = new ImageView(String.valueOf(getClass().getResource("/images/buildings/house/MERCENARY_POST.png")));
        mercerany.setLayoutY(130);
        mercerany.setLayoutX(86);
        mercerany.setFitWidth(42);
        mercerany.setFitHeight(39);

        ImageView church = new ImageView(String.valueOf(getClass().getResource("/images/buildings/house/CHURCH.png")));
        church.setLayoutY(103);
        church.setLayoutX(137);
        church.setFitWidth(42);
        church.setFitHeight(39);

        ImageView house = new ImageView(String.valueOf(getClass().getResource("/images/buildings/house/HOUSE.png")));
        house.setLayoutY(123);
        house.setLayoutX(197);
        house.setFitWidth(42);
        house.setFitHeight(39);

        ImageView inn = new ImageView(String.valueOf(getClass().getResource("/images/buildings/house/INN.png")));
        inn.setLayoutY(96);
        inn.setLayoutX(256);
        inn.setFitWidth(42);
        inn.setFitHeight(39);

        ImageView market = new ImageView(String.valueOf(getClass().getResource("/images/buildings/house/MARKET.png")));
        market.setLayoutY(115);
        market.setLayoutX(304);
        market.setFitWidth(42);
        market.setFitHeight(39);

        ImageView bigGate = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/BIG_STONE_GATEHOUSE.png")));
        bigGate.setLayoutY(113);
        bigGate.setLayoutX(35);
        bigGate.setFitWidth(41);
        bigGate.setFitHeight(43);

        ImageView deffendTurret = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/DEFEND_TURRET.png")));
        deffendTurret.setLayoutY(97);
        deffendTurret.setLayoutX(81);
        deffendTurret.setFitWidth(25);
        deffendTurret.setFitHeight(46);

        ImageView engineerGuid = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/ENGINEER_GUILD.png")));
        engineerGuid.setLayoutY(115);
        engineerGuid.setLayoutX(315);
        engineerGuid.setFitWidth(48);
        engineerGuid.setFitHeight(50);

        ImageView lookoutTower = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/LOOKOUT_TOWER.png")));
        lookoutTower.setLayoutY(96);
        lookoutTower.setLayoutX(169);
        lookoutTower.setFitWidth(19);
        lookoutTower.setFitHeight(48);

        ImageView pitchRig = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/PITCH_RIG.png")));
        pitchRig.setLayoutY(95);
        pitchRig.setLayoutX(200);
        pitchRig.setFitWidth(40);
        pitchRig.setFitHeight(44);

        ImageView poleturner = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/POLETURNER.png")));
        poleturner.setLayoutY(99);
        poleturner.setLayoutX(260);
        poleturner.setFitWidth(43);
        poleturner.setFitHeight(37);
        /*

        ImageView bakery = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/SMALL_STONE_GATEHOUSE.png")));
        bakery.setLayoutY(121);
        bakery.setLayoutX(321);
        bakery.setFitWidth(37);
        bakery.setFitHeight(43);

        ImageView woodCutter = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/SMALL_STONE_GATEHOUSE.png")));
        woodCutter.setLayoutY(121);
        woodCutter.setLayoutX(321);
        woodCutter.setFitWidth(37);
        woodCutter.setFitHeight(43);

        ImageView oilSmelter = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/SMALL_STONE_GATEHOUSE.png")));
        oilSmelter.setLayoutY(122);
        oilSmelter.setLayoutX(108);
        oilSmelter.setFitWidth(49);
        oilSmelter.setFitHeight(43);

        ImageView diary = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/SMALL_STONE_GATEHOUSE.png")));
        diary.setLayoutY(96);
        diary.setLayoutX(158);
        diary.setFitWidth(41);
        diary.setFitHeight(43);

        ImageView mill = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/SMALL_STONE_GATEHOUSE.png")));
        mill.setLayoutY(99);
        mill.setLayoutX(207);
        mill.setFitWidth(38);
        mill.setFitHeight(60);

        ImageView ironMine = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/SMALL_STONE_GATEHOUSE.png")));
        ironMine.setLayoutY(96);
        ironMine.setLayoutX(239);
        ironMine.setFitWidth(49);
        ironMine.setFitHeight(43);

        ImageView blackSmith = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/SMALL_STONE_GATEHOUSE.png")));
        blackSmith.setLayoutY(115);
        blackSmith.setLayoutX(307);
        blackSmith.setFitWidth(49);
        blackSmith.setFitHeight(53);
         */

        EventHandler<MouseEvent> garden = (EventHandler<MouseEvent>) e -> {
            pane.getChildren().add(appleGarden);
            pane.getChildren().add(beerGarden);
            pane.getChildren().add(barrak);
            pane.getChildren().add(oat);
        };

        showGardens.setOnMouseClicked(garden);



        //  pane.getChildren().add(showProductive);
        pane.getChildren().add(showWar);
        pane.getChildren().add(showProductive);
        pane.getChildren().add(showCity);
        pane.getChildren().add(showOthers);
        pane.getChildren().add(showGardens);
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
            Path path = Paths.get("/FXML/Css/setRate.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/FXML/Css/setRate.css").toExternalForm());
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
            Path path = Paths.get("/FXML/Css/setRateOptions.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/FXML/Css/setRateOptions.css").toExternalForm());
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
    Label setFear;
    Slider fearSlider = new Slider();
    public void setFearRate(ActionEvent event) {
        try{   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/GameInformation.fxml"));
            Pane root = fxmlLoader.load();
            fearSlider.setId("custom");
            fearSlider.setPrefHeight(25.0);
            fearSlider.setPrefWidth(180.0);
            fearSlider.setLayoutX(312);
            fearSlider.setLayoutY(69);
            fearSlider.setMax(5);
            fearSlider.setMin(-5);
            Label label = new Label("Set Fear Rate");
            label.setFont(Font.font("Century",24));
            label.setLayoutX(43);
            label.setLayoutY(14);
            setFear = new Label("Tax Information");
            setFear.setFont(Font.font("Century",18));
            setFear.setLayoutX(43);
            setFear.setLayoutY(50);
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
            ImageView select = new ImageView(String.valueOf(getClass().getResource("/images/select.png")));
            select.setFitHeight(30);
            select.setFitWidth(30);
            select.setLayoutY(13);
            select.setLayoutX(555);
            Stage stage = new Stage();
            EventHandler<MouseEvent> setTax = (EventHandler<MouseEvent>) e -> {
                fearNumber = (int) fearSlider.getValue();
                gameMenuController.setFearRate(number);
                stage.close();
            };
            select.setOnMouseClicked(setTax);
            root.getChildren().add(right);
            root.getChildren().add(left);
            root.getChildren().add(fearSlider);
            root.getChildren().add(label);
            root.getChildren().add(setFear);
            root.getChildren().add(select);
            stage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root);
            Path path = Paths.get("/FXML/Css/MainMenuStyle.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/FXML/Css/MainMenuStyle.css").toExternalForm());
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
            ImageView select = new ImageView(String.valueOf(getClass().getResource("/images/select.png")));
            select.setFitHeight(30);
            select.setFitWidth(30);
            select.setLayoutY(13);
            select.setLayoutX(555);
            Stage stage = new Stage();
            EventHandler<MouseEvent> setTax = (EventHandler<MouseEvent>) e -> {
                foodNumber = (int) slider.getValue();
                gameMenuController.setFoodRate(number);
                stage.close();
            };
            select.setOnMouseClicked(setTax);
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
            root.getChildren().add(select);
            stage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root);
            Path path = Paths.get("/FXML/Css/MainMenuStyle.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/FXML/Css/MainMenuStyle.css").toExternalForm());
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
        System.out.println(mainMenuController.getUsername());
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
                number = (int) slider.getValue();
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
            Path path = Paths.get("/FXML/Css/MainMenuStyle.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/FXML/Css/MainMenuStyle.css").toExternalForm());
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

        fearSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int number1 = (int) fearSlider.getValue();
                System.out.println("n");
                setFear.setText("Set On " + number1);
            }
        });

    }

    public void productiveBuildings(MouseEvent event) {


    }

    public void cityBuildings(MouseEvent event) {
    }

    public void warBuildings(MouseEvent event) {
    }

    @FXML
    public void initialize(){
        popularity.textProperty().addListener((observable , oldText , newText)->{
                    if(gameMenuController.showPopularity()<=100 && gameMenuController.showPopularity()>=90)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/happy1.png"))));
                    else if(gameMenuController.showPopularity()<90 && gameMenuController.showPopularity()>=80)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/happy2.png"))));
                    else if(gameMenuController.showPopularity()<80 && gameMenuController.showPopularity()>=70)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/happy3.png"))));
                    else if(gameMenuController.showPopularity()<70 && gameMenuController.showPopularity()>=60)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/happy4.png"))));
                    else if(gameMenuController.showPopularity()<60 && gameMenuController.showPopularity()>=50)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/normal.png"))));
                    else if(gameMenuController.showPopularity()<50 && gameMenuController.showPopularity()>=40)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/sad1.png"))));
                    else if(gameMenuController.showPopularity()<40 && gameMenuController.showPopularity()>=30)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/sad2.png"))));
                    else if(gameMenuController.showPopularity()<30 && gameMenuController.showPopularity()>=20)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/sad3.png"))));
                    else if(gameMenuController.showPopularity()<20 && gameMenuController.showPopularity()>=0)
                        face.setImage(new Image(String.valueOf(getClass().getResource("/images/face/sad4.png"))));
                }


        );

        coin.setText(String.valueOf(gameMenuController.getCoin()));
        popularity.setText(String.valueOf(gameMenuController.showPopularity()));

    }

    public void showPopularity(MouseEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/popularityDetails.fxml"));
            Pane root = fxmlLoader.load();

            String good = String.format("-fx-text-fill: Green;");
            String bad = String.format("-fx-text-fill: RED;");
            String normal = String.format("-fx-text-fill: YELLOW;");

            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            ImageView left;
            Label taxRateLable = new Label(String.valueOf(number));
            taxRateLable.setLayoutY(48);
            taxRateLable.setLayoutX(288);
            taxRateLable.setFont(Font.font("System" , 18));
            taxRateLable.setStyle("Bold");
            Label foodRateLable = new Label(String.valueOf(foodNumber));
            foodRateLable.setLayoutX(288);
            foodRateLable.setLayoutY(85);
            foodRateLable.setFont(Font.font("System" , 18));
            foodRateLable.setStyle("Bold");
            Label fearRateLable = new Label(String.valueOf(fearNumber));
            fearRateLable.setLayoutX(288);
            fearRateLable.setLayoutY(126);
            fearRateLable.setFont(Font.font("System" , 18));
            fearRateLable.setStyle("Bold");
            System.out.println(gameMenuController.getTaxRate() + number);
            switch (number){
                case -3,-2,-1 : left = new ImageView(String.valueOf(getClass().getResource("/images/popularity/saddest.png")));
                    left.setLayoutX(339);
                    left.setLayoutY(48);
                    left.prefWidth(32);
                    left.prefHeight(21);
                    taxRateLable.setStyle(bad);
                    break;
                case 0,1,2:left = new ImageView(String.valueOf(getClass().getResource("/images/popularity/sad.png")));
                    left.setLayoutX(339);
                    left.setLayoutY(48);
                    left.prefWidth(32);
                    left.prefHeight(21);
                    taxRateLable.setStyle(normal);
                    break;
                case 3,4: left = new ImageView(String.valueOf(getClass().getResource("/images/popularity/normal.png")));
                    left.setLayoutX(339);
                    left.setLayoutY(48);
                    left.prefWidth(32);
                    left.prefHeight(21);
                    taxRateLable.setStyle(normal);
                    break;
                case 5,6: left = new ImageView(String.valueOf(getClass().getResource("/images/popularity/happy.png")));
                    left.setLayoutX(339);
                    left.setLayoutY(48);
                    left.prefWidth(32);
                    left.prefHeight(21);
                    taxRateLable.setStyle(good);
                    break;
                default:
                    left = new ImageView(String.valueOf(getClass().getResource("/images/popularity/happiest.png")));
                    left.setLayoutX(339);
                    left.setLayoutY(48);
                    left.prefWidth(32);
                    left.prefHeight(21);
                    taxRateLable.setStyle(good);
            }
            ImageView foodRate;
            switch (foodNumber){
                case -2 : foodRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/saddest.png")));
                    foodRate.setLayoutX(339);
                    foodRate.setLayoutY(88);
                    foodRate.prefWidth(32);
                    foodRate.prefHeight(21);
                    foodRateLable.setStyle(bad);
                    break;
                case -1:foodRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/sad.png")));
                    foodRate.setLayoutX(339);
                    foodRate.setLayoutY(88);
                    foodRate.prefWidth(32);
                    foodRate.prefHeight(21);
                    foodRateLable.setStyle(normal);
                    break;
                case 0:foodRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/normal.png")));
                    foodRate.setLayoutX(339);
                    foodRate.setLayoutY(88);
                    foodRate.prefWidth(32);
                    foodRate.prefHeight(21);
                    foodRateLable.setStyle(normal);
                    break;
                case 1: foodRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/happy.png")));
                    foodRate.setLayoutX(339);
                    foodRate.setLayoutY(88);
                    foodRate.prefWidth(32);
                    foodRate.prefHeight(21);
                    foodRateLable.setStyle(good);
                    break;
                default:
                    foodRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/happiest.png")));
                    foodRate.setLayoutX(339);
                    foodRate.setLayoutY(88);
                    foodRate.prefWidth(32);
                    foodRate.prefHeight(21);
                    foodRateLable.setStyle(good);
            }
            ImageView fearRate;
            System.out.println(fearNumber);
            switch (fearNumber){
                case -5,-4,-3 : fearRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/saddest.png")));
                    fearRate.setLayoutX(339);
                    fearRate.setLayoutY(48);
                    fearRate.prefWidth(32);
                    fearRate.prefHeight(21);
                    System.out.println("k");
                    root.getChildren().add(fearRate);
                    fearRateLable.setStyle(bad);
                    break;
                case -2,-1:fearRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/sad.png")));
                    fearRate.setLayoutX(339);
                    fearRate.setLayoutY(48);
                    fearRate.prefWidth(32);
                    fearRate.prefHeight(21);
                    fearRateLable.setStyle(normal);
                    break;
                case 0,1:fearRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/normal.png")));
                    fearRate.setLayoutX(339);
                    fearRate.setLayoutY(48);
                    fearRate.prefWidth(32);
                    fearRate.prefHeight(21);
                    fearRateLable.setStyle(normal);
                    break;
                case 2,3: fearRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/happy.png")));
                    fearRate.setLayoutX(339);
                    fearRate.setLayoutY(48);
                    fearRate.prefWidth(32);
                    fearRate.prefHeight(21);
                    fearRateLable.setStyle(good);
                    break;
                default:
                    fearRate = new ImageView(String.valueOf(getClass().getResource("/images/popularity/happiest.png")));
                    fearRate.setLayoutX(339);
                    fearRate.setLayoutY(48);
                    fearRate.prefWidth(32);
                    fearRate.prefHeight(21);
                    fearRateLable.setStyle(good);
            }
            root.getChildren().add(fearRateLable);
            root.getChildren().add(foodRateLable);
            root.getChildren().add(taxRateLable);
            //  root.getChildren().add(fearRate);
            root.getChildren().add(fearRate);
            root.getChildren().add(foodRate);
            root.getChildren().add(left);
            Scene scene = new Scene(root);
            Path path = Paths.get("/FXML/Css/popularityBackground.css");
            String address = String.valueOf(path.toAbsolutePath());
            System.out.println(address);
            scene.getStylesheets().add(getClass().getResource("/FXML/Css/popularityBackground.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

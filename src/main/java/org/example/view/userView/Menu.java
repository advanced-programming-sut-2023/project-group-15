package org.example.view.userView;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.example.controller.GameMenuController;
import org.example.controller.MarketController;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Menu extends Application implements Initializable {

        private static Stage stage;
        public Button button1;
        public Pane parentFirst;
        @FXML
        private Button button;
        int number = 0 ;
        Pane parent;
        MarketController marketController = new MarketController();
        @FXML
        public void showMarket(MouseEvent mouseEvent) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Market.fxml"));
                        Image image2 = new Image((getClass().getResource("/images/0_0img26.png").toString()));
                        ImageView imageView = new ImageView(image2);
                        imageView.setLayoutX(398.0);
                        Pane root = fxmlLoader.load();
                        Stage stage = new Stage();
                        EventHandler<MouseEvent> backToGame = (EventHandler<MouseEvent>) e -> {
                                stage.close();
                        };
                        imageView.setOnMouseClicked(backToGame);
                        stage.setTitle("market");
                        root.getChildren().add(imageView);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setScene(new Scene(root));
                        stage.show();
                     /*   HashMap<String, Integer> number = new HashMap<>(marketController.show1());

                       // Market.stage = stage;
                        URL url = SignupMenu.class.getResource("/FXML/Market.fxml");
                        Pane pane = FXMLLoader.load(url);
                        Scene scene = new Scene(pane);
                        stage.setScene(scene);
                        stage.show();*/

                } catch (Exception e){
                        System.out.println(e);
                }
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }

        @Override
        public void start(Stage stage) throws Exception {
                Menu.stage = stage;
                URL url = SignupMenu.class.getResource("/FXML/Menu.fxml");
                Pane pane = FXMLLoader.load(url);
                Scene scene = new Scene(pane);
                stage.setScene(scene);
                //stage.setFullScreen(true);
                stage.show();
        }

        @FXML
        public void showGovermentMenu(MouseEvent mouseEvent) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Goverment.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        System.out.println("kkkkkkkkkk");
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                }catch (Exception e){
                        System.out.println("can not");
                }
        }

        public void clicked(ActionEvent event) throws Exception {
                ++number;
                System.out.println(number);
                if(number%2 == 0){
                        parentFirst.getChildren().remove(parent);
                        return;
                }
                parent = FXMLLoader.load(getClass().getResource("/FXML/Goverment.fxml"));
                Scene scene = button.getScene();
                parent.translateXProperty().set(scene.getHeight());

                ImageView showCity = new ImageView(String.valueOf(getClass().getResource("/images/city.png")));
                showCity.setLayoutY(166);
                showCity.setLayoutX(43);
                showCity.setFitWidth(22);
                showCity.setFitHeight(26);
                parent.getChildren().add(showCity);
                ImageView showGardens = new ImageView(String.valueOf(getClass().getResource("/images/productive.png")));
                showGardens.setLayoutY(166);
                showGardens.setLayoutX(14);
                showGardens.setFitWidth(22);
                showGardens.setFitHeight(26);
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
                parent.getChildren().add(showGardens);
                parent.getChildren().add(showDefend);
                parent.getChildren().add(showProductive);
                parent.getChildren().add(showWar);
                parent.getChildren().add(showOthers);

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
                mercerany.setLayoutY(125);
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
                bigGate.setLayoutX(30);
                bigGate.setFitWidth(41);
                bigGate.setFitHeight(43);

                ImageView deffendTurret = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/DEFEND_TURRET.png")));
                deffendTurret.setLayoutY(97);
                deffendTurret.setLayoutX(87);
                deffendTurret.setFitWidth(41);
                deffendTurret.setFitHeight(43);

                ImageView engineerGuid = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/ENGINEER_GUILD.png")));
                engineerGuid.setLayoutY(115);
                engineerGuid.setLayoutX(135);
                engineerGuid.setFitWidth(48);
                engineerGuid.setFitHeight(50);

                ImageView lookoutTower = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/LOOKOUT_TOWER.png")));
                lookoutTower.setLayoutY(96);
                lookoutTower.setLayoutX(185);
                lookoutTower.setFitWidth(15);
                lookoutTower.setFitHeight(47);

                ImageView pitchRig = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/PITCH_RIG.png")));
                pitchRig.setLayoutY(130);
                pitchRig.setLayoutX(200);
                pitchRig.setFitWidth(40);
                pitchRig.setFitHeight(35);

                ImageView poleturner = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/POLETURNER.png")));
                poleturner.setLayoutY(99);
                poleturner.setLayoutX(250);
                poleturner.setFitWidth(50);
                poleturner.setFitHeight(37);

                ImageView smallGate = new ImageView(String.valueOf(getClass().getResource("/images/buildings/defend/SMALL_STONE_GATEHOUSE.png")));
                smallGate.setLayoutY(121);
                smallGate.setLayoutX(321);
                smallGate.setFitWidth(37);
                smallGate.setFitHeight(43);

                ImageView bakery = new ImageView(String.valueOf(getClass().getResource("/images/buildings/productive/BAKERY.png")));
                bakery.setLayoutY(97);
                bakery.setLayoutX(26);
                bakery.setFitWidth(39);
                bakery.setFitHeight(43);

                ImageView woodCutter = new ImageView(String.valueOf(getClass().getResource("/images/buildings/productive/WOODCUTTER.png")));
                woodCutter.setLayoutY(115);
                woodCutter.setLayoutX(270);
                woodCutter.setFitWidth(45);
                woodCutter.setFitHeight(43);

                ImageView oilSmelter = new ImageView(String.valueOf(getClass().getResource("/images/buildings/productive/OIL_SMELTLER.png")));
                oilSmelter.setLayoutY(97);
                oilSmelter.setLayoutX(230);
                oilSmelter.setFitWidth(45);
                oilSmelter.setFitHeight(43);

                ImageView diary = new ImageView(String.valueOf(getClass().getResource("/images/buildings/productive/DIARY.png")));
                diary.setLayoutY(97);
                diary.setLayoutX(110);
                diary.setFitWidth(38);
                diary.setFitHeight(37);

                ImageView mill = new ImageView(String.valueOf(getClass().getResource("/images/buildings/productive/MILL.png")));
                mill.setLayoutY(98);
                mill.setLayoutX(150);
                mill.setFitWidth(22);
                mill.setFitHeight(43);

                ImageView ironMine = new ImageView(String.valueOf(getClass().getResource("/images/buildings/productive/IRON_MINE.png")));
                ironMine.setLayoutY(126);
                ironMine.setLayoutX(190);
                ironMine.setFitWidth(38);
                ironMine.setFitHeight(37);

                ImageView blackSmith = new ImageView(String.valueOf(getClass().getResource("/images/buildings/productive/BLACKSMITH.png")));
                blackSmith.setLayoutY(120);
                blackSmith.setLayoutX(70);
                blackSmith.setFitWidth(38);
                blackSmith.setFitHeight(37);

                ImageView picWar = new ImageView(String.valueOf(getClass().getResource("/images/buildings/war/squareTower.png")));
                picWar.setLayoutY(90);
                picWar.setLayoutX(300);
                picWar.setFitWidth(32);
                picWar.setFitHeight(49);

                ImageView armourer = new ImageView(String.valueOf(getClass().getResource("/images/buildings/war/ARMOURER.png")));
                armourer.setLayoutY(103);
                armourer.setLayoutX(33);
                armourer.setFitWidth(44);
                armourer.setFitHeight(33);

                ImageView armoury = new ImageView(String.valueOf(getClass().getResource("/images/buildings/war/ARMOURY.png")));
                armoury.setLayoutY(125);
                armoury.setLayoutX(74);
                armoury.setFitWidth(32);
                armoury.setFitHeight(33);

                ImageView dogs = new ImageView(String.valueOf(getClass().getResource("/images/buildings/war/CAGED_WAR_DOGS.png")));
                dogs.setLayoutY(120);
                dogs.setLayoutX(105);
                dogs.setFitWidth(39);
                dogs.setFitHeight(33);

                ImageView huntingBuilding = new ImageView(String.valueOf(getClass().getResource("/images/buildings/war/HUNTING_BUILDING.png")));
                huntingBuilding.setLayoutY(120);
                huntingBuilding.setLayoutX(150);
                huntingBuilding.setFitWidth(32);
                huntingBuilding.setFitHeight(44);

                ImageView premeter = new ImageView(String.valueOf(getClass().getResource("/images/buildings/war/PERMETER_TOWER.png")));
                premeter.setLayoutY(87);
                premeter.setLayoutX(118);
                premeter.setFitWidth(38);
                premeter.setFitHeight(37);

                ImageView squareTower = new ImageView(String.valueOf(getClass().getResource("/images/buildings/war/SQUARE_TOWER.png")));
                squareTower.setLayoutY(111);
                squareTower.setLayoutX(252);
                squareTower.setFitWidth(27);
                squareTower.setFitHeight(51);

                ImageView drawBridge = new ImageView(String.valueOf(getClass().getResource("/images/buildings/other/DRAWBRIDGE.png")));
                drawBridge.setLayoutY(103);
                drawBridge.setLayoutX(33);
                drawBridge.setFitWidth(41);
                drawBridge.setFitHeight(42);

                ImageView fletcher = new ImageView(String.valueOf(getClass().getResource("/images/buildings/other/FLETCHER.png")));
                fletcher.setLayoutY(113);
                fletcher.setLayoutX(98);
                fletcher.setFitWidth(41);
                fletcher.setFitHeight(32);

                ImageView oxTether = new ImageView(String.valueOf(getClass().getResource("/images/buildings/other/OX_TETHER.png")));
                oxTether.setLayoutY(108);
                oxTether.setLayoutX(159);
                oxTether.setFitWidth(49);
                oxTether.setFitHeight(42);

                ImageView quarry = new ImageView(String.valueOf(getClass().getResource("/images/buildings/other/QUARRY.png")));
                quarry.setLayoutY(105);
                quarry.setLayoutX(245);
                quarry.setFitWidth(48);
                quarry.setFitHeight(42);

                ImageView stable = new ImageView(String.valueOf(getClass().getResource("/images/buildings/other/STABLE.png")));
                stable.setLayoutY(113);
                stable.setLayoutX(312);
                stable.setFitWidth(36);
                stable.setFitHeight(33);

                EventHandler<MouseEvent> garden = (EventHandler<MouseEvent>) e -> {
                        parent.getChildren().add(appleGarden);
                        parent.getChildren().add(beerGarden);
                        parent.getChildren().add(barrak);
                        parent.getChildren().add(oat);

                        parent.getChildren().remove(cathedral);
                        parent.getChildren().remove(mercerany);
                        parent.getChildren().remove(church);
                        parent.getChildren().remove(house);
                        parent.getChildren().remove(inn);
                        parent.getChildren().remove(market);

                        parent.getChildren().remove(bigGate);
                        parent.getChildren().remove(smallGate);
                        parent.getChildren().remove(deffendTurret);
                        parent.getChildren().remove(poleturner);
                        parent.getChildren().remove(pitchRig);
                        parent.getChildren().remove(lookoutTower);
                        parent.getChildren().remove(engineerGuid);

                        parent.getChildren().remove(oilSmelter);
                        parent.getChildren().remove(woodCutter);
                        parent.getChildren().remove(bakery);
                        parent.getChildren().remove(blackSmith);
                        parent.getChildren().remove(mill);
                        parent.getChildren().remove(ironMine);
                        parent.getChildren().remove(diary);

                        parent.getChildren().remove(armourer);
                        parent.getChildren().remove(armoury);
                        parent.getChildren().remove(dogs);
                        parent.getChildren().remove(huntingBuilding);
                        parent.getChildren().remove(squareTower);
                        parent.getChildren().remove(premeter);

                        parent.getChildren().remove(drawBridge);
                        parent.getChildren().remove(fletcher);
                        parent.getChildren().remove(oxTether);
                        parent.getChildren().remove(quarry);
                        parent.getChildren().remove(stable);
                };

                EventHandler<MouseEvent> houseMenu = (EventHandler<MouseEvent>) e -> {
                        parent.getChildren().add(cathedral);
                        parent.getChildren().add(mercerany);
                        parent.getChildren().add(church);
                        parent.getChildren().add(house);
                        parent.getChildren().add(inn);
                        parent.getChildren().add(market);

                        parent.getChildren().remove(appleGarden);
                        parent.getChildren().remove(beerGarden);
                        parent.getChildren().remove(barrak);
                        parent.getChildren().remove(oat);

                        parent.getChildren().remove(bigGate);
                        parent.getChildren().remove(smallGate);
                        parent.getChildren().remove(deffendTurret);
                        parent.getChildren().remove(poleturner);
                        parent.getChildren().remove(pitchRig);
                        parent.getChildren().remove(lookoutTower);
                        parent.getChildren().remove(engineerGuid);

                        parent.getChildren().remove(oilSmelter);
                        parent.getChildren().remove(woodCutter);
                        parent.getChildren().remove(bakery);
                        parent.getChildren().remove(blackSmith);
                        parent.getChildren().remove(mill);
                        parent.getChildren().remove(ironMine);
                        parent.getChildren().remove(diary);

                        parent.getChildren().remove(armourer);
                        parent.getChildren().remove(armoury);
                        parent.getChildren().remove(dogs);
                        parent.getChildren().remove(huntingBuilding);
                        parent.getChildren().remove(squareTower);
                        parent.getChildren().remove(premeter);

                        parent.getChildren().remove(drawBridge);
                        parent.getChildren().remove(fletcher);
                        parent.getChildren().remove(oxTether);
                        parent.getChildren().remove(quarry);
                        parent.getChildren().remove(stable);
                };

                EventHandler<MouseEvent> defendMenu = (EventHandler<MouseEvent>) e -> {
                        parent.getChildren().add(bigGate);
                        parent.getChildren().add(smallGate);
                        parent.getChildren().add(deffendTurret);
                        parent.getChildren().add(poleturner);
                        parent.getChildren().add(pitchRig);
                        parent.getChildren().add(lookoutTower);
                        parent.getChildren().add(engineerGuid);

                        parent.getChildren().remove(appleGarden);
                        parent.getChildren().remove(beerGarden);
                        parent.getChildren().remove(barrak);
                        parent.getChildren().remove(oat);

                        parent.getChildren().remove(cathedral);
                        parent.getChildren().remove(mercerany);
                        parent.getChildren().remove(church);
                        parent.getChildren().remove(house);
                        parent.getChildren().remove(inn);
                        parent.getChildren().remove(market);

                        parent.getChildren().remove(oilSmelter);
                        parent.getChildren().remove(woodCutter);
                        parent.getChildren().remove(bakery);
                        parent.getChildren().remove(blackSmith);
                        parent.getChildren().remove(mill);
                        parent.getChildren().remove(ironMine);
                        parent.getChildren().remove(diary);

                        parent.getChildren().remove(armourer);
                        parent.getChildren().remove(armoury);
                        parent.getChildren().remove(dogs);
                        parent.getChildren().remove(huntingBuilding);
                        parent.getChildren().remove(squareTower);
                        parent.getChildren().remove(premeter);

                        parent.getChildren().remove(drawBridge);
                        parent.getChildren().remove(fletcher);
                        parent.getChildren().remove(oxTether);
                        parent.getChildren().remove(quarry);
                        parent.getChildren().remove(stable);
                };

                EventHandler<MouseEvent> productiveMenu = (EventHandler<MouseEvent>) e -> {
                        parent.getChildren().add(oilSmelter);
                        parent.getChildren().add(woodCutter);
                        parent.getChildren().add(bakery);
                        parent.getChildren().add(blackSmith);
                        parent.getChildren().add(mill);
                        parent.getChildren().add(ironMine);
                        parent.getChildren().add(diary);

                        parent.getChildren().remove(appleGarden);
                        parent.getChildren().remove(beerGarden);
                        parent.getChildren().remove(barrak);
                        parent.getChildren().remove(oat);

                        parent.getChildren().remove(cathedral);
                        parent.getChildren().remove(mercerany);
                        parent.getChildren().remove(church);
                        parent.getChildren().remove(house);
                        parent.getChildren().remove(inn);
                        parent.getChildren().remove(market);

                        parent.getChildren().remove(bigGate);
                        parent.getChildren().remove(smallGate);
                        parent.getChildren().remove(deffendTurret);
                        parent.getChildren().remove(poleturner);
                        parent.getChildren().remove(pitchRig);
                        parent.getChildren().remove(lookoutTower);
                        parent.getChildren().remove(engineerGuid);

                        parent.getChildren().remove(armourer);
                        parent.getChildren().remove(armoury);
                        parent.getChildren().remove(dogs);
                        parent.getChildren().remove(huntingBuilding);
                        parent.getChildren().remove(squareTower);
                        parent.getChildren().remove(premeter);

                        parent.getChildren().remove(drawBridge);
                        parent.getChildren().remove(fletcher);
                        parent.getChildren().remove(oxTether);
                        parent.getChildren().remove(quarry);
                        parent.getChildren().remove(stable);
                };

                EventHandler<MouseEvent> warMenu = (EventHandler<MouseEvent>) e -> {
                        parent.getChildren().add(armourer);
                        parent.getChildren().add(armoury);
                        parent.getChildren().add(dogs);
                        parent.getChildren().add(huntingBuilding);
                        parent.getChildren().add(squareTower);
                        parent.getChildren().add(premeter);

                        parent.getChildren().remove(appleGarden);
                        parent.getChildren().remove(beerGarden);
                        parent.getChildren().remove(barrak);
                        parent.getChildren().remove(oat);

                        parent.getChildren().remove(cathedral);
                        parent.getChildren().remove(mercerany);
                        parent.getChildren().remove(church);
                        parent.getChildren().remove(house);
                        parent.getChildren().remove(inn);
                        parent.getChildren().remove(market);

                        parent.getChildren().remove(bigGate);
                        parent.getChildren().remove(smallGate);
                        parent.getChildren().remove(deffendTurret);
                        parent.getChildren().remove(poleturner);
                        parent.getChildren().remove(pitchRig);
                        parent.getChildren().remove(lookoutTower);
                        parent.getChildren().remove(engineerGuid);
                        parent.getChildren().remove(oilSmelter);
                        parent.getChildren().remove(woodCutter);
                        parent.getChildren().remove(bakery);
                        parent.getChildren().remove(blackSmith);
                        parent.getChildren().remove(mill);
                        parent.getChildren().remove(ironMine);
                        parent.getChildren().remove(diary);

                        parent.getChildren().remove(drawBridge);
                        parent.getChildren().remove(fletcher);
                        parent.getChildren().remove(oxTether);
                        parent.getChildren().remove(quarry);
                        parent.getChildren().remove(stable);
                };



                EventHandler<MouseEvent> otherMenu = (EventHandler<MouseEvent>) e -> {
                        parent.getChildren().add(drawBridge);
                        parent.getChildren().add(fletcher);
                        parent.getChildren().add(oxTether);
                        parent.getChildren().add(quarry);
                        parent.getChildren().add(stable);


                        parent.getChildren().remove(appleGarden);
                        parent.getChildren().remove(beerGarden);
                        parent.getChildren().remove(barrak);
                        parent.getChildren().remove(oat);

                        parent.getChildren().remove(bigGate);
                        parent.getChildren().remove(smallGate);
                        parent.getChildren().remove(deffendTurret);
                        parent.getChildren().remove(poleturner);
                        parent.getChildren().remove(pitchRig);
                        parent.getChildren().remove(lookoutTower);
                        parent.getChildren().remove(engineerGuid);

                        parent.getChildren().remove(oilSmelter);
                        parent.getChildren().remove(woodCutter);
                        parent.getChildren().remove(bakery);
                        parent.getChildren().remove(blackSmith);
                        parent.getChildren().remove(mill);
                        parent.getChildren().remove(ironMine);
                        parent.getChildren().remove(diary);

                        parent.getChildren().remove(armourer);
                        parent.getChildren().remove(armoury);
                        parent.getChildren().remove(dogs);
                        parent.getChildren().remove(huntingBuilding);
                        parent.getChildren().remove(squareTower);
                        parent.getChildren().remove(premeter);

                        parent.getChildren().remove(cathedral);
                        parent.getChildren().remove(mercerany);
                        parent.getChildren().remove(church);
                        parent.getChildren().remove(house);
                        parent.getChildren().remove(inn);
                        parent.getChildren().remove(market);

                };


                showOthers.setOnMouseClicked(otherMenu);
                showWar.setOnMouseClicked(warMenu);
                showProductive.setOnMouseClicked(productiveMenu);
                showDefend.setOnMouseClicked(defendMenu);
                showCity.setOnMouseClicked(houseMenu);
                showGardens.setOnMouseClicked(garden);

                parent.setLayoutX(0);
                parent.setLayoutY(217);
                parentFirst.getChildren().add(parent);
                Timeline timeline = new Timeline();
                KeyValue keyValue = new KeyValue(parent.translateXProperty(), 0, Interpolator.EASE_IN);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
        }

}
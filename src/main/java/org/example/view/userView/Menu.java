package org.example.view.userView;

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
import org.example.controller.MarketController;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Menu extends Application implements Initializable {

        private static Stage stage;
        @FXML
        private Button button;

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
                stage.show();
        }

        @FXML
        public void showGovermentMenu(MouseEvent mouseEvent) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Goverment.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("market");
                        stage.setScene(new Scene(root));
                        stage.show();
                }catch (Exception e){
                        System.out.println("can not");
                }
        }

}
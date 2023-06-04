package org.example.view.userView;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserMainGameMenu extends Application {
    public static void main (String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        newGame();
//        BorderPane borderPane = FXMLLoader.load(getClass().getResource("/FXML/userMainGameMenu.fxml"));
//        Scene scene = new Scene(borderPane);
//        stage.setScene(scene);
//        stage.show();
    }

    public void newGame() {
//        pageCreation();
//        Scene scene = new Scene();
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
    }



    public void exit(MouseEvent mouseEvent) {
    }

    public void logout(MouseEvent mouseEvent) {
    }

    public void accountSetting(MouseEvent mouseEvent) {
    }

    public void highScores(MouseEvent mouseEvent) {
    }

    public void addPlayer(MouseEvent mouseEvent) {
    }
//    private VBox pageCreation() {
//        VBox mainLayout = new VBox();
//        mainLayout.setSpacing(30);
//        mainLayout.setAlignment(Pos.CENTER);
//        HBox centerPart = createCenterPart();
//        HBox bottomPart = createBottomPart();
//    }
//
//    private HBox createBottomPart() {
//        Button button = new Button();
//
//    }
//
//    private HBox createCenterPart() {
//        HBox output = new HBox();
//        output.setAlignment(Pos.CENTER);
//        output.setSpacing(30);
//        output.setMinWidth(400);
//        output.setMinHeight(300);
//        output.getChildren().add(hBoxLeftPart());
//        output.getChildren().add(hBoxRightPart());
//        return output;
//    }
//
//    private VBox hBoxRightPart() {
//        CheckBox one = new CheckBox();
//        one.setText("1");
//        CheckBox two = new CheckBox();
//        two.setText("2");
//        VBox rightPart = new VBox();
//        rightPart.setAlignment(Pos.CENTER);
//        rightPart.setSpacing(20);
//        Text textOnRightSide = new Text();
//        textOnRightSide.setText("choose one of these map templates");
//        rightPart.getChildren().addAll(textOnRightSide,one,two);
//        return rightPart;
//    }
//
//    private VBox hBoxLeftPart() {
//        CheckBox twoHundred = new CheckBox();
//        twoHundred.setText("200");
//        CheckBox fourHundred = new CheckBox();
//        fourHundred.setText("400");
//        VBox leftPart = new VBox();
//        leftPart.setSpacing(20);
//        leftPart.setAlignment(Pos.CENTER);
//        Text textOnLeftSide = new Text();
//        textOnLeftSide.setText("choose your map dimensions");
//        leftPart.getChildren().addAll(textOnLeftSide,twoHundred,fourHundred);
//        return leftPart;
//    }
}

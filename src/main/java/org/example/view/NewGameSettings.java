package org.example.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controller.StartingGameMenuController;
import org.example.view.userView.MainMenu;
import org.example.view.userView.StartingMenu;

public class NewGameSettings extends Application {
    private StartingGameMenuController startingGameMenuController = new StartingGameMenuController(MainMenu.getUsername());
    @FXML
    private CheckBox templateOne;
    @FXML
    private CheckBox templateTwo;
    @FXML
    private CheckBox fourHundredCheckBox;
    @FXML
    private CheckBox twoHundredCheckBox;

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = FXMLLoader.load(getClass().getResource("/FXML/newGameSettings.fxml"));
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public void checkCheckBoxes(MouseEvent mouseEvent) {
        if (templateOne.isSelected() || templateTwo.isSelected()) {
            if (twoHundredCheckBox.isSelected() || fourHundredCheckBox.isSelected()) {
                createNewGameCheck();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error while starting new game");
                alert.setContentText("you most select the map dimension!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while starting new game");
            alert.setContentText("you most select the map template!");
            alert.showAndWait();
        }
    }

    private void createNewGameCheck() {
        int dimension = 0,template = 0;
        if (twoHundredCheckBox.isSelected()) {
            dimension = 200;
        } else if (fourHundredCheckBox.isSelected()) {
            dimension = 400;
        }
        if (templateOne.isSelected()) {
            template = 1;
        } else if (templateTwo.isSelected()) {
            template = 2;
        }
        startingGameMenuController.newGame(dimension,template);
    }

    public void GoBack() {
        try {
            new MainMenu().start(StartingMenu.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void leftCheckBox(MouseEvent mouseEvent) {
        CheckBox checkBox = (CheckBox) mouseEvent.getSource();
        if (checkBox.equals(twoHundredCheckBox)) {
            fourHundredCheckBox.setSelected(false);
        }
        if (checkBox.equals(fourHundredCheckBox)) {
            twoHundredCheckBox.setSelected(false);
        }
    }

    public void rightCheckBox(MouseEvent mouseEvent) {
        CheckBox checkBox = (CheckBox) mouseEvent.getSource();
        if (checkBox.equals(templateOne)) {
            templateTwo.setSelected(false);
        }
        if (checkBox.equals(templateTwo)) {
            templateOne.setSelected(false);
        }
    }
}
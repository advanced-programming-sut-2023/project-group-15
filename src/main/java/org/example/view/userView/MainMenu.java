package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenu extends Application {
    public void start (Stage stage) throws Exception{
        Pane pane = FXMLLoader.load(MainMenu.class.getResource("/FXML/MainMenu.fxml"));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    public void enterProfileMenu(MouseEvent mouseEvent) throws Exception {
        new ProfileMenu().start(StartingMenu.stage);
    }
}

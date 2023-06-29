package org.example.view.userView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class SetRate extends Application {

    private static Stage stage;
    public Button setTaxRate;
    public Button setFoodRate;
    public Button setFearRate;

    @Override
    public void start(Stage stage) throws Exception {
        SetRate.stage = stage;
        URL url = SignupMenu.class.getResource("/FXML/setRateOptions.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("/Css/setRateOptions.css").toExternalForm());
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }

    public void setRate(ActionEvent event) {
    }

    public void backToSetRate(MouseEvent event) {
    }

    public void setFearRate(ActionEvent event) {
    }

    public void setFoodRate(ActionEvent event) {
    }

    public void setTaxRate(ActionEvent event) {
    }
}

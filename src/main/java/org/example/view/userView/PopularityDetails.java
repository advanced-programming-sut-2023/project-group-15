package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class PopularityDetails extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        PopularityDetails.stage = stage ;
        URL url = MainMenu.class.getResource("/FXML/popularityDetails.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void closePopularity(MouseEvent event) {
        stage.close();
    }
}

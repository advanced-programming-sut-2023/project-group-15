package org.example.model.graphics;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SuccessfulMessage extends Application {
    private String text;
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        borderPane.setCenter(vBox);
        Text text = new Text();
        text.setText(this.text);
        Button button = new Button();
        vBox.getChildren().add(text);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public void setText(String text) {
        this.text = text;
    }
}

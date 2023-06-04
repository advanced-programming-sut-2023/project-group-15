package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.controller.userControllers.SignupMenuController;

import java.net.URL;
import java.util.Optional;

public class ChooseQuestion extends Application {
public static Stage stage;
    private final SignupMenuController signupMenuController = new SignupMenuController();
    public void start (Stage stage ) throws Exception
    {
        ChooseQuestion.stage = stage;
        URL url = SignupMenu.class.getResource("/FXML/ChooseQuestion.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    public void pickQuestion(MouseEvent mouseEvent) throws Exception {
        System.out.println();
        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("Question");
        sloganInput.setContentText("enter your anwer");
        Optional<String> result = sloganInput.showAndWait();
        if (result.isPresent()) {
            signupMenuController.userSlogan(sloganInput.getEditor().getText());
            new SignupMenu().start(ChooseQuestion.stage);
        }
    }
}

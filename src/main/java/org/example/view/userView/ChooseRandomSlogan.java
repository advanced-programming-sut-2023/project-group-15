package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.controller.userControllers.SignupMenuController;

import java.net.URL;

public class ChooseRandomSlogan extends Application {


    static Stage stage;
    public RadioButton first;
    public RadioButton second;
    public RadioButton third;
    public RadioButton fourth;
    public RadioButton fifth;
    public RadioButton sixth;
    public RadioButton seven;
    public RadioButton eight;
    public RadioButton nine;
    public RadioButton ten;
    public RadioButton eleven;
    private final SignupMenuController signupMenuController = new SignupMenuController();
    @Override
    public void start (Stage stage) throws Exception
    {
        ChooseRandomSlogan.stage = stage ;
        URL url = ChooseRandomSlogan.class.getResource("/FXML/randomSlogan.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void selectSlogan(MouseEvent mouseEvent) throws Exception {
        if(first.isSelected())
            signupMenuController.setSlogan(first.getText());
        if(second.isSelected())
            signupMenuController.setSlogan(second.getText());
        if(third.isSelected())
            signupMenuController.setSlogan(third.getText());
        if(fourth.isSelected())
            signupMenuController.setSlogan(fourth.getText());
        if(fifth.isSelected())
            signupMenuController.setSlogan(fifth.getText());
        if(sixth.isSelected())
            signupMenuController.setSlogan(sixth.getText());
        if(seven.isSelected())
            signupMenuController.setSlogan(seven.getText());
        if(eight.isSelected())
            signupMenuController.setSlogan(eight.getText());
        if(nine.isSelected())
            signupMenuController.setSlogan(nine.getText());
        if(ten.isSelected())
            signupMenuController.setSlogan(ten.getText());
        if(eleven.isSelected())
            signupMenuController.setSlogan(eleven.getText());

        new SignupMenu().start(ChooseRandomSlogan.stage);

    }
}

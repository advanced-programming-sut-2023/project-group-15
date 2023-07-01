package org.example.view.userView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.controller.userControllers.MainMenuController;

public class ChooseAvatar extends Application {
    MainMenuController mainMenuController = new MainMenuController();

    public void start(Stage stage) throws Exception {
        Image image1 = new Image(getClass().getResource("/Images/Avatars/avatar1.png").toString());
        Image image2 = new Image(getClass().getResource("/Images/Avatars/avatar2.png").toString());
        Image image3 = new Image(getClass().getResource("/Images/Avatars/avatar3.png").toString());
        Image image4 = new Image(getClass().getResource("/Images/Avatars/avatar4.png").toString());
        Image image5 = new Image(getClass().getResource("/Images/Avatars/avatar5.png").toString());
        Image image6 = new Image(getClass().getResource("/Images/Avatars/avatar6.png").toString());
        Image image7 = new Image(getClass().getResource("/Images/Avatars/avatar7.png").toString());
        Image image8 = new Image(getClass().getResource("/Images/Avatars/avatar8.png").toString());
        Image image9 = new Image(getClass().getResource("/Images/Avatars/avatar9.png").toString());
        Image image10 = new Image(getClass().getResource("/Images/Avatars/avatar10.png").toString());
        //Setting the image view
        javafx.scene.image.ImageView imageView1 = new javafx.scene.image.ImageView(image1);
        javafx.scene.image.ImageView imageView2 = new javafx.scene.image.ImageView(image2);
        javafx.scene.image.ImageView imageView3 = new javafx.scene.image.ImageView(image3);
        javafx.scene.image.ImageView imageView4 = new javafx.scene.image.ImageView(image4);
        javafx.scene.image.ImageView imageView5 = new javafx.scene.image.ImageView(image5);
        javafx.scene.image.ImageView imageView6 = new javafx.scene.image.ImageView(image6);
        javafx.scene.image.ImageView imageView7 = new javafx.scene.image.ImageView(image7);
        javafx.scene.image.ImageView imageView8 = new javafx.scene.image.ImageView(image8);
        javafx.scene.image.ImageView imageView9 = new javafx.scene.image.ImageView(image9);
        javafx.scene.image.ImageView imageView10 = new javafx.scene.image.ImageView(image10);
        RadioButton p1 = new RadioButton("1");
        RadioButton p2 = new RadioButton("2");
        RadioButton p3 = new RadioButton("3");
        RadioButton p4 = new RadioButton("4");
        RadioButton p5 = new RadioButton("5");
        RadioButton p6 = new RadioButton("6");
        RadioButton p7 = new RadioButton("7");
        RadioButton p8 = new RadioButton("8");
        RadioButton p9 = new RadioButton("9");
        RadioButton p10 = new RadioButton("10");
        ToggleGroup tg = new ToggleGroup();
        p1.setToggleGroup(tg);
        p2.setToggleGroup(tg);
        p3.setToggleGroup(tg);
        p4.setToggleGroup(tg);
        p5.setToggleGroup(tg);
        p6.setToggleGroup(tg);
        p7.setToggleGroup(tg);
        p8.setToggleGroup(tg);
        p9.setToggleGroup(tg);
        p10.setToggleGroup(tg);
        javafx.scene.layout.GridPane gridPane = new javafx.scene.layout.GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setMinSize(400, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(imageView1, 0, 0);
        gridPane.setHalignment(imageView1, HPos.CENTER);
        gridPane.add(imageView2, 1, 0);
        gridPane.setHalignment(imageView2, HPos.CENTER);
        gridPane.add(imageView3, 2, 0);
        gridPane.setHalignment(imageView3, HPos.CENTER);
        gridPane.add(imageView4, 3, 0);
        gridPane.setHalignment(imageView4, HPos.CENTER);
        gridPane.add(imageView5, 4, 0);
        gridPane.setHalignment(imageView5, HPos.CENTER);
        gridPane.add(imageView6, 0, 3);
        gridPane.setHalignment(imageView6, HPos.CENTER);
        gridPane.add(imageView7, 1, 3);
        gridPane.setHalignment(imageView7, HPos.CENTER);
        gridPane.add(imageView8, 2, 3);
        gridPane.setHalignment(imageView8, HPos.CENTER);
        gridPane.add(imageView9, 3, 3);
        gridPane.setHalignment(imageView9, HPos.CENTER);
        gridPane.add(imageView10, 4, 3);
        gridPane.setHalignment(imageView10, HPos.CENTER);
        gridPane.add(p1, 0, 1);
        gridPane.setHalignment(p1, HPos.CENTER);
        gridPane.add(p2, 1, 1);
        gridPane.setHalignment(p2, HPos.CENTER);
        gridPane.add(p3, 2, 1);
        gridPane.setHalignment(p3, HPos.CENTER);
        gridPane.add(p4, 3, 1);
        gridPane.setHalignment(p4, HPos.CENTER);
        gridPane.add(p5, 4, 1);
        gridPane.setHalignment(p5, HPos.CENTER);
        gridPane.add(p6, 0, 4);
        gridPane.setHalignment(p6, HPos.CENTER);
        gridPane.add(p7, 1, 4);
        gridPane.setHalignment(p7, HPos.CENTER);
        gridPane.add(p8, 2, 4);
        gridPane.setHalignment(p8, HPos.CENTER);
        gridPane.add(p9, 3, 4);
        gridPane.setHalignment(p9, HPos.CENTER);
        gridPane.add(p10, 4, 4);
        gridPane.setHalignment(p10, HPos.CENTER);
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n) {

                javafx.scene.control.RadioButton rb = (javafx.scene.control.RadioButton) tg.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();
                    switch (s) {
                        case ("1"):
                            mainMenuController.getCurrentUser().setAvatar(imageView1.getImage());
                            break;
                        case ("2"):
                            mainMenuController.getCurrentUser().setAvatar(imageView2.getImage());
                            break;
                        case ("3"):
                            mainMenuController.getCurrentUser().setAvatar(imageView3.getImage());
                            break;
                        case ("4"):
                            mainMenuController.getCurrentUser().setAvatar(imageView4.getImage());
                            break;
                        case ("5"):
                            mainMenuController.getCurrentUser().setAvatar(imageView5.getImage());
                            break;
                        case ("6"):
                            mainMenuController.getCurrentUser().setAvatar(imageView6.getImage());
                            break;
                        case ("7"):
                            mainMenuController.getCurrentUser().setAvatar(imageView7.getImage());
                            break;
                        case ("8"):
                            mainMenuController.getCurrentUser().setAvatar(imageView8.getImage());
                            break;
                        case ("9"):
                            mainMenuController.getCurrentUser().setAvatar(imageView9.getImage());
                            break;
                        case ("10"):
                            mainMenuController.getCurrentUser().setAvatar(imageView10.getImage());
                            break;
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("your avatar has been chosen successfully");
                    alert.showAndWait();


                    // change the label
                    //r1.setText(s + " selected");
                    //System.out.println(s);
                }
            }
        });


        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        stage.setTitle("Grid Pane Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();

    }
}

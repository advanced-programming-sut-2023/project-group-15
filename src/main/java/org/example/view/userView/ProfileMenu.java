//this class is completed!
package org.example.view.userView;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.example.controller.userControllers.LoginMenuController;
import org.example.controller.userControllers.ProfileMenuController;
import org.example.controller.userControllers.SignupMenuController;
import org.example.model.Styles;
import org.example.view.enums.outputs.ProfileMenuOutput;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;

public class ProfileMenu extends Application {
    TextInputDialog newUsername = new TextInputDialog();
    SignupMenuController signupMenuController = new SignupMenuController();
    Styles styles = new Styles();
    private ProfileMenuController profileMenuController;
    Label slogan = new Label(profileMenuController.getCurrentUser().getSlogan());

    public void start(Stage stage) throws Exception {
        MainMenu.stage = stage;
        URL url = MainMenu.class.getResource("/FXML/ProfileMenu.fxml");
        Pane pane = FXMLLoader.load(url);
        pane.getChildren().add(slogan);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        //  stage.setResizable(false);
        stage.show();

    }


    /*public ProfileMenu(LoginMenuController currentUserController) {
        this.profileMenuController = (ProfileMenuController) currentUserController;
    }*/

    public ProfileMenu() {

    }

    /* protected void changeUserUsername(Matcher matcher) {
         String username = matcher.group("username");
         System.out.println(profileMenuController.changeUsername(username).getOutput());
     }
     protected void changeUserPassword(Matcher matcher) {
         String oldPass = matcher.group("oldPass");
         String newPass = matcher.group("newPass");
         System.out.println(profileMenuController.changePassword(oldPass,newPass).getOutput());
     }
     protected void changeUserNickname(Matcher matcher) {
         String nickName = matcher.group("nickname");
         System.out.println(profileMenuController.changeNickname(nickName).getOutput());
     }
     protected void changeUserEmail(Matcher matcher) {
         String email = matcher.group("email");
         System.out.println(profileMenuController.changeEmail(email).getOutput());
     }*/
    public void profileDisplay() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Label username = new Label(profileMenuController.getCurrentUser().getUsername());
        Label password = new Label(profileMenuController.getCurrentUser().getPassword());
        Label nickname = new Label(profileMenuController.getCurrentUser().getNickname());
        Label email = new Label(profileMenuController.getEmail());
        vbox.getChildren().addAll(username, password, nickname, email);
        Pane pane = new Pane();
        Stage stage = new Stage();
        Scene scene = new Scene(vbox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }


    public void changeEmail(MouseEvent mouseEvent) {

        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("new email");
        sloganInput.setContentText("enter new email");
        Optional<String> result = sloganInput.showAndWait();
        String userInput;
        if (result.isPresent()) {
            userInput = String.valueOf(result);
            switch (profileMenuController.changeEmail(userInput)) {
                case EMAIL_CHANGED_SUCCESSFULLY:
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("email changed");
                    alert.setContentText("your email updated successfully");
                    alert.showAndWait();
                    break;
                case INVALID_NEW_EMAIL:

                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("email change error");
                    alert2.setContentText("please enter a valid username");
                    alert2.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("email is empty");
            alert.setContentText("please enter a email");
            alert.showAndWait();
        }
    }

    public void changeUsername(MouseEvent mouseEvent) {

        newUsername.setTitle("new username");
        newUsername.setContentText("please enter your new username");
        Optional<String> result = newUsername.showAndWait();
        TextField username = newUsername.getEditor();
        username.textProperty().addListener((observable, oldValue, newValue) ->
        {
            usernameCheck();
        });
        String userInput;
        if (result.isPresent()) {
            userInput = String.valueOf(result);


        }
    }

    private void usernameCheck() {
        SignupMenuOutput result = SignupMenuController.usernameCheckErrors(newUsername.getResult());
        Label errorUsername = new Label();
        if (result.equals(SignupMenuOutput.USERNAME_EXISTS)) {
            signupMenuController.usernameSuggestionGenerator();

            errorUsername.setStyle(styles.getErrorMessage());
            errorUsername.setText("this username exists you can use " + signupMenuController.getUsername());
            newUsername.getEditor().setStyle(styles.getErrorStyle());
        }
        if (result.equals(SignupMenuOutput.INVALID_USERNAME_FORMAT)) {
            errorUsername.setStyle(styles.getErrorMessage());
            errorUsername.setText("invalid username , must contains letters , digits , _ !");
            newUsername.getEditor().setStyle(styles.getErrorStyle());
        }

        if (result.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            errorUsername.setStyle(styles.getSuccessfulMessage());
            errorUsername.setText("");
            newUsername.getEditor().setStyle(styles.getSuccessStyle());
            signupMenuController.setUsername(newUsername.getEditor().getText());
        }

    }

    public void changeNickname(MouseEvent mouseEvent) {

        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("new nickname");
        sloganInput.setContentText("enter new nickname");
        Optional<String> result = sloganInput.showAndWait();
        if (result.isPresent()) {
            profileMenuController.changeNickname(String.valueOf(result));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("please enter a nickname");
        }

    }

    public void ScoreBoard(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("AA High Scores Table");
        stage.setWidth(350);
        stage.setHeight(500);

        final Label label = new Label("Highest Score");
        label.setFont(new Font("Arial", 20));

        TableColumn<Map, String> firstDataColumn = new TableColumn<>("Rank");
        TableColumn<Map, String> secondDataColumn = new TableColumn<>("Name");
        firstDataColumn.setCellValueFactory(new MapValueFactory("player"));
        firstDataColumn.setMinWidth(150);

        secondDataColumn.setCellValueFactory(new MapValueFactory("score"));
        secondDataColumn.setMinWidth(100);
        javafx.scene.control.TableView tableView = new javafx.scene.control.TableView<>(generateDataInMap());

        tableView.setEditable(true);
        Callback<TableColumn<Map, String>, TableCell<Map, String>>
                cellFactoryForMap = (TableColumn<Map, String> p) ->
                new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object t) {
                        return t.toString();
                    }

                    @Override
                    public Object fromString(String string) {
                        return string;
                    }
                });
        firstDataColumn.setCellFactory(cellFactoryForMap);
        secondDataColumn.setCellFactory(cellFactoryForMap);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getColumns().setAll(firstDataColumn, secondDataColumn);
        final VBox vbox = new VBox();

        vbox.setSpacing(1);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);

        stage.show();
    }
    private ObservableList<Map> generateDataInMap(){
        /*List<Header> headerList = new ArrayList<>();
        headers.map().entrySet().forEach(e -> {
            headerList.add(new Header(e.getKey(), e.getValue().get(0)));
        });

        ObservableList<Header> list
                = FXCollections.observableArrayList(headerList);
        responseHeadersTableView.setItems(list);*/
        return null;

}



    public void changePassword(MouseEvent mouseEvent) {
        //TODO check letter by letter and have input for both new and old password
        TextInputDialog passwordDialog = new TextInputDialog();
        passwordDialog.setTitle("password change");

    }

    public void chooseAvatar(MouseEvent mouseEvent) throws Exception{
        new ChooseAvatar().start(MainMenu.stage);
    }

    public void removeSlogan(MouseEvent mouseEvent) {
        profileMenuController.removeSlogan();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("remove slogan");
        alert.setContentText("your slogan removed successfully");
    }

    public void changeSlogan(MouseEvent mouseEvent) {
        TextInputDialog sloganInput = new TextInputDialog();
        sloganInput.setHeaderText("new slogan");
        sloganInput.setContentText("enter new slogan");
        Optional<String> result = sloganInput.showAndWait();
        if(result.isPresent()) {
            profileMenuController.changeSlogan(String.valueOf(result));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("slogan change");
            alert.setContentText("your slogan was changed successfully");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("please enter a slogan");
            alert.showAndWait();
        }
    }
  /*  public void initialize(){
        username.textProperty().addListener((observable , oldText , newText)->{
                    usernameCheck();
                }


        );
        password.textProperty().addListener((observable , oldText , newText)->{
            passwordCheck();
        } );
    }*/


}

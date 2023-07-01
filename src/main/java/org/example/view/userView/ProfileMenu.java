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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.example.controller.userControllers.MainMenuController;
import org.example.controller.userControllers.ProfileMenuController;
import org.example.controller.userControllers.SignupMenuController;
import org.example.model.Styles;
import org.example.view.ScoreBoard;
import org.example.view.enums.outputs.ProfileMenuOutput;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

import static org.example.Utility.captchaStringGen;
import static org.example.Utility.displacementMap;

public class ProfileMenu extends Application {
    TextInputDialog newUsername = new TextInputDialog();
    PasswordField newPassword = new PasswordField();
    boolean nameChanged = true;
    MainMenuController mainMenuController = new MainMenuController();

    SignupMenuController signupMenuController = new SignupMenuController();
    private Stage stage1 = new Stage();
    private boolean captchaCheck = false;
    Styles styles = new Styles();
    public Label errorPassword = new Label();
    private ProfileMenuController profileMenuController = new ProfileMenuController();
    Label slogan = new Label(MainMenuController.getCurrentUser().getSlogan());
    Image background = new Image(getClass().getResource("/Images/04.jpg").toString());
    Image profileDBackground = new Image(getClass().getResource("/Images/02.jpg").toString());
    BackgroundImage dbImg = new BackgroundImage(profileDBackground,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1, 1.0, true, true, false, false));

    BackgroundImage bImg = new BackgroundImage(background,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1, 1.0, true, true, false, false));
    Background bGround = new Background(bImg);
    Background dbGround = new Background(dbImg);

    public void start(Stage stage) throws Exception {
        StartingMenu.stage = stage;
        URL url = StartingMenu.class.getResource("/FXML/ProfileMenu.fxml");
        Pane pane = FXMLLoader.load(url);
        pane.getChildren().add(slogan);
        pane.setBackground(bGround);
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
        Label username = new Label(" your username: " + MainMenuController.getCurrentUser().getUsername());
        //Label password = new Label(MainMenuController.getCurrentUser().getPassword());
        Label nickname = new Label(" your nickname: " + MainMenuController.getCurrentUser().getNickname());
        Label email = new Label("your email: " + MainMenuController.getCurrentUser().getEmail());
        ImageView avatar = new ImageView(MainMenuController.getCurrentUser().getAvatar());
        avatar.setFitHeight(81);
        avatar.setFitWidth(81);
        Background background = new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY));
        Pane pane = new Pane();
        pane.setBackground(dbGround);
        vbox.setPadding(new Insets(5, 5, 5, 5));
        vbox.setTranslateX(50);
        vbox.setBackground(background);
        vbox.setTranslateY(60);
        avatar.setX(150);
        avatar.setY(150);
        vbox.getChildren().addAll(username, nickname, email);
        pane.getChildren().addAll(vbox, avatar);
        //pane.setBackground(bGround);
        Stage stage = new Stage();
        Scene scene = new Scene(pane, 300, 300);
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
            userInput = sloganInput.getEditor().getText();
            System.out.println(userInput);
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
                    alert2.setContentText("please enter a valid email");
                    alert2.showAndWait();
                    break;
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
        if (newUsername.resultProperty().getValue() != null) {
            System.out.println("ok press");
            System.out.println(SignupMenuController.usernameCheckErrors(newUsername.getEditor().getText()));
            if (SignupMenuController.usernameCheckErrors(newUsername.getEditor().getText()).equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                nameChanged = true;
            }

            if (nameChanged) {
                System.out.println(profileMenuController.changeUsername(newUsername.getEditor().getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("username change");
                alert.setContentText("your username was changed was successfully");
                alert.showAndWait();

                //MainMenuController.getCurrentUser().setUsername(newUsername.getEditor().getText());
            }

        }
        newUsername.getEditor().textProperty().addListener((observable, oldText, newText) ->
        {
            usernameCheck();

        });

    }

    private void usernameCheck() {
        SignupMenuOutput result = SignupMenuController.usernameCheckErrors(newUsername.getEditor().getText());

        if (result.equals(SignupMenuOutput.USERNAME_EXISTS)) {
            nameChanged = false;
            // System.out.println("hello");
            signupMenuController.usernameSuggestionGenerator();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("this username exists you can use" + signupMenuController.getUsername());
            alert.showAndWait();
        }
        if (result.equals(SignupMenuOutput.INVALID_USERNAME_FORMAT)) {
            nameChanged = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            System.out.println("checked u");
            alert.setTitle("Error");
            alert.setContentText("invalid username , must contains letters , digits , _ !");
            alert.showAndWait();
        }

       /* if ( newUsername.resultProperty().getValue() != null && result.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            System.out.println("checked s");
            nameChanged = true;*/
          /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("username change");
            alert.setContentText("your username was changed was successfully");
            alert.showAndWait();
            MainMenuController.getCurrentUser().setUsername(newUsername.getEditor().getText());
        }*/

    }


    public void changeNickname(MouseEvent mouseEvent) {

        TextInputDialog nicknameInput = new TextInputDialog();
        nicknameInput.setHeaderText("new nickname");
        nicknameInput.setContentText("enter new nickname");
        Optional<String> result = nicknameInput.showAndWait();
        if (result.isPresent()) {
            profileMenuController.changeNickname(nicknameInput.getEditor().getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("please enter a nickname");
        }

    }

    public void ScoreBoard(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("StrongHold High Scores Table");
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

    private ObservableList<Map> generateDataInMap() {
        /*List<Header> headerList = new ArrayList<>();
        headers.map().entrySet().forEach(e -> {
            headerList.add(new Header(e.getKey(), e.getValue().get(0)));
        });

        ObservableList<Header> list
                = FXCollections.observableArrayList(headerList);
        responseHeadersTableView.setItems(list);*/
        return null;

    }


    public void changePassword(MouseEvent mouseEvent) throws Exception {
        Pane pane = new Pane();
        newPassword.setId("password");
        PasswordField oldPassword = new PasswordField();
        oldPassword.setId("password");
        Label oldPass = new Label();
        oldPass.setText("current password: ");
        Label newPass = new Label();
        newPass.setText("new password:   ");
        Button submit = new Button();
        submit.setText("save");
        pane.setBackground(bGround);
        Scene scene = new Scene(pane, 300, 200);
        oldPass.setTranslateX(5);
        oldPass.setTranslateY(20);
        oldPassword.setTranslateX(103);
        oldPassword.setTranslateY(20);
        newPass.setTranslateX(5);
        newPass.setTranslateY(101);
        newPassword.setTranslateX(103);
        newPassword.setTranslateY(100);
        submit.setTranslateX(150);
        submit.setTranslateY(150);
        oldPass.setStyle("-fx-background-color: wheat");
        newPass.setStyle("-fx-background-color: wheat");
        oldPass.setTextFill(Color.BLACK);
        oldPass.setTextFill(Color.BLACK);
        pane.getChildren().addAll(oldPass, oldPassword, submit, newPass, newPassword, errorPassword);
        stage1.setScene(scene);
        stage1.show();
        newPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            passwordCheck();

        });
        submit.setOnAction(e ->
        {
            System.out.println("hello");
            if (!oldPassword.getText().isBlank() && !newPassword.getText().isBlank()) {
                if (!oldPassword.getText().equals(MainMenuController.getCurrentUser().getPassword())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("your current password in not true");
                    alert.setHeaderText("current password error");

                } else if (errorPassword.getText().equals("")) {
                    System.out.println("1");
                    if (!captchaCheck)
                        captchaShower();
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("your password was changed successfully");
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("please fill the required parts");
            }
        });

    }

    public void captchaShower() {
        Label captchaMessage = new Label("please enter the below captcha");
        Button submit2 = new Button("submit");
        TextField captchaInput = new TextField();
        captchaInput.setId("captcha");
        Label error = new Label();
        error.setText("wrong captcha");
        error.setStyle(styles.getErrorMessage());
        error.setVisible(false);
        error.setTranslateY(100);
        error.setTranslateY(200);
        Scene scene = new Scene(new Group(), 300, 300);
        ObservableList content = ((Group) scene.getRoot()).getChildren();
        String[] captcha;
        captcha = captchaStringGen();
        captchaMessage.setTranslateX(50);
        captchaMessage.setTranslateY(50);
        submit2.setTranslateX(100);
        submit2.setTranslateY(200);
        captchaInput.setTranslateX(50);
        captchaInput.setTranslateY(70);
        content.add(displacementMap(captcha[0]));
        content.addAll(captchaMessage, submit2, captchaInput, error);
        stage1.setScene(scene);
        stage1.show();
        //todo the error labels are not shown
        submit2.setOnAction(e ->
        {
            if (!captchaInput.getText().isBlank()) {
                if (captchaInput.getText().equals(captcha[0])) {
                    captchaCheck = true;
                    stage1.close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("wrong captcha");
                    captchaShower();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("please fill the required parts");
                alert.showAndWait();
            }
        });

    }

    public void chooseAvatar(MouseEvent mouseEvent) throws Exception {
        Stage avatarStage = new Stage();
        new ChooseAvatar().start(avatarStage);
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
        if (result.isPresent()) {
            profileMenuController.changeSlogan(sloganInput.getEditor().getText());
            System.out.println(MainMenuController.getCurrentUser().getSlogan());
            slogan.setVisible(false);
            slogan.setText(MainMenuController.getCurrentUser().getSlogan());
            slogan.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("slogan change");
            alert.setContentText("your slogan was changed successfully");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("please enter a slogan");
            alert.showAndWait();
        }
    }

    public void initialize() {
        newUsername.getEditor().textProperty().addListener((observable, oldText, newText) -> {
                    usernameCheck();
                }


        );
        newPassword.textProperty().addListener((observable, oldText, newText) -> {
            passwordCheck();
        });
    }

    private void passwordCheck() {
        switch (SignupMenuController.passwordCheckErrors(newPassword.getText())) {
            case ERROR_PASSWORD_IS_TOO_SHORT:
                errorPassword.setStyle(styles.getErrorMessage());
                errorPassword.setText("password must contains as least 6 characters");
                newPassword.setStyle(styles.getErrorStyle());
                break;
            case CHECKED_SUCCESSFULLY:
                System.out.println("checked successfully");
                errorPassword.setStyle(styles.getSuccessfulMessage());
                errorPassword.setText("");
                System.out.println(errorPassword.getText());
                newPassword.setStyle(styles.getSuccessfulMessage());
                signupMenuController.setPassword(newPassword.getText());
                break;
            default:
                errorPassword.setStyle(styles.getErrorMessage());
                errorPassword.setText("password must contains at least a large,small,special characters,digit");
                newPassword.setStyle(styles.getErrorStyle());
        }
    }


    public void showScoreboard(MouseEvent mouseEvent) {
        new ScoreBoard().start(new Stage());
    }

    public void uploadAvatar(MouseEvent mouseEvent) {
        FileChooser fc = new FileChooser();
        fc.setTitle("please choose an image");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("*.png", "*.jpg", "*.gif");
        File selectedImage = fc.showOpenDialog(new Stage());
        if (selectedImage != null) {
            Image avatar = new Image(selectedImage.toURI().toString());
            mainMenuController.getCurrentUser().setAvatar(avatar);

        }
    }

    public void market(MouseEvent mouseEvent) throws Exception {
        new Market().start(new Stage());
    }
}

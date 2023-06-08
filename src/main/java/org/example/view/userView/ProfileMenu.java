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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.example.controller.userControllers.MainMenuController;
import org.example.controller.userControllers.ProfileMenuController;
import org.example.controller.userControllers.SignupMenuController;
import org.example.model.Styles;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.net.URL;
import java.util.Map;
import java.util.Optional;

import static org.example.Utility.captchaStringGen;
import static org.example.Utility.displacementMap;

public class ProfileMenu extends Application {
    TextInputDialog newUsername = new TextInputDialog();
    PasswordField newPassword = new PasswordField();

    SignupMenuController signupMenuController = new SignupMenuController();
    private Stage stage1 = new Stage();
    private boolean captchaCheck = false;
    Styles styles = new Styles();
    public Label errorPassword = new Label();
    private ProfileMenuController profileMenuController = new ProfileMenuController();
    Label slogan = new Label(MainMenuController.getCurrentUser().getSlogan());
    Image background = new Image(getClass().getResource("/Images/04.jpg").toString());
    BackgroundImage bImg = new BackgroundImage(background,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1, 1.0, true, true, false, false));
    Background bGround = new Background(bImg);

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
        Label username = new Label(MainMenuController.getCurrentUser().getUsername());
        //Label password = new Label(MainMenuController.getCurrentUser().getPassword());
        Label nickname = new Label(MainMenuController.getCurrentUser().getNickname());
        Label email = new Label(MainMenuController.getEmail());
        ImageView avatar = new ImageView(MainMenuController.getCurrentUser().getAvatar());
        Pane pane = new Pane();
        vbox.getChildren().addAll(username, nickname, email );
        pane.getChildren().addAll(vbox , avatar);
        vbox.setBackground(bGround);
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
      Pane pane = new Pane();
      newPassword.setId("password");
      PasswordField oldPassword = new PasswordField();
      oldPassword.setId("password");
      Label oldPass = new Label();
      oldPass.setText("current password");
      Label newPass = new Label();
      newPass.setText("new password");
      Button submit = new Button();
      pane.setBackground(bGround);
        Scene scene = new Scene(pane , 300 , 200);
        oldPass.setTranslateX(20);
        oldPass.setTranslateY(50);
        oldPassword.setTranslateX(60);
        oldPass.setTranslateY(50);
        newPassword.setTranslateX(100);
        oldPassword.setTranslateY(60);
        pane.getChildren().addAll(oldPass , oldPassword , newPass , newPassword , errorPassword);
        stage1.setScene(scene);
        stage1.show();
        newPassword.textProperty().addListener((observable ,oldValue , newValue)-> {
            passwordCheck();

        });
        submit.setOnAction(e ->
        {
            if(!oldPassword.getText().isBlank() && !newPassword.getText().isBlank())
            {
                if(!oldPassword.getText().equals(MainMenuController.getCurrentUser().getPassword())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("your current password in no true");
                    alert.setHeaderText("current password error");

                }
              else if(errorPassword.getText().equals(""))
                {
                    if(!captchaCheck)
                    captchaShower();
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("your password was changed successfully");
                    }
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("please fill the required parts");
            }
        });

    }
    public void captchaShower()
    {
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
        content.addAll(captchaMessage, submit2, captchaInput , error);
        stage1.setScene(scene);
        stage1.show();
        //todo the error labels are not shown
        submit2.setOnAction(e ->
        {
            if (!captchaInput.getText().isBlank()) {
                if (captchaInput.getText().equals(captcha[0])) {
                    captchaCheck = true;
                    stage1.close();
                }

                else
                {
                    error.setVisible(true);
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

    public void chooseAvatar(MouseEvent mouseEvent) throws Exception{
        new ChooseAvatar().start(StartingMenu.stage);
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
  private void passwordCheck() {
      switch (SignupMenuController.passwordCheckErrors(newPassword.getText())) {
          case ERROR_PASSWORD_IS_TOO_SHORT:
              errorPassword.setStyle(styles.getErrorMessage());
              errorPassword.setText("password must contains as least 6 characters");
              newPassword.setStyle(styles.getErrorStyle());
              break;
          case CHECKED_SUCCESSFULLY:
              errorPassword.setStyle(styles.getSuccessfulMessage());
              errorPassword.setText("");
              newPassword.setStyle(styles.getSuccessfulMessage());
              signupMenuController.setPassword(newPassword.getText());
              break;
          default:
              errorPassword.setStyle(styles.getErrorMessage());
              errorPassword.setText("password must contains at least a large,small,special characters,digit");
              newPassword.setStyle(styles.getErrorStyle());
      }
  }


}

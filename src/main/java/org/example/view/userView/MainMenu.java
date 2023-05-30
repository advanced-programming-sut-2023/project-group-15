//this is class is completed! please don't touch my class!
package org.example.view.userView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

public class MainMenu extends Application {
    public static Stage stage;
    @Override
    public void start (Stage stage) throws Exception
    {
        MainMenu.stage = stage ;
        URL url = MainMenu.class.getResource("/FXML/MainMenu.fxml");
        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();



    }

    public void signUp(MouseEvent mouseEvent) throws Exception{
        new SignupMenu().start(MainMenu.stage);
    }

    public void login(MouseEvent mouseEvent) throws Exception {
        new LoginMenu().start(MainMenu.stage);
    }
    /*public void run()  {
        Matcher mainMenuMatcher;
        String userInput;
        System.out.println(SignupMenuOutput.SHOW_MAIN_MENU_OPTIONS.getOutput());
        while (true) {
            userInput = InputScanner.getScanner().nextLine();
            if (userInput.matches("\\s*exit\\s*"))
                return;
            else if ((mainMenuMatcher = SignupMenuEnum.getMatcher(userInput, SignupMenuEnum.USER_CREATION)) != null) {
                System.out.println(SignupMenuOutput.SHOW_OPTIONS.getOutput());
                new SignupMenu().run(mainMenuMatcher);
            } else if ((mainMenuMatcher = LoginMenuEnum.getMatcher(userInput, LoginMenuEnum.USER_LOGIN)) != null) {
                new LoginMenu().loginInCheck(mainMenuMatcher);
            } else if (LoginMenuEnum.getMatcher(userInput, LoginMenuEnum.FORGET_PASSWORD) != null) {
                forgetPassword();
            } else if (SignupMenuEnum.getMatcher(userInput, SignupMenuEnum.CREATE_MAP) != null) {
                new MapMenu().run();
            } else {
                System.out.println("Invalid command!");
            }
        }
    }*/

  /*  private void forgetPassword() {
        System.out.println("enter your username:");
        String input = InputScanner.getScanner().nextLine();
        new LoginMenu().forgetPassword(input);
    }

    public void signUp(MouseEvent mouseEvent) {

    }

    public void login(MouseEvent mouseEvent) {
    }*/
}
package org.example.veiw;

import org.example.InputScanner;
import org.example.veiw.enums.commands.LoginMenuEnum;
import org.example.veiw.enums.commands.SignupMenuEnum;

import java.util.regex.Matcher;

public class MainMenu {
    public void run() {
        InputScanner mainMenuScanner = new InputScanner();
        Matcher mainMenuMatcher;
        String userInput;
        while (true) {
            userInput = mainMenuScanner.getScanner().nextLine();
            if (userInput.matches("\\s*exit\\s*"))
                return;
            else if ((mainMenuMatcher = SignupMenuEnum.getMatcher(userInput, SignupMenuEnum.USER_CREATION))!=null) {
                userCreationCheckInput(mainMenuMatcher);
            } else if ((mainMenuMatcher = LoginMenuEnum.getMatcher(userInput, LoginMenuEnum.USER_LOGIN))!=null) {
                userLoginCheckInput(mainMenuMatcher);
            }
        }
    }

    private void userLoginCheckInput(Matcher mainMenuMatcher) {
        //TODO: check user input for this command...
    }

    private void userCreationCheckInput(Matcher mainMenuMatcher) {
        //TODO: check user input for this command...
    }
}

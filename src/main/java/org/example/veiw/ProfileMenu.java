package org.example.veiw;

import org.example.controller.ProfileMenuController;

import java.util.regex.Matcher;

public class ProfileMenu extends LoginMenu{
    private final ProfileMenuController profileMenuController = new ProfileMenuController();
    private Matcher profileMenuMatcher;
    public void changeProfile(Matcher loginMenuMatcher) {

        profileMenuController.setUsername(loginMenuMatcher.group("username"));
    }

    protected void changeUserUsername(Matcher matcher) {
        //TODO:creating controller here....
        return;
    }

    protected void changeUserPassword(Matcher matcher) {
        //TODO:creating controller here....
        return;
    }
    protected void changeUserNickname(Matcher matcher) {
        //TODO:creating controller here....
        return;
    }
    protected void changeUserEmail(Matcher matcher) {
        //TODO:creating controller here....
        return;
    }
    protected void changeUserSlogan(Matcher matcher) {
        //TODO:creating controller here....
        return;
    }

    protected void removeUserSlogan() {
    }
}

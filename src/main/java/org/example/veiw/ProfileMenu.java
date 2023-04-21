package org.example.veiw;

import org.example.controller.ProfileMenuController;

import java.util.regex.Matcher;

public class ProfileMenu {
    private final ProfileMenuController profileMenuController = new ProfileMenuController();
    public void changeProfile(Matcher loginMenuMatcher) {

        profileMenuController.setUsername(loginMenuMatcher.group("username"));
    }
}

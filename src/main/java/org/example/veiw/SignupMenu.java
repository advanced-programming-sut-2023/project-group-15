package org.example.veiw;



import org.example.controller.SignupMenuController;

import java.util.regex.Matcher;

public class SignupMenu extends MainMenu{
    private final SignupMenuController signupMenuController = new SignupMenuController();
    public void checkSigningUp(Matcher matcher) {
        signupMenuController.setUsername(matcher.group("username"));
        signupMenuController.setPassword(matcher.group("password"));
        signupMenuController.setNickname(matcher.group("nickname"));
        signupMenuController.setEmail(matcher.group("email"));
        signupMenuController.setSlogan(matcher.group("slogan"));
        System.out.println(signupMenuController.signupUser());
    }

}

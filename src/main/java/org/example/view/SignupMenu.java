package org.example.view;



import org.example.InputScanner;
import org.example.controller.SignupMenuController;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.regex.Matcher;

public class SignupMenu extends MainMenu{
    private final SignupMenuController signupMenuController = new SignupMenuController();
    public void checkSigningUp(Matcher matcher, InputScanner sginupMenuScanner) {
        signupMenuController.setUsername(matcher.group("username"));
        signupMenuController.setPassword(matcher.group("password"));
        signupMenuController.setNickname(matcher.group("nickname"));
        signupMenuController.setEmail(matcher.group("email"));
        signupMenuController.setSlogan(matcher.group("slogan"));
        String message = signupMenuController.signupUser().getOutput();
        if (message.equals(SignupMenuOutput.STAND_BY.getOutput())) {
            System.out.println("you password is: "+signupMenuController.getClipBoard());
            String verification = null;
            while (true) {
                System.out.println("re-enter your password please: ");
                if (signupMenuController.randomPasswordVerification(verification)) {
                    signupMenuController.signingsComplete();
                    return;
                } else if (verification.matches("^\\s*quit\\s*$")) {
                    return;
                } else {
                    System.out.println("doesn't matched to the password!,\n try again! or enter \"quit\" to exit");
                }
            }
        }
        System.out.println(signupMenuController.signupUser());
    }

}

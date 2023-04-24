package org.example.view;



import org.example.InputScanner;
import org.example.controller.SignupMenuController;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.regex.Matcher;

public class SignupMenu extends MainMenu{
    private final SignupMenuController signupMenuController = new SignupMenuController();
    private Matcher signupMenuMatcher;
    private String signupMenuInput;

    public void run(Matcher signupMenuMatcher,InputScanner signupMenuScanner) {
        classifyParameters(signupMenuMatcher);
        usernameCheck();
    }

    private void usernameCheck() {
        if (signupMenuController.usernameCheck().equals(SignupMenuOutput.USERNAME_EXISTS)) {
            signupMenuController.usernameSuggestion();
            //TODO: suggesting valid username to user...
        }
    }

    public void checkSigningUp(Matcher matcher, InputScanner signupMenuScanner) {

        String message = signupMenuController.signupUserCheck().getOutput();
        if (signupMenuController.getSlogan().matches("\\s*random\\s*")) {
            signupMenuController.setSlogan(signupMenuController.generateRandomSlogan());
            System.out.println("your slogan is: "+signupMenuController.getSlogan());
        }
        if (signupMenuController.getPassword().matches("\\s*random\\s*")) {
            signupMenuController.setClipBoard(signupMenuController.generateRandomPassword());
            System.out.println("your password is: "+signupMenuController.getPassword());
            while (true) {
                String verification = signupMenuScanner.getScanner().nextLine();
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
        if (message.equals(SignupMenuOutput.SECURITY_QUESTION.getOutput())) {
            //TODO: printing security questions....
            while (true) {
                if ((signupMenuMatcher = SignupMenuEnum.getMatcher(signupMenuInput,SignupMenuEnum.PICK_QUESTION))!=null) {
                    //TODO: pick question part...
                }
            }
        }
        if (message.equals(SignupMenuOutput.STAND_BY.getOutput())) {
            System.out.println("you password is: "+signupMenuController.getClipBoard());

        }
        System.out.println(signupMenuController.signupUserCheck());
    }
    public void classifyParameters(Matcher matcher) {
        signupMenuController.setUsername(matcher.group("username"));
        signupMenuController.setPassword(matcher.group("password"));
        signupMenuController.setNickname(matcher.group("nickname"));
        signupMenuController.setEmail(matcher.group("email"));
        signupMenuController.setSlogan(matcher.group("slogan"));
    }

}

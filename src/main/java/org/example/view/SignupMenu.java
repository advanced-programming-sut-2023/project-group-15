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

    public void run(Matcher signupMenuMatcher) {
        SignupMenuOutput status;
        classifyParameters(signupMenuMatcher);
        status = usernameCheck();
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            status = passwordCheck();
            if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                //continue
            }
        } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
            //TODO: returning to the main menu
        } else {
            System.out.println(status);
        }

    }

    private SignupMenuOutput passwordCheck() {
        if (signupMenuController.getPassword().matches("\\s*random\\s*")) {
            signupMenuController.setClipBoard(signupMenuController.generateRandomPassword());
            System.out.println("your password is: "+signupMenuController.getPassword());
            while (true) {
                String verification = InputScanner.getScanner().nextLine();
                System.out.println("re-enter your password please: ");
                if (signupMenuController.randomPasswordVerification(verification)) {
                    return SignupMenuOutput.CHECKED_SUCCESSFULLY;
                } else if (verification.matches("^\\s*quit\\s*$")) {
                    return SignupMenuOutput.QUIT_FROM_PROCESS;
                } else {
                    System.out.println("doesn't matched to the password!,\n try again! or enter \"quit\" to exit");
                }
            }
        }
        return signupMenuController.passwordCheck(signupMenuController.getPassword());
    }

    private SignupMenuOutput usernameCheck() {
        SignupMenuOutput result = signupMenuController.usernameCheckErrors();
        if (result.equals(SignupMenuOutput.USERNAME_EXISTS)) {
            while (true) {
                signupMenuController.usernameSuggestionGenerator();
                System.out.println("there's another user with this username!,\n" +
                        "you can use\"" + signupMenuController.getUsername() + "\" or quit the registration process or try something else!");
                System.out.println("1.accept the suggested username,\n" +
                        "2.quit,\n" +
                        "3.try another username,\n" +
                        "type the number here: ");
                if (InputScanner.getScanner().nextLine().matches("^\\s*1\\s*$"))
                    return SignupMenuOutput.CHECKED_SUCCESSFULLY;
                else if (InputScanner.getScanner().nextLine().matches("^\\s*2\\s*$"))
                    return SignupMenuOutput.QUIT_FROM_PROCESS;
                else if (InputScanner.getScanner().nextLine().matches("^\\s*3\\s*$")) {
                    signupMenuController.setUsername(InputScanner.getScanner().nextLine());
                    usernameCheck();
                } else
                    System.out.println(SignupMenuOutput.INVALID_COMMAND);
            }
        }
        else if (result.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
            return SignupMenuOutput.QUIT_FROM_PROCESS;
        } else if (result.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
        }
        return result;
    }

    public void checkSigningUp(Matcher matcher, InputScanner signupMenuScanner) {

        String message = signupMenuController.signupUserCheck().getOutput();
        if (signupMenuController.getSlogan().matches("\\s*random\\s*")) {
            signupMenuController.setSlogan(signupMenuController.generateRandomSlogan());
            System.out.println("your slogan is: "+signupMenuController.getSlogan());
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

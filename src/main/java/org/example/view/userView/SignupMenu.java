//this class is completed!
package org.example.view.userView;

import org.example.InputScanner;
import org.example.controller.userControllers.SignupMenuController;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.regex.Matcher;

public class SignupMenu extends MainMenu {
    private final SignupMenuController signupMenuController = new SignupMenuController();
    private boolean questionFlag = true;

    public void run(Matcher signupMenuMatcher)  {
        SignupMenuOutput status;
        classifyParameters(signupMenuMatcher);
        status = usernameCheck();
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            status = passwordCheck();
            if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                status = sloganCheck();
                if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                    status = signupMenuController.signupUserCheck();
                    if (status.equals(SignupMenuOutput.SECURITY_QUESTION)) {
                        if (questionFlag)
                            pickQuestion();
                        signupMenuController.signingsComplete();
                        System.out.println(SignupMenuOutput.USER_CREATED_SUCCESSFULLY.getOutput());
                        return;
                    } else
                        System.out.println(status.getOutput());
                } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
                    return;
                } else
                    System.out.println(status.getOutput());
            } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
                return;
            } else {
                System.out.println(status.getOutput());
            }
        } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
            return;
        } else {
            System.out.println(status.getOutput());
        }
    }

    private SignupMenuOutput sloganCheck() {
        if (signupMenuController.getSlogan() == null) {
            signupMenuController.setSlogan("empty");
            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
        }
        else if (signupMenuController.getSlogan().matches("\\s*random\\s*")) {
            signupMenuController.showSlogans();
            System.out.println("choose one of these slogans (enter the number):");
            while (true) {
                String input = InputScanner.getScanner().nextLine();
                if (Integer.parseInt(input) <= 11 || Integer.parseInt(input) >= 1) {
                    signupMenuController.selectSlogan(input);
                    return SignupMenuOutput.CHECKED_SUCCESSFULLY;
                } else if (input.matches("^\\s*quit\\s*$")) {
                    return SignupMenuOutput.QUIT_FROM_PROCESS;
                } else
                    System.out.println("you entered invalid input, try again! or enter \"quit\" to exit");
            }
        }
        return SignupMenuOutput.CHECKED_SUCCESSFULLY;
    }

    private SignupMenuOutput pickQuestion() {
        Matcher signupMenuMatcher;
        System.out.println("pick a question from these questions:");
        signupMenuController.showQuestions();
        while (true) {
            String input = InputScanner.getScanner().nextLine();
            if ((signupMenuMatcher = SignupMenuEnum.getMatcher(input, SignupMenuEnum.PICK_QUESTION)) != null) {
                SignupMenuOutput status = signupMenuController.pickSecurityQuestion(signupMenuMatcher);
                if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                    return status;
                } else
                    System.out.println(status.getOutput());
            } else if (input.matches("^\\s*quit\\s*$")) {
                return SignupMenuOutput.QUIT_FROM_PROCESS;
            } else
                System.out.println("invalid command!,\ntry again!\ntype \"quit\" to cancel the process");
        }
    }

    private SignupMenuOutput passwordCheck() {
        if (signupMenuController.getPassword().matches("\\s*random\\s*")) {
            signupMenuController.setPassword(signupMenuController.generateRandomPassword());
            System.out.println("your password is: " + signupMenuController.getPassword());
            while (true) {
                System.out.println("re-enter your password please: ");
                String verification = InputScanner.getScanner().nextLine();
                if (signupMenuController.randomPasswordVerification(verification)) {
                    SignupMenuOutput output = pickQuestion();
                    questionFlag = false;
                    return output;
                } else if (verification.matches("^\\s*quit\\s*$")) {
                    return SignupMenuOutput.QUIT_FROM_PROCESS;
                } else {
                    System.out.println("doesn't matched to the password!, try again! or enter \"quit\" to exit");
                }
            }
        }
        SignupMenuOutput status = SignupMenuController.passwordCheckErrors(signupMenuController.getPassword());
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            if (signupMenuController.checkPasswordWithConfiguration())
                return status;
            return SignupMenuOutput.ERROR_PASSWORD_DONOT_MATCH_WITH_CONFIGURATION;
        }
        return status;
    }

    private SignupMenuOutput usernameCheck() {
        SignupMenuOutput result = SignupMenuController.usernameCheckErrors(signupMenuController.getUsername());
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
        } else if (result.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
            return SignupMenuOutput.QUIT_FROM_PROCESS;
        } else
            return result;
    }

    public void classifyParameters(Matcher matcher) {
        signupMenuController.setUsername(matcher.group("username"));
        signupMenuController.setPassword(matcher.group("password"));
        signupMenuController.setNickname(matcher.group("nickname"));
        signupMenuController.setClipBoard(matcher.group("configuration"));
        signupMenuController.setEmail(matcher.group("email"));
        signupMenuController.setSlogan(matcher.group("slogan"));
    }
}

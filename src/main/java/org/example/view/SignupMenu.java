package org.example.view;

import org.example.InputScanner;
import org.example.controller.SignupMenuController;
import org.example.model.enums.SecurityQuestion;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.regex.Matcher;

public class SignupMenu extends MainMenu {
    private final SignupMenuController signupMenuController = new SignupMenuController();
    private Matcher signupMenuMatcher;

    public void run(Matcher signupMenuMatcher) {
        SignupMenuOutput status;
        classifyParameters(signupMenuMatcher);
        status = usernameCheck();
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            status = passwordCheck();
            if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                status = signupMenuController.signupUserCheck();
                if (status.equals(SignupMenuOutput.SECURITY_QUESTION)) {
                    pickQuestion();
                }
            } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
                return;
            } else {
                System.out.println(status);
            }
        } else if (status.equals(SignupMenuOutput.QUIT_FROM_PROCESS)) {
            return;
        } else {
            System.out.println(status);
        }
    }

    private SignupMenuOutput pickQuestion() {
        System.out.println("pick a question from these questions,(enter the number):");
        questions();
        while (true) {
            String input = InputScanner.getScanner().nextLine();
            if ((signupMenuMatcher=SignupMenuEnum.getMatcher(input,SignupMenuEnum.PICK_QUESTION))!=null) {
                SignupMenuOutput status = signupMenuController.pickSecurityQuestion(signupMenuMatcher);
                if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                    return status;
                }
            } else if (input.matches("^\\s*quit\\s*$")) {
                return SignupMenuOutput.QUIT_FROM_PROCESS;
            } else
                System.out.println("invalid command!,\ntry again!\ntype \"quit\" to cancel the process");
        }

    }
    private void questions() {
        System.out.println("1."+ SecurityQuestion.FATHER_NAME.getQuestion());
        System.out.println("2."+SecurityQuestion.BROTHER_NAME.getQuestion());
        System.out.println("3."+SecurityQuestion.LAPTOP_MODEL.getQuestion());
        System.out.println("4."+SecurityQuestion.PHONE_MODEL.getQuestion());
        System.out.println("5."+SecurityQuestion.HAIR_COLOR.getQuestion());
        System.out.println("6."+SecurityQuestion.CAR_COLOR.getQuestion());
        System.out.println("7."+SecurityQuestion.FAVORITE_FOOD.getQuestion());
        System.out.println("8."+SecurityQuestion.FAVORITE_GAME.getQuestion());
        System.out.println("9."+SecurityQuestion.USER_JOB.getQuestion());
        System.out.println("10."+SecurityQuestion.USER_AGE.getQuestion());
    }
    private SignupMenuOutput passwordCheck() {
        if (signupMenuController.getPassword().matches("\\s*random\\s*")) {
            signupMenuController.setPassword(signupMenuController.generateRandomPassword());
            System.out.println("your password is: "+signupMenuController.getPassword());
            while (true) {
                System.out.println("re-enter your password please: ");
                String verification = InputScanner.getScanner().nextLine();
                if (signupMenuController.randomPasswordVerification(verification)) {
                    System.out.println("should go to security question part...");
                    return SignupMenuOutput.CHECKED_SUCCESSFULLY;
                } else if (verification.matches("^\\s*quit\\s*$")) {
                    return SignupMenuOutput.QUIT_FROM_PROCESS;
                } else {
                    System.out.println("doesn't matched to the password!, try again! or enter \"quit\" to exit");
                }
            }
        }
        return SignupMenuController.passwordCheckErrors(signupMenuController.getPassword());
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
        } else
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
                if ((signupMenuMatcher = SignupMenuEnum.getMatcher(message,SignupMenuEnum.PICK_QUESTION))!=null) {
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
        signupMenuController.setClipBoard(matcher.group("configuration"));
        signupMenuController.setEmail(matcher.group("email"));
        signupMenuController.setSlogan(matcher.group("slogan"));
        //test:
        System.out.println("username: "+signupMenuController.getUsername());
        System.out.println("password: "+signupMenuController.getPassword());
        System.out.println("P.configuration: "+signupMenuController.getClipBoard());
        System.out.println("email: "+signupMenuController.getEmail());
        System.out.println("slogan: "+signupMenuController.getSlogan());
    }
}

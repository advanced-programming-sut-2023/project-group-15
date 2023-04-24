package org.example.view;



import org.example.InputScanner;
import org.example.controller.SignupMenuController;
import org.example.model.enums.SecurityQuestion;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.regex.Matcher;

public class SignupMenu extends MainMenu{
    private final SignupMenuController signupMenuController = new SignupMenuController();
    private Matcher signupMenuMatcher;

    public void run(Matcher signupMenuMatcher) {
        SignupMenuOutput status;
        classifyParameters(signupMenuMatcher);
        status = usernameCheck();
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            status = passwordCheck();
            if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                if (signupMenuController.emailCheckErrors().equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                    if (signupMenuController.nicknameCheckErrors().equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)){
                        if (pickQuestion().equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                            signupMenuController.signingsComplete();
                        }
                    }
                }
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
                for (SecurityQuestion question:SecurityQuestion.allQuestions()) {
                    if (question.getQuestionNumber().matches(signupMenuMatcher.group("Qnumber"))) {
                        signupMenuController.setPassRecoveryQuestion(question);
                        if (signupMenuMatcher.group("Qanswer1").equals(signupMenuMatcher.group("Qanswer2"))) {
                            signupMenuController.setPassRecoveryAnswer(signupMenuMatcher.group("Qanswer1"));
                            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
                        } else {
                            System.out.println("your answers doesn't match!,\ntry again!\n,type \"quit\" to cancel the process");
                        }
                    }
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
        return signupMenuController.passwordCheckErrors(signupMenuController.getPassword());
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

    public void classifyParameters(Matcher matcher) {
        signupMenuController.setUsername(matcher.group("username"));
        signupMenuController.setPassword(matcher.group("password"));
        signupMenuController.setNickname(matcher.group("nickname"));
        signupMenuController.setEmail(matcher.group("email"));
        signupMenuController.setSlogan(matcher.group("slogan"));
    }

}

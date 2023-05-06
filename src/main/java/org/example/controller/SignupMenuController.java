package org.example.controller;


import org.example.model.User;
import org.example.model.enums.SecurityQuestion;
import org.example.model.enums.Slogans;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupMenuController extends MainMenuController{
    public SignupMenuOutput signupUserCheck() {
        SignupMenuOutput status;
        if ((status = emailCheck(this.getEmail()))!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
            return status;
        if ((status = nicknameCheck())!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
            return status;
        return SignupMenuOutput.SECURITY_QUESTION;
    }
    private SignupMenuOutput nicknameCheck() {
        return this.getNickname()==null ? SignupMenuOutput.EMPTY_FIELD : SignupMenuOutput.CHECKED_SUCCESSFULLY;
    }
    public SignupMenuOutput sloganCheck() {
        return this.getSlogan()==null ? SignupMenuOutput.EMPTY_FIELD : SignupMenuOutput.CHECKED_SUCCESSFULLY;
    }
    public static SignupMenuOutput usernameCheckErrors(String username) {
        if (username == null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (username.matches("^\\w+$")) {
            for (User user:User.allUsers) {
                if (user.getUsername().equals(username)) {
                    return SignupMenuOutput.USERNAME_EXISTS;
                }
            }
            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
        }
        return SignupMenuOutput.INVALID_USERNAME_FORMAT;
    }
    public static SignupMenuOutput passwordCheckErrors(String password) {
        if (password==null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (password.length()>=6) {
            if (SignupMenuEnum.getMatcher(password,SignupMenuEnum.SMALL_CHAR)!=null) {
                if (SignupMenuEnum.getMatcher(password,SignupMenuEnum.CAPITAL_CHAR)!=null) {
                    if (SignupMenuEnum.getMatcher(password,SignupMenuEnum.DIGITS)!=null) {
                        if (SignupMenuEnum.getMatcher(password,SignupMenuEnum.SPECIAL_CHAR)!=null) {
                            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
                        }
                        return SignupMenuOutput.ERROR_PASSWORD_NO_SPECIAL_CHARACTER;
                    }
                    return SignupMenuOutput.ERROR_PASSWORD_NO_DIGITS;
                }
                return SignupMenuOutput.ERROR_PASSWORD_NO_CAPITAL_CHARACTER;
            }
            return SignupMenuOutput.ERROR_PASSWORD_NO_SMALL_CHARACTER;
        }
        return SignupMenuOutput.ERROR_PASSWORD_IS_TOO_SHORT;
    }

    public boolean checkPasswordWithConfiguration() {
        return this.getPassword().equals(this.getClipBoard());
    }
    public static SignupMenuOutput emailCheck(String email) {
        if (email==null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (email.matches("[\\w.]+@[\\w.]+\\.[\\w.]+")) {
            for (User user: User.allUsers) {
                if (getMatcher(user.getEmail(),email)!=null)
                    return SignupMenuOutput.DUPLICATE_EMAIL_ERROR;
            }
            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
        }
        return SignupMenuOutput.INVALID_EMAIL_FORMAT;
    }
    public void selectSlogan(String input) {
        this.setSlogan(Slogans.getAllSlogans().get(Integer.parseInt(input)).getSlogan());
    }
    public String generateRandomPassword() {
        String password;
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}]).{8,20}$";
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz"+"1234567890"+"!@#$%^&*()_+{}";
        Random random = new Random();
        while(true){
            char[] p = new char[8];
            for (int i=0;i<8;i++) {
                p[i] = charSet.toCharArray()[random.nextInt(charSet.length()-1)];
            }
            password = java.lang.String.valueOf(p);
            if(password.matches(regex)) {
                return password;
            }
        }
    }
    public SignupMenuOutput pickSecurityQuestion(Matcher matcher) {
        for (SecurityQuestion question:SecurityQuestion.allQuestions()) {
            if (question.getQuestionNumber().matches(matcher.group("Qnumber"))) {
                this.setPassRecoveryQuestion(question);
                if (matcher.group("Qanswer1").equals(matcher.group("Qanswer2"))) {
                    this.setPassRecoveryAnswer(matcher.group("Qanswer1"));
                    return SignupMenuOutput.CHECKED_SUCCESSFULLY;
                } else {
                    return SignupMenuOutput.ANSWERS_ARE_NOT_EQUAL;
                }
            }
        }
        return SignupMenuOutput.INVALID_COMMAND;
    }
    public void usernameSuggestionGenerator() {
        while (true) {
            boolean flag = true;
            Random random = new Random();
            char randomChar = (char) (random.nextInt(26)+'a');
            this.setUsername(this.getUsername()+randomChar);
            for (User user : User.allUsers){
                if (user.getUsername().equals(this.getUsername())) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return;
        }
    }
    public boolean randomPasswordVerification(String verification) {
        return verification.equals(this.getPassword());
    }
    public void signingsComplete() {
        User newUser = new User(this.getUsername(), this.getPassword(), this.getNickname(), this.getEmail());
        if (this.getSlogan()!=null) {
            newUser.setSlogan(this.getSlogan());
        }
        newUser.addUser();
        System.out.println("added to User class!");
    }
    private static Matcher getMatcher(String password, String regex) {
        Matcher matcher = Pattern.compile(regex,Pattern.CASE_INSENSITIVE).matcher(password);
        return matcher.matches() ? matcher : null ;
    }
}

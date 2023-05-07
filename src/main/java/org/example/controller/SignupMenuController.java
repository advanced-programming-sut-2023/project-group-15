package org.example.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



import org.example.model.User;
import org.example.model.enums.SecurityQuestion;
import org.example.model.enums.Slogans;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupMenuController extends MainMenuController{
    public SignupMenuOutput signupUserCheck() {
        SignupMenuOutput status;
        if ((status = usernameCheck())!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
            return status;
        if ((status = emailCheck(this.getEmail()))!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
            return status;
        if ((status = passwordCheck(this.getPassword()))!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
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

    public SignupMenuOutput usernameCheck() {
        if (this.getUsername() == null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (this.getUsername().matches("^\\w+$")) {
            for (User user:User.allUsers) {
                if (user.getUsername().equals(this.getUsername())) {
                    return SignupMenuOutput.USERNAME_EXISTS;
                }
            }
            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
        }
        return SignupMenuOutput.INVALID_USERNAME_FORMAT;
    }


    public static SignupMenuOutput passwordCheck(String password) {
        if (password==null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (password.length()>=6) {
            if (password.matches("[a-z]+")) {
                if (password.matches("[A-Z]+")) {
                    if (password.matches("\\d+")) {
                        if (password.matches("[',!;?$^:\\\\/`|~&\" @#%*{}()\\[\\]<>_+.\\s=-]")) {
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

    public static SignupMenuOutput emailCheck(String email) {
        if (email==null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (email.matches("[\\w.]+@[\\w.]+\\.[\\w.]+")) {
            for (User user: User.allUsers) {
                if (user.getEmail().equals(email))
                    return SignupMenuOutput.DUPLICATE_EMAIL_ERROR;
            }
            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
        }
        return SignupMenuOutput.INVALID_EMAIL_FORMAT;
    }

    public String generateRandomSlogan() {
        //TODO: uncompleted method!
        return null;
    }

    public String generateRandomPassword() {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}]).{8,20}$";
        String charSet = "";
        charSet += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        charSet += "abcdefghijklmnopqrstuvwxyz";
        charSet += "1234567890";
        charSet += "!@#$%^&*()_+{}";
        Matcher matcher;
        char[] password = new char[8];
        Random random = new Random();
        while(true){
            for (int i = 0; i < 8; i++) {
                password[i] = charSet.toCharArray()[random.nextInt(charSet.length() - 1)];
            }
            matcher = getMatcher(charSet,regex);
            if(matcher != null) {
                System.out.println(Arrays.toString(password));
                return Arrays.toString(password);
            }
        }
    }
    public boolean pickSecurityQuestion(String numOfQuestion) {
        //for on all questions!
        //TODO: uncompleted method!
        return false;
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
    public SignupMenuOutput suggestingUsername() {

        return null;
    }
    public boolean randomPasswordVerification(String verification) {
        return verification.equals(this.getClipBoard());
    }
    public static String getPassHashSha256(String password, byte[] salt) {

        String passwordString = null;
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            messagedigest.update(salt);
            byte[] bytes = messagedigest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            //System.out.println(bytes);
            for (byte aByte : bytes) {
                //convert to HEX;
                //System.out.print(bytes[i]+" ");
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
                //System.out.println(sb);
            }
            passwordString = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return passwordString;
    }

    private static byte[] makeSalt()  {
        return new byte[16];
    }


    public void signingsComplete() {
        byte[] salt = makeSalt();
        String passHash = getPassHashSha256(this.getPassword() , salt);
        User newUser = new User(this.getUsername(), passHash, this.getNickname(), this.getEmail());
        if (this.getSlogan()!=null) {
            newUser.setSlogan(this.getSlogan());
        }
        GameDataBase.addUser(newUser);
        GameDataBase.setJasonFile(newUser);
        newUser.addUser();
    }
    private Matcher getMatcher(String password, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(password);
        return matcher.matches() ? matcher : null ;
    }

}

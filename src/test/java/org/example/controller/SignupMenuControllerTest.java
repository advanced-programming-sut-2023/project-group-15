package org.example.controller;


import org.example.controller.userControllers.SignupMenuController;
import org.example.model.User;
import org.example.model.enums.Slogans;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
class SignupMenuControllerTest {
    @InjectMocks
    SignupMenuController controller;
    @Test
    void signupUserCheckTests() {
        SignupMenuOutput status = SignupMenuController.emailCheck("mahdi@.com");
        Assertions.assertNotEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,status);
        controller.setNickname("");
        status = controller.nicknameCheck();
        Assertions.assertNotEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,status);
        status = SignupMenuController.emailCheck("abc@xyz.com");
        controller.setNickname("mahdi");
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,status);
    }

    @Test
    void sloganCheckTests() {
        controller.setSlogan("");
        controller.setSlogan("sloganTest");
    }

    @Test
    void usernameCheckErrorsTests() {
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.usernameCheckErrors("mahdi"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.usernameCheckErrors("mahdiAK"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.usernameCheckErrors("mahdi123"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.usernameCheckErrors("mahdiAK123"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.usernameCheckErrors("mahdi_"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.usernameCheckErrors("mahdi_12"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.usernameCheckErrors("mahdi_AK"));
        Assertions.assertEquals(SignupMenuOutput.EMPTY_FIELD,SignupMenuController.usernameCheckErrors(""));
        Assertions.assertEquals(SignupMenuOutput.INVALID_USERNAME_FORMAT,SignupMenuController.usernameCheckErrors("mahdi@"));
        Assertions.assertEquals(SignupMenuOutput.INVALID_USERNAME_FORMAT,SignupMenuController.usernameCheckErrors("AAAA!"));
        Assertions.assertEquals(SignupMenuOutput.INVALID_USERNAME_FORMAT,SignupMenuController.usernameCheckErrors("1234#"));
        Assertions.assertEquals(SignupMenuOutput.INVALID_USERNAME_FORMAT,SignupMenuController.usernameCheckErrors("mahdi-ak"));
        new User("mahdi","Ma123@","nickname","mahdi@gmail.com");
        Assertions.assertEquals(SignupMenuOutput.USERNAME_EXISTS,SignupMenuController.usernameCheckErrors("mahdi"));
    }

    @Test
    void passwordCheckErrorsTests() {
        Assertions.assertEquals(SignupMenuOutput.EMPTY_FIELD,SignupMenuController.passwordCheckErrors(""));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_NO_CAPITAL_CHARACTER,SignupMenuController.passwordCheckErrors("amirhossein"));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_NO_DIGITS,SignupMenuController.passwordCheckErrors("mahdiAK"));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_NO_SMALL_CHARACTER,SignupMenuController.passwordCheckErrors("MAHDI123"));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_NO_SPECIAL_CHARACTER,SignupMenuController.passwordCheckErrors("mahdiAK123"));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_IS_TOO_SHORT,SignupMenuController.passwordCheckErrors("mA1@"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.passwordCheckErrors("mahdiAK123@"));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_NO_SMALL_CHARACTER,SignupMenuController.passwordCheckErrors("222222"));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_NO_CAPITAL_CHARACTER,SignupMenuController.passwordCheckErrors("aaaa111111"));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_NO_SPECIAL_CHARACTER,SignupMenuController.passwordCheckErrors("123423aaaaA"));
        Assertions.assertEquals(SignupMenuOutput.ERROR_PASSWORD_IS_TOO_SHORT,SignupMenuController.passwordCheckErrors("Ma2a"));
    }

    @Test
    void checkPasswordWithConfigurationTests() {
        controller.setPassword("mahdiAK123@");
        controller.setClipBoard("mahdiAK123@");
        Assertions.assertTrue(controller.checkPasswordWithConfiguration());
        controller.setPassword("ali@AX123");
        controller.setClipBoard("ali@aX123");
        Assertions.assertFalse(controller.checkPasswordWithConfiguration());
    }

    @Test
    void emailCheckTests() {
        new User("ali","aliAl123@","ali ali","mahdi@gmail.com");
        Assertions.assertEquals(SignupMenuOutput.DUPLICATE_EMAIL_ERROR,SignupMenuController.emailCheck("mahdi@gmail.com"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.emailCheck("mahdi@a.com"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.emailCheck("ma.h.d.i@gmail.com"));
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,SignupMenuController.emailCheck("mah.di@g.mail.com"));
        Assertions.assertEquals(SignupMenuOutput.EMPTY_FIELD,SignupMenuController.emailCheck(""));
        Assertions.assertEquals(SignupMenuOutput.INVALID_EMAIL_FORMAT,SignupMenuController.emailCheck("mahdi@gmailcom"));
        Assertions.assertEquals(SignupMenuOutput.INVALID_EMAIL_FORMAT,SignupMenuController.emailCheck("mahdi@.gmailcom"));
        Assertions.assertEquals(SignupMenuOutput.INVALID_EMAIL_FORMAT,SignupMenuController.emailCheck("mahdigmail.com"));
        Assertions.assertEquals(SignupMenuOutput.INVALID_EMAIL_FORMAT,SignupMenuController.emailCheck("mahdigmailcom"));
        Assertions.assertEquals(SignupMenuOutput.INVALID_EMAIL_FORMAT,SignupMenuController.emailCheck("mahdi.gmail@com"));
    }

    @Test
    void nicknameCheckTests() {
        controller.setNickname("");
        Assertions.assertEquals(SignupMenuOutput.EMPTY_FIELD,controller.nicknameCheck());
        controller.setNickname("nickname");
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,controller.nicknameCheck());
    }

    @Test
    void selectSloganTests() {
        controller.setSlogan(Slogans.getAllSlogans().get(1).getSlogan());
        Assertions.assertEquals(Slogans.SLOGAN2.getSlogan(),controller.getSlogan());
        controller.setSlogan(Slogans.getAllSlogans().get(7).getSlogan());
        Assertions.assertNotEquals(Slogans.SLOGAN7.getSlogan(),controller.getSlogan());
    }
    @Test
    void generateRandomPasswordTests() {
        String test = controller.generateRandomPassword();
        Assertions.assertTrue(test.length()>=6);
        Assertions.assertTrue(test.matches(SignupMenuEnum.SMALL_CHAR.getRegex()));
        Assertions.assertTrue(test.matches(SignupMenuEnum.CAPITAL_CHAR.getRegex()));
        Assertions.assertTrue(test.matches(SignupMenuEnum.DIGITS.getRegex()));
        Assertions.assertTrue(test.matches(SignupMenuEnum.SPECIAL_CHAR.getRegex()));
    }

    @Test
    void pickSecurityQuestionTests() {
        Matcher matcher = getMatcherForTest("question pick -a answer -c answer2 -q 2",SignupMenuEnum.PICK_QUESTION.getRegex());
        Assertions.assertEquals(SignupMenuOutput.ANSWERS_ARE_NOT_EQUAL,controller.pickSecurityQuestion(matcher));
        matcher = getMatcherForTest("question pick -a answer -c answer2 -q 23",SignupMenuEnum.PICK_QUESTION.getRegex());
        Assertions.assertEquals(SignupMenuOutput.INVALID_COMMAND,controller.pickSecurityQuestion(matcher));
        matcher = getMatcherForTest("question pick -a answer -c answer -q 2",SignupMenuEnum.PICK_QUESTION.getRegex());
        Assertions.assertEquals(SignupMenuOutput.CHECKED_SUCCESSFULLY,controller.pickSecurityQuestion(matcher));
    }

    @Test
    void usernameSuggestionGeneratorTests() {
        String name = "mahdi";
        controller.setUsername("mahdi");
        controller.usernameSuggestionGenerator();
        Assertions.assertTrue(controller.getUsername().matches(".*"+name+".*"));
    }

    @Test
    void randomPasswordVerificationTests() {
        controller.setPassword("MahdiAk123@");
        controller.setClipBoard("MahdiAk123@");
        Assertions.assertTrue(controller.checkPasswordWithConfiguration());
        controller.setClipBoard("Mahdiak123@");
        Assertions.assertFalse(controller.checkPasswordWithConfiguration());
    }

    @Test
    void signingsCompleteTests() {
        controller.setUsername("test user");
        controller.setPassword("test@1PASS");
        controller.setNickname("test nickname");
        controller.setEmail("test@email.com");
        controller.setSlogan("this is a test!");
        User user = new User("test user","test@1PASS","test nickname","test@email.com","this is a test!");
        controller.signingsComplete();
        Assertions.assertTrue(GameDataBase.getAllUsers().contains(user));
    }

    @Test
    void changeForgetPasswordTests() {
        User user = new User("mahdi","mahdiAK123@","nickname","mahdi@gmail.com");
        controller.setUsername("mahdi");
        controller.setPassword("mahdi123@AK");
        controller.changeForgetPassword();
        System.out.println(user.getPassword());
        Assertions.assertNotEquals("mahdi123@AK",user.getPassword());
        Assertions.assertEquals("mahdiAK123@",user.getPassword());
    }
    private static Matcher getMatcherForTest(String password, String regex) {
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(password);
        return matcher.matches() ? matcher : null;
    }
}
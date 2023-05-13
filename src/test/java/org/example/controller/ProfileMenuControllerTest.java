package org.example.controller;

import org.example.model.User;
import org.example.view.enums.outputs.ProfileMenuOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/*@ExtendWith(MockitoExtension.class)
class ProfileMenuControllerTest {
    @InjectMocks ProfileMenuController controller;
    @AfterEach
    void cleaningController() {
        controller.setUsername("");
        controller.setPassword("");
        controller.setNickname("");
        controller.setSlogan("");
        controller.setEmail("");
    }
    @Test
    void changeUsernameTests() {
        User userTest = new User("ali","aliAl123@","nickname","ali@ali.com");
        String test = "amin";
        controller.setUsername("ali");
        Assertions.assertEquals(ProfileMenuOutput.INVALID_NEW_USERNAME,controller.changeUsername("....."));
        Assertions.assertEquals(ProfileMenuOutput.USERNAME_CHANGED_SUCCESSFULLY,controller.changeUsername(test));
        Assertions.assertNotEquals("ali",userTest.getUsername());
    }

    @Test
    void changeNicknameTests() {
        User testUser = new User("ali","aliAl123@","nickname","ali@ali.com");
        String test = "test nickname";
        controller.setPassword("aliAl123@");
        controller.setNickname("nickname");
        Assertions.assertEquals(ProfileMenuOutput.NICKNAME_CHANGED_SUCCESSFULLY,controller.changeNickname(test));
    }
    @Test
    void changePasswordTests() {
        String newPassTest = "newPass123@";
        User test = new User("test","test123@TEST","testNickname","test@email.com");
        controller.setPassword("test123@TEST");
        assertEquals(ProfileMenuOutput.INVALID_CURRENT_PASSWORD,controller.changePassword("test123@TESt",newPassTest));
        assertEquals(ProfileMenuOutput.INVALID_NEW_PASSWORD,controller.changePassword(test.getPassword(),"testA!"));
        assertEquals(ProfileMenuOutput.NEWPASS_AND_OLDPASS_ARE_EQUALS,controller.changePassword(test.getPassword(),test.getPassword()));
        assertEquals(ProfileMenuOutput.PASSWORD_CHANGED_SUCCESSFULLY,controller.changePassword(test.getPassword(),"TestNew@123"));
    }

    @Test
    void changeEmailTests() {
        User test = new User("test","test123@TEST","testNickname","test@gmail.com");
        controller.setEmail("test@gmail.com");
        controller.setPassword("test123@TEST");
        assertEquals(ProfileMenuOutput.EMAIL_CHANGED_SUCCESSFULLY,controller.changeEmail("another@test.com"));
        assertEquals(ProfileMenuOutput.INVALID_NEW_EMAIL,controller.changeEmail("anotherTest.com"));
    }

    @Test
    void changeSloganTests() {
        User test = new User("test","test123@TEST","testNickname","test@gmail.com","say my name!");
        controller.setSlogan("say my name!");
        controller.setPassword("test123@TEST");
        assertEquals(ProfileMenuOutput.SLOGAN_CHANGED_SUCCESSFULLY,controller.changeSlogan("you're goddamn right!"));
        assertNotEquals("say my name!",test.getSlogan());
    }

    @Test
    void removeSloganTests() {
        User test = new User("test","test123@TEST","testNickname","test@gmail.com","say my name!");
        controller.setSlogan("say my name!");
        controller.setPassword("test123@TEST");
        assertEquals(ProfileMenuOutput.SLOGAN_REMOVED_SUCCESSFULLY,controller.removeSlogan());
        assertNull(controller.getSlogan());
    }

    @Test
    void showUserHighestScoreTESTS() {
    }

    @Test
    void showUserRankTESTS() {
    }

    @Test
    void showUserProfileDisplay() {

    }
}*/
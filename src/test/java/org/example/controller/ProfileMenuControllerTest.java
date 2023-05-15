package org.example.controller;

import org.example.controller.userControllers.ProfileMenuController;
import org.example.model.User;
import org.example.view.enums.outputs.ProfileMenuOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProfileMenuControllerTest {
    @InjectMocks
    ProfileMenuController profileMenuController;
    @AfterEach
    void cleaningController() {
        profileMenuController.setUsername("amin");
        profileMenuController.setPassword("");
        profileMenuController.setNickname("");
        profileMenuController.setSlogan("");
        profileMenuController.setEmail("");
    }
    @Test
    void changeUsernameTests() {
        User userTest = new User("ali","aliAl123@","nickname","ali@ali.com");
        String test = "amin";
        profileMenuController.setUsername("ali");
        Assertions.assertEquals(ProfileMenuOutput.INVALID_NEW_USERNAME, profileMenuController.changeUsername("....."));
        Assertions.assertEquals(ProfileMenuOutput.USERNAME_CHANGED_SUCCESSFULLY, profileMenuController.changeUsername(test));
        Assertions.assertNotEquals("ali",userTest.getUsername());
    }

    @Test
    void changeNicknameTests() {
        User testUser = new User("ali","aliAl123@","nickname","ali@ali.com");
        String test = "test nickname";
        profileMenuController.setPassword("aliAl123@");
        profileMenuController.setNickname("nickname");
        Assertions.assertEquals(ProfileMenuOutput.NICKNAME_CHANGED_SUCCESSFULLY, profileMenuController.changeNickname(test));
    }
    @Test
    void changePasswordTests() {
        String newPassTest = "newPass123@";
        User test = new User("test","test123@TEST","testNickname","test@email.com");
        profileMenuController.setPassword("test123@TEST");
        assertEquals(ProfileMenuOutput.INVALID_CURRENT_PASSWORD, profileMenuController.changePassword("test123@TESt",newPassTest));
        assertEquals(ProfileMenuOutput.INVALID_NEW_PASSWORD, profileMenuController.changePassword(test.getPassword(),"testA!"));
        assertEquals(ProfileMenuOutput.NEWPASS_AND_OLDPASS_ARE_EQUALS, profileMenuController.changePassword(test.getPassword(),test.getPassword()));
        assertEquals(ProfileMenuOutput.PASSWORD_CHANGED_SUCCESSFULLY, profileMenuController.changePassword(test.getPassword(),"TestNew@123"));
    }

    @Test
    void changeEmailTests() {
        User test = new User("test","test123@TEST","testNickname","test@gmail.com");
        profileMenuController.setEmail("test@gmail.com");
        profileMenuController.setPassword("test123@TEST");
        assertEquals(ProfileMenuOutput.EMAIL_CHANGED_SUCCESSFULLY, profileMenuController.changeEmail("another@test.com"));
        assertEquals(ProfileMenuOutput.INVALID_NEW_EMAIL, profileMenuController.changeEmail("anotherTest.com"));
    }

    @Test
    void changeSloganTests() {
        User test = new User("test","test123@TEST","testNickname","test@gmail.com","say my name!");
        profileMenuController.setSlogan("say my name!");
        profileMenuController.setPassword("test123@TEST");
        assertEquals(ProfileMenuOutput.SLOGAN_CHANGED_SUCCESSFULLY, profileMenuController.changeSlogan("you're goddamn right!"));
        assertNotEquals("say my name!",test.getSlogan());
    }

    @Test
    void removeSloganTests() {
        User test = new User("test","test123@TEST","testNickname","test@gmail.com","say my name!");
        profileMenuController.setSlogan("say my name!");
        profileMenuController.setPassword("test123@TEST");
        assertEquals(ProfileMenuOutput.SLOGAN_REMOVED_SUCCESSFULLY, profileMenuController.removeSlogan());
        assertNull(profileMenuController.getSlogan());
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
}
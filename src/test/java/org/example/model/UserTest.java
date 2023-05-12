package org.example.model;

import org.example.model.gameData.GameDataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserTest {
    @Test
    public void getterAndSetterTests() {
        User user1 = new User("","","","","");
        Assertions.assertTrue(GameDataBase.getAllUsers().contains(user1));
        user1.setUsername("arturMorgan");
        user1.setPassword("redDead2Redemption@$");
        user1.setNickname("you are goddamn right!");
        user1.setEmail("rockstar@gmail.com");
        user1.setSlogan("say my name!");
        User temp = new User("arturMorgan","redDead2Redemption@$","you are goddamn right!","rockstar@gmail.com","say my name!");
        Assertions.assertEquals(temp,user1);
        Assertions.assertEquals(user1,User.findUserWithPass("redDead2Redemption@$"));
        User user2 = new User("mahdiXak96","Ma123@","mahdi","mahdi@gmail.com","never give up!");
        Assertions.assertEquals("mahdiXak96",user2.getUsername());
        Assertions.assertEquals("Ma123@",user2.getPassword());
        Assertions.assertEquals("mahdi",user2.getNickname());
        Assertions.assertEquals("mahdi@gmail.com",user2.getEmail());
        Assertions.assertEquals("never give up!",user2.getSlogan());
    }

}
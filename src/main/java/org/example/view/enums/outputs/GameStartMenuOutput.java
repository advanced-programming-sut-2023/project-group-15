//this is class is completed!
package org.example.view.enums.outputs;

public enum GameStartMenuOutput {
    ADD_USER_SUCCESS("user added successfully"),
    ADD_USER_FORBIDDEN("you are not owner of a game"),
    USER_NOT_FOUND("could not find the user please try again"),
    PLAYER_CAPACITY_IS_FULL("player capacity is full!\nyou can't add player!"),
    GAME_IS_NOT_STARTED("You haven't started the game yet!\nfirst start the game!"),
    USER_HAS_STARTED_GAME("you already started a game before!\ncan't start new game!"),
    GAME_STARTED_SUCCESSFULLY("game started successfully!"),
    User_DOESNT_EXIST("the user you have chosen doesn't exist"),
    PLAYER_IN_THE_GAME("the player in already in the game"),
    NOT_YOUR_TURN("it's not your turn to play!");
    private final String output;

    GameStartMenuOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

}

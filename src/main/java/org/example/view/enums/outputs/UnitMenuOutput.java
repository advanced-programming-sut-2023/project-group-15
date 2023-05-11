package org.example.view.enums.outputs;

public enum UnitMenuOutput {
    UNIT_NOT_FOUND("The soldier was not found in the coordinates...\ntry again"),
    UNIT_DO_NOT_ALLOWED_PLACE_THERE("unit don't allowed to place there!"),
    UNIT_FOUND("The soldier was chosen...\nwhat's your next step?"),
    UNIT_NOT_FOUND_AND_CANNOT_MOVE("Your request cannot be processed (there is no soldier to move)\ntry again"),
    OUT_OF_BOUNDS("Your destination is beyond the soldier's power\ntry again"),
    SUCCESSFUL_MOVE("successful move"),
    WRONG_UNIT("Choose the right unit(tunneler)!"),
    SUCCESSFUL_DIG("successful dig tunnel..."),
    WRONG_PLACE_FOR_DOG_TUNNEL("wrong place for digging tunnel"),
    WRONG_BUILDING("This building will not be destroyed!"),
    WRONG_UNIT_FOR_AIR_ATTACK("choose the right unit..."),
    SUCCESSFUL_AIR_ATTACK("successful air attack"),
    SUCCESSFUL_ATTACK("successful attack"),
    UNIT_DISBANDED("unit disbanded"),
    SUCCESSFUL_POUR_OIL("successful pour oil"),
    WRONG_UNIT_TO_POUR_OIL("choose the right unit(engineer)!"),
    SUCCESSFUL_DIG_DITCH("successful dig ditch"),
    WRONG_UNIT_TO_DIG_DITCH("choose the right unit(spearmen)!"),
    PATROL_UNIT("The unit stopped patrolling"),
    SUCCESSFUL_BUILD_TREBUCHET("successful build trebuchet"),
    SUCCESSFUL_BUILD_CATAPULTS("successful build catapults"),
    SUCCESSFUL_BUILD_SHIELD("successful build shield"),
    SUCCESSFUL_BUILD_BATTERING_RAM("successful build battering ram"),
    WRONG_UNIT_ENGINEER("choose the right unit(engineer)!"),
    CONQUERING_AND_OPENING_THE_GATE("Conquering and opening the gate"),
    CONQUERING("Conquering..."),
    ;
    private final String output;

    public String getOutput() {
        return output;
    }

    UnitMenuOutput(String output) {
        this.output = output;
    }

}

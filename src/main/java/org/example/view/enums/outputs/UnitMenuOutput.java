package org.example.view.enums.outputs;

public enum UnitMenuOutput {
    UNIT_NOT_FOUND("The soldier was not found in the coordinates...\ntry again"),
    UNIT_FOUND("The soldier was chosen...\nwhat's your next step?"),
    UNIT_NOT_FOUND_AND_CANNOT_MOVE("Your request cannot be processed (there is no soldier to move)\ntry again"),
    OUT_OF_BOUNDS("Your destination is beyond the soldier's power\ntry again"),
    SUCCESSFULL_MOVE("seccessfull move"),
    ;
    private final String output;

    public String getOutput() {
        return output;
    }

    UnitMenuOutput(String output) {
        this.output = output;
    }

}

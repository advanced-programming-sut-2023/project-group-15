//this class is completed!
package org.example.view.enums.outputs;

public enum BuildingStatusOutput {

    INVALID_COORDINATE("there in no building on this tile"),
    CHECKED_SUCCESSFULLY("ok!"),
    DROP_FORBID("drop building forbid"),
    REPAIR_FORBID("not enough source for repair"),
    NOT_SELECTED("you have no selected building to repair"),
    CAN_NOT_DROP_BUILDING("Cant drop building in this tile"),
    NOT_ENOUGH_RESOURCES("not enough resources to build this building"),
    ;

    private final String output;

    public String getOutput() {
        return output;
    }

    BuildingStatusOutput(String status) {
        this.output = status;
    }
}

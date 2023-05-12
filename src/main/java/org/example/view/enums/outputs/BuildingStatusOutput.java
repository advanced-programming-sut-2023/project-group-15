//this class is completed!
package org.example.view.enums.outputs;

public enum BuildingStatusOutput {

    INVALID_X_COORDINATE(""),
    INVALID_Y_COORDINATE(""),
    CHECKED_SUCCESSFULLY("ok!"),
    DROP_FORBID("drop building forbid"),


    ;

    private final String status;

    public String getStatus() {
        return status;
    }

    BuildingStatusOutput(String status) {
        this.status = status;
    }
}

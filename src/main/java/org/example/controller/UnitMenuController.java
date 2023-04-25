package org.example.controller;
import org.example.model.MBC.InfantryUnit;
import org.example.model.MBC.LauncherUnit;
import org.example.model.MBC.UnitWallTarget;
import org.example.model.enums.State;
import org.example.model.User;
import org.example.model.enums.UnitName;
import org.example.view.enums.outputs.UnitMenuOutput;


public class UnitMenuController {
    public LauncherUnit launcherUnit;
    public InfantryUnit infantryUnit;
    public UnitWallTarget unitWallTarget;
    public State state;
    public String type;
    public int x,y;
    public UnitName name;

    private UnitMenuOutput selectUnit(int x, int y){
        //TODO: add code to get informaion from map
       if((name = UnitName.valueOf(type)) != null){
        this.x = y;
        this.y = y;
        name = UnitName.valueOf(type);
        return UnitMenuOutput.UNIT_FOUND;
       }

       else
           return UnitMenuOutput.UNIT_NOT_FOUND;
    }

    private UnitMenuOutput moveUnit(int x,int y){
        // TODO: add code to verify type of unit
        if(selectUnit(x,y) == null)
            return UnitMenuOutput.UNIT_NOT_FOUND_AND_CANNOT_MOVE;
        else{
            int indexOfType = UnitMenuOutput.valueOf(type).ordinal();
            int deltaX = x - this.x;
            int deltaY = y - this.y;
            if(indexOfType<7)
            {
               infantryUnit.setMaxMove(name);
               int maxMove = infantryUnit.getMaxMove();
                if(deltaX > maxMove && deltaY > maxMove)
                    return UnitMenuOutput.OUT_OF_BOUNDS;

                else {
                    this.x += deltaX;
                    this.y += deltaY;
                    // TODO: add code to move unit in map
                    return UnitMenuOutput.SUCCESSFULL_MOVE;
                }
            }

            else if(indexOfType > 6 && indexOfType <= 12){
                launcherUnit.setMove(name);
                int maxMove = launcherUnit.getMaxMove();
                if(deltaX > maxMove && deltaY > maxMove)
                    return UnitMenuOutput.OUT_OF_BOUNDS;

                else {
                    this.x += deltaX;
                    this.y += deltaY;
                    // TODO: add code to move unit in map
                    return UnitMenuOutput.SUCCESSFULL_MOVE;
                }
            }

            else{
                unitWallTarget.setMaxMove(name);
                int maxMove = unitWallTarget.getMaxMove();
                if(deltaX > maxMove && deltaY > maxMove)
                    return UnitMenuOutput.OUT_OF_BOUNDS;

                else {
                    this.x += deltaX;
                    this.y += deltaY;
                    // TODO: add code to move unit in map
                    return UnitMenuOutput.SUCCESSFULL_MOVE;
                }
            }

        }
    }

    private void setUnit(int x, int y, State state){
        // TODO: add code to get unit from map

    }

    private void airAttack(int x,int y){
        // TODO: add code to select unit

    }

    private void disbandUnit(){

    }

    private void build(){

    }
}

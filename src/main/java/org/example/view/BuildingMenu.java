package org.example.view;

import org.example.InputScanner;
import org.example.controller.BuildingController;
import org.example.view.enums.commands.BuildingCommandsEnum;

import java.util.regex.Matcher;

public class BuildingMenu {
    public BuildingMenu() {
    }
    public void run()
    {
        BuildingController controller = new BuildingController();
        String command = InputScanner.getScanner().nextLine();
        Matcher matcher ;
        while (true)
        {
            if((matcher = BuildingCommandsEnum.getMatcher(command , BuildingCommandsEnum.DROP_BUILDING)) != null)
                controller.dropBuilding(matcher);
            else if((matcher = BuildingCommandsEnum.getMatcher(command , BuildingCommandsEnum.SELECT_BUILDING)) != null)
            controller.selectBuilding(Integer.parseInt(matcher.group("-x")) , Integer.parseInt(matcher.group("-y")));
            else if((matcher =  BuildingCommandsEnum.getMatcher(command , BuildingCommandsEnum.REPAIR)) != null)
                controller.repair();

        }
    }
}

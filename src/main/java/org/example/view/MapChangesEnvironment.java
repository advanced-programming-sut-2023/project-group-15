package org.example.view;

import org.example.InputScanner;
import org.example.controller.DropBuildingController;
import org.example.controller.MapMenuEnvironmentController;
import org.example.view.enums.commands.BuildingCommandsEnum;
import org.example.view.enums.commands.MapEnum;
import org.example.view.enums.outputs.BuildingStatusOutput;

import java.util.regex.Matcher;

public class MapChangesEnvironment {
    public void run()
    {
        MapMenuEnvironmentController controller = new MapMenuEnvironmentController();
        String command;
        int mapNumber;
        int mapsize;
        int playerNo = 0;
//      int playerNo = GameDataBase.getCurrentUser().getUserNO();
        Matcher matcher;
        if(playerNo== 1) {
            System.out.println("please enter the size of map that you prefer between 200 & 400");
            mapsize = InputScanner.getScanner().nextInt();
            System.out.println("now please enter the map number you want");
            mapNumber = InputScanner.getScanner().nextInt();
            switch (mapNumber)
            {
                //TODO read and set from the file
            }
            controller.generateEachPlayerMap(playerNo, mapNumber);
            //TODO the first players map would be generated hear
            System.out.println("now please enter the changes you wish to make in the map");

        }

        while(true)
        {
            command = InputScanner.getScanner().nextLine();
            if((matcher = MapEnum.getMatcher(command,MapEnum.SET_TEXTURE)) != null)
            controller.setTileTexture(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.SET_TEXTURE2)) != null)
                controller.setTexture(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.CLEAR)) != null)
                controller.clear(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.DROP_ROCK)) != null)
                controller.dropRock(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.DROP_TREE)) != null)
                controller.dropTree(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.DROP_BUILDING)) !=null)
            controller.dropBuilding(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.DROP_UNIT)) != null)
                controller.dropUnit(matcher);

        }
    }


    //testing for dropping buildings...
    private DropBuildingController buildingController = new DropBuildingController();
    public void testRun() {
        Matcher matcherTest;
        String input;
        while (true) {
            input = InputScanner.getScanner().nextLine();
            if ((matcherTest = BuildingCommandsEnum.getMatcher(input,BuildingCommandsEnum.DROP_BUILDING))!=null) {
                BuildingStatusOutput status = dropBuilding(matcherTest);
                if (status.equals(BuildingStatusOutput.CHECKED_SUCCESSFULY))
                    System.out.println("building set successfully!");
                else
                    System.out.println(status.getStatus());
            }

        }
    }

    private BuildingStatusOutput dropBuilding(Matcher matcherTest) {
        classifyController(matcherTest);
        BuildingStatusOutput status = buildingController.checkParameters();
        if (status.equals(BuildingStatusOutput.CHECKED_SUCCESSFULY)) {
            status = buildingController.checkTheLand();
            if (status.equals(BuildingStatusOutput.CHECKED_SUCCESSFULY)) {
                buildingController.SettingTheBuilding();
            }
        }
        return status;
    }


    private void classifyController(Matcher matcherTest) {
        buildingController.setType(matcherTest.group("type"));
        buildingController.setCoordinateX(matcherTest.group("x"));
        buildingController.setCoordinateY(matcherTest.group("y"));
    }
}

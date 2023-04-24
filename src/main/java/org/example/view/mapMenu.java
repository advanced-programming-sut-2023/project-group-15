package org.example.view;

import org.example.InputScanner;

import java.util.regex.Matcher;

public class mapMenu {
    private void run(Matcher matcher)
    {
        String command;
        InputScanner scanner = new InputScanner();
        command = scanner.getScanner().nextLine();
        while (true)
        {
//            if(mapMenuEnum.getMatcher(command,mapMenuEnum.SHOW_MAP) != null)
//                showMap(Integer.parseInt(matcher.group("xCoordinate"))
//                        , Integer.parseInt(matcher.group("yCoordinate")));
//



        }

        //TODO
        //
        //TODO exit
    }
    private static void showMap(int x,int y)
    {

    }

        /*TODO map should be shown 10 up down left right
        s : soldier
        SG : small gatehouse
        BG : big gatehouse
        D : drawBridge
        LT : lookoutTower
        PT : perimeter tower

/*



        return null;
    }
    private map showDetails(int x ,int y)
    {
        // TODO : only a tile should be shown
        return null;

    }
    // TODO : have a guide for map tiles

    private void changeEnvironment(int x, int y)
    {
        //should check
    }*/
}

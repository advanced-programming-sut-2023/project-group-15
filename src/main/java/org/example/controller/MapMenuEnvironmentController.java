package org.example.controller;

import org.example.model.Tile;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.gameData.Map;
import java.util.regex.Matcher;


public class MapMenuEnvironmentController {

    public void setTileTexture(Matcher matcher){
        int x = 0;
        int y =0;
        String type = new String();
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                if(matcher.group(i) == null)
                    continue;
                if (matcher.group(i).equals("x"))
                    x = Integer.parseInt(matcher.group(i + 1));
                if ((matcher.group(i).equals("y")))
                    y = Integer.parseInt(matcher.group(i+1));
                if((matcher.group(i).equals("-t")))
                    type = matcher.group(i+1);
            }
        }
            Tile currentTile = Map.findATile(x, y);
        for (LandType landType : LandType.values())
            if (landType.equals(type))
                currentTile.setLandType(landType);
    }


    public void setTexture(Matcher matcher)
    {
        String type = new String();
        int x1=0;
        int y1=0;
        int x2=0;
        int y2=0;
            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.group(i).equals("x1"))
                    x1 = Integer.parseInt(matcher.group(i + 1));
                if (matcher.group(i).equals("y1"))
                    y1 = Integer.parseInt(matcher.group(i + 1));
                if (matcher.group(i).equals("x2"))
                    x2 = Integer.parseInt(matcher.group(i + 1));
                if (matcher.group(i).equals("y2"))
                    y2 = Integer.parseInt(matcher.group(i + 1));
                if (matcher.group(i).equals("t"))
                    type = matcher.group(i + 1);
            for (int x = x1; x< x2; x++) {
                for (int y = y1; y < y2; y++) {
                    for (LandType landType : LandType.values())
                        if (landType.equals(type))
                            Map.findATile(x, y).setLandType(landType);
                }
            }
        }
    }
    public void clear(Matcher matcher ) {
        int x = 0 , y = 0 ;
            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.group(i) == null)
                    continue;
                if (matcher.group(i).equals("x"))
                    x = Integer.parseInt(matcher.group(i + 1));
                if ((matcher.group(i).equals("y")))
                    y = Integer.parseInt(matcher.group(i + 1));
        }
            Tile currentTile = Map.findATile(x, y);
            currentTile.setBuilding(null);
            currentTile.setTreeName(null);
            currentTile.setSoldier(null);
            currentTile.setRock(false, null);
    }
    public void dropUnit(Matcher matcher)
    {
        //Mobina
    }
    public void dropBuilding(Matcher matcher)
    {
        //Mahdi
    }
    public void dropTree(Matcher matcher)
    {
        int x = 0 , y = 0 ;
        String type = new String();
            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.group(i) == null)
                    continue;
                if (matcher.group(i).equals("x"))
                    x = Integer.parseInt(matcher.group(i + 1));
                if ((matcher.group(i).equals("y")))
                    y = Integer.parseInt(matcher.group(i + 1));
                if ((matcher.group(i).equals("-t")))
                    type = matcher.group(i + 1);
        }
        Tile currentTile = Map.findATile(x , y);
        for(Tree tree : Tree.values())
            if(tree.equals(type))
        currentTile.setTreeName(tree);

    }
    public void dropRock(Matcher matcher)
    {
        int x = 0 , y=0 ;
        String direction = new String();
            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.group(i) == null)
                    continue;
                if (matcher.group(i).equals("x"))
                    x = Integer.parseInt(matcher.group(i + 1));
                if ((matcher.group(i).equals("y")))
                    y = Integer.parseInt(matcher.group(i + 1));
                if ((matcher.group(i).equals("-t")))
                    direction = matcher.group(i + 1);
            }
        Tile currentTile = Map.findATile(x , y);
        currentTile.setRock(true,direction);

    }

}

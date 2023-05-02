package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MapEnum {
    //String regex = "show map" +"((( -(?<flag>(x|y))( ((?<group>\\S+)|(\"(?<group2>[^\"].+)\")))){2}";
/*    String regex2 = "show map +(( -(?<flag>(x|y))( ((?<group>\\S+)|(\"(?<group2>[^\"].+)\"))))){2}";
    String regex3 = "show map (?<flag>-(x|y))( ((?<group>\\S+)|(\"(?<group2>[^\"].+)\"))){2}";
    String regex4 = "(music|sport|book|movie)";
    String showMapRegx = "show map -(x|y) (\\d+) -(x|y) (\\d+)";
    String showMapDetRegx = "show details -(x|y) (\\d+) -(x|y) (\\d+)";
    String mapPanShowRegx = "show ((left|right) (\\d+)*(\\s+)*(up|down)(\\s+)*(\\d+)*)" +
            "|show ((up|down) (\\d+)*(\\s+)*(left|right)(\\s+)*(\\d+)*)";
    //String setTexRegx = "settexture (-(x|y) (\\d+) -(x|y) (\\d+) (-t) ([a-z]+))|((-t) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))|(-(x|y) (\\d+) (-t) ([a-z]+) -(x|y) (\\d+))";
    String setTexRegx = "settexture (-(x|y) (\\d+) -(x|y) (\\d+) (-t) ([a-z]+))" +
            "|((-t) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-t) ([a-z]+) -(x|y) (\\d+))";

    String setCellTexRegx = "settexture -(x1|y1) (\\d+) -(x2|y2) (\\d+) -t (a-z))";

    String clearCellRegx = "clear -(x|y) (\\d+) -(x|y) (\\d+)";

    //droprock -x [x] -y [y] -d [direction]
    String dropRockRegx = "droprock (-(x|y) (\\d+) -(x|y) (\\d+) (-d) ([a-z]+))" +
            "|((-d) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-d) ([a-z]+) -(x|y) (\\d+))";

    //droptree -x [x] -y [y] -t [type]
    String dropTreeRegx = "droptree  (-(x|y) (\\d+) -(x|y) (\\d+) (-t) ([a-z]+))" +
            "|((-t) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-t) ([a-z]+) -(x|y) (\\d+))";

    //dropbuilding -x [x] -y [y] -t [type]
    String dropBuildingRegx = "dropbuilding (-(x|y) (\\d+) -(x|y) (\\d+) (-t) ([a-z]+))" +
            "|((-t) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-t) ([a-z]+) -(x|y) (\\d+))";




    //trade -t [resourceType] -a [resourceAmount] -p [price] -m [message]
*/
    MAP_MOVING("map ((left|right) (\\d+)*(\\s+)*(up|down)(\\s+)*(\\d+)*)" +
                      "|map ((up|down) (\\d+)*(\\s+)*(left|right)(\\s+)*(\\d+)*)"),

   MAP_DETAILS("show details -(x|y) (\\d+) -(x|y) (\\d+)"),
    SET_TEXTURE("settexture -(x1|y1) (\\d+) -(x2|y2) (\\d+) -t (a-z))"),
    SET_TEXTURE2("settexture (-(x|y) (\\d+) -(x|y) (\\d+) (-t) ([a-z]+))" +
            "|((-t) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-t) ([a-z]+) -(x|y) (\\d+))"),
    CLEAR("clear -(x|y) (\\d+) -(x|y) (\\d+)"),
    DROP_TREE("droptree  (-(x|y) (\\d+) -(x|y) (\\d+) (-t) ([a-z]+))" +
            "|((-t) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-t) ([a-z]+) -(x|y) (\\d+))"),
    DROP_BUILDING("dropbuilding (-(x|y) (\\d+) -(x|y) (\\d+) (-t) ([a-z]+))" +
            "|((-t) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-t) ([a-z]+) -(x|y) (\\d+))"),
    DROP_ROCK("droprock (-(x|y) (\\d+) -(x|y) (\\d+) (-d) ([a-z]+))" +
            "|((-d) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-d) ([a-z]+) -(x|y) (\\d+))"),
    DROP_UNIT("dropunit (-(x|y|c) (\\d+) -(x|y|c) (\\d+) (-x|y|c) (\\d+) (-t) ([a-z]+))"+
            "|((-t) ([a-z]+) -(x|y|c) (\\d+) -(x|y|c) (\\d+) -(x|y|c) (\\d+))" +
            "|(-(x|y|c) (\\d+) (-t) ([a-z]+) -(x|y|c) (\\d+)  -(x|y|c) (\\d+))" +
            "|(-(x|y|c) (\\d+) -(x|y|c) (\\d+) (-t) ([a-z]+) -(x|y|c) (\\d+))"),

    ;
    private final String regex;

    MapEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public static Matcher getMatcher(String input, MapEnum regex) {
        Matcher matcher = Pattern.compile(regex.getRegex(), Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }

}

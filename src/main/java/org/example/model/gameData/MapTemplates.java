package org.example.model.gameData;

import org.example.model.Tile;
import org.example.model.enums.LandType;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class MapTemplates {
    Tile[][] mapTemplate1 = new Tile[200][200];
    Tile[][] mapTemplate2 = new Tile[200][200];
    Tile[][] mapTemplate3 = new Tile[400][400];
    Tile[][] mapTemplate4 = new Tile[400][400];

    public void setMapTemplate2() {
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                mapTemplate2[i][j] = new Tile();
            }
        }
        for (int i = 5; i < 15; i++) {
            for (int j = 5; j < 40; j++) {
                mapTemplate2[i][j].setLandType(LandType.RIVER);
            }
        }
        for (int i = 30; i < 60; i++) {
            for (int j = 40; j < 70; j++) {
                mapTemplate2[i][j].setLandType(LandType.BIG_POND);
            }
        }

        for (int i = 180; i < 200; i++) {
            for (int j = 180; j < 200; j++) {
                mapTemplate2[i][j].setLandType(LandType.DENSE_GRASSLAND);
            }
        }
        for(int i=180 ; i<200 ; i++)
        {
            for (int j = 180; j < 200; j++) {
                mapTemplate2[i][j].setLandType(LandType.SEA);
            }
        }
    }

    public void setMapTemplate1() {
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                mapTemplate1[i][j] = new Tile();
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                mapTemplate1[i][j].setLandType(LandType.SEA);
            }
        }
        for (int i = 11; i < 20; i++) {
            for (int j = 21; j < 35; j++) {
                mapTemplate1[i][j].setLandType(LandType.DENSE_GRASSLAND);
            }
        }

        for (int i = 60; i < 70; i++) {
            for (int j = 10; j < 15; j++) {
                mapTemplate1[i][j].setLandType(LandType.DENSE_GRASSLAND);
            }
        }
        for (int i = 100; i < 110; i++) {
            for (int j = 100; j < 120; j++)
                mapTemplate1[i][j].setLandType(LandType.RIVER);
        }
        for (int i = 140; i < 160; i++) {
            for (int j = 130; j < 150; j++) {
                mapTemplate1[i][j].setLandType(LandType.IRON);
            }
        }
    }

    public void setMapTemplate3() {
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                mapTemplate3[i][j] = new Tile();
            }
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 40; j++) {
                mapTemplate3[i][j].setLandType(LandType.SEA);
            }
        }
        for (int i = 20; i < 40; i++) {
            for (int j = 40; j < 70; j++) {
                mapTemplate3[i][j].setLandType(LandType.DENSE_GRASSLAND);
            }
        }

        for (int i = 60; i < 70; i++) {
            for (int j = 10; j < 15; j++) {
                mapTemplate1[i][j].setLandType(LandType.DENSE_GRASSLAND);
            }
        }
        for (int i = 100; i < 110; i++) {
            for (int j = 100; j < 120; j++) {
                mapTemplate3[i][j].setLandType(LandType.RIVER);
            }
        }
        for (int i = 240; i < 300; i++) {
            for (int j = 130; j < 150; j++) {
                mapTemplate3[i][j].setLandType(LandType.IRON);
            }
        }
    }

    public void setMapTemplate4() {
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                mapTemplate4[i][j] = new Tile();
            }
        }
        for (int i = 5; i < 15; i++) {
            for (int j = 5; j < 40; j++)
                mapTemplate4[i][j].setLandType(LandType.RIVER);
        }
        for (int i = 30; i < 60; i++) {
            for (int j = 40; j < 70; j++) {
                mapTemplate4[i][j].setLandType(LandType.BIG_POND);
            }
        }

        for (int i = 180; i < 200; i++) {
            for (int j = 180; j < 200; j++) {
                mapTemplate4[i][j].setLandType(LandType.GRASS);
            }
            for (int j = 180; j < 200; j++) {
                mapTemplate4[i][j].setLandType(LandType.SEA);
            }
        }
        for (int i = 300; i < 320; i++) {
            for (int j = 300; j < 330; j++) {
                mapTemplate4[i][j].setLandType(LandType.DENSE_GRASSLAND);
            }
        }
    }

    public void setJasonFile1() {


        JSONObject obj = new JSONObject();

        String path = "d:/json/defaultMap1.json";
        File dir = new File("d:/json/");
        dir.mkdirs();

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {

            for (int i = 0; i < mapTemplate1.length; i++) {
                for (int j = 0; j < mapTemplate1.length; j++) {
                    obj.put("Land: ", mapTemplate1[i][j].getLandType() +
                            " bulding: " + mapTemplate1[i][j].getBuilding() +
                            " Tree: " + mapTemplate1[i][j].getTree() +
                            " Soldier: " + mapTemplate1[i][j].getSoldier() +
                            " numberOfSoldiers: " + mapTemplate1[i][j].getNumberOfSoldiers() +
                            " Rock:" + mapTemplate1[i][j].isRock() +
                            " Rockdirection " + mapTemplate1[i][j].getRockDirection());

                    out.write(obj.toString());
                    out.write("\n");
                }
            }
            out.write(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJasonFile2() {


        JSONObject obj = new JSONObject();

        String path = "d:/json/defaultMap2.json";
        File dir = new File("d:/json/");
        dir.mkdirs();

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {

            for (int i = 0; i < mapTemplate2.length; i++) {
                for (int j = 0; j < mapTemplate2.length; j++) {
                    obj.put("Land: ", mapTemplate2[i][j].getLandType() +
                            " bulding: " + mapTemplate2[i][j].getBuilding() +
                            " Tree: " + mapTemplate2[i][j].getTree() +
                            " Soldier: " + mapTemplate2[i][j].getTree() +
                            " numberOfSoldiers: " + mapTemplate2[i][j].getNumberOfSoldiers() +
                            " Rock" + mapTemplate2[i][j].isRock() +
                            " Rockdirection " + mapTemplate2[i][j].getRockDirection());

                    out.write(obj.toString());
                    out.write("\n");
                }
            }
            out.write(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJasonFile3() {


        JSONObject obj = new JSONObject();

        String path = "d:/json/defaultMap3.json";
        File dir = new File("d:/json/");
        dir.mkdirs();

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {

            for (int i = 0; i < mapTemplate3.length; i++) {
                for (int j = 0; j < mapTemplate3.length; j++) {
                    obj.put("Land: ", mapTemplate3[i][j].getLandType() +
                            " bulding: " + mapTemplate3[i][j].getBuilding() +
                            " Tree: " + mapTemplate3[i][j].getTree() +
                            " Soldier: " + mapTemplate3[i][j].getTree() +
                            " numberOfSoldiers: " + mapTemplate3[i][j].getNumberOfSoldiers() +
                            " Rock" + mapTemplate3[i][j].isRock() +
                            " Rockdirection " + mapTemplate3[i][j].getRockDirection());

                    out.write(obj.toString());
                    out.write("\n");
                }
            }
            out.write(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJasonFile4() {


        JSONObject obj = new JSONObject();

        String path = "d:/json/defaultMap4.json";
        File dir = new File("d:/json/");
        dir.mkdirs();

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {

            for (int i = 0; i < mapTemplate4.length; i++) {
                for (int j = 0; j < mapTemplate4.length; j++) {
                    obj.put("Land: ", mapTemplate4[i][j].getLandType() +
                            " bulding: " + mapTemplate4[i][j].getBuilding() +
                            " Tree: " + mapTemplate4[i][j].getTree() +
                            " Soldier: " + mapTemplate4[i][j].getTree() +
                            " numberOfSoldiers: " + mapTemplate4[i][j].getNumberOfSoldiers() +
                            " Rock" + mapTemplate4[i][j].isRock() +
                            " Rockdirection " + mapTemplate4[i][j].getRockDirection());

                    out.write(obj.toString());
                    out.write("\n");
                }
            }
            out.write(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO : user should be able to choose between maps in the first of the game

    }
}

package org.example;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Random;

public class Utility {
    public static String[] captchaStringGen() {
        String alphabet = "ABCDEFGHIJKMLNPQRSTUVWXYZabcdefghijklmnpqrstuvwxyz0123456789";
        StringBuilder captchaStr = new StringBuilder();
        StringBuilder captcha = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            char c = alphabet.charAt(rand.nextInt(alphabet.length()));
            captchaStr.append(c);
            captcha.append(c);
        }
        String[] arr = new String[2];
        arr[0] = String.valueOf(captchaStr);
        arr[1] = String.valueOf(captcha);
        return arr;
    }

    public static Node displacementMap(String captcha) {
        int w = 120;
        int h = 100;
        FloatMap map = new FloatMap();
        map.setWidth(w);
        map.setHeight(h);
        System.out.println(captcha);
        for (int i = 0; i < w; i++) {
            double v = (Math.sin(i / 20.0 * Math.PI) - 0.2) / 8.0;
            for (int j = 0; j < h; j++) {
                map.setSamples(i, j, 0.0f, (float) v);
            }
        }
        Group g = new Group();
        DisplacementMap dm = new DisplacementMap();
        dm.getScaleX();
        dm.setMapData(map);
        Text t = new Text();
        t.setX(100.0f);
        t.setY(80.0f);
        t.setText(captcha);
        t.setFill(Color.RED);
        t.setFont(Font.font(null, FontWeight.BOLD, 36));
        g.getChildren().add(t);
        g.setTranslateX(-30);
        g.setTranslateY(60);
        return g;
    }
}

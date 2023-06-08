//this class is completed!
package org.example.model.enums;

import java.util.ArrayList;

public enum Slogans {

    SLOGAN1("Build. Defend. Conquer.", 1),
    SLOGAN2("Create Your Own Kingdom and Conquer the World.", 2),
    SLOGAN3("The desert is a cruel place to fight mi'lord, are you sure you have the heart for it?", 3),
    SLOGAN4("Prepare for battle! My banner will fly atop your keep before this day is out.", 4),
    SLOGAN5("Raise Your Siege Skills and Crush Your Enemy.", 5),
    SLOGAN6("Prepare for battle! My banner will fly atop your keep before this day is out.", 6),
    ;
    static final ArrayList<Slogans> allSlogans = new ArrayList<>();

    static {
        allSlogans.add(SLOGAN1);
        allSlogans.add(SLOGAN2);
        allSlogans.add(SLOGAN3);
        allSlogans.add(SLOGAN4);
        allSlogans.add(SLOGAN5);
        allSlogans.add(SLOGAN6);

    }

    public static ArrayList<Slogans> getAllSlogans() {
        return allSlogans;
    }

    public int getIndex() {
        return index;
    }

    private final String slogan;
    private final int index;

    public String getSlogan() {
        return slogan;
    }
    public static void slogans() {
        System.out.println("1." + Slogans.SLOGAN1.getSlogan());
        System.out.println("2." + Slogans.SLOGAN2.getSlogan());
        System.out.println("3." + Slogans.SLOGAN3.getSlogan());
        System.out.println("4." + Slogans.SLOGAN4.getSlogan());
        System.out.println("5." + Slogans.SLOGAN5.getSlogan());
        System.out.println("6." + Slogans.SLOGAN6.getSlogan());

    }


    Slogans(String slogan, int index) {
        this.slogan = slogan;
        this.index = index;
    }
}

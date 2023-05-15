//this class is completed!
package org.example.model.enums;

import java.util.ArrayList;

public enum Slogans {

    SLOGAN1("NO!!! YOU WILL NOT COMMAND ME AS YOUR SERVANT!!", 1),
    SLOGAN2("My Victory is at hand! The desert will run with bloooood, before this day is out.", 2),
    SLOGAN3("The desert is a cruel place to fight mi'lord, are you sure you have the heart for it?", 3),
    SLOGAN4("Prepare for battle! My banner will fly atop your keep before this day is out.", 4),
    SLOGAN5("Lets have 'em!!", 5),
    SLOGAN6("Grab a shovel lads.", 6),
    SLOGAN7("Let me guess: Digging.", 7),
    SLOGAN8("Yes?", 8),
    SLOGAN9("Salaam", 9),
    SLOGAN10("Oh....half rations.", 10),
    SLOGAN11("This is too easy.", 11),
    ;
    static final ArrayList<Slogans> allSlogans = new ArrayList<>();

    static {
        allSlogans.add(SLOGAN1);
        allSlogans.add(SLOGAN2);
        allSlogans.add(SLOGAN3);
        allSlogans.add(SLOGAN4);
        allSlogans.add(SLOGAN5);
        allSlogans.add(SLOGAN6);
        allSlogans.add(SLOGAN7);
        allSlogans.add(SLOGAN8);
        allSlogans.add(SLOGAN9);
        allSlogans.add(SLOGAN10);
        allSlogans.add(SLOGAN11);
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
        System.out.println("7." + Slogans.SLOGAN7.getSlogan());
        System.out.println("8." + Slogans.SLOGAN8.getSlogan());
        System.out.println("9." + Slogans.SLOGAN9.getSlogan());
        System.out.println("10." + Slogans.SLOGAN10.getSlogan());
        System.out.println("11." + Slogans.SLOGAN11.getSlogan());
    }

    Slogans(String slogan, int index) {
        this.slogan = slogan;
        this.index = index;
    }
}

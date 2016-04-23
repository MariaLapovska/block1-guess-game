package com.github.lapovska.guess_game;

/**
 * Created by Asus on 23.04.2016.
 */

public class View {
    // Text's constants
    public static final String GREETING_DATA = "Dear user, welcome to the more-less game!";
    public static final String INPUT_INT_DATA = "Input INT value from %d to %d: %n";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input!";
    public static final String OUT_OF_RANGE_DATA = "Input is out of range!";
    public static final String LESS_DATA = "This number is less then mine.";
    public static final String BIGGER_DATA = "This number is bigger then mine.";
    public static final String EQUALS_DATA = "You won! This number equals mine.";
    public static final String STATS_DATA = "Here are all of your inputs: ";
    public static final String END_DATA = "Bye!";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageAndRange(String message, int min, int max) {
        System.out.printf(message, min, max);
    }
}

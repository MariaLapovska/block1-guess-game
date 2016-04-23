package com.github.lapovska.guess_game;

import java.util.Scanner;

/**
 * Created by Asus on 23.04.2016.
 */

public class Controller {
    // Constructor
    Model model;
    View view;
    StringBuilder stats;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
        stats = new StringBuilder();
    }

    // The Work method
    public void processUser(){
        int min = 0;
        int max = 100;
        int num = model.rand(min, max);
        int guess = 0;

        view.printMessage(view.GREETING_DATA);

        while (true) {
            Scanner sc = new Scanner(System.in);
            view.printMessageAndRange(view.INPUT_INT_DATA, min, max);
            guess = inputIntValueWithScanner(sc, min, max);

            stats.append(String.valueOf(guess));
            stats.append("\n");

            if ((guess < min) || (guess > max)) {
                view.printMessage(view.OUT_OF_RANGE_DATA);
            } else if (guess < num) {
                view.printMessage(view.LESS_DATA);
                min = guess;
            } else if (guess > num) {
                view.printMessage(view.BIGGER_DATA);
                max = guess;
            } else {
                view.printMessage(view.EQUALS_DATA);
                view.printMessage(view.STATS_DATA);

                //Output all guesses
                view.printMessage(stats.toString());
                view.printMessage(view.END_DATA);
                break;
            }
        }
    }

    // The Utility methods
    public int inputIntValueWithScanner(Scanner sc, int min, int max) {
        while (!sc.hasNextInt()) {
            stats.append(sc.next());
            stats.append("\n");

            view.printMessage(view.WRONG_INPUT_INT_DATA);
            view.printMessageAndRange(view.INPUT_INT_DATA, min, max);
        }

        return sc.nextInt();
    }
}

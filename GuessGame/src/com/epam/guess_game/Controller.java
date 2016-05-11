package com.epam.guess_game;

import java.util.Scanner;

/**
 * Created by Asus on 23.04.2016.
 */
public class Controller {

    private static final int MIN = 0;
    private static final int MAX = 100;

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /** The Work method */
    public void processUser(){

        int guess = 0;

        try {
            model.setBoundaries(MIN, MAX);
        } catch (IndexOutOfBoundsException e) {
            view.printMessageAndRange(View.WRONG_BOUNDS_DATA, MIN, MAX);
            System.exit(1);
        }

        model.setSecretNum();

        view.printMessage(View.GREETING_DATA);

        while (true) {
            Scanner sc = new Scanner(System.in);
            view.printMessageAndRange(View.INPUT_INT_DATA, model.getLowerBoundary() + 1,
                                        model.getUpperBoundary() - 1);
            guess = inputIntValueWithScanner(sc);

            if (!checkOutOfRange(guess)) {
                int res = model.checkNum(guess);

                if (res == 1) {
                    view.printMessage(View.BIGGER_DATA);
                } else if (res == -1) {
                    view.printMessage(View.LESS_DATA);
                } else { //model.checkNum(guess) == 0
                    view.printMessage(View.EQUALS_DATA);
                    view.printMessage(View.STATS_DATA);

                    //Output statistics
                    view.printStats(model.getStats());
                    view.printMessage(view.GUESS_DATA + model.getGuessNum());
                    view.printMessage(view.END_DATA);
                    break;
                }
            } else { //guess is out of range
                view.printMessage(view.OUT_OF_RANGE_DATA);
            }
        }
    }

    // The Utility methods

    public int inputIntValueWithScanner(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_DATA);
            view.printMessageAndRange(view.INPUT_INT_DATA, model.getLowerBoundary() + 1,
                                        model.getUpperBoundary() - 1);

            sc.next();
        }

        return sc.nextInt();
    }

    /**
     * Returns boolean value that indicates whether the user's guess is out of range.
     *
     * @param guess Number guessed by user
     * @return
     * true if guess is less or equal to lower boundary, or more or equal to upper boundary,
     * false otherwise
     */
    public boolean checkOutOfRange(int guess) {
        if ((guess <= model.getLowerBoundary()) || (guess >= model.getUpperBoundary())) {
            return true;
        } else { // Number is in range
            return false;
        }
    }
}

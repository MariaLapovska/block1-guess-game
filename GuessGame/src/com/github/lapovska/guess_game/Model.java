package com.github.lapovska.guess_game;

import java.util.Random;

/**
 * Created by Asus on 23.04.2016.
 */

public class Model {
    private final static int RAND_MAX = 1000;

    // The Program logic

    /**
     * Returns a pseudo-random number between 0 and RAND_MAX, inclusive.
     *
     * @return Integer between 0 and RAND_MAX, inclusive.
     */
    public int rand() {
        Random rand = new Random();

        return rand.nextInt(RAND_MAX + 1);
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value. Must be greater than min.
     * @return Integer between min and max, inclusive.
     */
    public int rand(int min, int max) {
        Random rand = new Random();

        return rand.nextInt(max - min + 1) + min;
    }
}

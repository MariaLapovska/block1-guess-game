package com.epam.game_test;

import com.epam.guess_game.Model;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Asus on 11.05.2016.
 */
public class ModelTest {

    Model model = new Model();

    @Test
    public void testRandLower() {
        assertEquals("Check lower boundary", 1, model.randTestBoundaries(0, 100, 0.));
    }

    @Test
    public void testRandUpper() {
        assertEquals("Check upper boundary", 99, model.randTestBoundaries(0, 100, 0.99));
    }

    @Test
    public void testCheckNumLess() {
        model.setSecretNum(50);
        assertEquals("Check less", -1, model.checkNum(20));
    }

    @Test
    public void testCheckNumMore() {
        model.setSecretNum(10);
        assertEquals("Check more", 1, model.checkNum(30));
    }

    @Test
    public void testCheckNumEqual() {
        model.setSecretNum(30);
        assertEquals("Check equals", 0, model.checkNum(30));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetBoundariesException() {
        model.setBoundaries(5, 2);
    }
}
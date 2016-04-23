package com.github.lapovska.guess_game;

/**
 * Created by Asus on 23.04.2016.
 */

public class GuessGame {
    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Run
        controller.processUser();
    }
}

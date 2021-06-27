package com.tarknaiev.home_2_game;

import java.util.Scanner;

/**
 * @author ihor tarknaiev
 */
public class Controller {
    private Model model;
    private View view;

    /**
     * Constructor
     *
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Main process
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        this.StartNewgame(sc);
        view.printMessage(View.FINAL_FULL_STRING + model.GetFullStatisticData());
    }

    /**
     * New game starting
     * 
     * @param sc
     */
    public void StartNewgame(Scanner sc) {
        model.StartNewGame();
        view.printMessage(View.START_GAME_STRING);

        do {
            view.printMessage(View.INPUT_INT_DATA + "\n" + model.GetCurrentInputData());
            int newInputData = inputIntValueFromScanner(sc);
            String message = model.CheckNewData(newInputData);
            view.printMessage(message);
        } while (!model.IsFinished());

        view.printMessage(View.FINAL_GAME_STRING + model.GetGameStatisticData());

        view.printMessage(View.START_NEW_GAME_STRING);
        String newGame = inputStringValueFromScanner(sc);
        if (newGame.equals("y")) {
            this.StartNewgame(sc);
        }
    }

    /**
     * Waiting for input int data
     *
     * @param sc
     * @return int
     */
    public int inputIntValueFromScanner(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * Waiting for input string data
     * 
     * @param sc
     * @return string
     */
    public String inputStringValueFromScanner(Scanner sc) {
        while (!sc.hasNext()) {
            view.printMessage(View.NEW_GAME_WRONG_CHOICE);
            sc.next();
        }
        return sc.next();
    }
}

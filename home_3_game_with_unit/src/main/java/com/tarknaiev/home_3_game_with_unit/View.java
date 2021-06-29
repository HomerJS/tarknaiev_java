package com.tarknaiev.home_3_game_with_unit;

/**
 * @author ihor tarknaiev
 */
public class View {
    public static final String START_GAME_STRING = "Let's play.";
    public static final String INPUT_INT_DATA = "Input INT value: ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please!";
    public static final String FINAL_GAME_STRING = "Your statisitc data: ";
    public static final String FINAL_FULL_STRING = "Your full statisitc data: ";
    public static final String START_NEW_GAME_STRING = "Do you want to start a new game? (y - to start a new game, or inout any symbol for exit)";
    public static final String NEW_GAME_WRONG_CHOICE = "Please input 'y' or 'n'";
    /**
     * Print message in console
     * 
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }
}

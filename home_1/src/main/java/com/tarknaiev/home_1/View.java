package com.tarknaiev.home_1;

/**
 * @author ihor tarknaiev
 */
public class View {
    public static final String INPUT_STRING_DATA = "Input STRING value (only 'Hello' and 'world!' are acceptable) = ";
    public static final String WRONG_INPUT_STRING_DATA = "Wrong input! Repeat please! Only 'Hello' and 'world!' are acceptable and only in this order";
    public static final String RIGHT_INPUT_STRING_DATA = "Good choice!";
    public static final String FINAL_STRING = "FINAL value = ";

    /**
     * Print message in console
     * 
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }
}

package com.tarknaiev.home_3_game_with_unit;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author ihor Tarknaiev
 */
public class Model {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 100;
    public static final String ERROR_VALIDATION_MESSAGE = "Your value is out of bounds. Try Again.";
    public static final String GAME_HAS_FINISHED_MESSAGE = "The game has finished.";
    public static final String TRY_ONE_MORE_TIME_MESSAGE = "Try one more time.";

    /**
     * number for searching
     */
    protected int randNumber;

    /**
     * is game finished flag
     */
    protected boolean isFinished;

    /**
     * previous step string: lower/higher
     */
    protected String previousStep;

    /**
     * list of winning numbers
     */
    protected ArrayList<Integer> hiddenNumber;

    /**
     * list of all attempts
     */
    protected ArrayList<ArrayList<Integer>> fullAttempttsList;

    /**
     * min range for the game
     */
    protected int minRange;

    /**
     * max range for the game
     */
    protected int maxRange;

    /**
     * randomizer
     */
    protected Random rand;

    /**
     * Constructor
     */
    public Model() {
        this.randNumber = 0;
        this.previousStep = null;
        this.minRange = this.MIN_VALUE;
        this.maxRange = this.MAX_VALUE;
        this.rand = new Random();
        this.hiddenNumber = new ArrayList<>();
        this.fullAttempttsList = new ArrayList<>();
    }

    /**
     * Start game method
     * clear all data
     * 
     */
    public void StartNewGame() {
        this.isFinished = false;
        this.previousStep = "";
        this.minRange = this.MIN_VALUE;
        this.maxRange = this.MAX_VALUE;
        this.randNumber = this.rand.nextInt((this.MAX_VALUE - this.MIN_VALUE) + 1) + this.MIN_VALUE;
        this.hiddenNumber.add(this.randNumber);
        this.fullAttempttsList.add(this.hiddenNumber.size() - 1, new ArrayList<>());
    }

    /**
     *  Manage incoming data
     * 
     * @param value
     * @return string
     */
    public String CheckNewData(int value) {
        if (!this.ValidateNewData(value)) {
            return this.ERROR_VALIDATION_MESSAGE;
        }

        String resultMessage = "";
        if (IsValueTheSame(value)) {
            this.isFinished = true;
            resultMessage = this.GAME_HAS_FINISHED_MESSAGE;
        } else {
            this.SetPreviousStep(value);
            this.SetNewRanges(value);
            resultMessage = this.TRY_ONE_MORE_TIME_MESSAGE;
        }
        this.SetAttempt(value);
        return resultMessage;
    }

    /**
     * Validate incoming data stick to the borders
     * 
     * @param newValue
     * @return Boolean
     */
    protected boolean ValidateNewData(int newValue) {
        return !(newValue < this.minRange || newValue > this.maxRange);
    }

    /**
     * check if user win
     * 
     * @param value
     * @return Boolean
     */
    protected boolean IsValueTheSame(int value) {
        return value == this.randNumber;
    }

    /**
     * return is game finished flag
     * 
     * @return Boolean
     */
    public boolean IsFinished() {
        return this.isFinished;
    }

    /**
     * Set new borders
     * 
     * @param value
     */
    protected void SetNewRanges(int value) {
        if (value > this.randNumber) {
            this.maxRange = value;
        } else {
            this.minRange = value;
        }
    }

    /**
     * Set attempt to the list for statistic
     * 
     * @param value
     */
    protected void SetAttempt(int value) {
        this.fullAttempttsList.get(this.hiddenNumber.size() - 1).add(value);
    }

    /**
     * Set previous step lower/higher
     * 
     * @param value
     */
    protected void SetPreviousStep(int value) {
        this.previousStep = value > this.randNumber ? "lower" : "higher";
    }

    /**
     * Get input data for the step
     * 
     * @return String
     */
    public String GetCurrentInputData() {
        String result = "";
        result = !this.previousStep.isEmpty()
                ? "Previous step: " + this.previousStep + "\n" : "";

        int currentList = this.hiddenNumber.size() - 1;
        if (this.fullAttempttsList.get(currentList).size() > 0) {
            result += this.GetAttempStatisticInString(currentList);
        }

        result += "Input range from " + this.minRange + " - " + this.maxRange;

        return result;
    }

    /**
     * Return full statistic data for all games
     * 
     * @return String
     */
    public String GetFullStatisticData() {
        String delimiter = "/////////////////////\n";
        String result = "\nYou've played " + this.hiddenNumber.size() + " time(s)\n" + delimiter;
        for (int i = 0; i < this.hiddenNumber.size(); ++i) {
            result += "Hidden number: " + this.hiddenNumber.get(i) + "\n";
            result += this.GetAttempStatisticInString(i);
            result += delimiter;
        }

        return result;
    }

    /**
     * Get statistic data for attempts in a good form
     * 
     * @param counter
     * @return String
     */
    protected String GetAttempStatisticInString(int counter) {
        String result = "Attempts: [";
        for (int tempAttemp : this.fullAttempttsList.get(counter)) {
            result += tempAttemp + ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += "] \n";
        return result;
    }

    /**
     *  Return last game statistic in a good form
     * 
     * @return String
     */
    public String GetGameStatisticData() {
        String result = "\n";
        result += "Hidden number: " + this.hiddenNumber.get(this.hiddenNumber.size() - 1) + "\n";
        result += this.GetAttempStatisticInString(this.hiddenNumber.size() - 1);
        return result;
    }
}

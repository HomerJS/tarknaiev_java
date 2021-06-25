package com.tarknaiev.home_1;

/**
 * @author ihor Tarknaiev
 */
public class Model {
    public static final String HELLO = "Hello";
    public static final String WORLD = "world!";
    public static final int FULL_WORLD_IN_SENTENCE = 2;

    /**
     * Contains full string
     */
    protected String fullString;

    /**
     * Counts world in the full string
     */
    protected int worldInSentence;

    /**
     *Constructor
     */
    public Model() {
        this.fullString = "";
        this.worldInSentence = 0;
    }

    /**
     * Add value to the full string
     * 
     * @param value
     * @return Boolean
     */
    public boolean addValue(String value) {
        if (this.validateHelloWorldString(value)) {
            this.setValue(value);
            ++this.worldInSentence;
            return true;
        }
        return false;
    }

    /**
     * Setter for full string
     * 
     * @param value
     */
    protected void setValue(String value) {
        String temp = this.fullString + " " + value;
        this.fullString = temp.trim();
    }

    /**
     * Getter for full string
     * 
     * @return String
     */
    public String getValue() {
        return this.fullString;
    }

    /**
     * Validate input string
     * 
     * @param string
     * @return Boolean
     */
    public boolean validateHelloWorldString(String string) {
        return (this.fullString.isEmpty() && string.equals(this.HELLO))
                || (!this.fullString.isEmpty() && string.equals(this.WORLD));
    }

    /**
     * Return if we have a full Phrase  
     * 
     * @return Boolean
     */
    public boolean isFinal() {
        return this.worldInSentence == this.FULL_WORLD_IN_SENTENCE;
    }
}

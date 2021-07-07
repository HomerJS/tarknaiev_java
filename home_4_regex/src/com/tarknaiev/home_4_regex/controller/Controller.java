package com.tarknaiev.home_4_regex.controller;

import com.tarknaiev.home_4_regex.exceptions.TestException;
import com.tarknaiev.home_4_regex.model.Field;
import com.tarknaiev.home_4_regex.model.Person;
import com.tarknaiev.home_4_regex.view.MessageConstants;
import com.tarknaiev.home_4_regex.view.View;

import java.util.Scanner;

/**
 * The type Controller.
 *
 * @author ihor tarknaiev
 */
public class Controller {
    private Person person;
    private View view;

    /**
     * Instantiates a new Controller.
     *
     * @param person the model person
     * @param view        the view
     */
    public Controller(Person person, View view) {
        this.person = person;
        this.view = view;
    }

    /**
     * Main process
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        view.printMessage(MessageConstants.START_MESSAGE);
        for (Field field: Field.values()) {
            this.updateField(sc, field);
        }
        view.printMessage(MessageConstants.ALL_DATA_MESSAGE);
        view.printMessage(person.toString());
    }

    /**
     * get and set field data
     *
     * @param sc
     * @param field
     */
    protected void updateField(Scanner sc, Field field) {
        String inputValue = this.dataGetter(sc, field);
        try {
            person.setData(field.getName(), inputValue);
        } catch (TestException e) {
            view.printMessage(e.getMessage());
            this.updateField(sc, field);
        }
    }

    /**
     * get and check input data
     *
     * @param sc     the sc
     * @param field the field
     * @return String string
     */
    public String dataGetter(Scanner sc, Field field) {
        String inputValue = this.inputStringValueFromScanner(sc, field.getPublicName());
        if (!person.validate(field.getRegex(), inputValue)) {
            this.dataGetter(sc, field);
        }
        return inputValue;
    }

    /**
     * Input reader
     *
     * @param sc              the sc
     * @param fieldPublicName the field public name
     * @return String string
     */
    public String inputStringValueFromScanner(Scanner sc, String fieldPublicName) {
        System.out.print(fieldPublicName + ": ");
        while (!sc.hasNext()) {
            view.printMessage(MessageConstants.ERROR_MESSAGE);
            sc.next();
        }
        return sc.next();
    }
}

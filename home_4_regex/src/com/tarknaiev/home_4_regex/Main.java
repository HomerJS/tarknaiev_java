package com.tarknaiev.home_4_regex;

import com.tarknaiev.home_4_regex.controller.Controller;
import com.tarknaiev.home_4_regex.model.Person;
import com.tarknaiev.home_4_regex.view.View;

/**
 * @author ihor tarkaniev
 */
public class Main {

    /**
     * Run the project
     *
     * @param args
     */
    public static void main(String[] args) {
        Person person = new Person();
        View view = new View();
        Controller controller = new Controller(person, view);
        controller.run();
    }

}

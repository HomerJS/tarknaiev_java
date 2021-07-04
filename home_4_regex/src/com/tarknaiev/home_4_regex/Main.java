package com.tarknaiev.home_4_regex;

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
        ModelPerson modelPerson = new ModelPerson();
        View view = new View();
        Controller controller = new Controller(modelPerson, view);
        controller.run();
    }

}

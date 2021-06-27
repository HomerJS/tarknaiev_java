package com.tarknaiev.home_2_game;

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
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.run();
    }

}

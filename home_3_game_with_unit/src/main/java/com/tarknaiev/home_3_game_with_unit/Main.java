package com.tarknaiev.home_3_game_with_unit;

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

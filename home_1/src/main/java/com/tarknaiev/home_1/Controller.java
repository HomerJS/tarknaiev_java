package com.tarknaiev.home_1;

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
        
        do {
            inputStringValueFromScanner(sc);
        } while (model.isFinal() == false);
        
        view.printMessage(View.FINAL_STRING + model.getValue());
    }
    
    /**
     * Waiting for input data 
     * 
     * @param sc
     */
    public void inputStringValueFromScanner(Scanner sc) {
        view.printMessage(View.INPUT_STRING_DATA);        
        while (!sc.hasNext()) {
            view.printMessage(View.WRONG_INPUT_STRING_DATA + View.INPUT_STRING_DATA);
            sc.next();
        }
        String result = model.addValue(sc.next()) ? View.RIGHT_INPUT_STRING_DATA : View.WRONG_INPUT_STRING_DATA;
        view.printMessage(result);
    }
}

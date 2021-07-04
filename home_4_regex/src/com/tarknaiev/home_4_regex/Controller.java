package com.tarknaiev.home_4_regex;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Controller.
 *
 * @author ihor tarknaiev
 */
public class Controller {
    private ModelPerson modelPerson;
    private View view;

    /**
     * Instantiates a new Controller.
     *
     * @param modelPerson the model person
     * @param view        the view
     */
    public Controller(ModelPerson modelPerson, View view) {
        this.modelPerson = modelPerson;
        this.view = view;
    }

    /**
     * Main process
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        view.printMessage(View.START_MESSAGE);
        for (ModelValidator object: this.validatorGenerator()) {
            String inputValue = this.dataGetter(sc, object);
            modelPerson.setData(object.getFieldName(), inputValue);
        }

        view.printMessage(View.ALL_DATA_MESSAGE + "\n" + modelPerson.toString());
    }

    /**
     * Generate array of field models
     *
     * @return ArrayList array list
     */
    protected ArrayList<ModelValidator> validatorGenerator() {
        ArrayList<ModelValidator> result = new ArrayList<>();
        for (String fieldName : ModelValidator.fieldNameList) {
            result.add(new ModelValidator(fieldName));
        }
        return result;
    }

    /**
     * get and check input data
     *
     * @param sc     the sc
     * @param object the object
     * @return String string
     */
    public String dataGetter(Scanner sc, ModelValidator object) {
        String inputValue = this.inputStringValueFromScanner(sc, object.getPublicName());
        if (modelPerson.validate(object.getRegex(), inputValue)) {
            this.dataGetter(sc, object);
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
            view.printMessage(View.ERROR_MESSAGE);
            sc.next();
        }
        return sc.next();
    }
}

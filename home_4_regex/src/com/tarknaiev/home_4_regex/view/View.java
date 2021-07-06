package com.tarknaiev.home_4_regex.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author ihor tarknaiev
 */
public class View {
    private static final String MESSAGES_BUNDLE_NAME = "resources/messages";
    public static final ResourceBundle bundle;
    static {
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("en"));
    }

    /**
     * Print message in console
     * 
     * @param message
     */
    public void printMessage(String message) {
        System.out.println(bundle.getString(message));
    }
}

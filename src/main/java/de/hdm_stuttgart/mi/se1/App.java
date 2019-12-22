package de.hdm_stuttgart.mi.se1;

import java.util.Arrays;

/**
 * A simple http://logging.apache.org/log4j/2.x demo,
 * see file resources/log4j2.xml for configuration options
 * and A1.log containing debugging output.
 */

public class App {
    /**
     * Your application's main entry point.
     *
     * @param args Yet unused
     */
    public static void main( String[] args ) {

        // Beispiel für die Input.getInput()-Methode
        if(Input.getInput("Hello")) {
            System.out.println("success");
        }
        else {
            System.out.println("fail");
        }

        // Beispiel für die Input.searchAllCurrencies()-Methode
        String[] example = new String[] {"Australian Dollar", "Canadian Dollar", "Pound Sterling", "Euro", "US Dollar", "Chinese Yuan"};
        String[] searchedExample = Input.searchAllCurrencies(example);
        System.out.println(Arrays.toString(searchedExample));
        // oder untereinander
        for (int i = 0; i < searchedExample.length; i++) {
            System.out.println((i + 1) + ". " + searchedExample[i]);
        }
    }
}
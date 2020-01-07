package de.hdm_stuttgart.mi.se1;

import java.util.Arrays;
import java.util.Scanner;

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
    private static Scanner scan = new Scanner(System.in);

    public static String[] allCurrencies;
    public static double[] allExchangeRates;

    private int indexOfOldCurrency;
    private int indexOfNewCurrency;

    public static void main( String[] args ) {
        // Beispiel für die Input.getInput()-Methode
        String pressedKeys = scan.next();
        if(Input.getInput("Hello", pressedKeys)) {
            System.out.println("success");
        }
        else {
            System.out.println("fail");
        }

        // Beispiel für die Input.searchAllCurrencies()-Methode
        String[] example = new String[] {"Australian Dollar", "Canadian Dollar", "Pound Sterling", "Euro", "US Dollar", "Chinese Yuan"};
        String searchedString = scan.next();
        String[] searchedExample = Input.searchAllCurrencies(example, searchedString);
        System.out.println(Arrays.toString(searchedExample));
        // oder untereinander
        for (int i = 0; i < searchedExample.length; i++) {
            System.out.println((i) + ". " + searchedExample[i]);
        }
    }
}
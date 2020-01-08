package de.hdm_stuttgart.mi.se1;

import java.io.IOException;
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

    private int indexOfOldCurrency = -1;
    private int indexOfNewCurrency = -1;
    private double moneyAmount;

    public static void main( String[] args ) {
        //In den folgenden 7 Zeilen wird die .txt Datei in die 2 Arrays konvertiert
        try {
            allCurrencies = Input.splitArray(Input.readLines("currencys.txt"), 0);
            allExchangeRates = Arrays.stream(Input.splitArray(Input.readLines("currencys.txt"), 1)).mapToDouble(Double::parseDouble).toArray();
        }
        catch(IOException e) {
            System.out.println("Fail");
        }

        // Beispiel für die Input.getInput()-Methode
        String pressedKeys = scan.next();
        if(Input.getInput("Hello", pressedKeys)) {
            System.out.println("success");
        }
        else {
            System.out.println("fail");
        }

        // Beispiel für die Input.searchAllCurrencies()-Methode
        String searchedString = scan.next();
        String[] searchedExample = Input.searchAllCurrencies(allCurrencies, searchedString);
        System.out.println(Arrays.toString(searchedExample));
        // oder untereinander
        for (int i = 0; i < searchedExample.length; i++) {
            System.out.println((i) + ". " + searchedExample[i]);
        }
    }
}
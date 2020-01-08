package de.hdm_stuttgart.mi.se1;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A simple http://logging.apache.org/log4j/2.x demo,
 * see file resources/log4j2.xml for configuration options
 * and A1.log containing debugging output.
 */

public class App {

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
            // Konvertiert das String-Array zu einem Double-Array
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

    // TODO: write test
    private void upperInterface(){
        if (indexOfOldCurrency != 0 && indexOfNewCurrency != 0) {
            System.out.println("Buying " + moneyAmount + " of " + allCurrencies[indexOfOldCurrency]);
            moneyAmount = Input.CalculateNewCurrency(indexOfOldCurrency, indexOfNewCurrency, moneyAmount, allCurrencies, allExchangeRates);
            System.out.println("Selling " + moneyAmount + " of " + allCurrencies[indexOfNewCurrency]);
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }
        else {
            System.out.println("Currency to buy: " + (indexOfOldCurrency == -1 ? "not set" : allCurrencies[indexOfOldCurrency]));
            System.out.println("Currency to sell: " + (indexOfNewCurrency == -1 ? "not set" : allCurrencies[indexOfNewCurrency]));
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }
    }
    private void lowerInterface() {
        System.out.println("0: select currency to buy");
        System.out.println("1: select currency to sell");
        System.out.println("2: choose amount to be converted");
        System.out.println("Please choose an Option (x to exit):");

        if (Input.getInput("0", scan.next())) {
            search();
        }
        if (Input.getInput("1", scan.next())) {
            search();
        }
        if (Input.getInput("2", scan.next())) {
            search();
        }
        if (Input.getInput("x", scan.next())) {
            exit();
        }
    }

     private void search() {
         System.out.println("Enter a currency`s name or part of it (x to exit:)");
         String scanInput = scan.next();

         if (Input.getInput("x,", scanInput)) {
             exit();
         } else {
             String[] searchedStrings = Input.searchAllCurrencies(allCurrencies, scanInput);
             if (searchedStrings.length < 0) {
                 for (int i = 0; i < searchedStrings.length; i++) {
                     System.out.println((i) + ". " + searchedStrings[i]);
                 }
             } else {
                 System.out.println("No valid input, please reenter");
                 search();
             }
         }
     }

     private void exit()
        {

        }
}
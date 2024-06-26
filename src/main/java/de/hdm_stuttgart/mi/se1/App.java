package de.hdm_stuttgart.mi.se1;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static Scanner scan = new Scanner(System.in);

    public static String[] allCurrencies;
    public static double[] allExchangeRates;

    private static int indexOfOldCurrency = -1;
    private static int indexOfNewCurrency = -1;
    private static double oldMoneyAmount;
    private static double newMoneyAmount;

    // Main
    public static void main( String[] args ) {
        //In den folgenden 7 Zeilen wird die .txt Datei in die 2 Arrays konvertiert
        try {
            allCurrencies = Input.splitArray(Input.readLines("currencys.txt"), 0);
            // Konvertiert das String-Array zu einem Double-Array
            allExchangeRates = Arrays.stream(Input.splitArray(Input.readLines("currencys.txt"), 1)).mapToDouble(Double::parseDouble).toArray();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        upperInterface();
        lowerInterface();
    }

    /**
     * Methode um den oberen Teil des Interfaces anzuzeigen
     */
    private static void upperInterface(){
        if (indexOfOldCurrency != -1 && indexOfNewCurrency != -1) {
            System.out.println("Buying " + oldMoneyAmount+ " of " + allCurrencies[indexOfOldCurrency]);
            newMoneyAmount = Input.CalculateNewCurrency(indexOfOldCurrency, indexOfNewCurrency, oldMoneyAmount, allCurrencies, allExchangeRates);
            System.out.println("Selling " + newMoneyAmount + " of " + allCurrencies[indexOfNewCurrency]);
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }
        else {
            System.out.println("Currency to buy: " + (indexOfOldCurrency == -1 ? "not set" : allCurrencies[indexOfOldCurrency]));
            System.out.println("Currency to sell: " + (indexOfNewCurrency == -1 ? "not set" : allCurrencies[indexOfNewCurrency]));
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }
    }

    /**
     * Methode um den unteren Teil des Interfaces anzuzeigen
     */
    private static void lowerInterface() {
        System.out.println("0: select currency to buy");
        System.out.println("1: select currency to sell");
        System.out.println("2: choose amount to be converted");
        System.out.println("Please choose an option (x to exit): ");

        String userInput = scan.next();

        if (Input.getInput("0", userInput))
            search(userInput);
        else if (Input.getInput("1", userInput))
            search(userInput);
        else if (Input.getInput("2", userInput))
            saveMoneyAmount();
        else if (Input.getInput("x", userInput))
            System.exit(0);
        else if (Input.getInput("Banane", userInput)) {
            System.out.println("The Trojan horse entered your pc.\nSystem shutting down in t-");
            Input.Banane();
        }
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Not a valid input, please try again\n");
            upperInterface();
            lowerInterface();
        }
    }

    /**
     * Sucht alle Währungen nach dem scanInput(z.B. 'dol') und speichert alle gefundenen Währungsnamen in einem neuen Array
     * @param userInput Der erste Input des Users (Optionen zur Auswahl: 0,1,2)
     */
     private static void search(String userInput) {
         System.out.println("Enter a currency`s name or part of it (x to exit: )");
         //Der Teil des Währungsnamen, nach dem gesucht werden soll
         String scanInput = scan.next();

         if (Input.getInput("x", scanInput)) {
             lowerInterface();
         } else {
             // Ein Array wird erstellt, in dem alle Währungsnamen gespeichert werden, welche den scanInput enthalten
             String[] searchedStrings = Input.searchAllCurrencies(allCurrencies, scanInput);
             // Wenn ein Währungsname gefunden wurde
             if (searchedStrings.length > 0) {
                 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                 upperInterface();

                 for (int i = 0; i < searchedStrings.length; i++) {
                     System.out.println((i) + ". " + searchedStrings[i]);
                 }
                 System.out.println("Select a currency by index");
                 selectIndexOfCurrency(searchedStrings, userInput);
             }
             // Wenn kein Währungsname gefunden wurde
             else {
                 System.out.println("Not a valid input. Please try again\n");
                 search(userInput);
             }
         }
     }

    /**
     * Man schaut, wann die gewählte Währung im allCurrencies[] vorkommt und speichert den Index
     * @param searchedStrings Das Array, in dem die gefilterten Währungen gespeichert sind
     * @param userInput Die Wahl des Users im lowerInterface (Optionen zur Auswahl: 0,1)
     */
     private static void selectIndexOfCurrency(String[] searchedStrings, String userInput) {
         String indexOfCurrency = scan.next();
         try {
             // Wenn die eingegebene Zahl innerhalb der Länge des neuen Währungsarrays liegt
             if (Integer.parseInt(indexOfCurrency) <= searchedStrings.length) {
                 for (int i = 0; i < allCurrencies.length; i++) {
                     // Loopt durch alle Währungen und checkt,
                     // wann der Name der gesuchten Währung gleich dem Namen der Währung im allCurrencies[] ist
                     // und speichert den Index ab
                     if (searchedStrings[Integer.parseInt(indexOfCurrency)].equals(allCurrencies[i])) {
                         if (Integer.parseInt(userInput) == 0)
                             indexOfOldCurrency = i;
                         else if (Integer.parseInt(userInput) == 1)
                             indexOfNewCurrency = i;
                         break;
                     }
                 }
             } else
                 selectIndexOfCurrency(searchedStrings, userInput);
         }

         // Bei String Inputs, wird ein Fehler geworfen
         catch(NumberFormatException e) {
             System.out.println("Not a valid Input, please try again\n");
             selectIndexOfCurrency(searchedStrings, userInput);
         }

         System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
         upperInterface();
         lowerInterface();
     }

    /**
     * Speicherung des Geldbetrags
     */
    private static void saveMoneyAmount(){
         System.out.println("Please enter an amount");
         try {
             oldMoneyAmount = scan.nextDouble();
             oldMoneyAmount = (double) Math.round(oldMoneyAmount*100) / 100;
         } catch (InputMismatchException e){
             System.out.println("Not a valid Input, please try again\n");
         }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        upperInterface();
        lowerInterface();
    }
}
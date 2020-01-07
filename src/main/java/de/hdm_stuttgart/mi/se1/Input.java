package de.hdm_stuttgart.mi.se1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Input-Klasse soll uns das Vergleichen der eingegebenen Zeichen mit unseren gewollten Zeichen erleichtern
 */

public class Input {

    /**
     * Diese Methode liest eine Datei in ein Array ein
     * @param filename Der Name der Datei, die eingelesen werden soll
     * @return Ein Array, dass die einzelnen Zeilen der Datei als einzelne Arraypositionen
     * @throws IOException
     */
    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }
    /**
     * Diese Methode überprüft, ob ein bestimmter String eingegeben wird
     * @param desiredInput Der String, der eingegeben werden muss, damit die Methode true zurückgibt
     * @return Ob der eingegebe String gleich ist wie der gewünschte String
     */
    public static boolean getInput(String desiredInput, String pressedKeys) {
        // .equalsIgnoreCase() ignoriert Groß- und Kleinschreibung des Strings.
        if(pressedKeys.equalsIgnoreCase(desiredInput)) {
            return true;
        }
        return false;
    }

    /**
     * Die Methode ist wichtig für die Suchfunktion. Sie gibt uns ein String-Array mit allen Strings zurück,
     * die den eingegeben String enthalten.
     * @param stringsToBeChecked Das Array mit den Strings, die überprüft werden sollen (in unserem alle Währungsnamen)
     * @return Ein neues Array mit allen Namen, die bei der Suche gefunden wurden
     */
    public static String[] searchAllCurrencies(String[] stringsToBeChecked, String searchedString) {
        String[] foundStrings = new String[0];

        for (int i = 0; i < stringsToBeChecked.length; i++) {
            if (stringsToBeChecked[i].toLowerCase().contains(searchedString.toLowerCase())) {
                foundStrings = addString(foundStrings, foundStrings.length, stringsToBeChecked[i]);
            }
        }
        return foundStrings;
    }

    /**
     * Diese Methode wird genutzt, um einen String an ein String-Array anzuhängen. So können wir un der Methode searchAllCurrencies()
     * einen String zu einem Array hinzufügen, wenn er zum gesuchten Begriff passt.
     * @param oldArray Das alte Array, an welches ein String angehängt werden soll
     * @param length Die Länge des alten Arrays
     * @param stringToAdd Der String, der an das alte Array angehängt werden soll
     * @return Ein Array mit dem angehängten String
     */
    private static String[] addString(String[] oldArray, int length, String stringToAdd)
    {
        String[] newArray = new String[length + 1];

        for (int i = 0; i < length; i++) {
            newArray[i] = oldArray[i];
        }

        newArray[length] = stringToAdd;
        return newArray;
    }

    /**
     *Die Methode um unsere Währungen umzurechnenen
     * @param indexOfOldCurrency Der Index im Array allCurrencies[] der alten Währung
     * @param indexOfNewCurrency Der Index im Array allCurrencies[] der alten Währung
     * @param moneyAmount Der Betrag der Währung vor dem umrechnenen
     * @param allCurrecies Das Array, welches alle Währungsnamen enthält
     * @param allExchangeRates Das Array, welches alle Umrechnungssätze enthält
     * @return Den Betrag der neuen Währung auf 2 Nachkommastellen gerundet
     */
    public static double CalculateNewCurrency(int indexOfOldCurrency, int indexOfNewCurrency, double moneyAmount, String[] allCurrecies, double[] allExchangeRates)
    {
        return Math.round(moneyAmount * allExchangeRates[indexOfOldCurrency] * allExchangeRates[indexOfNewCurrency] * 100) / 100;
    }
}

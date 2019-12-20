package de.hdm_stuttgart.mi.se1;

import java.util.Scanner;

/**
 * Die Input-Klasse soll uns das Vergleichen der eingegebenen Zeichen mit unseren gewollten Zeichen erleichtern
 */

public class Input {
    static Scanner scan = new Scanner(System.in);

    /**
     * Diese Methode überprüft, ob ein bestimmter String eingegeben wird
     * @param desiredInput Der String, der eingegeben werden muss, damit die Methode true zurückgibt
     * @return Ob der eingegebe String gleich ist wie der gewünschte String
     */
    public static boolean getInput(String desiredInput) {
        String pressedKeys = scan.next();
        // .equalsIgnoreCase() ignoriert Groß- und Kleinschreibung des Strings.
        if(pressedKeys.equalsIgnoreCase(desiredInput)) {
            return true;
        }
        return false;
    }

    /**
     * Diese Methode überprüft, ob ein eingebener String in einem anderen String enthalten ist
     *  --> Wichtig für die Suchfunktion bei der Währungseingabe
     * @param stringToBeChecked Der String, in welchem der eingegebe String enthalten sein soll
     * @return Ob der eingegebe String in dem gewünschten String vorkommt
     */
    public static boolean searchForString(String stringToBeChecked) {
        String searchedString = scan.next();
        if (stringToBeChecked.contains(searchedString)) {
            return true;
        }
        return false;
    }
}

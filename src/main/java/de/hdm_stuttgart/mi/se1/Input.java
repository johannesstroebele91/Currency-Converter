package de.hdm_stuttgart.mi.se1;

import java.util.Scanner;

//Die Input-Klasse soll uns das Vergleichen der eingegebenen Zeichen mit unseren gewollten Zeichen erleichtern.

public class Input {
    static Scanner scan = new Scanner(System.in);

    //Die Methode wird true, wenn die eingegebene Zeichenfolge gleich ist wie die gewollte Zeichenfolge, die wir der Methode mitgegen.
    public static boolean getInput(String desiredInput)
    {
        String pressedKeys = scan.next();

        // .equalsIgnoreCase() ignoriert Groß- und Kleinschreibung des Strings.
        if(pressedKeys.equalsIgnoreCase(desiredInput))
        {
            return true;
        }
        return false;
    }
}

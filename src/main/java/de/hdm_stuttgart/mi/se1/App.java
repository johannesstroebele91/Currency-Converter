package de.hdm_stuttgart.mi.se1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * A simple http://logging.apache.org/log4j/2.x demo,
 * see file resources/log4j2.xml for configuration options
 * and A1.log containing debugging output.
 */

public class App {
    private static Logger log = LogManager.getLogger(App.class);

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

        //Beispiel für die Input.searchForString()-Methode
        if(Input.searchForString("Hello World")) {
            System.out.println("success");
        }
        else {
            System.out.println("fail");
        }
    }
}
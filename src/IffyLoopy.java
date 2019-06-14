/*
 * This program will
 * 1. print out 5 words the user has typed as a one string.
 *
 * 2. use the boolean value of redEyes to determine whether the user
 *    should be complimented or not:
 *
 * 3. ask the user if to continue: accept 'n' to terminate the program.
 */


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class IffyLoopy {
    public static void Loopy() {
        Scanner keyboard = new Scanner(System.in);
        String msg = "", word = "";

        // Requirement 1
        System.out.println("Type in 5 words: ");
        for (int i = 0; i < 5; i++) {
            word = keyboard.next();
            msg = msg + ' ' + word;
        }

        System.out.println(msg);

    }

    public static void Iffy(String msg) {
        int compVal = 0;
        char ch;
        Boolean foundFg = true;

        /*
         * check for "yes" or 'Y', ignoring cases.
         * It will only check for the 1st character of a string for 'Y' or 'y'
         * such that if user typed "Yne" it would be taken as "yes"
         */

        if (msg.length() == 1) {
            // it is a character
            ch = msg.charAt(0);
            if ((ch == 'Y') || (ch == 'y'))
                foundFg = true;
            else
                foundFg = false;
        }
        else {
            // it is a string
            if (msg.compareToIgnoreCase("yes") == 0)
                foundFg = true;
            else
                foundFg = false;
        }

        if (foundFg)
            System.out.println("Get some sleep!");
        else
            System.out.println("You look great!");

    }


    public static void main(String[] args) {
        String userMsg = "";

        Scanner keyboard = new Scanner(System.in);

        Loopy();                  // print out the first 5 words from the user

        while (true) {
            System.out.println("\nAre your eyes red?");
            userMsg = keyboard.nextLine();

            Iffy(userMsg);

            System.out.println("\nDo you want to try again?");
            userMsg = keyboard.nextLine();

            // continue until the user enters 'n' as an answer.
            if ((userMsg.charAt(0) == 'n') && (userMsg.length() == 1))
                break;
        }
    }
}

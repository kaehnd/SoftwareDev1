/*
 *Course: CS-1011
 *Term: Fa;; 2018
 * Assignment: Lab Two
 * Author: Daniel Kaehn
 * Date: 9/11
 */
package kaehnd;

import java.util.Scanner;

public class NumberNegator

{   // Converts any number to its oppositely signed counterpart

    public static void main(String[] args)
        {
            Scanner in = new Scanner(System.in);

            System.out.print("Enter a rational number: ");
            int userDouble = in.nextInt();

            int userNegative = -userDouble;

            System.out.println(userDouble + " negated is " +
                    userNegative);
        } // end main
} // end class NumberNegator

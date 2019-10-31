/*
 *Course: CS-1011
 *Term: Fa;; 2018
 * Assignment: Lab Two
 * Author: Daniel Kaehn
 * Date: 09/11/18
 */
package kaehnd;

import java.util.Scanner;

public class DollarsToPennies
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a valid dollar amount (ex. 26.64): $");
        double userDollars = in.nextDouble();

        int dollarsInPennies = (int) (userDollars * 100);

        System.out.println("$" + userDollars + " is " + dollarsInPennies + " pennies");
    } // end main

} // end class DollarsToPennies

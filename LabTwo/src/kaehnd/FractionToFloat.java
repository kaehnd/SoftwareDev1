/*
 *Course: CS-1011
 *Term: Fa;; 2018
 * Assignment: Lab Two
 * Author: Daniel Kaehn
 * Date: 09/11/18
 */
package kaehnd;

import java.util.Scanner;

public class FractionToFloat
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer numerator: ");
        int userNumerator = in.nextInt();

        System.out.print("Enter an integer denominator: ");
        int userDenominator = in.nextInt();

        double finalFloat = (double) userNumerator / userDenominator;

        System.out.println(userNumerator + " over " + userDenominator + " is " +
                finalFloat);
    } // end main
} // end class

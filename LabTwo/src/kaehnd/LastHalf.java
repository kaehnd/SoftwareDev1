/*
 *Course: CS-1011
 *Term: Fa;; 2018
 * Assignment: Lab Two
 * Author: Daniel Kaehn
 * Date: 09/11/18
 */

package kaehnd;

import java.util.Scanner;

public class LastHalf
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter any string with an even amount of characters: ");
        String userString = in.nextLine();

        String lastHalf = userString.substring((userString.length() + 1)/2);

        System.out.println("The last half of \"" + userString + "\" is \"" + lastHalf + "\"");
    } //end main
} // end class LastHalf

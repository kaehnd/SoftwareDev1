/*
 *Course: CS-1011
 *Term: Fa;; 2018
 * Assignment: Lab Two
 * Author: Daniel Kaehn
 * Date: 09/11/18
 */

package kaehnd;

import java.util.Scanner;

public class MakeInitialization
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter any integer: ");
        int userInt = in.nextInt();

        System.out.print("Enter a string variable name: ");
        String userVariable = in.next();

        System.out.println("int " + userVariable + " = " + userInt);
    } // end main
} // end class MakeInitialization

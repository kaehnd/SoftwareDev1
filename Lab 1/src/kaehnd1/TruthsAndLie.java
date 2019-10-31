/*
 *Course: CS-1011
 * Term:  Fall 2018
 * Assignment: Lab 1
 * Author: Daniel Kaehn
 * Date: 09/05/18
 */
package kaehnd1;
import java.util.Scanner;
public class TruthsAndLie
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);  // Provides user input
        System.out.println("Which of the following is a lie????? " +
                "Enter a number between 1 and 3");
        System.out.println("1: I have traveled outside of the US");
        System.out.println("2: I have a male dog named Lucy");
        System.out.println("3: I have spoken to a crowd or more than 500 people");

        int guess = in.nextInt();// Prompts user input
        while (guess != 2)// Loops until user inputs "2"
            {
            System.out.println("Wrong Bruh");
            guess = in.nextInt();
            }
        System.out.println("That's Right");
        }// endmain
    } //end class TruthsAndLie

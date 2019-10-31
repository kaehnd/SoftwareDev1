/*
 * Course: CS 1011-21
 * Term: Fall 2018
 * Assignment: Lab Five
 * Name: Daniel Kaehn
 * Date: 10/2/2018
 */
package kaehnd;

import java.util.Scanner;

/**
 * This program estimates values of PI based off of a user inputted number of randomly
 * generated points at some position on the unit square.
 */
public class Lab5 {
    public int getCorrectDigits(double a, double b){
        String aString = "" + a;
        String bString = "" + b;
        int count = 0;
        while(aString.charAt(count) == bString.charAt(count)) {
            count++;
        }
        return count-1;


    public static void main(String [] args) {
        int correctDigitsPrevious = 0;
        Scanner in = new Scanner(System.in);
        String tryAgain;
        String bestPi = "";
        do {
            double x;
            double y;
            int numberBelow;
            numberBelow = 0;
            long userNumberOfPoints;

            do {
                System.out.print("Enter number of darts to be thrown on a unit square" +
                        " to determine an estimate for pi: ");
                userNumberOfPoints = in.nextLong();
                if (userNumberOfPoints < 1) {
                    System.out.println("Please enter an integer value greater than zero.");
                }
                if (userNumberOfPoints > Integer.MAX_VALUE){
                    System.out.println("Please enter an integer value less than " +
                            Integer.MAX_VALUE);
                }
            }
            while(userNumberOfPoints < 1 || userNumberOfPoints > Integer.MAX_VALUE);

            int numberOfPoints = (int) userNumberOfPoints;

            for (int count = 0; count < numberOfPoints; count++) {
                x = Math.random();
                y = Math.random();
                if (Math.pow(x, 2) + Math.pow(y, 2) < 1) {
                    numberBelow++;
                }
            }

            double piEstimate = (double) numberBelow * 4 / numberOfPoints;
            int correctDigits = getCorrectDigits(piEstimate, Math.PI);
            if (correctDigits > correctDigitsPrevious) {
                bestPi = piEstimate + "";
            }

            System.out.println("This estimate was " + piEstimate + "\n" +
                    "And was correct to " + correctDigits + " digits.");

            //Stores correct digits for each run of do loop to find greatest value
            correctDigitsPrevious = correctDigits;

            do {
                System.out.print("Try again? (Y or N): ");
                tryAgain = in.next();
                if (!(tryAgain.equalsIgnoreCase("y") || tryAgain.equalsIgnoreCase("n"))){
                    System.out.println("You entered \"" + tryAgain +
                            "\"\nPlease enter \"y\" or \"n\"");
                }
            }
            while (!(tryAgain.equalsIgnoreCase("y") || tryAgain.equalsIgnoreCase("n")));

        }
        while (tryAgain.equalsIgnoreCase("Y"));

        System.out.println("Pi's best estimate this session was " + bestPi);
        DoublingInheritance drugs = new DoublingInheritance();
        int i = drugs.drugs;

        System.out.println(i);
    } //EndMain

    /* Method getCorrectDigits meant to get the number of digits that are the same
     * for two different doubles until one digit is not the same .
     */

    } //End Method getCorrectDigits
// } //End Public Class Lab5

/*
 *Course: CS-1011
 *Term: Fall 2018
 * Assignment: Lab Three
 * Author: Daniel Kaehn
 * Date: 09/18/18y
 */

package kaehnd;

import java.util.Scanner;

public class Lab3 {

    /* Program that calculates an estimate of expected income tax based upon current fixed tax brackets
     * and user input of joint or single filing status and estimated income.
     */

    public static void main(String[] args) {

        final int BRACKET_ONE, BRACKET_TWO, BRACKET_THREE, BRACKET_FOUR, BRACKET_FIVE, BRACKET_SIX;

        final double BRACKET_ZERO_RATE = .10;
        final double BRACKET_ONE_RATE = .12;
        final double BRACKET_TWO_RATE = .22;
        final double BRACKET_THREE_RATE = .24;
        final double BRACKET_FOUR_RATE = .32;
        final double BRACKET_FIVE_RATE = .35;

        final double BRACKET_SIX_RATE = .37;

        double taxes = 0; //Initial tax value before calculation--must be declared here instead of in if statement
        String filingStatus;

        //Create scanner object and reference variable for keyboard input recognition
        Scanner in = new Scanner(System.in);

        //Obtain user input of filing status
        System.out.print("Are you married filng jointly? (Y/N): ");
        filingStatus = in.next();

        //Ask for valid input if the user entered any characters other than "Y" or "N"
        while (!(filingStatus.toUpperCase().equals("Y")) && !(filingStatus.toUpperCase().equals("N"))) {
            System.out.println("You entered  \"" + filingStatus + "\"");
            System.out.println("Please enter \"Y\" or \"N\"");
            System.out.print("Are you married filng jointly? (Y/N): ");
            filingStatus = in.next();
        }

       //Obtain income input as string and ensure it is an integer
        char c;
        String incomeIn;
        do {
            System.out.print("To the nearest integer, what was your total income in 2017? $");
            incomeIn = in.next();

            int count = 0;
            c = incomeIn.charAt(count); // Stores each character value to be checked if it is a digit

            while (count < incomeIn.length() - 1 && (Character.isDigit(c))|| c == '.') {
                count++;
                c = incomeIn.charAt(count);
            }// Loop terminates when all characters are confirmed to be digits or one character is not a digit
            if (!(Character.isDigit(c))) {
                System.out.println("You entered " + incomeIn);
                System.out.println("Please enter an integer value");
            }
        }while (!(Character.isDigit(c))); //Value of c after previous loop finishes determines if incomeIn is an integer

        //Convert incomeIn to an int value income
        double income = Double.parseDouble(incomeIn);

        // Store named tax bracket constants according to filing status
        if (filingStatus.equals("Y")) {
            BRACKET_ONE = 19050;
            BRACKET_TWO = 77400;
            BRACKET_THREE = 165000;
            BRACKET_FOUR = 315000;
            BRACKET_FIVE = 400000;
            BRACKET_SIX = 600000;
        }
        else {
            BRACKET_ONE = 9525;
            BRACKET_TWO = 38700;
            BRACKET_THREE = 82500;
            BRACKET_FOUR = 157500;
            BRACKET_FIVE = 200000;
            BRACKET_SIX = 500000;
        }

        //Calculate the estimated income tax
        double incomeRemaining = income; //Placeholder variable that accounts for income left untaxed after each bracket
            if (income > BRACKET_SIX) {
            taxes += (incomeRemaining - BRACKET_SIX) * BRACKET_SIX_RATE;
            incomeRemaining = BRACKET_SIX;
            taxes += (incomeRemaining - BRACKET_FIVE) * BRACKET_FIVE_RATE;
            incomeRemaining = BRACKET_FIVE;
        }if (income > BRACKET_FIVE) {
            taxes += (incomeRemaining - BRACKET_FIVE) * BRACKET_FIVE_RATE;
            incomeRemaining = BRACKET_FIVE;
            taxes += (incomeRemaining - BRACKET_FOUR) * BRACKET_FOUR_RATE;
            incomeRemaining = BRACKET_FOUR;
        }if (income > BRACKET_FOUR) {
            taxes += (incomeRemaining - BRACKET_FOUR) * BRACKET_FOUR_RATE;
            incomeRemaining = BRACKET_FOUR;
            taxes += (incomeRemaining - BRACKET_THREE) * BRACKET_THREE_RATE;
            incomeRemaining = BRACKET_THREE;
        }if (income > BRACKET_THREE){
            taxes += (incomeRemaining - BRACKET_THREE) * BRACKET_THREE_RATE;
            incomeRemaining = BRACKET_THREE;
            taxes += (incomeRemaining - BRACKET_TWO) * BRACKET_TWO_RATE;
            incomeRemaining = BRACKET_TWO;
        }if (income > BRACKET_TWO) {
            taxes += (incomeRemaining - BRACKET_TWO) * BRACKET_TWO_RATE;
            incomeRemaining = BRACKET_TWO;
            taxes += (incomeRemaining - BRACKET_ONE) * BRACKET_ONE_RATE;
            incomeRemaining = BRACKET_ONE;
        }if (income >BRACKET_ONE) {
            taxes += (incomeRemaining - BRACKET_ONE) * BRACKET_ONE_RATE;
            incomeRemaining = BRACKET_ONE;
        }taxes += incomeRemaining * BRACKET_ZERO_RATE;

        //Calculate effective tax rate
        double taxRate = taxes / income * 100;

        //Round taxes and tax rate to zero and two decimal places, respectively
        taxes = Math.round(taxes);
        taxRate = Math.round(taxRate*100)/100.0;

        System.out.println("Your estimated taxes for 2017 are $" + (int) taxes);
        System.out.println("at an effective rate of %" + taxRate);

    } // end main
} // end public class IncomeTaxEstimator

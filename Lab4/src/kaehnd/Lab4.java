/*
 *Course: CS-1011
 *Term: Fall 2018
 * Assignment: Lab Three
 * Author: Daniel Kaehn
 * Date: 09/25/18
 */
package kaehnd;

import java.util.Scanner;

public class Lab4 {

    /*This program simulates a situation where a user must choose between two options to gain the most amount of money
     *possible, with a certain amount of uncertainty if they will win due to random variables each time the user plays.
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double linearDollars;
        int playAgain;
        int choice;
        int count;
        int years;
        double linear;
        double exponential;
        do{
            //Random variables
            linearDollars = Math.round(100*(Math.random()* 2500 + 300))/100.0;
            years = (int)(Math.random()*35 + 5);
            //Game explanation
            System.out.println("\nYou are an explorer of Mayan ruins. On a certain conquest, you encounter an ancient" +
                " Mayan genie. He says to you:\n\n\"You, whom might consider yourself wise, I give you the power of " +
                "choice over your destiny. You may have my boon.\nYour first option is this: I will give " +
                "you $" + linearDollars +" every year for a certain number of years. " +
                "You might prosper soon with this.\nOr, you might choose my second option. " +
                "I will give you $.01 now, and double it every year for that same number of years. This might " +
                "benefit you greatly in the future.\nChoose now, and choose wisely\"\n");
            System.out.print("Choose option 1 or 2: ");
            choice = in.nextInt();

            System.out.println("\nThe genie calculates the fruits of your decision, and shows them to you\n");
            linear = linearDollars;
            exponential = .01;
            count = 1;

            //Calculates and prints amounts for all years and both linear and exponential paths
            System.out.format("Week %d\tLinear: $%.2f\t\tExponential: $%.2f\n", count, linear, exponential);
            while(count <= years && linear > exponential) {
                linear += linearDollars;
                exponential *= 2;
                count++;
                System.out.format("Week %d\tLinear: $%.2f\t\tExponential: $%.2f\n", count, linear, exponential);
            }
            double amountLostOrWon = Math.abs(.01 * Math.pow(2, years) - linearDollars * years);
            System.out.println();
            if ((choice == 1 && linear > exponential) || (choice == 2 && exponential > linear))
                if (count < years){
                    System.out.print("At this point the genie stops. He tells you this: \n\n\"You have chosen " +
                            "wisely for your future. You will forever be prosperous. Had you chosen my first option," +
                            "you would have lost $");
                }
                else{
                    System.out.print("At the end of the calculations, the genie tells you this:\n\n\"You have " +
                            "chosen your future poorly, yet you still have won my boon. " +
                            "Had you chosen my second option, you would have lost $");

                }
            else {
                System.out.print("At the end of the calculations, the genie tells you this: \n\"You have chosen " +
                        "poorly, and the tides are not in your favor. You lost ");
            }
            System.out.format("%.2f\n\n", amountLostOrWon);
            System.out.println("Go now, you have chosen. Unless, that is, you would like to entertain me some " +
                    "more...\n\nPlay again? (1 for yes): ");
            playAgain = in.nextInt();
        }
        while(playAgain == 1);
    }//Endmain
}//End Public Class Lab4

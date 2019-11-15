/*
 * Course: CS-1011
 * Term: Fall 2018
 * Assignment: Lab 1
 * Author: Dr. Chris Taylor
 * Date: 08/20/18
 */
package kaehnd;

import java.util.Scanner;

/**
 * Class containing the entire program for lab 1 in fall 2018 CS-1011 course.
 * @author taylor
 * @version 2018-08-20
 */
public class StudyTime {

    /**
     * Simple program to determine help set study expectations for a new
     * college student.
     * @param args ignored
     */
    public static void main(String[] args) {
        // Create a "reference variable"/object to gather data
        // from the keyboard
        Scanner in = new Scanner(System.in);
	
	//adding changes to the file
        // Request data from the user
        System.out.print("Enter the number of credits you are taking this term: ");
        int creditsTaken = in.nextInt();
        System.out.print("Enter the number of hours you plan to spend studying each week: ");
        int plannedHours = in.nextInt();

        // Calculate recommended hours of study
        int recommendedHoursLow = creditsTaken * 2;
        int recommendedHoursHigh = creditsTaken * 3;

        System.out.println("You are taking " + creditsTaken
                + " this term and plan to study " + plannedHours + " per week.");

        System.out.print("You plan to study ");
        if(plannedHours < recommendedHoursLow) {
            System.out.print("less than");
        } else if(plannedHours > recommendedHoursHigh) {
            System.out.print("more than");
        } else {
            System.out.print("in the range of");
        }
        System.out.println(" the recommended " + recommendedHoursLow + " - "
                + recommendedHoursHigh + " hours per week.");

    }
//Adding more things to the file
}

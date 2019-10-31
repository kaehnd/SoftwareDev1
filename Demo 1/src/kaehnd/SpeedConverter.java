

/*
 *Course: CS-1011
 *Term: Fall 2018
 * Assignment
 * Author
 * Date
 */

package kaehnd;

import java.util.Scanner;

//This program does drugs

public class SpeedConverter
{
    public static void main(String[] args)
    {
       Scanner in;
        in = new Scanner(System.in);
       final double FEET_PER_METER = 3.2808;
       final int FEET_PER_MILE = 5280;
       final int SECONDS_PER_HOUR = 3600;
       double initialSpeed = in.nextDouble();
       double speedInMph;
       speedInMph = initialSpeed * FEET_PER_METER / FEET_PER_MILE
               * SECONDS_PER_HOUR;
       System.out.println("The speed in mph is" + speedInMph);

    } // endmain
} // endclass SpeedConverter

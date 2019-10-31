/*
 *Course: CS-1011
 *Term: Fall 2018
 * Assignment: LoopTest
 * Author: Daniel Kaehn
 * Date: 09/21/18
 */
package kaehnd;

import java.util.Scanner;

public class LoopTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String array = "";
        String array2 = "";
        System.out.print("Enter the height: ");
        int height = in.nextInt();
        System.out.print("Enter the width: ");
        int width = in.nextInt();

        while (array.length() < width){
            array += "*";
        }
        for (int count = 0; count < height; count++){
            System.out.println(array);
        }
        System.out.println();
        System.out.println();

        for (int count = 0; count < height; count ++){
            System.out.println(array);
            array = " " + array.substring(0,array.length()-1);
        }


    }// End Main
}// Ebd Public Class LoopTest

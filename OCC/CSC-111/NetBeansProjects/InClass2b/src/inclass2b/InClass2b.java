/******************************************************************************
 * Program Name: InClass2b
 * Author: Trevor Butler
 * Date: January 31, 2018
 * Course/Section: CSC-111-002
 * Program Description: Write a program that reads values representing a time
 * duration in hours, minutes and seconds and then prints the equivalent total 
 * number of seconds. The program should read in the 3 values as integers and 
 * the display the total seconds which is also an integer.
 *****************************************************************************/
package inclass2b;

import java.util.Scanner;

public class InClass2b 
{

    /**************************************************************************
     * Declare Hours as Int
     * Declare Min as Int
     * Declare Sec as Int
     * Declare Total Sec as Int
     * Declare scan as scanner
     * Get Hours
     *    Display "Enter Number of Hours"
     *    Input Hours
     * Get Min
     *    Display "Enter Number of Minutes"
     *    Input Min
     * Get Sec
     *    Display "Enter Number of Seconds"
     *    Input Seconds
     * Calc Total Seconds
     * Display Results
     * Display "    ", Total Seconds, EOL
     *************************************************************************/
    public static void main(String[] args) 
    {
        // Local Variables
        int hours;
        int min;
        int sec;
        int totalSec;
        Scanner scan = new Scanner(System.in);     
    
        // Display Input Message
        System.out.print("Enter Number of Hours: ");
        
        // Allows User to Input Number of Hours
        hours = scan.nextInt();
        
        // Display Input Message
        System.out.print("Enter Number of Minutes: ");
        
        // Allows User to Input Number of Minutes
        min = scan.nextInt();
        
        // Display Input Message
        System.out.print("Enter Number of Seconds: ");
        
        // Allows User to Input Number of Seconds
        sec = scan.nextInt();
        
        // Calcuates Total Number of Seconds
        totalSec = hours*(60*60)+min*60+sec;
        
        // Displays Total Seconds
        System.out.println("Total Number of Seconds:" + totalSec);
    }
    
}

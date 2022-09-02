/*******************************************************************************
* Program Name   :   CSC 111 Assignment 06 - ArraySmallestGreatest
* Author         :   Trevor Butler 
* Due Date       :   4/4/18
* Course/Section :   CSC 111 - 002 
* Write a program that will ask the user to enter 10 decimal (double) values. 
*    The 10 values should be stored in an array. After in values have been
*    entered and stored in the array the program will determine which value is
*    the highest (largest) and which is the lowest (smallest). It will then 
*    display the highest and the lowest value with a message indicating that 
*    it is the highest and lowest.
*******************************************************************************/
package arraysmallestgreatest;

import java.util.Scanner;

public class ArraySmallestGreatest 
{

    /***************************************************************************
     * BEGIN Assignment 06 - ArraySmallestGreatest
     *      Declare Variables
     *      Allow User to Enter 10 Values and Store Them in the Array
     *      Set number equal to currentLargest/Smallest
     *      Determine Which Values is the Largest
     *      Determine Which Value is the Smallest
     *      Display Largest/Smallest Value 
     * END Assignment 06 - ArraySmallestGreatest
     * 
     * @param args the command line arguments
     **************************************************************************/
    public static void main(String[] args) 
    {
        // Declare Variables
        final int SIZE = 10;
        double values [] = new double[SIZE];
        double largest;
        double smallest;
        
        // Allow User to Enter 10 Values and Store Them in the Array
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 10 Numbers");
        
        for(int index = 0; index < SIZE; index++)
        {
            System.out.print((index + 1) + ": ");
            values[index] = input.nextDouble();
        }
        
        // Set number equal to currentLargest/Smallest
        smallest = values[0];
        largest = values[0];

        // Determine Which Values is the Largest
        for(int index = 0; index < SIZE; index++)
        {
            if(values[index] > largest)
            {
                largest = values[index];
            }
        }
                
        // Determine Which Value is the Smallest
        for(int index = 0; index < SIZE; index++)
        {
            if(values[index] < smallest)
            {
                smallest = values[index];
            }
        }
        
        // Display Largest/Smallest Value 
        System.out.println("\nThe Smallest Number Was: " + smallest);
        System.out.println("The Largest Number Was: " + largest + "\n\n");
    }
    
}

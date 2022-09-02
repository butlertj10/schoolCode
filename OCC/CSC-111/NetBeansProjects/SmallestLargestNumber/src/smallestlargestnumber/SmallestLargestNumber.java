
package smallestlargestnumber;

import java.util.Scanner;

public class SmallestLargestNumber 
{
/*******************************************************************************
*Program Name   :   CSC 111 Assignment 04 - Smallest/Largest Numbers 
*Author         :   Trevor Butler 
*Due Date       :   3/7/18
*Course/Section :   CSC 111 - 002 
*Program Description: Write a program that will ask the user for a set of ten 
*   numbers. After all ten numbers have been entered, the program will display 
*   the largest and smallest numbers of the data set. The program will then 
*   prompt the user whether he/she would like to enter another set of data. 
*   When the user indicates he/she is finished entering data sets, the program
*   will finally display the average largest number and the average smallest 
*   number for all sets entered.
*
*BEGIN Assignment 04 - Smallest/Largest Numbers 
*   initialize totalCount to 0
*   initialize totalSmallest to 0
*   initialize totalLargest to 0
*   WHILE(user does not enter quit)
*       Add one to totalCount              
*       Input a Number
*       Set number equal to currentLargest/Smallest
*       WHILE(totalInput is less than MAX_INPUT)           
*               Add one to totalInput
*               Input a Number
*               IF(number is greater than currentLargest)
*                   Set number equal to currentLargest
*               END IF
*               IF(number is smaller than currentSmallest)
*                   Set number equal to currentSmallest
*               END IF
*       END WHILE
*       Add curentSmallest to totalSmallest
*       Add currentLargest to totalLargest
*       Reset totalInput Counter
*       Display Smallest and Largest Number
*       Ask user if they would like to continue     
*   END WHILE  
*   Calculate smallestAverage
*   Calculate largestAverage
*   Display smallest/largestAverage
*END Assignment 04 - Smallest/Largest Numbers 
*@param args the command line arguments
*******************************************************************************/

    public static void main(String[] args) 
    {
        // Declare Variables
        int totalCount = 0;
        int totalInput = 1;
        int currentSmallest;
        int currentLargest;
        int number;
        String choice = "Yes";
        int totalSmallest = 0;
        int totalLargest = 0;
        double smallestAvg;
        double largestAvg;
        final int MAX_INPUT = 10;
      
        // While user does not quit
        while(!"No".equals(choice))
        {
            // Add one to totalCount
            totalCount++;
                            
            // Input a Number
            System.out.println("Please Enter 10 Numbers");
            System.out.print("Number " + totalInput +": ");
            Scanner input = new Scanner(System.in);
            number = input.nextInt();
                
            // Set number equal to currentLargest/Smallest
            currentSmallest = number;
            currentLargest = number;
                    
            // While(totalInput is less than MAX_INPUT)
            while(totalInput < MAX_INPUT)
            {             
                // Add one to totalInput
                totalInput++;

                // Input a Number
                System.out.print("Number " + totalInput +": ");
                number = input.nextInt();  

                // IF(number is greater than currentLargest)
                if(number > currentLargest)
                {
                    // Set number equal to currentLargest
                    currentLargest = number;
                } // END IF

                // IF(number is smaller than currentSmallest)
                if(number < currentSmallest)
                {            
                    // Set number equal to currentSmallest
                    currentSmallest = number; 
                } // END IF

            }// END WHILE
  
            // Add curentSmallest to totalSmallest
            totalSmallest = totalSmallest + currentSmallest;
            
            // Add currentLargest to totalLargest
            totalLargest = totalLargest + currentLargest;     
            
            // Reset totalInput Counter
            totalInput = 1;
            
            // Display Smallest and Largest Number
            System.out.print("The Smallest Number Entered was: " + currentSmallest + "\n");
            System.out.print("The Largest Number Entered was: " + currentLargest + "\n");
            
            // Ask user if they would like to continue
            System.out.print("\nWould You Like to Enter Another Set of Data?\n");
            System.out.print("Enter 'Yes' for Yes or 'No' for No: ");
            Scanner ans = new Scanner(System.in);
            choice = ans.next();       
        } // END WHILE
        
        // Calculate smallestAverage
        smallestAvg = totalSmallest/totalCount;

        // Calculate largestAverage
        largestAvg = totalLargest/totalCount;

        // Display smallest/largestAverage
        System.out.print("\nThe Avgerage Smallest Number Input was: " + smallestAvg + "\n");
        System.out.println("The Average Largest Number Input was: " + largestAvg);

    }
}

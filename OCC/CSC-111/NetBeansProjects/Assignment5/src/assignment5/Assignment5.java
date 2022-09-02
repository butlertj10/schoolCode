package assignment5;

import java.util.Scanner;

public class Assignment5 
{

    /***************************************************************************
     * BEGIN Assignment 05 - Conversion Chart
     *      Declare Variables
     *      DO
     *          Input Minimum Inches
     *          Input Maximum Inches
     *          IF(Difference is too large OR Min is greater than Max)
     *              Display Error Msg that difference is too large or min > min
     *          ELSE
     *              Display Heading
     *              FOR(Each Value Possible)
     *                  Convert Inches to Centimeters
     *                  Display Number of Inches
     *                  Display Number of Centimeters
     *              END FOR
     *          END IF
     *          Ask user if they would like to enter more values
     *      WHILE(User did not Quit)
     *      Display Message that the program has come to an end
     * END Assignment 05 - Conversion Chart
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Declare Variables
        int maxInch;
        int minInch;
        String choice = "Yes";
        double centimeters;
        final int MAX_DIFF = 36;
        final int MIN_DIFF = 6;
        final double CM_CONV = 2.54;
        
        // DO
        do
        {
            // Input Minimum Inches
            System.out.print("Enter the Minimum Number of Inches: ");
            Scanner input = new Scanner(System.in);
            minInch = input.nextInt();
            
            // Input Maximum Inches
            System.out.print("Enter the Maximum Number of Inches: ");
            Scanner scan = new Scanner(System.in);
            maxInch = scan.nextInt();
            
                // IF(Difference is too large OR Min is greater than Max)
                if((maxInch - minInch) > MAX_DIFF || minInch > maxInch || (maxInch - minInch) < MIN_DIFF)
                {
                    // Display Error Msg that difference is too large or min > min
                    System.out.println("\nThere was an Error With the Inputs Entered");
                }
                    else
                {
                    // Display Heading
                    System.out.println("\n" + "    Conversion Chart\n");
                    System.out.println("   Inches" + "   Centimeters");
                    System.out.println("   ------" + "   -----------");
                    
                    // FOR(Each Value Possible)
                    for(int numInch = minInch; numInch <= maxInch; numInch+=6)
                    {
                        // Convert Inches to Centimeters
                        centimeters = (double)(numInch*CM_CONV);
                        
                        // Display Number of Inches
                        System.out.print("      " + numInch);
                        
                        // Display Number of Centimeters
                        System.out.print("      " + centimeters + "\n");
                        
                        
                    } // END FOR
                } // END IF
                
            // Ask user if they would like to enter more values
            System.out.print("\nWould You Like to Enter More Values?\n");
            System.out.print("Enter 'Yes' for Yes or 'No' for No: ");
            Scanner ans = new Scanner(System.in);
            choice = ans.next(); 
            System.out.print("\n");
        }
        
        // WHILE(User did not Quit)
        while(!"No".equals(choice));
            
        // Display Message that the program has come to an end
        System.out.println("Thank You! The Program is Now Over!\n");
    }
    
}

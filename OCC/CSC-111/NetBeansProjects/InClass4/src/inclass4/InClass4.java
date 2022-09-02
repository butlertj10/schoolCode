/*

 */
package inclass4;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class InClass4 
{

    /***************************************************************************
     * Declare Variables
     *  Declare minsParked as Integer
     *  Declare hours as Integer
     *  Declare leftMins Integer
     *  Declare cost as a double
     * 
     * Input Minutes Parked 
     *  Display "Enter the Number of Minutes Parked: "
     *  Input minsParked
     * 
     * IF (minsParked is less than or equal to zero)
     *  Display "You Entered an Invalid Value for Minutes", EOL
     * ELSE
     *  Set hours = minsParked / 60
     *  Set leftMins = minsParked % 60
     *  Set cost = hours * 1.00
     *  IF (leftMins greater than 0)
     *    cost = cost + 1.00
     *  END IF
     *  Display "You Parked for ", hours, " hours and ", leftMins, " minutes", EOL
     *  Display "Your Final Cost is: ", cost, EOL
     * END IF
     * 
     * @param args the command line arguments
     **************************************************************************/
    public static void main(String[] args) 
    {
        // Declare Variables
        int  minsParked;
        int hours = 0;
        int leftMins = 0;
        double cost = 0;
        
        // Input Minutes Parked 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Number of Minutes Parked: ");
        minsParked = input.nextInt();

        // IF (minsParked is less than or equal to zero)
        if (minsParked <= 0)
        {
            // Display Error Message
            System.out.print("You Entered an Invalid Value for Minutes");
        }
        else
        {
            // Set hours = minsParked / 60
            hours = minsParked /60;
        
            // Set leftMins = minsParked % 60
            leftMins = minsParked % 60;
                
            // Set cost = hours * 1.00
            cost = hours * 1.00;
        
            //  IF (leftMins greater than 0)
            if (leftMins > 0)
            {
                cost = cost + 1.00;
                    
            }//  END IF
        } // END IF
        
        // Display Outputs
        System.out.println("You Parked for " + hours + " hours and " + leftMins + " minutes");
        System.out.println("Your Final Cost is: " + cost);

    }
    
}

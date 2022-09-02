package compassnavigator;

import java.util.Scanner;

public class CompassNavigator 
{

/*******************************************************************************
 * BEGIN CompassNavigator
 *    Declare Variables 
 *    Input a degree number
 *    IF (Degree Number is not in range)   
 *       IF (Degree Number is greater than 0 and less than 90) 
 *           Direction equals 90 minus Degree Number
 *           Display direction
 *        ELSE IF (Degree Number is greater than 90 and less than 180)
 *           Direction equals 180 minus Degree Number
 *           Display direction
 *        ELSE IF (Degree Number is greater than 180 and less than 270)
 *           Direction equals 270 minus Degree Number
 *           Display direction
 *        ELSE IF (Degree Number is greater than 270)
 *           Direction equals 360 minus Degree Number
 *           Display direction
 *        ELSE IF (Degree Number is equal to 0)
 *           Display direction is North
 *        ELSE IF (Degree Number is equal to 90)
 *           Display direction is East
 *        ELSE IF (Degree Number is equal to 180)
 *           Display direction is South
 *        ELSE
 *           Display direction is West
 *        END IF
 *      ELSE 
 *           Display Degree Number was not in Range
 *      END IF
 * END CompassNavigator
 * @param args the command line arguments  
 ******************************************************************************/
    
    public static void main(String[] args) 
    {
        // Declare Variables
        double direction;
        double degreeNum;
        final double north = 360.0;
        final double east = 90.0;
        final double south = 180.0;
        final double west = 270.0;
        
        // Input a degree number
        System.out.print("Input a Degree Number to Find Out the Dicrection: ");
        Scanner input = new Scanner(System.in);
        degreeNum = input.nextDouble();
        
        if(degreeNum >= 0 && degreeNum <= north)
        {
            // IF (Degree Number is greater than 0 and less than 90)
            if(degreeNum > 0 && degreeNum < east)
            {
                // Direction equals 90 minus Degree Number
                direction = east - degreeNum;
                
                // Display direction
                System.out.println("The Direction is: N" + direction + "E");
            }
            // ELSE IF (Degree Number is greater than 90 and less than 180)
            else if(degreeNum > east && degreeNum <south)
            {
                // Direction equals 180 minus Degree Number
                direction = south - degreeNum;
                
                // Display direction
                System.out.println("The Direction is: S" + direction + "E");
            }
            // ELSE IF (Degree Number is greater than 180 and less than 270)
            else if(degreeNum > south && degreeNum < west)
            {
                // Direction equals 270 minus Degree Number
                direction = west - degreeNum;
                
                // Display direction
                System.out.println("The Direction is: S" + direction + "W");
            }
            // ELSE IF (Degree Number is greater than 270)
            else if(degreeNum > west && degreeNum < north)
            {
                // Direction equals 360 minus Degree Number
                direction = north - degreeNum;

                // Display direction
                System.out.println("The Direction is: N" + direction + "W");
            }
            // ELSE IF (Degree Number is equal to 0)
            else if(degreeNum == 0 || degreeNum == north)
            {
                //  Display direction is North
                System.out.println("The Direction is: N");
            }
            // ELSE IF (Degree Number is equal to east)
            else if (degreeNum == east)
            {
                // Display direction is East
                System.out.println("The Direction is: E");
            }
            // ELSE IF (Degree Number is equal to 180)
            else if(degreeNum == south)
            {
               //Display direction is South
               System.out.println("The Direction is: S");
            }
            // ELSE
            else
            {
               // Display direction is West
               System.out.println("The Direction is: W");
               
            } // END IF
        } // ELSE
        else
        {
            // Display Degree input was not in range 
            System.out.println("Degree Input was not in Range");
        }
    }
}


package area.permofrect;

import java.util.Scanner;

public class AreaPermOfRect 
{

    /***************************************************************************
     * BEGIN Calculate Area and Perimeter of a Rectangle
     *    Declare Variables
     *    Input 2 Sides of a Rectangle
     *    IF(Both Numbers are Positive)
     *         Calculate Area of Rectangle
     *         Calculate Perimeter of Rectangle
     *         Display Area and Perimeter of Rectangle
     *     ELSE
     *         Display Message of Invalid Inputs
     *     END IF
     * END Calculate Area and Perimeter of a Rectangle
     * @param args the command line arguments
     **************************************************************************/
   
    public static void main(String[] args) 
    {
        // Declare Variables
        int sideOne;
        int sideTwo;
        int area;
        int perimeter;
        
     // Input 2 Sides of a Rectangle
     Scanner input = new Scanner(System.in);
     System.out.print("Input Length of the First Side of a Rectangle: ");
     sideOne = input.nextInt();
     System.out.print("Input Length of the Second Side of a Rectangle: ");
     sideTwo = input.nextInt();
     
     // IF(Both Numbers are Positive)
     if(sideOne > 0 && sideTwo > 0)
     {    
        // Calculate Area of Rectangle
        area = sideOne*sideTwo;
        
        // Calculate Perimeter of Rectangle
        perimeter = (2*sideOne)+(2*sideTwo);
        
        // Display Area and Perimeter of Rectangle
        System.out.println("The Area of the Rectangle is: " + area);
        System.out.println("The Perimeter of the Recatngle is: " + perimeter);
     }
     else
     {
        // Display Message of Invalid Inputs
         System.out.println("One or Both of the Numbers Input Was NOT Positive");
         
     }// END IF
     
    }
    
}

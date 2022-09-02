/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass6;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class InClass6 
{

    /***************************************************************************
     * Declare Variables
     *  Declare numGrade
     *  Declare letterGrade as string
     * 
     * Input Numeric Grade
     *  Display "Enter the Numeric Grade: "
     *  Input numGrade
     * 
     * Determine Letter Grade
     *  IF (numGrade >= 0 && numGrade <= 0)
     *      IF (numGrade < 60)
     *          Set letterGrade = 'F'
     *      ELSE IF (numGrade < 70)
     *          Set letterGrade = 'D'
     *      ELSE IF (numGrade < 80)
     *          Set letterGrade = 'C'
     *      ELSE IF (numGrade < 90)
     *          Set letterGrade = 'B'
     *      ELSE
     *          Set letterGrade = 'A'
     *      END IF
     *      Display Letter Grade
     *          Display "Your Grade is: " letterGrade,EOL
     *  ELSE
     *      Display "You Entered an Ivalided Grade"
     *  END IF
     * 
     * @param args the command line arguments
     **************************************************************************/
    public static void main(String[] args) 
    {
        // Declare Variables
        int numGrade;
        String letterGrade = null;
        
        
        // Input Numeric Grade
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Numeric Grade: ");
        numGrade = input.nextInt();
     
        // Determine Letter Grade
        if(numGrade >= 0 && numGrade <= 100)
        {
            if(numGrade < 60)
                letterGrade = "F";
            else if(numGrade < 70)
                letterGrade = "D";
            else if(numGrade < 80)
                letterGrade = "C";
            else if (numGrade < 90)
                letterGrade = "B";
            else
                letterGrade = "A";
            
            // Display Letter Grade
            System.out.println("Your Grade is: " + letterGrade);
            
        } // END IF
        else    
        {
            // Display Error Message
            System.out.println("You Entered an Ivalided Grade");
        
        } // END IF
    }
    
}

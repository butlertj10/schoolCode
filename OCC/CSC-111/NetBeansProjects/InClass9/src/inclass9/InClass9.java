package inclass9;

import java.util.Scanner;


public class InClass9 
{

    /***************************************************************************
     * BEGIN InClass9
     *    Input Score between 0-100 (inclusive)
     *    WHILE (Score is not valid)
     *       Display Score is not valid
     *       Input Score between 0-100 (inclusive)
     *    END WHILE
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Declare Variables
        int score;
        
        // Input Score between 0-100 (inclusive)
        System.out.print("Enter a Grade: ");
        Scanner input = new Scanner(System.in);
        score = input.nextInt();
        
        // WHILE (Score is not valid)
        while(score < 0 || score > 100)
        {
            // Display Score is not valid
            System.out.println("Score Entered is NOT in Range");
            
            // Input Score between 0-100 (inclusive
            System.out.print("Please Enter a Different Grade: ");
            score = input.nextInt();
            
        }
    }
    
}

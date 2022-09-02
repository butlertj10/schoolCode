
package inclass9b;

import java.util.Scanner;


public class InClass9b 
{

    /***************************************************************************
     * BEGIN InClass9
     *    Input Score between 0-100 (inclusive)
     *    DO
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
        do
        {
            // Input Score between 0-100 (inclusive)
            System.out.print("Enter a Grade: ");
            Scanner input = new Scanner(System.in);
            score = input.nextInt();
        } while(score < 0 || score > 100);
        }
    }
    


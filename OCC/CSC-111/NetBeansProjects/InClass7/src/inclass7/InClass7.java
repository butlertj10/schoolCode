
package inclass7;

import java.util.Scanner;

public class InClass7 
{

    /***************************************************************************
     * BEGIN InClass7
     *    Declare Variables    
     *      Declare runningTotal to 0
     *      Declare counter to 0
     *    Get Number Grades
     *    IF(Number Grade is Greater Than 0)
     *      WHILE(counter is Less Than numGrades)
     *          Display "Enter a Grade: "
     *          Set grade to User Input
     *          Set runningtotal = runningTotal + grade
     *          Increment counter
     *      END WHILE
     *    Calculate average
     *    Display average
     *    ELSE
     *      Display "Invalid Grades", EOL
     * END InClass7
     * 
     * @param args the command line arguments
     **************************************************************************/
    public static void main(String[] args) 
    {
        // Declare Variables
        int numGrade;
        int runningTotal = 0;
        int counter = 0;
        int grade;
        double avg;
        
        // Get Number Grades
        System.out.print("Input Number of Grades: ");
        Scanner input = new Scanner(System.in);
        numGrade = input.nextInt();
        
        // IF(Number Grade is Greater Than 0)
        if(numGrade > 0)
        {
            // WHILE(counter is Less Than numGrades)
            while(counter < numGrade)
            {
                // Display "Enter a Grade: "
                System.out.print("Enter a Grade: ");
                
                // Set grade to User Input
                grade = input.nextInt();
                
                // Set runningtotal = runningTotal + grade
                runningTotal = runningTotal + grade;
                
                // Increment counter
                counter++;
                
            } // END WHILE
                        
            // Calculate average
            avg = runningTotal / (double)numGrade;
            
            // Display average
            System.out.print("The Avgerage Grade is: " + avg);
        }
        else
        {
            // Display "Invalid Grades", EOL
            System.out.println("Invalid Grades");
        }
    }
    
}

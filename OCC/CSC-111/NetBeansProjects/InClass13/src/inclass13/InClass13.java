
package inclass13;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class InClass13 
{
    /*******************************
    * GetInput
    *   Declare Variables
    *   Get Input
    *   Set temp equal to input     
     * @param data
     * @param size
     * @param prompt
    *******************************/
    
    public static void GetInput(int data[], int size, String prompt)
    {
        Scanner input = new Scanner(System.in);
        
        for(int index = 0; index < size; index++)
        {
            System.out.println(prompt);
            data[index] = input.nextInt();
        }
    }

    /**************************
     * Average
     *   Declare variables
     *   Calculate Average
     *   Return Average
     * @param data
     * @param size
     * @return 
    ***************************/
    
    public static int Average(int data[], int size)
    {
        int avg = 0; 
        int total = 0;
        
        for(int index = 0; index < size; index++)
        {
            // Running total of the data in the array
            total += data[index]; 
        }
        
        avg = total/size;
        
        return avg;
    }
    
    public static void DisplayOutput(int data[], int size, int avg)
    {
        System.out.println("\n\n");
        for(int index = 0; index < size; index++)
        {
            System.out.printf("%-15s %-15s %n", data[index], avg - data[index]);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
//        String heading1 = "Exam Name";
//        String heading2 = "Exam Grade";
//                
//        System.out.printf("%-15s %-15s %n", heading1, heading2);
//        System.out.printf("%-15s %-15s %n", 10, 20);
//        System.out.printf("%-15s %-15s %n", 105, 2606);
        
        final int SIZE = 5;
        int values [] = new int[SIZE];
        int average = 0;
        
        DisplayOutput(values, SIZE, 0);
        GetInput(values, SIZE, "Enter Values");
        average = Average(values, SIZE);
        DisplayOutput(values, SIZE, average);
        
    }
    
}

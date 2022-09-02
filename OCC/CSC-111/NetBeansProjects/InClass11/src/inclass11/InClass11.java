
package inclass11;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class InClass11
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        final int SIZE = 10;
        String [] letters = new String [SIZE];
        int index;
        Scanner input = new Scanner(System.in);
        
        for( index = 0; index < SIZE; index++)
        {
            System.out.print("Enter Letter #" + (index +1) + ": ");
            letters[index] = input.nextLine();
        }
        
        System.out.print("\n\n");
        
        for( index = 0; index < SIZE; index++)
        {
            System.out.println("Letter #" + (index +1) + " is " + letters[index]);
        }
        
        for( index = 0; index < SIZE; index++)
        {
            System.out.print(letters[index]);
        }
        
        System.out.print("\n\n");
    }
    
}

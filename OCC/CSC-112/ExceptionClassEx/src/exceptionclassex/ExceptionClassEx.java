package exceptionclassex;

import java.util.Scanner;

/**
 *
 * @author t.j.butler2
 */
public class ExceptionClassEx 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        boolean valid = false;
        
        while(!valid)
        {
            try
            {
                int value = GetInput();
                valid = true;
            }
            catch(EvennumException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static int GetInput() throws EvennumException
    {
        int input;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter an even integer: ");
        input = scan.nextInt();
        
        if(input % 2 != 0)
            throw new EvennumException();
        
        return input;
    }
}

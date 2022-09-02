package exceptionclasses;

import java.util.Scanner;

/**
 * 
 * @author Trev
 */
public class ExceptionClasses 
{
    /**
     * 
     * @param word password passed into method
     * @return
     * @throws NoDigit
     * @throws PasswordTooShort
     * @throws NoUpperCase
     * @throws NoLowerCase 
     */
    private static boolean ValidatePassword(String word) throws NoDigit, 
            PasswordTooShort, NoUpperCase, NoLowerCase
    {
        // Enforce min length of 8
        if(word.length() < 8){
            throw new PasswordTooShort();
        }
        
        // Check if there's a digit
        if(!word.matches(".*\\d.*"))
        {
            throw new NoDigit();
        }
        
        // Capital letter
        if(!word.matches(".*[A-Z].*"))
        {
            throw new NoUpperCase();
        }
        
        // Lowercase letter
        if(!word.matches(".*[a-z].*"))
        {
            throw new NoLowerCase();
        }
        
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String msg;
        Scanner scan = new Scanner(System.in);
        
        boolean passed = false;
        
        while(!passed)
        {
            // Gets users password
            System.out.print("Enter Your Password: ");
            msg = scan.nextLine();
            
            // Try/Catches Exceptions 
            try
            {
                passed = ValidatePassword(msg);
            }
            catch(NoDigit nd)
            {
                System.out.println(nd.getMessage());
            }
            catch(NoUpperCase nuc)
            {
                System.out.println(nuc.getMessage());
            }
            catch(NoLowerCase nlc)
            {
                System.out.println(nlc.getMessage());
            }
            catch(PasswordTooShort pts)
            {
                System.out.println(pts.getMessage());
            }
        }
        // Displays that password meets rquirements 
        System.out.println("Password Confirmed");
    }
}

/******************************************************************************
 * Program Name: CorrectChange
 * Author: Trevor Butler
 * Date: February 12, 2018
 * Course/Section: CSC-111-002
 * Program Description: Write an application that prompts for and reads a double
 * value representing a monetary amount. Then determine the least number of each
 * bill and coin needed to represent that amount, starting with the highest. 
 * Assume that ten dollars is the maximum size needed. 
 *****************************************************************************/
package correctchange;

import java.util.Scanner;

public class CorrectChange 
{
    /**************************************************************************
     * BEGIN CorrectChange
     *    Declare tenDollar as int
     *    Declare fiveDollar as int
     *    Declare oneDollar as int
     *    Declare quarter as double
     *    Declare dime as double
     *    Declare nickel as double
     *    Declare penny as double
     *    Declare moneyInput as double
     *    Declare scan as scanner
     *    Display "Enter an Amount of Money"
     *    Input moneyInput
     *    Calc number of tenDollar bills
     *    Calc the newBalance
     *    Calc number of fiveDollar bills
     *    Calc the newBalance
     *    Calc number of oneDollar bills
     *    Calc the newBalance
     *    Calc number of quarters
     *    Calc the newBalance
     *    Calc number of dimes
     *    Calc the newBalance
     *    Calc number of nickels
     *    Calc number of pennies
     *    Calc the newBalance
     *    Display Number of tenDollar bills
     *    Display Number of fiveDollar bills
     *    Display Number of oneDollar bills
     *    Display Number of quarters
     *    Display Number of dimes
     *    Display Number of nickels
     *    Display Number of pennys
     *    @param args        
     *************************************************************************/

    public static void main(String[] args) 
    {
        // Declare tenDollar as int
        int tenDollar;
        
        // Declare fiveDollar as int
        int fiveDollar;
        
        // Declare oneDollar as int
        int oneDollar;
        
        // Declare quarter as double
        double quarter;
        
        // Declare dime as double
        double dime;
        
        // Declare nickel as double
        double nickel;
        
        // Declare penny as double
        double penny;
        
        // Declare moneyInput as double
        double moneyInput;
        
        // Declare newBalance as int
        double newBalance;
        
        // Declare scan as scanner
        Scanner scan = new Scanner(System.in);     
        
        // Display "Enter an Amount of Money"
        System.out.print("Enter an Amount of Money: ");
        
        // Input moneyInput
        moneyInput = scan.nextDouble();

        // Calc number of tenDollar bills
        tenDollar = (int)(moneyInput/10);
            
        // Calc the newBalance
        newBalance = moneyInput-(tenDollar*10);

        // Calc number of fiveDollar bills
        fiveDollar = (int)(newBalance/5);

        // Calc the newBalance
        newBalance = newBalance-(fiveDollar*5);

           // Calc number of oneDollar bills
        oneDollar = (int)(newBalance/1);

        // Calc the newBalance
        newBalance = newBalance-(oneDollar*1);

        // Calc number of quarters
        quarter = (int)(newBalance/.25);

        // Calc the newBalance
        newBalance = newBalance-(quarter*.25);

        // Calc number of dimes
        dime = (int)(newBalance/.10);

        // Calc the newBalance
        newBalance = newBalance-(dime*.10);

        // Calc number of nickels
        nickel = (int)(newBalance/.05);

        // Calc the newBalance
        newBalance = newBalance-(nickel*.05);

        // Calc number of pennies
        penny = (int)(newBalance/.01);

        // Display Number of tenDollar bills
        System.out.println("Ten Dollar Bills: " + tenDollar);
        
        // Display Number of fiveDollar bills
        System.out.println("Five Dollar Bills: " + fiveDollar);
        
        // Display Number of oneDollar bills
        System.out.println("One Dollar Bills: " + oneDollar);
        
        // Display Number of quarters
        System.out.println("Quarters: " + quarter);
        
        // Display Number of dimes
        System.out.println("Dimes: " + dime);
        
        // Display Number of nickels
        System.out.println("Nickles: " + nickel);
        
        // Display Number of pennys
        System.out.println("Pennys: " + penny);
        
    }

}

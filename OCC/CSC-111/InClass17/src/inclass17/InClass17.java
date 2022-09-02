/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass17;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class InClass17 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int id;
        Scanner input = new Scanner(System.in);
        Bank myBank = new Bank();
        int menuChoice = 1;
        double amount;
        
        do 
        {
            System.out.println("Enter Account ID: ");
            id = input.nextInt();
            
            if(myBank.SetCurrentAccount(id))
            {
                System.out.println("Account Exists");
                while(menuChoice != 4) 
                {
                    System.out.println("1: Withdrawal");
                    System.out.println("2: Deposit");
                    System.out.println("3: Check Balance");
                    System.out.println("4: Exit");
                    menuChoice = input.nextInt();
                    
                    switch(menuChoice)
                    {
                        case 1: 
                            System.out.println("How Much Would You Like To Withdrawl?");
                            amount = input.nextDouble();
                            myBank.Withdrawal(amount);
                            System.out.println(myBank);
                            break;
                            
                        case 2:
                            System.out.println("How Much Would You Like To Deposit?");
                            amount = input.nextDouble();
                            myBank.Deposit(amount);
                            System.out.println(myBank);
                            break;
                        
                        case 3:
                            System.out.println(myBank.ShowBalance());
                            break;
                    }
                }
                menuChoice = 0;
            }
            else
            {
                System.out.println("There Is No Account With That ID");
            }
        }while(id > 0);
    }
    
}

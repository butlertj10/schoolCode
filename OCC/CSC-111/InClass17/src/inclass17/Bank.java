/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass17;

/**
 *
 * @author Trev
 */
public class Bank 
{
    private Account myAccount[] = new Account[5];
    private int numAccount;
    private int currentAccount;
    
    public Bank()
    {
        myAccount[0] = new Account(1111, 1000.10);
        myAccount[1] = new Account(2222, 2000.20);
        myAccount[2] = new Account(3333, 3000.30);
        myAccount[3] = new Account(4444, 4000.40);
        myAccount[4] = new Account(5555, 5000.50);
    }
    
    public boolean SetCurrentAccount(int number)
    {
        boolean found = false;
        int count = 0;
        while(!found && count < 6)
        {
           if(myAccount[count].getId() == number) 
           {
              currentAccount = number; 
              numAccount = count; 
              found = true;
           }
           count++;
        }
        return found;
    }
    
    public void Withdrawal(double amount)
    {
        myAccount[numAccount].Withdrawl(amount);
    }
    
    public void Deposit(double amount)
    {
        myAccount[numAccount].Deposit(amount);
    }
    
    public String ShowBalance()
    {
        String msg;
        msg = "Your Balance For Account Number Is: " + currentAccount + " is " + myAccount[numAccount].getBalance();
        return msg;
    }

    @Override
    public String toString() 
    {
        String msg;
        msg = "Bank{";
        
        for(int index = 0; index < 5; index++)
        {
            msg += myAccount[index].toString() + "\n";
        }
        
        msg += '}';
        
        return msg;
    }
    
    
}


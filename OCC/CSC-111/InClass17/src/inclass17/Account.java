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
public class Account 
{
    private int id;
    private double balance;
    
    public Account()
    {
        balance = 100.00;
    }
    
    public Account(int id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
        
    public double getBalance()
    {
        return balance;
    }
    
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    public void Withdrawl(double amount)
    {
        if(balance - amount < 0)
        {
            System.out.println("Not Enough Funds");
        }
        else
        {
            balance = balance - amount;
            System.out.println("Your New Balance Is: " + balance + "\n");
        }
    }

    public void Deposit(double amount)
    {
        balance = balance + amount;
        
        System.out.println("Your New Balance Is: " + balance + "\n");
    }
    
    @Override
    public String toString()
    {
        return "Account{" + "id:" + id + ", balance:" + balance + '}';
    }
}

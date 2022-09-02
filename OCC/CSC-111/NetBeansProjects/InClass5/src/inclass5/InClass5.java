/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass5;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class InClass5 {

    /**
     * @param args the command line arguments
     * 
     * Declare Variables 
     *      Declare choice as integer
     *      Declare numTickets as integer
     *      Declare finalCost as double
     *      Declare ticketCost as double
     * 
     * Display Menu
     *      Group of systems outs of the menu in description
     * 
     * Allow user to pick a choice
     *      Set choice to user input
     * 
     * Determine cost per ticket
     *      if choice is 1
     *          set ticketCost to 89.99
     *      else if choice is 2
     *          Set ticketCost to 80.99
     *      else if choice is 3
     *          Set ticketCost to 55.99
     *      else if choice is 4
     *          Set ticketCost to 30.99
     * 
     * Get number of tickets
     *      Displays "How Many Tickets Would You Like? "
     *      Set numTickets to user input
     * 
     * Calculate final cost
     *      finalCost = numTickets * ticketCost
     * 
     * Display final cost
     *      Display "Thank You for Using the Ticket Kiosk!", EOL
     *      Display "Your Total is: $", finalCost, EOL
     *      Display "Have a Nice Day!", EOL
     */
    public static void main(String[] args) 
    {
        // Declare Variables
        int choice;
        int numTickets;
        double finalCost;
        double ticketCost;
        Scanner input = new Scanner(System.in);
        
        // Display Menu
        System.out.println("Welcome to Wally World's Ticket Kiosk!");
        System.out.println("Please make you selections from the following menu.");
        System.out.println("1) Adult Ticket with Rides");
        System.out.println("2) Adult Ticket no Rides");
        System.out.println("3) Kids Ticket (12 and younger)");
        System.out.println("4) Senior Citizen Tickets (55 and over)");
        System.out.print("Please make selection: ");
        
        // Allow user to pick a choice
        choice = input.nextInt();
        
        // Determine to ticketCost
        if(choice == 1)
            ticketCost = 89.99;
        else if(choice == 2)
            ticketCost = 80.99;
        else if(choice == 3)
            ticketCost = 55.99;
        else
            ticketCost = 30.99;
        // END IF
        
        // Get number of tickets
        System.out.print("How Many Tickets Would You Like?: ");
        numTickets = input.nextInt();
        
        // Calculate final cost
        finalCost = numTickets * ticketCost;

        // Display final cost
        System.out.println("Thank You for Using the Ticket Kiosk!");
        System.out.println("Your Total is: $" + finalCost);
        System.out.println("Have a Nice Day!");
    }
    
}

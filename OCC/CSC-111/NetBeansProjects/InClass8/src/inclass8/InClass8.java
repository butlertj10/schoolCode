
package inclass8;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class InClass8 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
                // Declare Variables
        int choice;
        int numTickets;
        double finalCost;
        double ticketCost = 0;
        Scanner input = new Scanner(System.in);
        
        // Display Menu
        System.out.println("Welcome to Wally World's Ticket Kiosk!");
        System.out.println("Please Make Your Selections From the Following Menu.");
        System.out.println("1) Adult Ticket with Rides");
        System.out.println("2) Adult Ticket with No Rides");
        System.out.println("3) Kids Ticket (12 and Younger)");
        System.out.println("4) Senior Citizen Tickets (55 and Over)");
        System.out.println("5) Quit Kiosk");
        System.out.print("Please make selection: ");
        
        // Allow user to pick a choice
        choice = input.nextInt();
        
        while(choice != 5)
        {   
            // Determine which ticketCost
            switch (choice) 
            {
                case 1:
                    ticketCost = 49.99;
                    break;
                case 2:
                    ticketCost = 29.99;
                    break;
                case 3:
                    ticketCost = 24.99;
                    break;
                case 4: 
                    ticketCost = 19.99;
                default:
                    choice = 5;
                    break;
            }

            // Get number of tickets
            System.out.print("How Many Tickets Would You Like?: ");
            numTickets = input.nextInt();

            // Calculate final cost
            finalCost = numTickets * ticketCost;

            // Display final cost
            System.out.println("Thank You for Using the Ticket Kiosk!");
            System.out.println("Your Total is: $" + finalCost);
            System.out.println("Have a Nice Day! \n");

            // Display Menu
            System.out.println("Welcome to Wally World's Ticket Kiosk!");
            System.out.println("Please Make Your Selections From the Following Menu.");
            System.out.println("1) Adult Ticket with Rides");
            System.out.println("2) Adult Ticket with No Rides");
            System.out.println("3) Kids Ticket (12 and Younger)");
            System.out.println("4) Senior Citizen Tickets (55 and Over)");
            System.out.println("5) Quit Kiosk");
            System.out.print("Please make selection: ");
                   
            // Allow user to pick a choice
            choice = input.nextInt();
            
        } // END WHILE
        
        // Display End of Kiosk
        System.out.println("\nYou Have Quit the Kiosk!");
    }
    
}

package videogames;

import java.util.Scanner;

/******************************************************************************
 * Program Name: VideoGames
 * Author: Trevor Butler
 * Date: May 7, 2018
 * Course/Section: CSC-111-002
 * Program Description: Create a Class representing the information in one item 
 * of your database.  The information for one item must include a minimum of 3 
 * fields. Within the Class for one item, include the following methods:
 *  1. A constructor that accepts the information about one item and assigns 
 *      it to the instance data of the method.
 *  2. A method that prints the information about ONE item of your collection.
 *      Name this method toString. 
 * 
 * Create another Class with an Array of Objects of the Class of one item with 
 * the following methods:
 *  1. Instantiate an Array of the Objects from the Class of one item.
 *  2. Create a constructor to initialize the number of items in the array to zero.
 *  3. Create a method to add one item at a time to the array.
 *  4. Create a method to display the contents of the entire array.  
 *      Call this method toString.
 *  5. Create a method to increase the size of the array if it is getting full.
 * 
 *  Create a Driver Class with a Menu with the option to add an item, to print 
 *  out a list of all items, and exit. Before printing the menu, populate the 
 *  array by hard-coding the addition of 5 items to the array so that it has 
 *  items already in it at the time the menu is displayed. Test the menu by 
 *  printing out the array, adding more items to the array, and then printing 
 *  the array again. 
 *****************************************************************************/
public class VideoGames 
{
    /***************************************************************************
    * BEGIN Assignment 10 - VideoGames 
    * Declare Variables
    *   Create new game    
    *   Print out new game
    *   Create a collection of games and add them to collection
    *   Display Video Game Collection
    *   DO
    *       WHILE(menuChoice is not to quit)
    *           Ask/allow user to make a selection
    *           switch(menuChoice)
    *               case 1: 
    *                   Ask/allow user to enter each field of the video game   
    *                   Add game to the collection
    *               case 2:
    *                   Display collection of video games
    *               case 3:
    *                   Display that they have exited the menu
    *       END WHILE
    *   Resets menuChoice
    *   WHILE(menuChoice is not 0)
    * END Assignment 10 - VideoGames
    ***************************************************************************/
    public static void main(String[] args) 
    {       
        // Declare Variables
        Scanner input = new Scanner(System.in);
        int menuChoice = 1;
        String title;
        String rating;
        String type;
    
        // Create new game
        Game Mario = new Game("Mario", "E", "RPG");
        
        // Print out game
        System.out.println(Mario);
        
        // Create a collection of games
        GameCollection myCollection = new GameCollection();
        myCollection.addGame(Mario);
        myCollection.addGame("Dark Souls", "M", "RPG");
        myCollection.addGame("Bloodborne", "M", "RPG");
        myCollection.addGame("Rainbow Six Siege", "M", "Stratigic");
        myCollection.addGame("NHL 18", "E", "Sports");
        myCollection.addGame("Madden 18", "E", "Sports");
        
        // Display Video Game Collection
        System.out.println(myCollection);

        // DO
        do 
        {
            // WHILE(menuChoice is not to quit)
            while(menuChoice != 3) 
            {
                // Ask/allow user to make a selection
                System.out.println("\nPlease Make A Selection:\n");
                System.out.println("1: Add Game");
                System.out.println("2: Display Collection");
                System.out.println("3: Exit");
                System.out.print("\nSelection: ");
                menuChoice = input.nextInt();

                switch(menuChoice)
                {
                    case 1: 
                        // Ask/allow user to enter each field of the video game
                        System.out.print("\nEnter Game Title: ");
                        title = input.next();
                        System.out.print("Enter Game Rating: ");
                        rating = input.next();
                        System.out.print("Enter Game Type: ");
                        type = input.next();
                        
                        // Add game to the collection
                        myCollection.addGame(title, rating, type);
                        break;

                    case 2:
                        // Display collection of video games
                        System.out.println(myCollection);
                        break;

                    case 3:
                        // Display that they have exited the menu
                        System.out.println("\n---You Have Exited The Menu---");
                        break;
                }
            } // END WHILE
            // Resets menuChoice
            menuChoice = 0;

         // WHILE(menuChoice is not 0)
        }while(menuChoice != 0);
    }
    
}

package videogames;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class Menu 
{
    Scanner input = new Scanner(System.in);
    int menuChoice = 1;
    String title;
    String rating;
    String type;
    
   /* public Menu()
    {
        do 
        {
            System.out.println("Make A Selection:");
            while(menuChoice != 3) 
            {
                System.out.println("1: Add Game");
                System.out.println("2: Display Collection");
                System.out.println("3: Exit");
                menuChoice = input.nextInt();

                switch(menuChoice)
                {
                    case 1: 
                        System.out.println("Enter Game Title: ");
                        title = input.nextLine();
                        System.out.println("Enter Game Rating: ");
                        rating = input.nextLine();
                        System.out.println("Enter Game Type: ");
                        type = input.nextLine();
                        myCollection.addGame(title, rating, type);
                        break;

                    case 2:
                        System.out.println(myCollection);
                        break;

                    case 3:
                        System.out.println("You Have Exited The Menu");
                        break;
                }
            }
            menuChoice = 0;

        }while(menuChoice != 0);
    }*/
}


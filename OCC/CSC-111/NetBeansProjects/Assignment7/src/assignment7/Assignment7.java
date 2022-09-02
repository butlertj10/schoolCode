/*******************************************************************************
*Program Name   :   Assignment 07 - The Guessing Game
*Author         :   Trevor Butler
*Date           :   April 11th, 2018   
* Course/Section :   CSC 111 - 002 
*Program Description: Develop a program that simulates the high-low game. 
    * For each execution of the program, the game will generate a random    
    * number in the inclusive range of 1 to 100. The user will have up to 10
    * chances to guess the value. The program will keep track of all the user’s 
    * guesses in an array. For each guess, the program will tell the user if 
    * his/her guess was too high or too low. If the user is successful, the
    * program will stop asking for guesses, display the list of guesses, and
    * show a congratulatory message stating how many guesses he/she took. If the
    * user does not guess the correct answer within 10 tries, the program will 
    * display the list of guesses, and show him/her the correct value with a 
    * message stating that he/she was not successful. Regardless of the outcome,
    * the program will give the user a chance to run the program again with a
    * new random number.
*******************************************************************************/
      
package assignment7;

import java.util.Random;
import java.util.Scanner;

public class Assignment7 
{

    /********************************************************************
    *BEGIN Assignment 07 - The Guessing Game
    *   Declare Variables
    *   DO
    *       Call GetRandom Method and Set it to randomNum
    *       Display Title
    *       FOR (Each guess)
    *           Set guess to curretGuess
    *           Store guess in array
    *           IF (guess was correct)
    *               Set numGuesses = to MAX_GUESSES - 1
    *               Display Message that correct the correct number was guessed
    *           ELSE
    *               Call Results Method
    *           END IF
    *       END FOR
    *       Display Guess Title
    *       FOR (Each Value in the array)
    *           Display all guesses
    *       END FOR
    *       Display the correct Random Number
    *       Ask if user would like to try again
    *   WHILE (User did not quit)
    *   Display Message that The Guessing Game is over
    *END Assignment 07 - The Guessing Game
    ********************************************************************/
    public static void main(String[] args) 
    {
        // Declare Variables
        final int MAX_GUESSES = 10;
        final int lowVal = 1;
        final int highVal = 100;
        int randomNum;
        int currentGuess;
        String choice = "Y";
        int guesses [] = new int[MAX_GUESSES];
        
        // DO
        do
        {
            // Call GetRandom Method and Set it to randomNum
            randomNum = GetRandom(lowVal, highVal);
            
            // Display Title
            System.out.println("You Have Ten Guesses to Guess The Correct Number\n");

            // FOR (Each guess)
            for(int numGuesses = 0; numGuesses < MAX_GUESSES; numGuesses++)
            {
                // Set Guess to curretGuess
                currentGuess = UserGuess(lowVal, highVal);

                // Store guess in array
                guesses[numGuesses] = currentGuess;
                
                // IF (guess was correct)
                if (currentGuess == randomNum)
                {
                    // Set numGuesses = to MAX_GUESSES
                    numGuesses = MAX_GUESSES -1;
                    
                    // Display Message that correct the correct number was guessed
                    System.out.print("\nYou Guessed The Correct Number!\n");   
                }
                else
                {
                    // Call Results Method
                    Results(randomNum, currentGuess);
                    
                } // END IF
            } // END FOR
            
            // Dislpay Guess Title
            System.out.println("\nYour Guesses Were:");
            
            // FOR (Each Value in the array)
            for (int index = 0; index < MAX_GUESSES; index++)
            {
                // Display All Guesses
                System.out.println("Guess #" + (index + 1) + ": " + guesses[index]);
            }
            // END FOR
            
            // Display Random Number
            System.out.print("\nThe Correcr Answer Was: " + randomNum + '\n');
            
            // Ask if user would like to try again
            System.out.print("\nWould You Like to Try Again?\n");
            System.out.print("Enter 'Y' for Yes or 'N' for No: ");
            Scanner ans = new Scanner(System.in);
            choice = ans.next(); 
            System.out.print("\n");
        }
        
        // WHILE (User did not quit)
        while(!"N".equals(choice));
        
        // Display Message that The Guessing Game is over
        System.out.print("The Guessing Game Is Now Over! Thank You!\n\n");
    }
    
    /********************************************************************
    *Method Name    :   GetRandom
    *Author         :   Trevor Butler
    *Date           :   April 11th, 2018 
    *Program Description: A method that generates the random number to be 
    * guessed returns the random number to main. Two parameters are the two
    * numbers needed to generate the random number.
    *  
    *BEGIN GetRandom(int low, int high))
    *   Declare Variables
    *   Generate Random Number
    *   Return Random Number
    *END GetRandom(int low, int high)
    ********************************************************************/
    public static int GetRandom(int low, int high)
    {
        // Declare Variables
        int ranNum;
        
        // Generate Random Number
        Random generator = new Random ( );
        ranNum = generator.nextInt(high) + low;
        
        // Returm Random Number
        return ranNum;
    }

    /********************************************************************
    *Method Name    :   Results
    *Author         :   Trevor Butler
    *Date           :   April 11th, 2018 
    *Program Description: This method tells the user if the guess is too low or
    * too high. It will have 2 parameters one for the random number and the 
    * second is the user guess.  
    *  
    *BEGIN Results(int randomNumber, int guess)
    *   IF (guess is greater than randomNumber)
    *       Display guess was too high
    *   ELSE 
    *       Display guess was too low
    *   END IF
    *END Results(int randomNumber, int guess)
    ********************************************************************/
    public static void Results(int randomNumber, int guess)
    {
        // IF (guess is greater than randomNumber)
        if(guess > randomNumber)
        {
            // Display guess was too high
            System.out.println("The Guess " + guess + " Was Too High\n");
        }
        else
        {
            // Display guess was too low
            System.out.println("Guess " + guess + " Was Too Low\n");
        } // END IF
    }
    
    /********************************************************************
    *Method Name    :   UserGuess
    *Author         :   Trevor Butler
    *Date           :   April 11th, 2018 
    *Program Description: This method will get the user guess. It has 2 
    * parameters which will be the valid range the user should guess between. 
    * It will return the users guess as an integer. This method should validate 
    * that the users guess is between the two parameters.  
    *  
    *BEGIN UserGuess(int low, int high)
    *   Declare Variables
    *   Allow User to enter their guess
    *   WHILE (guess is not in range)
    *       Display Error message
    *       Ask user to input a valid guess
    *   END WHILE
    *   Return guess    
    *END UserGuess(int low, int high)
    ********************************************************************/
    public static int UserGuess(int low, int high)
    {
        // Declare Variables
        int guess;
        
        // Allow User to enter their guess
        System.out.print("Guess a Number between 1-100: ");
        Scanner input = new Scanner(System.in);
        guess = input.nextInt();
        
        // WHILE (guess is not in range)
        while(guess > 100 || guess < 1)
        {
            // Display Error message
            System.out.println("The Guess Entered Was NOT In The 1-100 Range!\n");
            
            // Ask user to input a valid guess
            System.out.print("Guess a Number between 1-100: ");
            guess = input.nextInt();
        }   // END WHILE
        
        // Return guess 
        return guess;
    }
}

/********************************************************************
*Program Name   : Extra Credit 01 - Unknown Number Array
*Author		    : Trevor Butler
*Date 	   	    : Oct 31, 2017
*Course/Section : CSC110-003
*Program Description: Write a program that will input an unknown
	number of integers and print out only those that are larger
	than the average. The most numbers you will input will be 
	10. You will have to use an array to store the integer values.
	Remember to have a title for your output page
*	
*BEGIN Extra Credit 01 - Unknown Number Array
*   Set Count = 0
*	Set Sum   = 0
*	Set Avg   = 0
*   Input first unknown value or quit value
*   WHILE (User did not enter the quit value) 
*      Store the value in the array at position Count
*	   Add Value to Sum
*      Increment Count by 1
*	   IF (the array has been filled)
*		  Clear Screen
*         Set the Input variable to the quit value
*         Output message indicating max inputs have been reached
*		  Pause Screen
*      ELSE 
*         Prompt the user for next input value or quit value
*      END IF
*   END WHILE 
*   Clear Screen
*	IF (No grades were entered)
*		Display error message
*	ELSE
*		Calculate Average
*   	Display Heading
*   	FOR (Each Value in Array)
*      		IF (Value is Greater than the Avgerage)
*				Display that value on its own line
*			END IF
*  		END FOR
*	END IF
*END Extra Credit 01 - Unknown Number Array
********************************************************************/
#include <iostream>

#include <iomanip>

#include <cstdlib>

using namespace std;

int main()

{
	//local constants
	const int QUIT        = -1;	// Value used to quit program
	const int MAX_NUMBERS = 10;	// Max quizzes that can be input in the array 

	//local variables	
	int Num_Value;				// Quiz input by user
	int Num_Count = 0;			// Counts number of quizzes which is initalized at zero
	int Numbers[MAX_NUMBERS];	// Quiz Array List
	int Sum = 0;					// Sum of all Numbers Input
	int Avg = 0; 					// Average of all Number Input
	
	/**************************start main program*********************/
	
	// Allows user to enter Quiz Value
	cout << "\n\n\n\n" << setw(57) << "Enter Number or Enter -1 to Quit: ";
	cin  >> Num_Value;
	
	// Checks for Valid Value or Quit Value
	while (Num_Value != QUIT)
	{
		// Stores the input in array at position count
		Numbers[Num_Count] = Num_Value;	
		
		// Calcualtes Sum of Numbers
		Sum += Num_Value;
		
		// Counts Numbers Entered
		Num_Count++;
			
		// Checks if array is full
		if(Num_Count == MAX_NUMBERS)
		{
			// Clears Screen
			system("cls");
			
			// Sets Value equal to quit value 
			Num_Value = QUIT;
			
			// Displays Max inputs have been reached
			cout << "\n\n\n\n" << setw(59) << "------------------------------------\n"
				 << setw(59) << "| Maximun Inputs Have Been Reached |\n"
				 << setw(62) << "------------------------------------\n\n\n\n";
			
			// Pauses screen until user presses a key
			system("pause");
		}	
		else 
		{
			// Display Message and Input Numbers
			cout << "\n" << setw(57) << "Enter Number or Enter -1 to Quit: ";
			cin  >> Num_Value;
			
		} // End if
		
	} // End While

	// Clear Output Screen
	system("cls");
	
	// Checks if any values were entered
	if(Num_Count == 0 && Num_Value == -1)
	{
		// Displays message when no values were entered 
		cout << "\n\n\n\n\n" 
			 << setw(54) << "--------------------------\n"
			 << setw(54) << "| No Values Were Entered |\n"
			 << setw(59) << "--------------------------\n\n\n\n\n\n";
	}
	else
	{
		// Calculate Average of inputs
		Avg = (Sum / Num_Count);
		
		// Displays Title
		cout << "\n\n\n\n" << setw(57) << "Numbers Greater Than The Avgerage\n" 
			 << setw(57) << "---------------------------------\n";
	
		// Displays grades	 
		for(int Position = 0;  Position < Num_Count; Position++)
		{
			// If Numbers in the Array are Greater Than the Avgerage 
			if(Numbers[Position] > Avg)
			{
				// Print out Numbers Greater than Avgerage
				cout << setw(41) << Numbers[Position] << "\n";
		
			} // End if
			
		}// End For
		
	}// End if
	
	// Return 0 to Operating Systems
	return 0;
	
} // End Main Program

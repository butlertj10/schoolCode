/**********************************************************************
*Program Name   :   CSC 110 Lab 03 - Array Input Using Sentinel
*Author         :   Trevor Butler 
*Due Date       :   10/26/17
*Course/Section :   CSC 110 - 003 
*Program Description: Write a program to input an unknown number of
*   values into an empty array.  It is important that the array
*   not have any values in it that you want saved prior to 
*   implementing this code
*
*BEGIN Lab 03 - Array Input Using Sentinel Value
*   Set Count = 0
*   Input first value or quit value
*   WHILE (User did not enter the quit value) 
*      Store the input in the array at position Count
*      Increment Count by 1
*		IF (the array has been filled)
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
*   ELSE
*   	Display Heading
*   	FOR (Each value in the array)
*      		Display that value on its own line
*   	END FOR
*   END IF
*	Return 0 to System
*END Lab 03 - Array Input Using Sentinel Value
 *********************************************************************/
#include <iostream>

#include <iomanip>

#include <cstdlib>

using namespace std;

int main()

{
	//local constants
	const int QUIT        = -1;	// Value used to quit program
	const int MAX_QUIZZES = 5;	// Max quizzes that can be input in the array 

	//local variables	
	int Quiz_Value;				// Quiz input by user
	int Quiz_Count = 0;			// Counts number of quizzes which is initalized at zero
	int Quizzes[MAX_QUIZZES];	// Quiz Array List
	
	/**************************start main program*********************/
	
	// Allows user to enter Quiz Value
	cout << "\n\n\n\n" << setw(58) << "Enter Quiz Value or Enter -1 to Quit: ";
	cin  >> Quiz_Value;
	
	// Checks for Valid Value or Quit Value
	while (Quiz_Value != QUIT)
	{
		// Stores the input in array at position count
		Quizzes[Quiz_Count] = Quiz_Value;	
		
		// Counts Number of Values Entered
		Quiz_Count++;
			
		// Checks if array is full
		if(Quiz_Count == MAX_QUIZZES)
		{
			// Clears Screen
			system("cls");
			
			// Sets Value equal to quit value 
			Quiz_Value = QUIT;
			
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
			cout << "\n" << setw(58) << "Enter Quiz Value or Enter -1 to Quit: ";
			cin  >> Quiz_Value;
			
		} // End if
		
	} // End While

	// Clear Output Screen
	system("cls");
	
	// Checks if any values were entered
	if(Quiz_Count == 0 && Quiz_Value == -1)
	{
		// Displays message when no values were entered 
		cout << "\n\n\n\n\n" 
			 << setw(54) << "--------------------------\n"
			 << setw(54) << "| No Values Were Entered |\n"
			 << setw(59) << "--------------------------\n\n\n\n\n\n";
	}
	else
	{
		// Displays Title
		cout << "\n\n\n\n" << setw(48) << "Entered Grades\n" 
			 << setw(48) << "--------------\n";
	
		// Displays grades	 
		for(int Position = 0;  Position < Quiz_Count; Position++)
		{
			cout << setw(41) << Quizzes[Position] << "\n";
		}
		
	}// End if
	
	// Return 0 to Operating Systems
	return 0;
	
} // End Main Program

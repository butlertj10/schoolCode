/********************************************************************
*Program Name   : Program 01 - Quiz Calculator
*Author		    : Trevor Butler
*Date 	   	    : Oct 17, 2017
*Course/Section : CSC110-003
*Program Description: Create a program that will calculate the quiz
	averages that are between 0-20 and display and error message 
	if the grade is not in the range. The lowest grade will be dropped 
	if five or more quizes are taken. Display the nuber of quizzes
	(includeding the quiz that was dropped), lowest grade, and the 
	average rounded to the integer out of 100.
*
*BEGIN Program 01 -Calc Quiz Average
*	int Num_Quizzes = 0
*	int Total = 0 
*	Input Quiz Grade
*	WHILE (QUIZ != QUIT)
*		IF (Quiz_Grade is valid) 
*		   Add Quiz_Grade to total
*		   Add 1 to Num_Quizzes 
*		   IF (Quiz_Grade is lowest so far)
*			  store grade in lowest
*		   END IF
*		ELSE
*		   Display error
*		END IF
*	    Input Quiz_Grade or Quit 
*	END WHILE
*	IF (Num_Quizzes is less than zero)
*	   Drops Lowest Quiz Grade if there are More Than 5 Quizzes
*	   IF (Number of quizzes is greater than or equal to quiz drop)
*		  Calculates Avgerage With Dropping Lowest
*	   ELSE
*		  Calculates Avgerage Without Dropping Lowest
*	   END IF
*	   	  Display Grade Report (AVG , Low, #)
*  	ELSE
*  	   Display error message if none were input 
*	END IF
*END Program 01 - Calc Quiz Average
********************************************************************/
#include <iostream>
#include <iomanip>
#include <cstdlib>

using namespace std;

int main()

{

	// Local Constants
	const int MIN_GRADE 	= 0;  //Minimun Grade that can be input 
	const int MAX_GRADE 	= 20; //Max Grade that can be input 
	const int MIN_QUIZ_DROP = 5;  //Number of quizzes that will allow a drop
	const int QUIT 			= -1; // Value that quits input screen
	
	// Local Variables
	int Quiz_Grade;			// Input quiz grade
	int Avg_Quiz_Grade;		// Avgerage Quiz Grade
	int Total = 0;			// All Grades added together
	int Num_Quizzes = 0;	// Number of quizzes input by user
	int Lowest_Grade = 20;	// Lowest Quiz Grade
	
	/**************************start main program*********************/

	// Input Quiz Grade
	cout << "\n\n\n\n\n" 
	<< setw(66) << "Input Quiz Grade or Input -1 to Display Grade Report: ";
	cin  >> Quiz_Grade;
	
	// Determines Whether to Quit or Continue
	while (Quiz_Grade != QUIT)
	{	
		// Check if Quiz Grade is Valid
		if (Quiz_Grade <= MAX_GRADE && Quiz_Grade >= MIN_GRADE)
		{
			Total += Quiz_Grade;
			Num_Quizzes++;
		
			// Checks if Input Grade is the lowest Grade
			if (Quiz_Grade < Lowest_Grade)
		    {
		    	
			//Stores lowest grade
			Lowest_Grade = Quiz_Grade;
			
			}//END IF
		}
		else
	   	{
	  		// Display Error if Grade is not in the 0-20 Range
			cout << "\n" << setw(60) << "--------------------------------------\n"
			<< setw(60) <<	"| Error: Grade Is Not In Range (0-20)|\n" 
			<< setw(60) << "--------------------------------------\n";
		} // End if
	
	// Inputs New Quiz Grade or -1 to Quit and Display
	cout << "\n"
	<< setw(66) << "Input Quiz Grade or Input -1 to Display Grade Report: ";
	cin  >> Quiz_Grade;
	} // End While

	// Clear Output Screen
	system("cls");
	
	// Check if Any Inputs Were entered
	if (Num_Quizzes > 0)
	{
		// Drops Lowest Quiz Grade if there are More Than 5 Quizzes
		if (Num_Quizzes >= MIN_QUIZ_DROP)
		{
			// Calculates Avgerage With Dropping Lowest
			Avg_Quiz_Grade = (Total - Lowest_Grade)/(Num_Quizzes - 1) * 5;
		}
		else
		{
			// Calculates Avgerage Without Dropping Lowest
			Avg_Quiz_Grade = (Total)/(Num_Quizzes) * 5;
		} //End if
		
		// Display Grade Report (AVG , Low, #)
		cout << "\n\n\n\n\n\n"  
		<< setw(50) << "Quiz Grade Report\n"
		<< setw(51) << "-----------------\n\n"
		<< setw(49) << "Number Of Quizzes : " << setw(3) << Num_Quizzes << "\n"
		<< setw(49) << "Lowest Quiz Grade : " << setw(3) << Lowest_Grade << "\n"
		<< setw(49) << "Average Quiz Grade: " << setw(3) << Avg_Quiz_Grade << "\n\n\n\n";
	}
	else
	{
		// Display error message if none were input 
		cout << "\n\n\n\n\n\n" << setw(53) << "------------------------\n"
		<< setw(53) << "| No Grades Were Input |\n" 
		<< setw(52) << "------------------------"
		<< "\n\n\n\n";	
	} // End if 
	
	// Return 0 to Operating Systems
	return 0;
	
} // End Main Program

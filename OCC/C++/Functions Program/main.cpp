/********************************************************************
*Program Name   :   Function Program - Baseball Average
*Author         :   Trevor Butler
*Date           :   December 8th, 2017
*Program Description: Create a program that will display baseball players 
*	names (just last names) and averages. The most players
*	you would have to process is 10. Input the players 
*	last name, at-bats, and hits. A player's average is
*	calculated by dividing the player's hits by the
*	number of at-bats. Averages are generally displayed 
*	to 3 decimal points.  For any player, if the number
*	of hits exceeds the number of at-bats, display an error message.
*
*BEGIN Function Program - Baseball Average
*   Input a player's last name or QUIT to quit
*	Input that player's at-bats and hits
*	Clear Screen
*   WHILE (Name entered is not QUIT or Count does not equal 10)
*		IF (at-bats is greater than or equal to hits)
*			Display an error message
*		ELSE
*			Store Player's name in name array
*			Call Avgerage function and store average in average array
*			Add one to count
*		END IF
*   	Input a player's last name or QUIT to quit
*		Input that player's at-bats and hits
*		Clear Screen
*   END WHILE
*   Call function to Display Team Batting Averages
*END Function Program - Baseball Average
 ********************************************************************/
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

// Place Prototypes Here
float bat_avg(float, float);
void display_averages(int&, string[], float[]);

int main()
{
	//local constants
	const string QUIT  = "QUIT"; // String to Quit the Program
	const int MAX_PLAYERS = 10;     // Max size of the array
	
	//local variables
	string Names[MAX_PLAYERS];	// Array of Player's name
	float Avg[MAX_PLAYERS];		// Array of Player's avgerage
	int Player_Count = 0;	// Number of PLayers entered
	string Player_Name;		// Name of player entered 
	float At_Bat;				// Number of at-bats entered
	float Hits;				// Number of hits entered
	
	/*************************************************************/
	
	// Allows user to input a player's last name or QUIT to quit
	cout << "\n" 
		 << setw(67) << "Please Enter Player's Last Name or Enter 'QUIT' to Quit\n"
		 << setw(66) << "-------------------------------------------------------"
		 << "\n\n" << setw(22) << "Last Name: ";
	cin >> Player_Name;
	
	// Clear Screen
	system("cls");
	
	// WHILE the Name entered is not QUIT
	while(Player_Name != "QUIT")
	{
		// Allows user to input that player's at-bats and hits
		cout << "\n"
			 << setw(57) << "Please Enter Player's Statistics\n"
			 << setw(56) << "--------------------------------" 
			 << "\n\n" << setw(42) << "At-Bats: ";
		cin >> At_Bat;
		cout << "\n" << setw(42) << "Hits: ";
		cin >> Hits;
	
		// Clear Screen
		system("cls");
	
		// IF (at-bats is greater than or equal to hits)
		if(At_Bat >= Hits)
		{			
			// Stores Player's name in name array
			Names[Player_Count] = Player_Name;
			
			// Calls Avgerage function and stores average in average array
			Avg[Player_Count] = bat_avg(At_Bat, Hits);

			// Adds one to count
			Player_Count++;
		}
		else
		{
			// Displays an error message
			cout << "\n\n\n\n" << setw(60) << "---------------------------------------\n" 
			     << setw(60) << "| At-bats Cannot Be Greater Than Hits |\n"
			     << setw(64) << "---------------------------------------\n\n\n\n\n";
			
			// Pause Screen
			system("pause");
			
			// Clear Screen
			system("cls");
			
		}// END IF
		
		// If the array has not been filled
		if (Player_Count != MAX_PLAYERS)
		{
			// Allows user to input a player's last name or QUIT to quit
			cout << "\n" 
				 << setw(67) << "Please Enter Player's Last Name or Enter 'QUIT' to Quit\n"
				 << setw(66) << "-------------------------------------------------------"
				 << "\n\n" << setw(22) << "Last Name: ";
			cin >> Player_Name;
			
			// Clear Screen
			system("cls");
		}	
		else
		{	
            // Set the Player Name equal to the quit value
            Player_Name = "QUIT";
           
		    // Output message indicating max inputs have been reached
		    cout << "\n\n\n\n" << setw(62) << "-----------------------------------------\n" 
			     << setw(62) << "| Maximum Inputs (10) Have Been Reached |\n"
			     << setw(66) << "-----------------------------------------\n\n\n\n\n" ;
		   
		    // Pause Screen
		    system("pause");
		    
		    // Clear Screen
		    system("cls");
		}
	
	}// END WHILE

	//Call function to Display Team Batting Averages
	display_averages(Player_Count, Names, Avg);

} // END main

/********************************************************************
*Function Name  :   Calculate Average
*Author         :   Trevor Butler
*Date           :   December 8th, 2017
*Program Description: This function will calculate the batting
*	 average using the number of at-bats and hits. 
*
*BEGIN Calculate Average (int bats, int hits)
*   Calculate batting average
*   Return the result of calculation
*END Calculate Average (int bats, int hits)
********************************************************************/
#include <cmath>
 
float bat_avg(float bats, float hits)
{
	// Local Constants
	
	// Local Variables
	float Avg;	// Where calc_avg stores answer
	
	/**********************************************************/
	
	// Calculates batting average and stores average
	Avg = hits/bats;
	
	// Return the result of the calculation
	return Avg;
	
} // END calc_avg

/********************************************************************
*Function Name  :   Display Team Averages
*Author         :   Trevor Butler
*Date           :   December 8th, 2017
*Program Description: This function will display the names
*	of each player that was entered along with their batting 
*	average. The title of this screen will be, "Team Batting 
*	Avgerages".
*
*BEGIN Display Team Averages
*   Clear the screen
*   Display the titles
*	FOR each postion in the array 
*		Display the Names and Averages
*		Increment the Display number by one
*	END FOR 
*   Pause the screen
*   Clear the screen
*END Display Team Averages
********************************************************************/
 
void display_averages(int& Player_Count, string Names[], float Avg[])
{
	// Local Constants
	
	// Local Variables
	int Display_Count = 1; 	// Display Counter
	
	/**********************************************************/
	
	// Clear Sceen
	system("cls");
	
	// Display the titles
	cout << "\n\n\n" << setw(50) << "Team Batting Averages\n"
		 << setw(51) << "---------------------\n\n"
		 << setw(29) << "Player" << setw(27) << "Average\n"
		 << setw(29) << "------" << setw(27) << "-------\n";
		 
	// Display Player's Name and Average on its own numbered line
	for (int Position = 0; Position < Player_Count; Position++)
	{
		// Displays the Names and Averages on screen
		cout << setw(22) << Display_Count << ":" << setw(8) << Names[Position]
			 << setw(18) << Display_Count << ":" << fixed << setprecision(3) << setw(6) << Avg[Position] << "\n";
		
		// Increment the Display number by one
		Display_Count++;

	}// END FOR 

} // END display_closing

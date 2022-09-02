/********************************************************************
 *Program Name   :   Function Practice - find a cube
 *Author         :   Trevor Butler
 *Date           :   November 30th, 2017
 *Program Description: This program will find the cube of any number. 
 *   the number will be input from the user and then passed into 
 *   a cube function where the number will be raised to the 3rd power.
 *   That result will be displayed on the screen. This program will
 *   continue to find and display cubes until a sentinel value is 
 *   entered.
 *
 *BEGIN Function Practice - find a cube
 *   Input a number or 0 to quit
 *   WHILE (number entered is not QUIT)
 *       Call function to find cube of the input number
 *       Call function to display the cube
 *       Input next number or 0 to quit
 *   END WHILE
 *   Clear Screen
 *   Call function to Display departing message
 *END Function Practice - find a cube
 ********************************************************************/

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

// Place Prototypes Here
int calc_cube(int);
void display_closing();
int display_cube(int);

int main()
{
	//local constants
	int QUIT = 0;			// Value that allows user to quit
	
	//local variables
	int Num = 0;			// Number entered by user 
	int Calc_Cube_Val;		// Value of the calculated cube
	int Cube_Display;		// Value of the cube to be displayed 
	
	/*************************************************************/
	
	// Input a number or 0 to quit
	cout << "\n\n\n\n\n\n\n\n\n\n\n" << setw(57)
		 << "Enter a Number or Enter 0 to Quit: ";
	cin >> Num;
	
	// while number entered is not QUIT
	while(Num != QUIT)
	{
		// Call function to find cube of the input number
		Calc_Cube_Val = calc_cube(Num);
		
		// Call function to display the cube
		display_cube(Calc_Cube_Val);
 		
		// Input next number or 0 to quit
		cout << "\n\n\n\n\n\n\n\n\n\n\n" << setw(57)
		     << "Enter a Number or Enter 0 to Quit: ";
		cin >> Num;
		
	}// END WHILE
 
 	// Clear Screen
 	system("cls");
 	
	// Call function to Display departing message
	display_closing();
	
	// Return 0 to system
	return 0;
	
} // END main

/********************************************************************
 *Function Name  :   Calculate Cube
 *Author         :   Trevor Butler
 *Date           :   November 30th, 2017
 *Program Description: This program will find the cube of any number. 
 *   the number will be received as a parameter.  It will then be 
 *   raised to the 3rd power and the result will be returned to the
 *   calling function.
 *
 *BEGIN Calculate Cube (int Num)
 *   Calculate Num to the 3rd power
 *   Return the result of calculation
 *END Function Practice - find a cube
 ********************************************************************/
 #include <cmath>
 
	int calc_cube(int Val)
	{
		// Local Constants
		int POWER = 3;	// Exponent of the equation 
		
		// Local Variables
		int Cube;		// Where calc_cube stores answer
		
		/**********************************************************/
		
		// Calculates Num to the third power and stores answer
		Cube = pow(Val , POWER);
		
		// Return the result of the calculation
		return Cube;
		
	} // END calc_cube	
	 
 /********************************************************************
 *Function Name  :   Display Cube
 *Author         :   Trevor Butler
 *Date           :   November 30th, 2017
 *Program Description: This program will display the value of 
 *		a cube after the cube has been calculated.
 *
 *BEGIN Display Cube
 *   Clear the screen
 *   Display the Cube Value
 *   Pause the screen
 *   Clear the screen
 *END Function Practice - find a cube
 ********************************************************************/
 
int display_cube(int Cube)
{
	// Local Constants
	
	// Local Variables
	
	/**********************************************************/
	
	// Clear Sceen
	system("cls");
	
	// Display the closing message
	cout << "\n\n\n\n\n\n\n" << setw(46) << "The Value Cubed is: "
		 << setw(4) << Cube << "\n\n\n\n\n\n";
	
	// Pause Sceen
	system("pause");
	
	// Clear Sceen
	system("cls");
	
} // END display_closing

/********************************************************************
 *Function Name  :   Display Closing
 *Author         :   Trevor Butler
 *Date           :   November 30th, 2017
 *Program Description: This program will display a closing message to
 *   the user.  It will first clear the screen, then display the 
 *   message.  The message will include the Authors name and be big
 *   and bold.  
 *
 *BEGIN Display Closing
 *   Clear the screen
 *   Display the closing message
 *   Pause the screen
 *   Clear the screen
 *END Function Practice - find a cube
 ********************************************************************/
 
void display_closing()
{
	// Local Constants
	
	// Local Variables
	
	/**********************************************************/
	
	// Clear Sceen
	system("cls");
	
	// Display the closing message
	cout << "\n\n\n\n\n\n\n" 
		 << setw(65) << "------------------------------------------------\n" 
		 << setw(65) << "| The Author of this Program was Trevor Butler |\n" 
		 << setw(64) << "------------------------------------------------" << "\n\n\n\n\n\n\n";
	
	// Pause Sceen
	system("pause");
	
	// Clear Sceen
	system("cls");

} // END display_closing

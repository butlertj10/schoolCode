/************************************************************************
*Program Name   :   CSC 110 Lab 04 - Square Root/Exponentiation Function
*Author         :   Trevor Butler 
*Due Date       :   11/16/17
*Course/Section :   CSC 110 - 004 
*Write a program that will allow the user to either do exponentiation
*	or find the square root of a number. Ask the user which operation 
*	to perform. Then prompt the user for the correct number(s) needed
*	to perform the calculation. Display the square root to 2 decimal
*	places and the result of exponentiation as an integer. If the
*	user enters an incorrect operation then display an error instead
*	of the result. The user should enter ‘E’ – exponentiation,
*	‘S’ for square root, or ‘Q’ to quit.  Allow the user to keep
*	entering in operations until the ‘Q’ is entered.
*
*BEGIN Lab 04 - Square Root/Exponentiation Function
*	Ask User to input either S, E, or Q
*	Make the input letter uppercase
*	Clear Screen
*	WHILE (User did not enter Q) 
* 		IF (Letter does not equal S or E)
*			Set Letter equal to Q
*			Display Message that wrong operator was input
*			Pause and Clear Screen
*		ELSE
*			IF (Letter equals S)
*				Ask user to input Sqrt_Base
*				Preform Operation with the input number
*				Set answer equal to Sqrt_Ans
*				Clear Screen
*				Display Title and Answer
*				Pause Screen and Clear Screen
*	 		ELSE
*				Ask user to input Base and Exp
*				Preform Operation with the input numbers
*				Set answer equal to Exp_Ans
*				Clear Screen
*				Display Title and Answer
*				Pause Screen and Clear Screen
*			END IF
*		END IF
*		Ask User to input either S, E, or Q
*		Make the input letter uppercase
*		Clear Screen
*	END WHILE
*	Display a message that the user has quit the progam
*	Return 0 to System		
*END Lab 04 - Square Root/Exponentiation Function
 ***********************************************************************/
#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <cmath>

using namespace std;

int main()
{
	//local constants
	const char QUIT = 'Q';  // assigns QUIT to letter Q
	const char SQRT = 'S';  // assigns SQRT to the letter S
	const char EXP = 'E';   // assigns EXP to the letter E

	//local variables	
	float Sqrt_Ans; // The Answer of the square root
	int Sqrt_Num;   // The base of the square root
	int Base_Num;   // The base of the exponent
	int Exp_Num;	// The number the base is raised to 
	int Exp_Ans;	// The Exponentiation Answer
	char Letter; 	// The Letter the useer inputs
	
	
	/**************************start main program*********************/

	// Asks User to input either S, E, or Q
	cout << "\n\n\n\n\n\n\n\n\n\n\n" << setw(73) 
		 << "Enter 'E' for Exponentiation, 'S' for Square Root, or 'Q' to Quit: ";
	cin  >> Letter;
	
	// Turns lower case letter into an uppercase letter
	Letter = toupper(Letter);
	
	// Clears Screen
	system("cls");

	// While Quit has not been entered
	while (Letter != QUIT)
	{
		// IF Letter does not equal S or E
		if (Letter != SQRT && Letter != EXP)
		{
		
			// Set Letter equal to Q
			Letter = QUIT;
	
			// Display Message that wrong operator was input
			cout << "\n\n\n\n\n\n\n\n\n"
				 << setw(62) << "-------------------------------------------\n" 
				 << setw(62) << "| Program Does Not Support That Operation |\n" 
				 << setw(61) << "-------------------------------------------" 
				 << "\n\n\n\n\n\n\n\n";
			
			// Pauses Screen 
			system("pause");
			
			// Clears Screen
			system("cls");
		}
		else
		{
			// IF Letter equals S
			if (Letter == SQRT)
			{
				// Asks user to input Sqrt_Base
				cout << "\n\n\n\n\n\n\n\n\n\n\n" << setw(55) 
					 << "Input Base of the Square Root: ";
				cin  >> Sqrt_Num;
				
				// Preforms Operation with the input number
				Sqrt_Ans = sqrt(Sqrt_Num);
				
				// Clear Screen
				system("cls");
			
				// Displays Title and Answer
				cout << "\n\n\n\n\n\n\n\n\n\n\n" <<  setw(42) << "Square Root of " 
					 << Sqrt_Num << " equals " << fixed << setprecision(2) 
					 << Sqrt_Ans << "\n\n\n\n\n\n\n\n";
	
			// Pauses Screen 
			system("pause");
			
			// Clears Screen
			system("cls");
			
			}
			else	
			{
				// Asks user to input Base and Exp
				cout << "\n\n\n\n\n\n" << setw(55) << "Enter a Base and Exponent \n" 
					 << setw(55) << "-------------------------\n\n" << setw(43) << "Base: ";
				cin  >> Base_Num;
				cout << "\n" << setw(45) << "Exponent: ";
				cin  >> Exp_Num;
			
				// Preforms Operation with the input numbers
				Exp_Ans = pow(double(Base_Num), double(Exp_Num));
				
				// Clears Screen
				system("cls");
	
				// Display Title and Answer
				cout << "\n\n\n\n\n\n\n\n\n" << setw(26) << Base_Num 
					 << " to the Power of " << Exp_Num << " equals " 
					 << Exp_Ans << "\n\n\n\n\n\n\n\n";
				
			// Pauses Screen 
			system("pause");
			
			// Clears Screen
			system("cls");
				
			} // END IF
			
		} // END IF
		
		// Asks User to input either S, E, or Q
		cout << "\n\n\n\n\n\n\n\n\n\n\n" << setw(73) 
			 << "Enter 'E' for Exponentiation, 'S' for Square Root, or 'Q' to Quit: ";
		cin  >> Letter;
		
		// Turns lowercase letter into an uppercase letter
		Letter = toupper(Letter);	
		
		// Clear Screen
		system("cls");
		
	} // END WHILE	
	
	// Displays Message that program has quit
	cout << "\n\n\n\n\n\n\n\n\n" << setw(55) << "-----------------------------\n" 
		 << setw(55) << "| You Have Quit The Program |\n" 
		 << setw(54) << "-----------------------------" << "\n\n\n\n\n\n\n\n";
	
	// Returns 0 to System
	return 0;
	
} // End main program

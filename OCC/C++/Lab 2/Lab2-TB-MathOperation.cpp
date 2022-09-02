/********************************************************************
*Program Name : Lab 2 - Perform Math Operation
*Author : Trevor Butler
*Date : Sept 26, 2017
*Course/Section : CSC110-003
*Program Description: Create a program that will calculate the sum, difference, 
	or product of two numbers based on which math operator and numbers 
	are input by the user. Display an error message if the 
	math operator is not supported by the program.
*
*BEGIN Lab 02 - Preform/display Math Operation
*
*   Input 2 integers
*   Input 1 Math Operaton
*   Clear Screen
*   IF (MathOp is Valid)
*	   IF (MathOp == MULT)
*		 Ans = Product of two numbers
*      ELSE IF (MathOp == ADD)
*		 Ans = sum of two numbers
*      ELSE
*		 Ans = difference of two numbers 
*      END IF
*      Display Equation with Answer
*   ELSE
*      Display error message 
*   END IF	
*
*END Lab 02 - Preform/display Math Operation

********************************************************************/
#include <iostream>

#include <iomanip>

#include <cstdlib>

using namespace std;

int main()

{

	//local constants
	const char MULT = '*';
	const char ADD  = '+';
	const char SUB  = '-';
	
	//local variables
	int Num1; 		//First number input by user
	int Num2;		//Second number input by user
	char MathOp;	//Math operator input by user
	int Ans;		//Answer of operation

	/**************************start main program*********************/
	
	//Input 2 integers
	cout << "\n\n\n\n"
		 << setw(58) << "Input Two Integers to Calculate: \n";
	cout << setw(45) << "Number 1: ";
    cin  >> Num1;
    cout << setw(45) << "Number 2: ";
    cin  >> Num2;
    
	//Input 1 Math Operator		
	cout << "\n\n"   
		 << setw(70) << "Input Math Operator You Would Like To Use ( * , + , - ): \n"  
		 << setw(47) << "Math Operator: ";
	cin  >> MathOp;
	
	//Clear Screen
	system("cls");
	
	//Determine if math operator is valid
	if (MathOp == MULT || MathOp == SUB || MathOp == ADD)
	{
	    //Prefrom its correct operation
		if (MathOp == MULT)
			Ans = Num1 * Num2;
		else if (MathOp == ADD)
			Ans = Num1 + Num2;
		else
			Ans = Num1 - Num2;

	    //Display Equation with Answer
		cout << "\n\n\n\n\n\n"
		 
		 << setw(57) << "Calculated Answer and Equation\n" 
		 << setw(58) << "------------------------------\n\n"<< setw(37) << Num1  
		 << " " << MathOp << " "  << Num2 << " = "  << Ans 
		<< "\n\n\n\n\n";
    }
	//Display Error Message if MathOp cannot be found
	else
		cout << "\n\n\n\n\n\n"  
			 << setw(41) << "Math Operation (" << MathOp << ") is Not Supported By This Program \n\n\n\n\n\n";

	//return 0 to the operating systems
	return 0;

} 	//End main program

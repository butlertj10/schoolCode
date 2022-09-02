#include <iostream>
#include <ctime>
#include <iomanip>
#include <cstdlib>
using namespace std;

int main() 
{
	// local Constants
	int MAX_ARRAY = 25; // Max Array Value
	int MAX_VALUE = 9;  // Max Value Number
	
	// Local Variable
	int Ran_Num;			 // Random Number Generated
	int Insert_Num; 		 // Amount if numbers that will be inserted  
	int Random[MAX_ARRAY];   // Quiz Array List 
	int Counting_Num;		 // Number to Count
	int Count_Num = 0;		 // Number of times Counting_Num has been counted
	
	/**************************start main program*********************/
	srand(time(0));
	
	// Create a Random Number 
	Insert_Num = rand() % MAX_ARRAY;
	
	// Print Out Title
	cout << "\n\n\n\n" << setw(48) <<"Random Numbers\n"<< setw(48)<<"--------------\n";
	
	// Set New Random Generated Values in Their Positon
	for(int Position = 0; Position < Insert_Num; Position++)
	{
		// Gives Each position a random value 
		Random[Position] = rand() % MAX_VALUE + 1;
		cout << setw(41) << Random[Position] << "\n";
		
	}
	
	// Allow User to See Numbers 
	system("pause");
	
	//Clear Screen
	system("cls");
	
	// Let User Enter a Number 1-9
	cout << "\n\n\n" << setw(50) << "Enter a Number 1-9: ";
	cin >> Counting_Num;
	
	//Clear Screen
	system("cls");
	
	//Checks if Number is from 1-9
	if(Counting_Num <= 9 && Counting_Num >= 1)
	{
		
		// Counts how many times the entered number appers 
		for(int Pos = 0; Pos < Insert_Num; Pos++)
		{
			// Checks if number in array is equal to Counting_Num then adds one
			if(Random[Pos] == Counting_Num)
				Count_Num++;
		}
		
		// Display Count_Num
		cout << "\n\n\n\n" << setw (42) << "Number of Times " << Counting_Num
			<< " Appeared: " << setw (1) << Count_Num << "\n\n\n";
	}
	else
	{
		// Displays message that entered value was not from 1-9
		cout << "\n\n\n\n" << setw(58) << "---------------------------------\n" 
			<< setw(58) << "| Number Was Not In Range (1-9) |\n"
			<< setw(57) << "---------------------------------";
	}

	// Return Zero to systems
	return 0;
}

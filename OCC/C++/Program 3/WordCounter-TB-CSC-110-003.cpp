/************************************************************************
*Program Name   :   CSC-110 Lab 05 - Phrase Word Counter
*Author         :   Trevor Butler 
*Due Date       :   11/22/17
*Course/Section :   CSC-110 - 003 
*Write a program that will allow the user to enter a phrase
*	of any length with any amount of spaces in between words.
*	Then count how many words are in that particular phrase. 
*	Display the phrase and the number of words when finished.
*
*BEGIN Lab 05 - Phrase Word Counter
*	Prompt User to Enter a Phrase or Quit
*	WHILE (Phrase is not Equal to QUIT)
*		Clear Screen
*		IF Phrase Does Not End With a Space
*			Add a space at the end of the phrase
*		END IF
*		Get Length of Phrase
*		FOR  Each Character in the Given Phrase
*			IF Pos is Greater than Zero and char before is not a space
*				Add one to The Number of Words
*			END IF
*			IF There are Multiple Spaces in the Phrase
*				Create a New Phrase With Only Single Spaces
*			END IF
*		END FOR
*		Display the New Phrase and Number of Words in it 
*		Pause Screen
*		Clear Screen
*		Clear The Current Phrase
*		Reset Number of Words to Zero
*		Ask User to Enter a Phrase or Quit
*	END WHILE
*	Clear Screen
*	IF Phrase equals Quit
*		Display Message That Program Has Been Quit
*	END IF
*	Return 0 to the System
*END Lab 05 - Phrase Word Counter
 ***********************************************************************/
#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <string>

using namespace std;

int main()
{
	//local constants
	const string QUIT 	  = "QUIT"; // String to Quit the Program
	const int RESET_VALUE = 0; 	    // Value to Reset Num_Word

	//local variables	
	string Phrase;	   // Hold Original Phrase
	string New_Phrase; // Hold The New Phrase		
	int Length; 	   // Holds Length of Phrase
	int Num_Words = 0; // Counts number of words
	
	/**************************start main program*********************/

	// Prompt User to Enter a Phrase or Quit
	cout << "\n\n\n\n\n" << setw(57) << "Enter a Phrase or 'QUIT' to Quit\n\n" << "Phrase: ";
	getline(cin, Phrase);

	// While the Phrase is not Equal to QUIT
	while (Phrase != "QUIT")
	{
		// Clear Screen
		system("cls");
		
		// If Phrase Does Not End With a Space, Add a Space
		if(Phrase.at(Phrase.length()-1) != ' ' )
		{
			// Add a Space to the end of the Phrase
			Phrase = Phrase + " ";
		
		} // END IF
	
		// Gets Length of Phrase
		Length = Phrase.length();
	
		// Cycles Through Each Character in the Given Phrase
		for(int Pos = 0; Pos < Length; Pos++)
		{
			// Counts The Words in the Phrase
			if(Pos > 0 && (Phrase.at(Pos) == ' ' && Phrase.at(Pos-1) !=  ' '))
			{
				// Adds one to The Number of Words
				Num_Words++;
				
			} // END IF
			
			// Gets Rid of Multiple Spaces in the Phrase
			if(!(Pos != Length-1 && (Phrase.at(Pos) == ' ' && Phrase.at(Pos+1) == ' ')))
			{ 
				// Creates New Phrase With Only Single Spaces
				New_Phrase += Phrase.at(Pos);
				
			} // END IF
			
		} // END FOR
		
		// Displays the New Phrase and Number of Words in it 
		cout << "\n\n\n\n\n\n" << setw(47) << "Your Phrase is\n" << setw(48) 
			 << "--------------\n\n" << setw((80-New_Phrase.length())/2+New_Phrase.length()) 
			 << New_Phrase << "\n\n\n\n" << setw(33) << "There are " << Num_Words 
			 << " Words In This Phrase " << "\n\n\n\n\n\n\n";
			
		// Pauses Screen
		system("pause");
			
		// Clear Screen
		system("cls");
		
		// Clear The Current Phrase
		New_Phrase.clear();
		
		// Resets Number of Words to Zero
		Num_Words = RESET_VALUE;
			
		// Prompt User to Enter a Phrase or Quit
		cout << "\n\n\n\n\n" << setw(57) << "Enter a Phrase or 'QUIT' to Quit\n\n" << "Phrase: ";
		getline(cin, Phrase);
		
	} // END WHILE
	
	// Clear Screen
	system("cls");
	
	// Checks if Phrase is Equal to Quit
	if(Phrase == "QUIT")
	{
		// Displays Message That Program Has Been Quit
		cout << "\n\n\n\n\n\n\n" << setw(55) << "-------------------------------\n"
			 << setw(55) << "| You Have Exited The Program |\n"
			 << setw(54) << "-------------------------------"
			 << "\n\n\n\n\n\n\n";
	
	} // END IF
	
	// Returns 0 to the System
	return 0;
	
} // End Main Program

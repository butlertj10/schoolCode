/**********************************************************
    * Function Name  : Main
    * Author         : Trevor Butler
    * Date           : 11/21/17
    * Course/Section : CSC110 - 003
    * Program Description:
    *
    * BEGIN Main
    *    prompt the user to input a phrase that has more than 1 word in it
    *    display the length of the phrase
    *    IF (the phrase is > 10 characters)
    *        display only the first 10 characters centered on the screen
    *    ELSE
    *        display the entire phrase centered on the screen
    *    END IF
    *    display the third character of the phrase
    *    display the index of the first space in the phrase
    *    get the first word from the phrase and display the word
    *    remove first word from phrase - store in new phrase
    *    display the new phrase
    * END Main
    **********************************************************/

#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <string>
#include <algorithm> 

using namespace std;

int main()
{
	//local constants
	const int MAX = 10;

	//local variables	
	string Phrase;
	int Space;
	int Length; 
	string First;
	string New_Phrase;
		
	/**************************start main program*********************/
	
	cout << "Enter a Phrase: ";
	getline(cin , Phrase);
	
	Length = Phrase.length();
	
	cout << "\n"<< "Length: " << Length;
	
	if (Length > MAX)
	{
		cout << "\n\n" << "First 10 Characters of the Phrase: "; 
		for ( int Pos = 0; Pos < MAX; Pos++)
		{
			cout << Phrase.at(Pos);
		}
	}
	else
	{
		cout << "\n\n" << "Entire Phrase: " << Phrase;
	
	}
	
	cout << "\n\n" << "Third Character of the Phrase is: " << Phrase.at(2);
	
	Space = Phrase.find(" ");
	cout << "\n\n" << "First Space in Phrase is Located at Position: " << Space;
	
	First = Phrase.substr(0,Space);
	cout << "\n\n" << "First Word of Phrase is: " << First;
	
	New_Phrase = Phrase.substr(Space + 1,Length-(Space + 1));
	cout << "\n\n" << "New Phrase is: " << New_Phrase;
}

	

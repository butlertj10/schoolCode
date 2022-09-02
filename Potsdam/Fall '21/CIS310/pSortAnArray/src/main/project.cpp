/**
 * pSortAnArray sorts an Array of Strings in C++ 
 *
 * pSortAnArray prompts the user to enter sentences until they reach the max
 *  size or they can also enter 'QUIT' to stop entering sentences. Then the 
 *  program will take the array of entered sentences, and display them unsorted.
 *  Then they will be passed to a sort function to be sorted then displayed 
 *  again but now sorted.
 *
 * @author Trevor Butler
 * @email butlertj203@potsdam.edu
 * @course CIS 310 Operating Systems
 * @assignment pSortAnArray
 * @due 09/05/2021
 */

#include <iostream>

using namespace std;


/**
 * arraySort takes in an array of strings and a number of elements.
 *  It then creates a temporary array to hold values as each string 
 *  is compared to each other. After each string has been compared 
 *  and moved, the array will be sorted in ascending order of length. 
 * 
 * @param sentences
 * @param numElements
 * 
*/
void arraySort(string sentences[], int numElements)
{
    for (int i = 1; i < numElements; i++)
    {
        string temp = sentences[i];

        int j = i - 1;
        while (j >= 0 && temp.length() < sentences[j].length())
        {
            sentences[j + 1] = sentences[j];
            j--;
        }
        sentences[j + 1] = temp;
    }
}


/**
 * printSort takes in an array of strings and a number of elements. 
 *  It then uses a for loop to iterate through the array printing
 *  out each string from 0 to the final element of the array.
 * 
 * @param sentences
 * @param numElements
 * 
 */
void printSort(string sentences[], int numElements)
{
    // Iterate the array and print out each element
    for (size_t i = 0; i < numElements; i++)
    {
        cout << "S" << (i + 1) << ": " << sentences[i] << "\n";
    }
}


/**
 * main is where the user is prompted to enter in sentences to the array.
 *  After each sentence is entered it is input to an array at the count 
 *  postion. Once the max entries are entered or the sential is entered,
 *  the array will be displayed showing the order they were entered in.
 *  Then they will be sorted and redisplayed showing the sentences sorted
 *  in ascending order.
 * 
 * @return 0
 */
int main()
{
    //local constants
    const int MAX_ENTRIES = 19;
    const string SENTINAL = "QUIT";

    //local variables
    std::string enteredString = "";
    std::string sentences[MAX_ENTRIES];
    int count = 0;

    /**************************start main program*********************/

    // Allow users to enter their sentences
    cout << "Please enter a sentence then press enter to continue entering sentences, if you would like to quit enter 'QUIT'. \n\n";
    while (count < MAX_ENTRIES)
    {
        count++;
        cout << "Sentence " << count << ": ";
        getline(cin, enteredString);

        if (enteredString == SENTINAL)
        {
            break;
        }

        sentences[count - 1] = enteredString;
    }

    // Display message why sentences are no longer being entered
    if (count == (MAX_ENTRIES))
    {
        cout << "\n\n-------- You have entered the maximum entries, " << MAX_ENTRIES << ". Your sentences will now be sorted! --------\n";
    }
    else if (sentences[count].compare(SENTINAL) != 0)
    {
        cout << "\n\n-------- You have decided to quit entering sentences, your sentences will now be sorted! --------\n";
    }

    // Print presort, sort, print postsort
    cout << "\nThese are the sentences you entered BEFORE the sort: \n";
    printSort(sentences, count);
    arraySort(sentences, count);
    cout << "\nThese are the sentences you entered AFTER the sort: \n";
    printSort(sentences, count);

    return 0;
}
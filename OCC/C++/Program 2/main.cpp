/**********************************************************************
*Program Name   :   CSC 110 Lab 04 - Area of Circle Array
*Author         :   Trevor Butler 
*Due Date       :   11/7/17
*Course/Section :   CSC 110 - 004 
*Program Description: Write a program that will calculate the
*	area of a group of circle. The most circles we will process is 15.
*	Input the radius of the circle. If the radius is between 5 and 10
*	then store both the radius and the area into the array. The user
*	may have no circles, 15 circles, or somewhere inbetween. When
*	you are all done processing, display the calcualted areas 
*	and radii back to the screen.
*
*BEGIN Lab 04 - Area of Circle Array 
*	Set Circ_Count = 0
*   Input Radius value or quit value
*   WHILE (User did not enter the quit value) 
*	   IF (Radius is between 5-10)
*      	   Calculate area
*	   	   Store Area value in its array
*	   	   Store Radius value in its array
*          Increment Circ_Count by 1
*	   ELSE
*		   Display Message that values were not in range
*      END IF
*	   IF (the array has not been filled)
*           Prompt the user for next Radius value or quit value
*      ELSE
*		    Clear Screen
*           Set the Radius variable to the quit value
*           Output message indicating max inputs have been reached
*		    Pause Screen
*		    Clear Screen
*	   END IF
*   END WHILE 
*   Clear Screen
*	IF (No Circles were entered)
*		Display message that no circles were entered
*   ELSE
*   	Display Radius and Area Headings
*   	FOR (Each value in the arrays)
*      		Display Radius value on its own numbered line
*			Display Area value on its own numbered line
*   	END FOR
*   END IF
*	Return 0 to System
*END Lab 04 - Area of Circle Array
 *********************************************************************/
#include <iostream>

#include <iomanip>

#include <cstdlib>

#include <math.h>

using namespace std;

int main()

{
	//local constants
	const int QUIT        = -1;	// Value used to quit program
	const int MAX_CIRCLES = 15;	// Max Circles that can be input in the array 
	const int MIN_CIRCLES = 0;	// Max Circles that can be input in the array 
	const double PI = 3.1415926535897;

	//local variables	
	float Radius;				// Radius input by user
	float Area;				    // Calculated Area
	int Display_Count = 1;		// Display Counter
	int Circ_Count = 0;			// Counts number of Circles which is initalized at zero
	int Radii[MAX_CIRCLES];	    // Radius Array List
	int Areas[MAX_CIRCLES];		// Area Array List
	
	/**************************start main program*********************/
	
	//Input Radius value or quit value
	cout << "\n\n\n\n" << setw(54) << "Input a Radius or Quit Value: ";
	cin >> Radius;
	
	// While user did not enter the quit value
    while (Radius != QUIT) 
    { 	
        // Radius is between 5-10
		if (Radius <= 10 && Radius >= 5)
		{
			// Calculate Area
			Area = pow(Radius,2)*PI;
			
			// Store Area value in its array
			Areas[Circ_Count] = Area;
			
	   	    // Store Radius value in its array
	   	    Radii[Circ_Count] = Radius;
	   	   
	        // Increment Circ_Count by 1
	        Circ_Count++;
	    }
	    else
		{
		
		   // Display Message that values were not in range
		   cout << "\n" << setw(58) << "----------------------------------\n" 
		        << setw(58) << "| Value Entered Was Not In Range |\n"
				<< setw(58) << "----------------------------------\n";	
		   
   	    } // END IF
		
		// The array has not been filled
		if (Circ_Count != MAX_CIRCLES)
		{
            //Input Radius value or quit value
			cout << "\n" << setw(54) << "Input a Radius or Quit Value: ";
			cin >> Radius;
		}
		else
		{
		    // Clear Screen
		    system("cls");
		    
            // Set the Radius variable to the quit value
            Radius = QUIT;
           
		    // Output message indicating max inputs have been reached
		    cout << "\n\n\n\n" << setw(59) << "------------------------------------\n" 
			     << setw(59) << "| Maximum Inputs Have Been Reached |\n"
			     << setw(59) << "------------------------------------\n" ;
		   
		    // Pause Screen
		    system("pause");
		    
		    // Clear Screen
		    system("cls");

      } // END IF
      
	} // END WHILE 
	
	// Clear Screen
	system("cls");

    // If no circles were entered
	if (Circ_Count != MIN_CIRCLES)
	{
		// Display Radius and Area Headings
		cout << setw(31) << "Radius" << setw(25) << "Area\n"
			 << setw(31) << "------" << setw(25) << "----\n";
	
		for (int Position = 0; Position < Circ_Count; Position++)
		{
			// Display Radius and Area value on its own numbered line
			cout << setw(27) << Display_Count << ": " << Radii[Position] 
			<< setw(22) << right << Display_Count << ": " << Areas[Position] << "\n";
			
			// Increment the Display number by one
			Display_Count++;

    	}// END FOR
    	
	}// END IF
	
	else
	{
		
	// Display message that no circles were entered
	cout << "\n\n\n\n\n" << setw(55) << "---------------------------\n" << setw(55) << "| No Circles Were Entered |\n"
		 << setw(58) << "---------------------------\n\n\n\n";
	
    }// END IF
    
	// Return 0 to System
	return 0;
	
} // End Program
	
	
	
	
	
	

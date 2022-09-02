/********************************************************************

*Program Name : Lab 1 - Sales Report

*Author : Trevor Butler

*Date : Sept 12, 2017

*Course/Section : CSC110-003

*Program Description: Create a program that will calculate the % of items sold by 3 sales employees. For each employee,

*    input the first three letters of his/her first name and the number of items they sold. Calculate the total items 

*    sold and then the % of items sold by each employee. A sample display of the results is provided below.

*

*BEGIN Lab 01 - Calc/Display Sales Report

*

* Input 3 Names

* Input 3 Items Sold

* Clear Screen

* Calcualte Total Items Sold

* Calculate % Sold For Each Name

* Display Sales Report

*

*END Lab 01 - Calc/Display Sales Report

********************************************************************/

#include <iostream>

#include <iomanip>

#include <cstdlib>

using namespace std;

int main()

{

	//local constants

	//local variables
    string Name1;       //Employee Name 1
    string Name2;       //Employee Name 2
    string Name3;       //Employee Name 3
    int Items_Sold1;  //Number of items sold by employee 1
    int Items_Sold2;  //Number of items sold by employee 2
	int Items_Sold3;  //Number of items sold by employee 3
	int Total;          //Total number of items sold
	float Percent1;     //Precent of items sold by employee 1
	float Percent2;     //Precent of items sold by employee 2
	float Percent3;     //Precent of items sold by employee 3
 
/**************************start main program*********************/

	//Input 3 Names
    cout << "\n\n\n"
         << setw(66) << "Input The First Three Letters of Employee's Name: \n";
    cout << setw(39) << "1. ";
    cin  >> Name1;
    cout << setw(39) << "2. ";
    cin  >> Name2;
    cout << setw(39) << "3. ";
    cin  >> Name3;

	//Input 3 Items Sold
    cout << "\n\n"
	     << setw(66) << "Input The Number of Items Sold By Each Employee: \n";
    cout << setw(40) << "1. ";
	cin  >> Items_Sold1;
    cout << setw(40) << "2. ";
    cin  >> Items_Sold2;
    cout << setw(40) << "3. ";
    cin  >> Items_Sold3;

	//Clear the screen

	system("cls");

	//Calcualte Total Items Sold
    Total = Items_Sold1 + Items_Sold2 + Items_Sold3;
    
	//Calculate % Sold For Each Name
	Percent1 = (Items_Sold1/ (float)Total) * 100.0;
	Percent2 = (Items_Sold2/ (float)Total) * 100.0;
	Percent3 = (Items_Sold3/ (float)Total) * 100.0;
	 
	//Display Sales Report
    cout <<  fixed   << showpoint << setprecision(1);
	cout << "\n\n\n" << setw(52) << "Quarterly Sales Report\n\n";
    cout << setw(19) <<  "Name"  << setw(25) << "Items Sold" << setw(23) << "Pct Sold\n"
    	 << setw(19) <<  "----"  << setw(25) << "----------" << setw(24) << "--------\n\n"
    	 << setw(18) <<  Name1   << setw(22) <<  Items_Sold1 << setw(26) << Percent1 << "\n"
    	 << setw(18) <<  Name2   << setw(22) <<  Items_Sold2 << setw(26) << Percent2 << "\n"
		 << setw(18) <<  Name3   << setw(22) <<  Items_Sold3 << setw(26) << Percent3 << "\n\n"
		 << setw(21) << "Total:" << setw(19) <<    Total     << setw(28) << "100.0\n\n";
	//return 0 to the operating systems

	return 0;

} 	//End main program

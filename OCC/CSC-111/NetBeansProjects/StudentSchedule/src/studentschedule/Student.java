/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentschedule;
import java.lang.Object;

/**
 *
 * @author Trev
 */
public class Student 
{
    private final int MAX_COURSES = 6;
    
    public String studentName;
    public String studentID;
    public String streetAddress;
    public String city;
    public String state;
    public String zipCode;
    public String major;



    private int totalCredits;
    private int numberCourses;
    private String schedule[];
    
    public Student(String name, String id, String address, String c, String s, String zip, String m)
    {
        studentName = name;
        studentID = id;
        streetAddress = address;
        city = c;
        state = s;
        zipCode = zip;
        major = m;
        
        totalCredits = 0;
        numberCourses = 0;
        schedule = new String[MAX_COURSES];
    }
    
    public String toString()
    {
        String msg = "";
        
        msg += "Student Name: " + studentName + "\n";
        msg += "Student ID: " + studentID + "\n";
        msg += "Street Adress: " + streetAddress + "\n";
        msg += "City: " + city + "\n";
        msg += "State: " + state + "\n";
        msg += "Zip Code: " + zipCode + "\n";
        msg += "Major: " + major + "\n";
        
        return msg;
    }
    
    public String DisplaySchedule()
    {
        String msg = "";
        
        msg += "Student Schedule\n";
        
        for(int index = 0; index < MAX_COURSES; index++)
        {
            if(schedule[index] != null)
            {
                msg += schedule[index] + "\n";
            }
        }
        
        return msg;
    }
    
    public int TotalCredits()
    {
        return totalCredits;
    }
    
    private boolean CheckCredits(int credits)
    {
        boolean result = false;
        
        if((totalCredits + credits) <= 18)
            result = true;
        
        return result;
    }
    
    public void AddCourse(String courseName, int numCredits)
    {
        if(numberCourses < 6)
        {
            if(CheckCredits(numCredits))
            {
                schedule[numberCourses] = courseName + " " + numCredits;
                numberCourses++;
                totalCredits += numCredits;
            }
        }
    }
    
    public void DropCourse(String courseNameRemove)
    {
        /**************************************************************************
        *  Declare Variables
        *  WHILE(course is not found OR you have reached the last course in array)
        *       IF(index is less than number of courses)
        *           IF(course was found)
        *               FOR(course to be removed to end of array)     
        *                   copy course into previous position
        *               END FOR
        *               Clear last element of array
        *               Display that the course was removed
        *               Set found equal to true  
        *           END IF
        *           increment index and newCourseNumber by 1
        *       END IF
        *   END WHILE
        *   FOR (each value in the array)
        *       Adds up course credits throughout array
        *   END FOR
        *   Prints new number of courses and credits 
        *   IF(course was not found)
        *       Display message that course was not found
        *   END IF
        **************************************************************************/
        // Declare Variables
        int index = 0;
        boolean found = false;
        int newCourseNum = 0;
        int newCourseCredits;
        int totalCourseCredits = 0;
        
        //  WHILE(course is not found OR you have reached the last course in array)
        while(!(found) && index != numberCourses)
        {
            // IF(index is less than the number of courses)
            if(index < numberCourses)
            {
                // IF course was found
                if((schedule[index].substring(0,6)).equalsIgnoreCase(courseNameRemove))
                {   
                    // FOR(course to be removed to end of array)
                    for(int target = index; target < numberCourses - 1; target++)
                    {
                        // copy course into previous position
                        schedule[target] = schedule[target + 1];   
                    } // END FOR
                    
                    // Clears last elment of array
                    schedule[numberCourses-1] = "";
                    
                    // displays that the course was removed
                    System.out.println("\nThe Course " + courseNameRemove + 
                            " Was Removed!");

                    // set found equal to true
                    found = true;
                    
                } // END IF
                
                // increment index and newCourseNumber by 1
                index++;  
                newCourseNum++;
                
            } // END IF
        } // END WHILE   

        // FOR each value in the array
        for(index = 0; index < newCourseNum - 1; index++)
        {
            // Adds up course credits throughout array
            newCourseCredits = Integer.parseInt(schedule[index].substring(7));
            totalCourseCredits += newCourseCredits;
        }
        
        // Prints new number of courses and credits
        System.out.println("New Number Of Courses: " + (index - 1) + "\n");
        System.out.println("New Number Of Credits: " + totalCourseCredits + "\n");
        
        // IF course was not found
        if(found == false)
        {
            // displays message that course was not found
            System.out.println("\nThe Course " + courseNameRemove + " You Were "
                    + "Trying To Remove Was Not Found!");
        } // END IF
    }
   
    public void searchCourse(String courseName)
    {
        /**************************************************************************
        *  Declare Variables
        *  WHILE(course is not found OR you have reached the last course in array)
        *       IF(index is less than number of courses)
        *           IF(course was found)
        *               Display that course was found with corresponding credits
        *               Set found to true
        *               increment index by 1
        *           END IF
        *       END IF
        *   END WHILE
        *   IF(course was not found)
        *       Display message that course was not found
        *   END IF
        **************************************************************************/
        // Declare Variables
        int index = 0;
        boolean found = false;
        String courseCredits;

        //  WHILE(course is not found OR you have reached the last course in array)
        while(!(found) && index != numberCourses)
        {
            // IF(index is less than the number of courses)
            if(index < numberCourses)
            {
                // IF course was found
                if((schedule[index].substring(0,6)).equalsIgnoreCase(courseName))
                {               
                    courseCredits = schedule[index].substring(7);
                    System.out.println("\nThe Course " + courseName + " Was Found!"
                          + "\n" + "This Course Is " + courseCredits + " Credits.");
                    found = true;
                } // END IF
                
                index++;
            } // END IF
        } // END WHILE            
        // IF course was not found
        if(found == false)
        {
            // display message that course was not found
            System.out.println("\nThe Course " + courseName + " Was Not Found!");
        } // END IF
    }
}

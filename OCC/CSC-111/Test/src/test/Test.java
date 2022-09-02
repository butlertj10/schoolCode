/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Trev
 */
public class Test 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int index = 0;
        String courseName = "CSC111";
        final int MAX_COURSES = 6;
        String[] schedule = {"CSC111 4" , "CSC112 4", "MAT161 4", "ENG104 5", "GEO101 5"};
        
        while(!((schedule[index].substring(0,5)).equalsIgnoreCase(courseName)) || index != 4)
        {
            // search through all values in the array 
            for(index = 0; index < 4; index++)
            {          
                // if course was found
                if((schedule[index].substring(0,5)).equalsIgnoreCase(courseName))
                {               
                    String courseCredits = courseName.substring(7);
                    System.out.println("The Course " + courseName + " Was Found!"
                            + "This Course Is " + courseCredits + " Credits.");
                }

            }
        }            
            // if course was not found
            if(!((schedule[index].substring(0,5)).equalsIgnoreCase(courseName)))
            {
                System.out.println("The Course " + courseName + " Was Not Found!");
            }

    }
    
}

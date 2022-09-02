package testdie;

import java.util.Random;

/********************************************************************
*Program Name   :   Assignment 8 - Rolling Die
*Author         :   Trevor Butler
*Date           :   April 23rd, 2018
*Program Description: Create four separate methods in the class Die that will 
* perform each of the following tasks.
*   1. Roll one die and return the value.
*   2. Return the sum of a pair of dice rolled.
*   3. Roll a pair of dice and return a true if doubles has been rolled.
*   4. Roll a pair of dice and return the face value if doubles has been rolled
 ********************************************************************/
public class Die 
{
    private int face;
    private Random gen;
    boolean result;
    
    /******************************************
    *   public Die()
    * 
    *   Generate number on die
    *   Call roll()
    ******************************************/
    public Die()
    {
        gen = new Random();
        roll();
    }
    
    /******************************************
    *   public int roll()  
    * 
    *   generate number on die
    *   return roll value
    ******************************************/
    public int roll()
    {
        // generate number on die    
        face = gen.nextInt(6)+1;
        
        // returns roll value
        return face;
    }
    
    /******************************************
    *   public int sum(int first, int second)
    * 
    *   set total equal to first plus second
    *   return total
    ******************************************/
    public int sum(int first, int second)
    {
        int total;
       
        // gets sum of the two faces
        total = first + second;
        
        return total;
    }
    
    /******************************************
    *   public boolean isDoubles(int first, int second)
    * 
    *   IF(Both numbers were equal)
    *       set result equal to true
    *   ELSE
    *       set value equal to 0
    *   END IF
    *   return value
    ******************************************/
    public boolean isDoubles(int first, int second)
    {   
        boolean result;
        
        // IF(both rolls were equal)
        if(first == second)
        {
            result = true;
        }
        else 
        {
            result = false;
        } // END IF
        
        return result;
    }
    
    /******************************************
    *   public int faceValue(int first, int second)
    * 
    *   IF(doubles are rolled)
    *       set double value equal to value
    *   ELSE
    *       set value equal to 0
    *   END IF
    *   return value
    ******************************************/
    public int faceValue(int first, int second)
    {
        int value;
        // IF(doulces are rolled)
        if(isDoubles(first, second) == true)
        {
            value = first;
        }
        else
        {
            value = 0;
        } // END IF
        
        return value;
    }
}

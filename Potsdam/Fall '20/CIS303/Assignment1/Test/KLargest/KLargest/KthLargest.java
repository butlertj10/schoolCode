/**
 * @author Trevor J. Butler
 * @email butlertj203@potsdam.edu
 * @course CIS 303 Analysis of Algorithms
 * @Assignment 1 Kth Largest
 * @due 09/10/2020
*/

import java.util.*;
import java.io.*;

public class KthLargest {

    
    public static int kthLargest(int [] a, int k, PrintStream ps) {

        // Do not modify this line
        long start = System.currentTimeMillis();

        int[] sorted = new int[k];
        int iterator = 0;
        int checkValue = -99;

        /** Loops through the array k times where  each element in 
         * a[] is checked. If the value is larger than the value 
         * to be checked, the value will be added to a new array.
         * Then checks to see if the value not the known largest
         */
        while (iterator < k) 
        {
            for (int x = 0; x < a.length; x++) 
            {
                if (a[x] > checkValue) 
                {
                    for (int y = 0; x < k; x++) 
                    {
                        if (a[x] != sorted[y]) 
                        {
                            checkValue = a[x];
                        }
                    }
                }
            }

            //set values in array
            sorted[iterator] = checkValue;
            iterator++;
        }

        // Do not modif these 3 lines
        long stop = System.currentTimeMillis();
        long time = stop-start;
        ps.println(k + "\t" +   time);
        
        return sorted[sorted.length - 1]; // Change the return value to something appropriate
    }
  
}   

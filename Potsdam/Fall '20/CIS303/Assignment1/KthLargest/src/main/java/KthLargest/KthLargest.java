/*
    CIS 303 Algorithm Analysis and Design
    Assignment 1: KthLargest class
 
    Update this block with your information.
*/

import java.util.*;
import java.io.*;

public class KthLargest {

    
    public static int kthLargest(int [] a, int k, PrintStream ps) {

        // Do not modify this line
        long start = System.currentTimeMillis();
        
        // ///////////////////////////////////////////////////
        // Put your kthLargest  implementation here
        // ///////////////////////////////////////////////////

        int[] sorted = new int[k];
        int iterator = 0;
        // loops through program k times
        while (iterator < k) {
            int highest = 0;
            // loops through all the array
            for (int i = 0; i < a.length; i++) {
                // checks if the value in the array is larger 
                if (a[i] > highest) {
                    // loops through all elements in the ktracker array
                    for (int n = 0; i < k; i++) {
                        // finds largest that is not the already known largest
                        if (a[i] != sorted[n]) {
                            highest = a[i];
                        }
                    }
                }
            }

            //set values in array
            sorted[iterator] = highest;
            iterator++;
        }

        // Do not modif these 3 lines
        long stop = System.currentTimeMillis();
        long time = stop-start;
        ps.println(k + "\t" +   time);
        
        return sorted[sorted.length - 1]; // Change the return value to something appropriate
    }
  
}   

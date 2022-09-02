/*  **************************************************************
 CIS 303 Algorithm Analysis and Design
 Assignment 1: TimeTestKthLargest class
 Author: S. Haller, modified 8/2020 L. Grabowski
 
 This class tests time efficiency of the KthLargest class
 implementation by timing the algorithm with successively larger
 values of k in a large array. The program writes the value of
 k and the corresponding time (in ms) to a file, data.txt.
 
 Usage:
 1. Compile with KthLargest.java and TestKthLargest.java
 javac *.java
 2. To run:
 java TimeTestKthLargest <array size>
 where <array_size> is the size of the data array,
 5000 <= array_size <= 100000. Note that for larger array sizes,
 the program may take a few minutes to run.
 **************************************************************
 */

import java.io.*;

public class TimeTestKthLargest {

    public static void main (String [] args) throws Exception{    
	PrintStream ps = new PrintStream(new File("data.txt"));
	ps.println("k\ttime(ms)");
        int arraySize = Integer.parseInt(args[0]);
	int [] numbers = new int[arraySize];
	TestKthLargest.fill(numbers);
        int k = 1;
	KthLargest.kthLargest(numbers, k,ps);
	for (k = 1000; k <= arraySize; k+=1000)
              KthLargest.kthLargest(numbers, k, ps);
    }


  
}   

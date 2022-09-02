/*  **************************************************************
    CIS 303 Algorithm Analysis and Design
    Assignment 1: TestKthLargest class
    Author: S. Haller, modified 8/2020 L. Grabowski
 
    This class tests correctness of the KthLargest class
    implementation by comparing the result produced by KthLargest
    with a sorted copy of the data array.
 
    Usage:
    1. Compile with KthLargest.java
        javac *.java
    2. To run:
        java TestKthLargest <array size> <kth largest>
        where <array_size> is the size of the data array, and
        <kth largest> is the value for k, where k = 1 finds the
        largest value.
    **************************************************************
 */
import java.util.*;

public class TestKthLargest {

    public static void main (String [] args) throws Exception{    
        int arraySize = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        if (arraySize < k)
	    throw new Exception("\n\nCALL FORMAT: java KthLargest" +
                                " <array size> <kth largest, 1 = largest>\n");
        int [] numbers = new int[arraySize];
        fill(numbers);
        if (arraySize < 25)
        System.out.println(Arrays.toString(numbers));
        System.out.println("Number " + k + " is " +
			   KthLargest.kthLargest(numbers, k, System.out));
        System.out.println("Checking result ...");
        Arrays.sort(numbers);
        System.out.println("kth largest: " + numbers[arraySize - k]);
        if (arraySize < 25)
            printAndHighLight(numbers, k);
        }

    // Parameter: numbers -- empty int array
    // Pre-condition: numbers has been created
    // Post-condition: numbers has been filled with random ints
    public static void fill(int [] numbers) {
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int sign = 1;
            if (rand.nextInt(2) == 0)
                sign = -1;
            numbers[i] = rand.nextInt(100) * sign;
        }
    }

    // Parameter: a -- sorted array of ints; k -- value of k for kth largest
    // Pre-condition:
    //      1. a exists, contains valid data, and is sorted
    //      2. k has a value
    // Post-condition: result array printed, with kth largest value highlighted
    public static void printAndHighLight(int [] a, int k) {
        String result = "";
        for (int i = 0; i < a.length ; i++) {
            if (i == a.length - k)
                result += "*" + a[i] + "* ";
            else
                result +=  a[i] + " ";
        }
        System.out.println(result);
    }
  
}   

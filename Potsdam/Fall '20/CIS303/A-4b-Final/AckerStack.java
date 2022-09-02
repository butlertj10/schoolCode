/**
 * AckerStack.java computes and records data while solving the Ackerman
 *      function using an imitation stack.
 * 
 * AckerStack creates a "stack" using an array implementation along with 
 *      uniquely created stack functions imitating push, pop, and isEmpty.
 *      These allow ackermannStack to find the result of the Ackerman Fucntion 
 *      using a "stack". These results are then output to a file along with
 *      computation time to be analyzed.  
 *
 * @author Trevor Butler
 * @email butlertj203@potsdam.edu
 * @course CIS 303 Algorithm Analysis and Design
 * @assignment 4b
 * @due 10/29/2020
 */

import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class AckerStack {

    // Constant Variables
    private static final int MAX_STACK_SIZE = 2500;
    
    // Variables
    private int maxSize;
    private long[] sArray;
    private int top = -1;


    /**
     * Creates a "stack" without using Java's implementation 
     * 
     * Creates an array to replicate a stack with created "stack" 
     *      functions below. Creates sArray with a max size of 
     *      given parameter
     * 
     * @param mSize max size of array being created
     */
    public AckerStack(int mSize) {
        maxSize = mSize;
        sArray = new long[maxSize];
    }

    public static void main(String[] args) throws Exception {
        File fileStack = new File("StackData.txt");
        FileWriter fWriter = new FileWriter(fileStack, true);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        PrintWriter pWriter = new PrintWriter(bWriter);
        BufferedReader bReader = new BufferedReader(new FileReader(fileStack));
        if (bReader.readLine() == null) {
            pWriter.println("(m,n)\t \tTime (ns)");
        }
        bReader.close();
        long M = Long.parseLong(args[0]);
        long N = Long.parseLong(args[1]);
        System.out.println(ackermannStack(M, N, pWriter));
    }

    /**
     * Calculates the Akerman function without using a stack from Java
     * 
     * This function takes in two long varibles (and a PrintWriter variable)
     *      to calculate the Akerman function using a uniquely created stack.
     *      The result is then output to a file for later analysis along with 
     *      the time taken to compute. 
     * 
     * @param m first number in the set being entered
     * @param n second number in the set being enetered  
     * @param pw variable for PrintWriter to allow writing to file
     * @return the calculated value of the Ackermann function not using java's
     *      built-in stack implementation 
     */
    public static long ackermannStack(long m, long n, PrintWriter pw) {
        AckerStack ackStack = new AckerStack(MAX_STACK_SIZE);
        pw.print("(" + m + "," + n + ")\t \t");
        long startTime = System.nanoTime();
        ackStack.ackPush(m);
        while (!ackStack.isStackEmpty()) {
            m = ackStack.ackPop();
            if (m == 0) {
                n++;
            } else if (n == 0 && m > 0) {
                ackStack.ackPush(m - 1);
                n++;
            } else {
                ackStack.ackPush(m - 1);
                ackStack.ackPush(m);
                n--;
            }
        }
        long stopTime = System.nanoTime();
        long totaltime = stopTime - startTime;
        pw.println(totaltime);
        pw.close();
        return n;
    }

    /**
     * Pushes variable onto stack 
     * 
     * Pushes a long variable onto the sArray while incrementing top
     * 
     * @param i a long variable 
     */
    public void ackPush(long i) {
        sArray[++top] = i;
    }

    /**
     * Pops element off stack
     * 
     * Pops an element off sArray then decrements top
     * 
     * @return element of sArray at top--
     */
    public long ackPop() {
        return sArray[top--];
    }

    /**
     * Checks to see if stack is empty
     * 
     * Boolean check of the stack to see if top is equivalent 
     *      to -1, if so, returns true 
     * 
     * @return boolean determining if stack is empty or full
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
}
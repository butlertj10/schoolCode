/**
 * Ackermann.java calculates the value of the Ackermann function.
 *
 *  Compilation:  javac Ackermann.java
 *  Execution:    java Ackermann M N 
 *  
 *  Calculate the Ackermann function A(M, N) using a straightforward
 *  recursive program.
 *
 *  % java Ackermann 3 8
 *  2045
 *
 *  % java Ackermann 3 9
 *  StackOverflowError
 *
 * @author L. Grabowski, based on https://introcs.cs.princeton.edu/java/53universality/Ackermann.java
 * @date Last update, October 2020 by  L. Grabowski
 * @class CIS 303
 * @assignment 4b
 *
 */
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Ackermann {

    public static long ackermann(long m, long n, PrintWriter pr) {
        if (m == 0)
            return n + 1;
        if (n == 0)
            return ackermann(m - 1, 1, pr);
        return ackermann(m - 1, ackermann(m, n - 1, pr), pr);
    }

    public static void main(String[] args) throws Exception {

        File recFile = new File("RecursiveData.txt");
        FileWriter fileW = new FileWriter(recFile, true);
        BufferedWriter buffW = new BufferedWriter(fileW);
        PrintWriter prW = new PrintWriter(buffW);
        BufferedReader buffR = new BufferedReader(new FileReader(recFile));
        if (buffR.readLine() == null) {
            prW.println("(m,n)\t \tTime (ns)");
        }
        buffR.close();
        long M = Long.parseLong(args[0]);
        long N = Long.parseLong(args[1]); 
        prW.print("(" + M + "," + N + ")\t \t");
        long start = System.nanoTime();
        System.out.println(ackermann(M, N, prW));
        long stop = System.nanoTime();
        long time = stop-start;
        prW.println(time);
        prW.close();
    }
}
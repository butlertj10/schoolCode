/**
 * FibClient executes two function calls from FibTest 
 *
 * FibClient executes these calls and records their run-time in their
 *  corresponding text files of recursion and iteration. These loops 
 *  will start at 3 and go to maxFib recording the run-time each 
 *  pass.
 *
 * @author Trevor Butler
 * @email butlertj203@potsdam.edu
 * @course CIS 303 Algorithm Analysis and Design
 * @assignment 3b
 * @due 10/13/2020
 */

import java.io.*;

public class FibClient{
    
    public static void main (String [] args) throws Exception{  

        int maxFib = 65;
        PrintStream fibiPrintStream = new PrintStream(new File("fibiData.txt"));
        fibiPrintStream.println("n\tTime(ns)");
        for(int fi = 3; fi <= maxFib; fi++){

            long startFibi = System.nanoTime();
            FibTest.fibi(fi);
            long stopFibi = System.nanoTime();
            long timeFibi = stopFibi-startFibi;
            fibiPrintStream.println(fi + "\t" +   timeFibi);
        }

        PrintStream fibrPrintStream = new PrintStream(new File("fibrData.txt"));
        fibrPrintStream.println("n\tTime(ns)");
        for(int fr = 3; fr <= maxFib; fr++){

            long startFibr = System.nanoTime();
            FibTest.fibr(fr);
            long stopFibr = System.nanoTime();
            long timeFibr = stopFibr-startFibr;
            fibrPrintStream.println(fr + "\t" +   timeFibr);
        }
    }
}
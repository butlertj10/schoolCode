/**
 * FibTest provides iterative and recursive implementations
 * of fibonacci generation for empirical testing.
 *
 * FibTest has methods that implement 2 versions of fibonacci
 * number generation (fibi -- iterative; fibr -- recursive).
 * These methods must be called with the single parameter, n,
 * the desired fibonaaci number.
 *
 * @author Laura Grabowski, adapted from C. Shaffer
 * @email grabowlm@potsdam.edu
 * @course CIS 303 Algorithm Analysis and Design
 * @assignment 3b
 * @date 09/29/2020
*/

public class FibTest {
    /**
     * Iterative Fibonacci generator
     *
     * Code originally by C. Shaffer; original comments
     * are left in the code. IMPORTANT: the assert uses
     * n <= 91 as the max value that can be stored but it
     * is likely that your system cannot handle n that
     * large. YOU MUST TEST FOR YOUR SYSTEM'S LIMITS.
     * Do not change the assert here. Instead, validate
     * the parameter in your test client.
     *
     * @param n the desired Fibonacci number
     * @return the desired Fibonacci number
     */
    static long fibi(int n) {
        // fibr(91) is the largest value that fits in a long
        assert (n > 0) && (n <= 91) : "n out of range";
        long curr, prev, past;
        if ((n == 1) || (n == 2)) return 1;
        curr = prev = 1;            // curr holds current Fib value
        for (int i=3; i<=n; i++) {  // Compute next value
            past = prev;            // past holds fibi(i-2)
            prev = curr;            // prev holds fibi(i-1)
            curr = past + prev;     // curr now holds fibi(i)
        }
        return curr;
    }
    
    /**
     * Recursive Fibonacci generator
     *
     * Code originally by C. Shaffer; original comments
     * are left in the code. IMPORTANT: the assert uses
     * n <= 91 as the max value that can be stored but it
     * is likely that your system cannot handle n that
     * large. YOU MUST TEST FOR YOUR SYSTEM'S LIMITS.
     * Do not change the assert here. Instead, validate
     * the parameter in your test client.
     *
     * @param n the desired Fibonacci number
     * @return the desired Fibonacci number
     */
    static long fibr(int n) {
        // fibr(91) is the largest value that fits in a long
        assert (n > 0) && (n <= 91) : "n out of range";
        if ((n == 1) || (n == 2)) return 1; // Base case
        return fibr(n-1) + fibr(n-2);       // Recursive call
    }
}

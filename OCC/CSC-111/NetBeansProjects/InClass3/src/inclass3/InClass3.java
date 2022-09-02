package inclass3;

import java.util.Scanner;

/*******************************************************************************
 * BEGIN InClass3
 *    Declare Variables
 *          Declare radius as double
 *          Declare area as double
 *          Declare PI as double constant
 *    Display input message
 *    Input Radius
 *    Calc area of circ
 *    Display area of circ
 * END InClas3
 ******************************************************************************/

public class InClass3 {

    public static void main(String[] args)
    {
       // Declare Variables
       // Declare radius as double
       double rad;
       
       // Declare area as double
       double area;
       
       // Declare PI as double constant
       final double PI = 3.14;
       
       // Declare scan as Scanner
       Scanner input = new Scanner(System.in);
       
       // Display input message
       System.out.print("Input the Radius of a Circle: ");
       
       // Input Radius
       rad = input.nextInt();
       
       // Calc area of circ
       area = (PI)*(rad*rad);
       
       //   Display area of circ
       System.out.println("The Area of the Circle is: " + area);
    }
    
}

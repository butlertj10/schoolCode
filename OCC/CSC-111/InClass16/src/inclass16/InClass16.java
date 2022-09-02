/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass16;

import java.util.Scanner;

/**
 *
 * @author Trev
 */
public class InClass16 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        double rate, hours;
        Payroll [] myPayroll = new Payroll[7];
        Scanner scan = new Scanner(System.in);
        
        for( int index = 0; index < myPayroll.length; index++)
        {
            System.out.println(myPayroll[index]);
        }
        
        myPayroll[0] = new Payroll();
        System.out.print("Enter the Hourly Rate: ");
        rate = scan.nextDouble();
        System.out.print("Enter the Hours Worked: ");
        hours = scan.nextDouble();
        while( hours < 0 || hours > 60)
        {
            System.out.println("Invaild Hours, Hours Must Be Between 0-60");
            System.out.print("Enter the Hours Worked: ");
            hours = scan.nextDouble();
            
        }
        myPayroll[0].setHourlyRate(rate);
        myPayroll[0].setHours(hours);
        myPayroll[0].CalcGrossPay();
        
        myPayroll[1] = new Payroll();
        myPayroll[2] = new Payroll();
        myPayroll[3] = new Payroll();
        myPayroll[4] = new Payroll();
        myPayroll[5] = new Payroll();
        myPayroll[6] = new Payroll();
        
        for( int index = 0; index < myPayroll.length; index++)
        {
            System.out.println(myPayroll[index]);
        }
    }
    
}

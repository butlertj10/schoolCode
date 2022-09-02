/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass16;

/**
 *
 * @author Trev
 */
public class Payroll 
{
    private double hourlyRate;
    private double hours;
    private double totalPay;
    
    public Payroll()
    {
        hourlyRate = hours = totalPay = 0;
    }

    public double getHourlyRate() 
    {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) 
    {
        this.hourlyRate = hourlyRate;
    }

    public double getHours() 
    {
        return hours;
    }

    public void setHours(double hours) 
    {
        if(hours >= 0 && hours <= 60)
            this.hours = hours;
    }

    public double getTotalPay() 
    {
        return totalPay;
    }
    
    public void CalcGrossPay()
    {
        totalPay = hours * hourlyRate;
    }

    @Override
    public String toString() 
    {
        return "Payroll{" + "hourlyRate: " + hourlyRate + ", hours: " + hours +
                ", totalPay: " + totalPay + "}";
    }
    
    
}

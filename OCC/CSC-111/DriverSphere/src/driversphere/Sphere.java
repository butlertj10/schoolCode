/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driversphere;

/**
 *
 * @author Trev
 */
public class Sphere 
{
    private double radius;
            
    public Sphere(double radius)
    {
        this.radius = radius;
    }
    
    public String toString()
    {
        String msg = "";
        
        msg = "Sphere has a radius of: " + radius + "\n";
        
        return msg;
    }
    
    public double Area()
    {
        double area;
        
        area = (4 * Math.PI * radius * radius);
        
        return area;
    }
    
    public double Volume()
    {
        double vol;
                
        vol = (4/3 * Math.PI * radius * radius * radius);
    
       return vol;    
    }

    public double getRadius() 
    {
        return radius;
    }

    public void setRadius(double radius) 
    {
        if(radius < 0)
            System.out.println("Invailed Radius");
        else
            this.radius = radius;
    }
    
    
}

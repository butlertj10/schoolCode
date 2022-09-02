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
public class DriverSphere 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        double area, volume;
        
        Sphere shape1 = new Sphere(6.65);
        Sphere shape2 = new Sphere(36.23);
    
        System.out.print(shape1);
        System.out.print(shape2);
        
//        area = shape1.Area();
//        System.out.println(area);
        System.out.println(shape1);
        System.out.println("Shape 1 Area is: " + shape1.Area());
        System.out.println(shape2);
        System.out.println("Shape 2 Area is: " + shape2.Area());
   
//        volume = shape1.Volume();
//        System.out.println(volume);
        System.out.println(shape1);
        System.out.println("Shape 1 Volume is: " + shape1.Volume());
        System.out.println(shape2);
        System.out.println("Shape 2 Volume is: " + shape1.Volume());
        
        shape1.setRadius(0);

//        volume = shape1.Volume();
//        System.out.println(volume);
        System.out.println(shape1);
        System.out.println("Shape 1 Volume is: " + shape1.Volume());
    
        double temp;
        
        temp = shape2.getRadius();
        System.out.println("Radius of Shape 2 is: " + temp);
    }
    
    
    
}

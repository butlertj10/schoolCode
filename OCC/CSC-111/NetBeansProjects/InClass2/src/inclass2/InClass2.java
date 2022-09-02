
package inclass2;

public class InClass2 {

    public static void main(String[] args) 
    {
        double cel;
        double fah;
        
        // When Fahrenheit is 32.0
        fah = 32.0;
        
        cel = (fah - 32) * 5/9;
        System.out.println("Celsius is " + cel);
        
        // When Fahrenheit is 96.0
        fah = 96.0;
        
        cel = (fah - 32) * 5/9;
        System.out.println("Celsius is " + cel);
        
        // When Fahrenheit is -20.0
        fah = -20.0;
        
        cel = (fah - 32) * 5/9;
        System.out.println("Celsius is " + cel);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author speciosr
 */
public class People 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Person rich = new Person("Richard Specioso", 33, "123 Somewhere", 
                "Syracuse", "New York", 13221);
        
        System.out.println(rich.getStreet());
        System.out.println(rich);
    }
    
}

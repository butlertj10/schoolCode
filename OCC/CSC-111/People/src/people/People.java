/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author Trev
 */
public class People 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Person trev = new Person("Trevor Butler", 19, "123 Somewhere Lane",
            "Syracuse", "New York", 13082);
        
        Person myPeople [] = new Person[10];
         System.out.println(trev);
    }
    
}

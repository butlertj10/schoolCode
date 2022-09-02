/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatingpattern;

/**
 *
 * @author Trev
 */
public class CreatingPattern 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int row;
        int col;
        
        // Small To Large/Left To Right
        for(row = 1; row <= 10; row++)
        {
            for(col = 0; col < row; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.print("\n");
        
        // Large To Small/Right To Left
        for(row = 10; row >= 1; row--)
        {
            for(int space = 10; space > row; space--)
            {
                System.out.print(" ");
            }
            for(col =1; col <= row; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        
         System.out.print("\n");
        
        // Large To Small/Right To Left
        for(row = 10; row >= 1; row--)
        {
            for(col =1; col <= row; col++)
            {
                System.out.print("*");
            }for(int space = 10; space > row; space--)
            {
                System.out.print(" ");
            }
            System.out.println();
        }       

         // Large To Small/Right To Left
           for(row = 10; row >= 1; row--)
        {
            for(col =1; col <= row; col++)
            {
                System.out.print(" ");
            }for(int space = 10; space > row; space--)
            {
                System.out.print("*");
            }
            System.out.println();
        }   
    }
    
}

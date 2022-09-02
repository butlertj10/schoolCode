package binarytreeex;

import BinaryTree.BinaryTree;
import java.util.Iterator;

/**
 *
 * @author t.j.butler2
 */
public class BinaryTreeEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        BinaryTree<Integer> intTree = new BinaryTree<Integer>();
        Iterator<Integer> iter;
        Integer temp;
        
        if(intTree.isEmpty())
            System.out.println("Tree is Empty");
        else
            System.out.println("Tree is not Empty");
        
        intTree.addElement(10);
        intTree.addElement(11);
        intTree.addElement(5);
        intTree.addElement(13);
        
        if(intTree.isEmpty())
            System.out.println("Tree is Empty");
        else
            System.out.println("Tree is not Empty");
        
        System.out.println("Root value is " + intTree.getRootElement());
        
       iter = intTree.iterator();
        System.out.println("In Order Output");
        
        while(iter.hasNext())
        {
            temp = iter.next();
            System.out.println(temp + "");
        }
        System.out.println();
        
        
         iter = intTree.iteratorPreOrder();
        System.out.println("In PreOrder Output");
        
        while(iter.hasNext())
        {
            temp = iter.next();
            System.out.println(temp + "");
        }
        System.out.println();
        
        iter = intTree.iteratorPostOrder();
        System.out.println("In PostOrder Output");
        
        while(iter.hasNext())
        {
            temp = iter.next();
            System.out.println(temp + "");
        }
        System.out.println();
        
        
    }
    
}

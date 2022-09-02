package linkedlistsex;

import linkedlistsadt.LinkedListsADT;

/**
 *
 * @author t.j.butler2
 */
public class LinkedListsEx 
{
    private static LinkedListsADT<Integer> myList = new LinkedListsADT<Integer>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        listDetails();
        myList.addFront(6);
        listDetails();
        
        myList.append(37);
        listDetails();
        
        myList.append(1);
        listDetails();
        
        myList.append(7);
        listDetails();
        
//        myList.RemoveEnd();
//        listDetails();
//        
//        myList.RemoveFront();
//        listDetails();
//        
//        myList.Insert(4, 0);
//        listDetails();
//        
//        myList.RemoveAt(2);
//        listDetails();

//        myList.Insert(1);
//        myList.Insert(12);
//
//        myList.Insert(13);
//
//        myList.Insert(21);

        myList.BubbleSort();
        listDetails();

//        Integer value;
//        value = myList.getValueFront();
//        System.out.println("Front value is: " + value);
//        value = myList.getValueEnd();
//        System.out.println("End value is: " + value);
//
//        value = myList.getValue(0);
//        System.out.println("First Value is: " + value);
//        value = myList.getValue(1);
//        System.out.println("Second Value is: " + value);
//        value = myList.getValue(2);
//        System.out.println("Third Value is: " + value);

    }
    
    public static void listDetails()
    {
        System.out.println("Size of list is " + myList.size());
        if(myList.isEmpty())
            System.out.println("List is empty\n");
        else
            System.out.println("List is not empty\n");
        
        System.out.println(myList);
    }
}

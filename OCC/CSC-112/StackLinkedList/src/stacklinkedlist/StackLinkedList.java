package stacklinkedlist;

import stackADT.StackADT;

/**
 *
 * @author t.j.butler2
 */
public class StackLinkedList 
{
    // Data members
    private static StackADT<Integer> myStack = new StackADT<Integer>();
    
    public static void main(String[] args) 
    {
       DisplayStats();
       myStack.push(12);
       DisplayStats();
       myStack.push(6);
       myStack.push(2);
       myStack.push(1);
       myStack.push(13);
       myStack.push(53);
       DisplayStats();
       
       Integer x;
       x = myStack.pop();
       if(x == null)
            System.out.println("Pop is Null\n");
       else
            System.out.println("Pop is: " + x + "\n");
       
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        System.out.println("Popped Value is: " + myStack.pop());
        
        if(myStack.pop() == null)
        {
            System.out.println("Pop is Null");
        }
        
    }
    
    // Displays Size of stack and whether or not stack is empty
    private static void DisplayStats()
    {
        System.out.println("Size of Stack: " + myStack.size());
        
        if(myStack.isEmpty())
            System.out.println("Stack is Empty\n");
        else
            System.out.println("Stack is not Empty\n");
    }
}

    

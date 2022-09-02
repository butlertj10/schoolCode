package stackADT;

import linkedlistsadt.LinkedListsADT;

/**
 *
 * @author t.j.butler2
 * @param <T>
 */
public class StackADT<T> implements StackInterface<T>
{
//    private int arrayCap = 5;
//    private Object stack[];
//    private int top;
      private LinkedListsADT<T> stack;
    
    public StackADT()
    {
        stack = new LinkedListsADT<>();
        //top = 0; 
    }

    @Override
    /**
     * Push data on to stack 
     * when full will throw 
     * the StackOverflowError
     * --OR-- 
     * Change return type to 
     * boolean return false if
     * fails
     * --OR--  
     * Increase array to hold
     * more data
     * 
     */
    public void push(T element) 
    {
        stack.addFront(element);
    }
    
    @Override
    public T pop() 
    {
        T temp = null;
        
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
        }
        else
        {
            temp = stack.getValueFront();
            stack.RemoveFront();
        }
        
        return temp;
    }

    @Override
    public T peek() 
    {
        T temp = null;

        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }
        else 
        {
            temp = stack.getValueFront();
        }

        return temp;
    }

    @Override
    public boolean isEmpty() 
    {
       // boolean result = false;
        
//        if(top == 0)
//            result = true;
        
        return stack.isEmpty();
    }

    @Override
    public int size() 
    {
        return stack.size();
    } 
}

package stackadt;

public class StackADT<T> implements StackInterface<T>
{
    private int arrayCap = 5;
    private T stack[];
    private int top;
    
    public StackADT()
    {
        stack = (T[]) new Object[arrayCap];
        top = 0;
    }
    
    @Override
    /**
     * Push data on to stack 
     * when full will throw the StackOverflowError.
     * or
     * Change return type to boolean return false if push fails
     * or
     * Increase size of array as needed
     */
    public void push(T element) 
    {
        if(top == arrayCap)
        {
            IncreaseSize();
        }
        stack[top] = element;
        top++;                
        
        /*if(top != arrayCap)
        {
            stack[top] = element;
            top++;
        }*/
        //else
        //{
            //System.out.println("Stack is full");
            //throw new StackOverflowError("Stack is full");
        //}
    }

    private void IncreaseSize()
    {
        T [] newStack =(T[]) new Object[arrayCap * 2];
        int index = 0;
        
        for(T item : stack)
        {
            newStack[index] = item;
            index++;
        }
        
        stack = newStack;
        arrayCap *=2;
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
            top--;
            temp = (T)(stack[top]);
            stack[top] = null;
        }
        
        return temp;
    }

    @Override
    public T peek() 
    {
        T temp = null;
        
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
        }
        else
        {
            //top--;
            temp = (T)(stack[top-1]);
            //stack[top] = null;
        }
        
        return temp;
    }

    @Override
    public boolean isEmpty() 
    {
        boolean result = false;
        
        if(top == 0)
            result = true;
        
        return result;
    }

    @Override
    public int size() 
    {
        return top;
    }
    
}

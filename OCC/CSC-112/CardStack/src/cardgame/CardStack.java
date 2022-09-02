package cardgame;

/**
 * Interface of CardStack
 * 
 * @author Trevor
 * @param <T>
 */
public interface CardStack<T> 
{
    /**
     * Pushes element onto stack
     * 
     * @param element 
     */
    public void push(T element);
    
    /**
     * Removes card from stack
     * 
     * @return T
     */
    public T pop();
    
    /** 
    * Displays tops card without removing it
    * 
    * @return T
    */
    public T peek();
    
    /**
    * Returns true if stack is empty, false if it is not empty
    * 
    * @return boolean
    */
    public boolean isEmpty();
    
    /**
     * Returns size of stack
     * 
     * @return int
     */
    public int size();
}

package stackadt;

public interface StackInterface<T>
{
    /**
     * 
     * @param element 
     */
    public void push(T element);
    
    public T pop();
    
    public T peek();
    
    public boolean isEmpty();
    
    public int size();

}

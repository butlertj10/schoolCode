package stackADT;

/**
 *
 * @author t.j.butler2
 */
public interface StackInterface<T>
{
    public void push(T element);
    
    public T pop();
    
    public T peek();
    
    public boolean isEmpty();
    
    public int size();
    
}

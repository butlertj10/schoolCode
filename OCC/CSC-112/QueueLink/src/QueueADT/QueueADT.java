package QueueADT;
import linkedlistsadt.LinkedListsADT;

/**
 *
 * @author t.j.butler2
 */
public class QueueADT<T> implements QueueInterface<T>
{
    private LinkedListsADT<T> queue;
    
    public QueueADT()
    {
        queue = new LinkedListsADT<T>();
    }

    @Override
    public void enqueue(T element) 
    {
        queue.append(element);
    }

    @Override
    public T dequeue() 
    {
        T temp = null;

        temp = queue.getValueFront();
        queue.RemoveFront();
        
        return temp;
    }

    /**
     *
     * @return
     */
    @Override
    public T first() 
    {
         T temp = null;

        temp = queue.getValueFront();
        
        return temp;    
    }

    @Override
    public boolean isEmpty() 
    {
        return queue.isEmpty();
    }

    @Override
    public int size() 
    {
        return queue.size();
    }

    @Override
    public String toString() {
        return "QueueADT{" + "queue=" + queue + '}';
    }   
}

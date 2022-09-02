package linkedlistsadt;

/**
 *
 * @author t.j.butler2
 */
public interface LinkedListInterface<T>
{
    public boolean isEmpty();
    public int size();
    
    public void append(T obj);
    public void addFront(T obj);
    
    /**
     * Adding to the list at any location
     * if index is zero then adding to front
     * if index is greater than the size then either
     *  Append to the end of the list
     *  or throw exception that index if out of bounds
     *  or return boolean where false means index beyond size of list
     * 
     * @param obj data to be stored
     * @param index location the insert data onto the list
     */
    public void Insert(T obj, int index);
    
    /**
     * Keeping list sorted
     * OBJ must have compareTo method
     * 
     * @param obj data to be stored
     */
    public void Instert(T obj);
    
    public boolean RemoveEnd();
    public boolean RemoveFront();
    public boolean RemoveAt(int index);
    public boolean Remove(T obj);
    public boolean RemoveAll(T obj);
    public void Display(Integer[] values);
    public void BubbleSort(Integer[] data);
    
    public T getValue(int pos);
    public T getValueEnd();
    public T getValueFront();
    
}

package linkedlistsadt;

/**
 *
 * @author t.j.butler2
 */
public class LinkedListsADT<T extends Comparable> implements LinkedListInterface<T>
{
    protected Node<T> front;
    protected Node<T> back;
    protected int size;        
            
    public LinkedListsADT()
    {
        front = back = null;
        size = 0;
    }
            
    @Override
    public boolean isEmpty() 
    {
        boolean result = false;
        
        if (front == null)
            result = true;
        
        return result;
    }

    @Override
    public int size() 
    {
        return size;
    }

    @Override
    public void append(T obj) 
    {
        if (isEmpty()) 
        {
            addFront(obj);
        }
        else
        {
            Node<T> temp = new Node<T>(null, back, obj);
            back.setNext(temp);
            back = temp;
            size++;
        }
    }

    @Override
    public void addFront(T obj) 
    {
        if (isEmpty()) 
        {
            Node<T> temp = new Node<T>(null, null, obj);
            front = back = temp;
        } 
        else 
        {
            front = new Node(front, null, obj);
            front.getNext().setPrevious(front);
            
//            Node<T> temp = new Node<T>(front, null, obj);
//            front.setPrevious(temp);
//            front = temp;
        }
        size++;
    }

    @Override
    /**
     * insert @ index, connect nodes
     */
    public void Instert(T obj, int index) 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    /**
     * objects, lists in order (6, 7, 10) Sorted list
     */
    public void Instert(T obj) 
    {
        if(front == null)
        {
            
        }
        int count = 0;
        Node<T> current = front;
        Node<T> previous = current.getPrevious();
        Comparable temp = (Comparable)current.getValue();
        
        while(current != null && (temp.compareTo((Comparable)obj) < 0))
        {
                    
        }
    }

    @Override
    public boolean RemoveEnd() 
    {
        boolean result = false;
        
        if (!isEmpty())
        {
            if(front == back)
            {
                back = front = null;
            }
        }
        else
        {
            Node<T> temp = back.getPrevious();
            temp.setNext(null);
            back.setPrevious(null);
            back = temp;
        }
        result = true;
        size--;
        
        return result; 
    }

    @Override
    public boolean RemoveFront() 
    {
        boolean result = false;
        
        if (!isEmpty())
        {
            if(front == back)
            {
                back = front = null;
            }
        }
        else
        {
            Node<T> temp = front.getNext();
            front.setNext(null);
            temp.setPrevious(null);
            front = temp;
        }
        result = true;
        size--;
        
        return result; 
    }

    /**
     * find object at position and call remove
     * @param index
     * @return 
     */
    @Override
    public boolean RemoveAt(int index) 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean Remove(T obj) 
    {
        boolean result = false;
        Node<T> temp, temp2, temp3;
        
        if (!isEmpty())
        {
            if (obj.equals(front.getValue()))
            {
                result = RemoveFront();
            }
//            else if(obj.equals(back.getValue()))
//            {
//                result = RemoveEnd();
//            }
        }
        else
        {
            temp = front;
            
            while (temp.getNext() != null && !(temp.getValue().equals(obj)))
            {
                temp = temp.getNext();
            }
            if(temp.getValue().equals(obj))
            {
                temp2 = temp.getPrevious();
                temp3 = temp.getNext();
                
                //temp
                temp2.setNext(temp3);
                temp3.setPrevious(temp2);
            
                temp.setNext(null);
                temp.setPrevious(null);
                size--;
                result = true;
            }
        }
        
        return result;
    }

    @Override
    /**
     * remove all nodes w parameter value 
     * loop until false call^^
     */
    public boolean RemoveAll(T obj) 
    {
        return false;

    }
    
    @Override
    public String toString() 
    {
        String msg  = "Linked list\n";
        
        Node current = front;
        
        while (current != null) 
        {
            msg += current.getValue().toString() + " ";
            current = current.getNext();
        }
        
        return msg;
    }

    @Override
    public T getValue(int pos) 
    {
        T temp = null;
        Node<T> temp1;
        
        if (pos < size && pos >= 0)
        {
            temp1 = front;
            for (int count = 1; count <= pos; count++)
            {
                temp1 = temp1.getNext();
            }
            
            temp = temp1.getValue();
        }
        
        return temp;
    }

    @Override
    public T getValueEnd() 
    {
        T value = null;
        
        if (back != null)
        {
            value = back.getValue();
        }
        
        return value;
    }

    @Override
    public T getValueFront() 
    {
        T temp = null;
        
        if (front != null)
        {
            temp = front.getValue();
        }
        
        return temp;    
    }
}

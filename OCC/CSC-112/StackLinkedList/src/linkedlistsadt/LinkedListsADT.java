package linkedlistsadt;

import java.util.LinkedList;
import java.util.List;

/**
 * Class containing Linked List modifiers 
 * 
 * @see LinkedListInterface
 * @see Comparable
 * @author t.j.butler2
 * @param <T> 
 */
public class LinkedListsADT<T extends Comparable> implements LinkedListInterface<T>
{
    protected Node<T> front;
    protected Node<T> back;
    protected int size; 
            
    /**
     * Constructor of LinkedListADT
     */
    public LinkedListsADT()
    {
        front = back = null;
        size = 0;
    }
         
    /**
     * Determines is Linked List is empty
     * 
     * @return size
     */
    @Override
    public boolean isEmpty() 
    {
        boolean result = false;
        
        if (front == null)
            result = true;
        
        return result;
    }
    
    /**
     * Holds size of Linked List
     * 
     * @return size
     */
    @Override
    public int size() 
    {
        return size;
    }

    /**
     * Adds element to the end of the Linked List
     * 
     * @param obj 
     */
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

    /**
     * Adds element to the front of the list
     * 
     * @param obj 
     */
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
        }
        size++;
    }

    /**
     * Inserts element at given index of given value  
     * 
     * @param obj
     * @param index 
     */
    public void Insert(T obj, int index) 
    {
        Node<T> temp = null;
        Node<T> currentNode = front;
        Node<T> previousNode = null;
    
        if(index>size)
        {
            index=size;
        }
        
        for (int i = 0; i < index; i++)
        {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        
        temp = new Node<T>(front, back, obj);
        
        currentNode.setPrevious(temp);
    
        if(previousNode != null)
        {
            previousNode.setNext(temp);
        }
        
        if(index == size)
        {
            back = temp;
        }
        
        if(index == 0)
        {
            front = temp;
        }
        size++; 
    }

    /**
     * Inserts element and organizes them in increasing order
     * 
     * @param obj 
     */
    public void Insert(T obj) 
    {
        if (front == null) 
        {
            addFront(obj);
        }
        else
        {
            int count = 0;

            Node<T> current = front;
            Node<T> previous = current.getPrevious();
            Comparable temp = (Comparable)current.getValue();

            while(current != null && (temp.compareTo((Comparable)obj) < 0))
            {
                // get the current node
                current = current.getNext();
                count++;

                if(current != null)
                {
                    temp = (Comparable)current.getValue();
                }
            }
            Insert(obj, count);
        }
    }

    /**
     * Removes last element in Linked List
     * 
     * @return result
     */
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
            else
            {
                Node<T> temp = back.getPrevious();
                temp.setNext(null);
                back.setPrevious(null);
                back = temp;
            }
            
            result = true;
            size--;
        }
        
        return result; 
    }

    /**
     * Removes first element of the Linked List
     * 
     * @return result
     */
    @Override
    public boolean RemoveFront() 
    {
        boolean result = false;
        
        if(!isEmpty())
        {
            if(front == back)
            {
                back = front = null;
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
        }
        
        return result;
    }

    /**
     * Find object at given index and remove it
     * 
     * @param index
     * @return false
     */
    @Override
    public boolean RemoveAt(int index) 
    {
        Node temp = null;
        Node currentNode = front;
        Node previous = null;
        Node next = front.getNext();

        if (index > size - 1) 
        {
            index = size - 1;
        }
        
        for (int i = 0; i < index; i++) 
        {
            previous = currentNode;
            currentNode = currentNode.getNext();
            next = currentNode.getNext();
        }

        if (next != null) 
        {
            next.setPrevious(previous);
        } 
        else 
        {
            back = previous;
        }
        
        if (previous != null) 
        {
            previous.setNext(next);
        } 
        else 
        {
            front = next;
        }
        size--;
        return false;
    }

    /**
     * Removes element from Linked List
     * 
     * @param obj
     * @return result
     */
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

    /**
     * Removes all elements of given value
     * 
     * @param obj
     * @return result
     */
    @Override
    public boolean RemoveAll(T obj) 
    {
        boolean result = false;
        Node<T> temp = front;
        while (temp != null) 
        {
            if(temp.getValue() == obj)
            {
                // get the node after the one we're removing
                Node<T> nextNode = temp.getNext();

                // get the node before the one we're removing
                Node<T> prevNode = temp.getPrevious();
                
                // link the nodes before and after the one we're removing
                prevNode.setNext(nextNode);
                nextNode.setPrevious(prevNode);
                
                // Unline the one we're removing
                temp.setNext(null);
                temp.setPrevious(null);
                
                temp = nextNode;
                result = true;
            }
        }
        return result;
    }
    
    /**
     * Creates output message for Linked List
     * 
     * @return msg
     */
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

    /**
     * Gets value at position
     * 
     * @param pos
     * @return temp
     */
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

    /**
     * Gets end value
     * 
     * @return value
     */
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

    /**
     * Gets front value
     * 
     * @return temp
     */
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

    @Override
    public void Display(Integer[] values) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void BubbleSort(Integer[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

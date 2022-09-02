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
    @Override
    public void Insert(T obj, int index) 
    {
        Node<T> current;
        Node<T> previous;
        int count = 0;
        
        if(index == 0)
            addFront(obj);
        else if (index > size)
            append(obj);
        else
        {
            current = front;
            previous = current.getPrevious();
            
            while (current != null && count < index)
            {
                previous = current;
                current = current.getNext();
                count++;
            }
            
            Node<T> temp = new Node(current, previous, obj);
            if(current != null)
            {
                current.setPrevious(temp);
            }
            else
                back = temp;
            
            previous.setNext(temp);
            size++;
        }     
    }

    /**
     * Inserts element and organizes them in increasing order
     * 
     * @param obj 
     */
    @Override
    public void Insert(T obj) 
    {
        int count = 0;
        Node<T> current = front;
        Node<T> previous = current.getPrevious();
        Comparable temp = (Comparable)current.getValue();
        while(current != null && temp.compareTo((Comparable)obj) < 0)
        {
            previous = current;
            current = current.getNext();
            temp = (Comparable) current.getValue();
            count++;
        }
        
        Insert(obj, count);
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
        Node<T> temp = front;
        boolean result = false;
        
        if(!isEmpty() && index < size)
        {
            for(int count = 0; count < index; count++)
            {
                temp = temp.getNext();
            }
            result = Remove(temp.getValue());
        }
        return result;
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
        boolean result2 = false;
        
        do
        {
            result = Remove(obj);
            if(result)
                result2 = true;
            
        }while(result);
        
        return result2;
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
        
        if(pos < size && pos >= 0)
        {
            temp1 = front;
            for(int count = 1; count <= pos; count++)
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
    public void BubbleSort() 
    {
        
    }
//        // Get first item
//        Node<T> cItemFront =  front;        
//        
//        // Get last item
//        Node<T> cItemEnd = back.getPrevious();
//        
//        //Integer temp;
//	boolean swapped = true;
//        
//        while(cItemFront.getNext() != null && swapped) {
//            swapped = false;
//            while (cItemEnd.getPrevious() != null) {
//                //if (cItemFront.getValue().compareTo(cItemFront.getNext().getValue()) > 0) {
//                //if(cItemEnd.getValue().compareTo(cItemFront.getNext().getValue()) > 0)
//                //{
//                    swap(cItemEnd, cItemEnd.getNext());
//                    swapped = true;
//                //}
//
//                cItemEnd = cItemEnd.getPrevious();
//            }
//
//            cItemFront = cItemFront.getNext();
        
        
//        for (int i = 0; i < size && swapped; i++) {
//            swapped = false;
//            for (int j = 0; j < i; j++) {
//                Node<T> currentItem = (Node<T>) getValue(j);
//                Node<T> nextItem = currentItem.getNext();
//
//                if (nextItem != null) {
//                    if ((int) (currentItem.getValue()).compareTo(nextItem.getValue()) > 0) {
//                        swapIndex(j, j + 1);
//                        swapped = true;
//                    }
//                }
//            }
//        }    
    
    
    // pass something different than indexs 
    // inside class 
    // selection and bubble
    // both doing swap keep track
    // know nodes next to each other moving ref variables
    // nested loop one to swap and one to go throug again
    // sel where to place it, ref o where lowest is
    // shift as we go and reset as we get to end
    // keep track of curent to compare to other node
    /**
     * Selection sort
     * outer loop controls # of passes
     * inner determines what needs to be swapped
     * # in array tells us where it needs to go 
     * 
     * LL no index but keep reference to 1 of 3, 3 should be lowest
     * nest: assume where pos is smallest
     * loc needs to move and keep track of lowest 
     * update smallest and update loc and move current to the right
     * 
     * move ref variables to smallest 
     * @param index1
     * @param index2 
     */
//    private void swap(Node<T> index1, Node<T> index2)
//    {
//        // get first index item
//        Node<T> val1 = index1;
//
//        // get second index item
//        Node<T> val2 = index2;
//
//        // swap next values
//        Node<T> nextVal1 = ((Node<T>)val1).getNext();
//        Node<T> nextVal2 = ((Node<T>)val2).getNext();
//        
//        // swap previous values
//        Node<T> prevVal1 = ((Node<T>)val1).getPrevious();
//        Node<T> prevVal2 = ((Node<T>)val2).getPrevious();
//        
//        val1.setNext(nextVal2);
//        val1.setPrevious(prevVal2);
//        
//        val2.setNext(nextVal1);
//        val2.setPrevious(prevVal1);
//    }
//    
//    private void swapIndex(int index1, int index2)
//    {
//        // get first index item
//        Node<T> val1 = (Node<T>)getValue(index1);
//
//        // get second index item
//        Node<T> val2 = (Node<T>)getValue(index2);
//
//        // swap next values
//        Node<T> nextVal1 = ((Node<T>)val1).getNext();
//        Node<T> nextVal2 = ((Node<T>)val2).getNext();
//        
//        // swap previous values
//        Node<T> prevVal1 = ((Node<T>)val1).getPrevious();
//        Node<T> prevVal2 = ((Node<T>)val2).getPrevious();
//        
//        val1.setNext(nextVal2);
//        val1.setPrevious(prevVal2);
//        
//        val2.setNext(nextVal1);
//        val2.setPrevious(prevVal1);
//    }

// function to sort a singly linked list using insertion sort     
    public void insertionSort(T first)  
    { 
        // Initialize sorted linked list 
        Node<T> sorted = null; 
        Node<T> current = front; 
        // Traverse the given linked list and insert every 
        // node to sorted 
        while (current != null)  
        { 
            // Store next for next iteration 
            Node<T> next = current.getNext(); 
            // insert current in sorted linked list 
            sortedInsert(current); 
            // Update current 
            current = next; 
        } 
        // Update head_ref to point to sorted linked list 
        head = sorted; 
    } 
}



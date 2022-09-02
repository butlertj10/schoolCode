package queuelink;

import QueueADT.QueueADT;

/**
 *
 * @author t.j.butler2
 */
public class QueueLink 
{
    private static QueueADT<Integer> myQueue = new QueueADT<Integer>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       DisplayQueueStats();
       myQueue.enqueue(5);
       DisplayQueueStats();
       myQueue.enqueue(3);
       DisplayQueueStats();
       myQueue.enqueue(6);
       DisplayQueueStats();
       myQueue.enqueue(10);
       DisplayQueueStats();
       myQueue.enqueue(2);
       DisplayQueueStats();
       
        Integer temp = myQueue.dequeue();
       System.out.println(temp);
       DisplayQueueStats();
       temp = myQueue.first();
       System.out.println(temp);
       DisplayQueueStats();
       System.out.println(temp);
       DisplayQueueStats();
       temp = myQueue.dequeue();
       System.out.println(temp);
       DisplayQueueStats();
       System.out.println(temp);
       DisplayQueueStats();
       temp = myQueue.dequeue();
       System.out.println(temp);
       DisplayQueueStats();
       
       
    }
    
    private static void DisplayQueueStats()
    {
        System.out.println("Is The Queue Empty? : " + myQueue.isEmpty());
        System.out.println("The size is: " + myQueue.size());
        System.out.println(myQueue + "\n");
    }
}

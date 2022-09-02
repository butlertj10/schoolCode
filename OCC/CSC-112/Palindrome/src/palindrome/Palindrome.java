package palindrome;

import QueueADT.QueueADT;
import stackADT.StackADT;

/**
 *
 * @author t.j.butler2
 */
public class Palindrome 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        QueueADT<String> queue = new QueueADT<String>();
        StackADT<String> stack = new StackADT<String>();
        String messages [] = {"a but tuba", "a car a man a maraca", "a Santa at Nasa"};
        
        String msg1;
        int msgCharCount = 0;
        for (int msgCount = 0; msgCount < messages.length; msgCount++) 
        {
            msg1 = messages[msgCount];
            
            for (int count = 0; count < msg1.length(); count++)
            {
                if (!(msg1.substring(count, count+1).equalsIgnoreCase(" "))) 
                {
                    queue.enqueue(msg1.substring(count, count+1));
                    stack.push(msg1.substring(count, count+1));
                    msgCharCount++;
                }
            }
        }
        
        String test1 = queue.dequeue();
        String test2 = stack.pop();
        int counter = 0;
        
        while (test1 != null && test2 != null && test1.equalsIgnoreCase(test2))
        {
            counter++;
            test1 = queue.dequeue();
            test2 = stack.pop();
        }
        
        msgCharCount = 0;
        while(!queue.isEmpty())
            queue.dequeue();
        
        while(!stack.isEmpty())
            queue.dequeue();
        
        if(counter == msgCharCount)
            System.out.println("Palindrome " + msg1);
        else
            System.out.println("Not a Palindrome " + msg1);
    }
    
}

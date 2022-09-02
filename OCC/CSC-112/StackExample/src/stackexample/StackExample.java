package stackexample;
import stackadt.StackADT;
import java.util.Stack;

public class StackExample 
{
    private static StackADT<Integer> myStack = new StackADT<Integer>();
    private static StackADT<Card> deck = new StackADT<Card>();
    public static void main(String[] args) 
    {
        // TODO code application logic here
        DisplayStats();
        myStack.push(12);
        DisplayStats();        
        myStack.push(22);
        myStack.push(33);
        myStack.push(44);
        myStack.push(55);
        myStack.push(66);        
        myStack.push(77);
        DisplayStats();
        
        Integer x;
        x = myStack.pop();
        if(x == null)
            System.out.println("Pop gave me a null");
        else
            System.out.println("Popped value is " + x);
        
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());
        System.out.println("Popped value is " + myStack.pop());

        if(myStack.pop() == null)
            System.out.println("Pop gave me a null");
        

        
        
        
        Card aCard = new Card();
        deck.push(aCard);

        System.out.println("Card is " + deck.pop());
        
        Stack<Card> deck2 = new Stack<Card>();
        
    }
    
    private static void DisplayStats()
    {
        System.out.println("Size of stack " + myStack.size());
        if(myStack.isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println("Stack is not empty");
    }
}

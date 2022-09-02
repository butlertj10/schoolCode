package cardgame;
import java.util.Random;

/**
 * @see CardStack
 * @author Trevor
 */
public class DeckOfCards implements CardStack<Card>
{ 
    // Make a new deck
    private final int DECK_SIZE = 52;
    private Card[] deck = new Card[DECK_SIZE];
    private int top;
    
    /**
     * DeckOfCards constructor where deck is made then shuffled into a stack
     */
    public DeckOfCards()
    {
        // Build the deck
        int count = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int face = 1; face <= 13; face++)
            {
                deck[count] = new Card(face, suit);
                count++;
            }
        }
        
        top = deck.length;
        
        // Shuffle it
        deck = Shuffle(deck);
    }
    
    /**
     * Displays deck of 52 cards
     */
    public void DisplayDeck()
    {
        for (Card card : deck) 
        {
            System.out.println(card.getFaceName() +" of "+ card.getSuitName());
        }
    }
    
    /**
     * Shuffles deck of type Card[] putting the array into a stack
     * 
     * @param deck
     * @return deck
     */
    public Card[] Shuffle(Card[] deck)
    {
        Random generator = new Random();        
        int ran1, ran2;
        Card temp;
        
        for(int count = 0; count < 1000; count++)
        {
            ran1 = generator.nextInt(DECK_SIZE);
            ran2 = generator.nextInt(DECK_SIZE);
         
            temp = deck[ran1];
            deck[ran1] = deck[ran2];
            deck[ran2] = temp;
        }               
        return deck;
    }
    
    /**
     * Pushes element onto deck
     * 
     * @param element 
     */
    public void push(Card element) 
    {
        deck[top] = element;
        top++;  
    }

    /**
     * Takes card from top of stack and removes it 
     * 
     * @return temp
     */
    @Override
    public Card pop() 
    {
       Card temp = null;
        
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
        }
        else
        {
            top--;
            temp = deck[top];
            deck[top] = null;
        }
        
        return temp;
    }

    /**
     * Peeks at top card but does not remove it
     * 
     * @return temp
     */
    @Override
    public Card peek() 
    {
       Card temp = null;
        
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
        }
        else
        {
            temp = (deck[top-1]);
        }
        
        return temp;
    }

    /**
     * Returns true if deck is empty, false if it is not empty
     * 
     * @return boolean 
     */
    @Override
    public boolean isEmpty() 
    {
        return deck.length == 0;
    }

    /**
     * Returns size of stack
     * 
     * @return top
     */
    @Override
    public int size() 
    {
        return top;
    }
}

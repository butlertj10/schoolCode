package card;
import java.util.Random;

/**
 * Represents a deck of cards and associated functions.
 * 
 * @version 1.0
 * @author Trev
 */
public class DeckOfCard 
{
    private static final int MAX_CARDS = 52;
    private Card[] deck = new Card[MAX_CARDS];

     /**
     * Creates new deck of cards
     */
    public DeckOfCard() 
    {
        int iterator = 0;
        
        // Suits
        for (int i = 1; i <= 4; i++) 
        {
            // Faces
            for (int j = 1; j <= 13; j++) 
            {
                deck[iterator] = new Card(j, i);
                iterator++;
            }
        }
    }
    
    /**
     * Shuffles the cards in the deck
     */
    public void Shuffle()
    {       
        // Shuffle logic
        Random rnd = new Random();
        for (int i = deck.length - 1; i > 0; i--) 
        {
            // Gets random card and swaps it at postion i
            int rndCard = rnd.nextInt(i+1);
            Card cardToMove = deck[rndCard];
            deck[rndCard] = deck[i];
            deck[i] = cardToMove;
        }
    }
    
    /**
     * Draws a card and removes it from the deck
     * 
     * @see Card
     * @return a card drawn from the top of the deck
     */
    // Draws a card from the deck
    public Card Draw()
    {
        // Shuffles deck before draw
        Shuffle();
        
        // Get the card and remove it from the deck
        Card drawnCard = deck[0];
        
        // Creates new deck without drawn card
        Card[] newDeck = new Card[deck.length - 1];
        
        // i represents position in original deck, k is the new deck
        for (int i = 1, k = 0; i < deck.length; i++, k++) 
        {
            // Creates new deck without drawn card
            newDeck[k] = deck[i];
        }
        
        // Replaces deck with new deck
        deck = newDeck;
        
        // Displays card drawn and cards remaining
        System.out.println("Dealt " + drawnCard.getFaceName() + " of " 
            + drawnCard.getSuitName()); 
        System.out.println(String.format("%d cards remaining\n", deck.length));
        
        return drawnCard;
    }
}


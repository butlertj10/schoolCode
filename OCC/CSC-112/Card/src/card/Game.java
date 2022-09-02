package card;

/**
 * Creates a new game
 * 
 * @author Trev
 */
public class Game 
{
    /**
     * Runs main method
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        // Draws two cards
        DeckOfCard deck = new DeckOfCard();
        
        // Displays all cards in deck
        for (int i = 0; i < 52; i++)
        {          
            Card card1 = deck.Draw(); 
        } 
    }
}
